package SampleProjects.SendEmiail.controller;

import SampleProjects.SendEmiail.model.SendEmailRequest;
import SampleProjects.SendEmiail.model.SendEmailResponse;
import SampleProjects.SendEmiail.service.EmilProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@RestController
public class EmialController {

    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private EmilProcessor emailProcessor;

    @PostMapping(path = "/sendEmail")
    public SendEmailResponse sendEmail(@RequestBody SendEmailRequest request) {
        try {
            emailProcessor.sendEmail(mailProperties.getUsername(),
                    request.getEmailAddress(),
                    request.getSubject(),
                    request.getBody());

            return new SendEmailResponse(true, "Your email has been sent successfully");
        } catch (Exception e) {
            return new SendEmailResponse(false, "Internal Error");
        }
    }
}
