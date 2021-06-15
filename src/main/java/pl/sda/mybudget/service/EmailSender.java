package pl.sda.mybudget.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailSender {

    public void sendEmail(String emailAddress, String emailTitle, String body) {
        log.info("sending email to: [{}] with title: [{}]", emailAddress, emailAddress);
        log.info("email body: [{}]", body);
    }
}
