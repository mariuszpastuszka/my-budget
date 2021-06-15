package pl.sda.mybudget;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class MyBudgetApplication {

    public static void main(String[] args) {
        log.info("starting arguments...");
        for (String arg: args) {
            log.info("param: [{}]", arg);
        }
        SpringApplication.run(MyBudgetApplication.class, args);
    }

}
