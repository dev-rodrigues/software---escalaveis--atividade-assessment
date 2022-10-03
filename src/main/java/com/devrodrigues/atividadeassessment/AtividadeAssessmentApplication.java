package com.devrodrigues.atividadeassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class AtividadeAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtividadeAssessmentApplication.class, args);
    }

}
