package com.dc.flightReservation.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Component
public class EmailUtil {

    @Value("${com.dc.flightreservation.email.body}")
    public String EMAIL_BODY;
    @Value("${com.dc.flightreservation.email.subject}")
    public String EMAIL_SUBJECT;
    @Autowired
    private JavaMailSender sender;

    public void sendItinerary(String toAddress, String filePath){
        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(toAddress);
            helper.setSubject(EMAIL_SUBJECT);
            helper.setText(EMAIL_BODY);
            helper.addAttachment("Itinerary",new File(filePath));
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
