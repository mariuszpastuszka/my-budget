package pl.sda.mybudget.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.sda.mybudget.model.EmailsToSend;
import pl.sda.mybudget.repository.EmailsToSendRepository;

import java.time.LocalDateTime;
import java.util.List;

import static pl.sda.mybudget.model.enumeration.MailSendStatus.FAIL;
import static pl.sda.mybudget.model.enumeration.MailSendStatus.OK;

@Component
@Slf4j
public class MailScheduler {

    private String delayFromConfig = "2000";

    private final EmailsToSendRepository emailsToSendRepository;

    private final MailDeliverer mailDeliverer;

    public MailScheduler(EmailsToSendRepository emailsToSendRepository, MailDeliverer mailDeliverer) {
        this.emailsToSendRepository = emailsToSendRepository;
        this.mailDeliverer = mailDeliverer;
        log.info("mail scheduler constructed....");
    }

    public String getDelayFromConfig() {
        return delayFromConfig;
    }

    @Autowired
//    @PostConstruct - only on methods without arguments
    public void setDelayFromConfig(@Value("${schedule.fixed-delay-in-ms}") String delayFromConfig) {
        log.info("setting delay to: [{}]ms", delayFromConfig);
        this.delayFromConfig = delayFromConfig;
    }

    @Scheduled(initialDelay = 5000, fixedDelayString = "#{mailScheduler.delayFromConfig}")
    public void sendEmails() {
        log.info("trying to send...");

        getMailsToSend()
                .forEach(emailsToSend -> {
                    boolean sendingResult = mailDeliverer.trySendEmail(emailsToSend);
                    emailsToSend.setSendTime(LocalDateTime.now());
                    emailsToSend.setDeliveryStatus(sendingResult ? OK : FAIL);
                    emailsToSendRepository.save(emailsToSend);
                });
    }

    private List<EmailsToSend> getMailsToSend() {
        var result = emailsToSendRepository.findMailsToSend();
        log.info("number of messages to send: [{}]", result.size());

        return result;
    }
}
