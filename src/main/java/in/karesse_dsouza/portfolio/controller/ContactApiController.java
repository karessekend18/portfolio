package in.karesse_dsouza.portfolio.controller;

import in.karesse_dsouza.portfolio.DTO.ContactFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactApiController {
    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/api/contact")
    public void handleContactForm(@RequestBody ContactFormDTO form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("karessekend1821@gmail.com"); // <-- Replace with your email
        message.setSubject("New Contact Form Submission from " + form.getName());
        message.setText("Name: " + form.getName() + "\n" +
                "Email: " + form.getEmail() + "\n" +
                "Phone: " + form.getPhone() + "\n" +
                "Message: " + form.getMessage());
        mailSender.send(message);
    }
}

