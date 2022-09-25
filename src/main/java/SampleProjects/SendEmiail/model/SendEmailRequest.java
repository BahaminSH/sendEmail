package SampleProjects.SendEmiail.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendEmailRequest {
    private String subject;
    private String body;
    private String emailAddress;

    public SendEmailRequest(){}

    public SendEmailRequest(String subject, String body, String emailAddress){
        this.subject = subject;
        this.body = body;
        this.emailAddress = emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
