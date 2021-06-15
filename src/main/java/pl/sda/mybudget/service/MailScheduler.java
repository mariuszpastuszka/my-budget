package pl.sda.mybudget.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailScheduler {

    private String delayFromConfig = "2000";

    public String getDelayFromConfig() {
        return delayFromConfig;
    }

    @Autowired
    public void setDelayFromConfig(@Value("${schedule.fixed-delay-in-ms}") String delayFromConfig) {
        log.info("setting delay to: [{}]ms", delayFromConfig);
        this.delayFromConfig = delayFromConfig;
    }

    @Scheduled(fixedDelayString = "#{mailScheduler.delayFromConfig}")
    public void sendEmails() {
        log.info("trying to send...");

        // choose receivers and messages

        // send emails:)
    }
}
