package SampleProjects.SendEmiail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmilProcessor {

    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(String fromEmail, String toAddress, String subject, String body) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(message, StandardCharsets.UTF_8.toString());
        messageHelper.setSubject(subject);
        messageHelper.setText(body);
        messageHelper.setFrom(fromEmail);
        messageHelper.setTo(toAddress);

        mailSender.send(message);
    }
}
