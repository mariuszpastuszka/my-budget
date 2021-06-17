package pl.sda.mybudget.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.sda.mybudget.model.EmailsToSend;

@Service
@Slf4j
public class MailDeliverer {

    private JavaMailSender javaMailSender;

    public MailDeliverer(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public boolean trySendEmail(EmailsToSend toSend) {
        log.info("trying to send message: [{}]", toSend);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toSend.getReceiver().getEmail());
        message.setSubject(toSend.getTitle());
        message.setText(toSend.getBody());

        boolean result = true;

        try {
            javaMailSender.send(message);
        } catch (MailException exc) {
            log.warn("problem occurred during sending message", exc);
            result = false;
        }

        return result;
    }
}
