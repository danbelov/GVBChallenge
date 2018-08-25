package mail;

import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;

import javax.mail.*;

import javax.mail.internet.*;

import com.sun.mail.smtp.*;

public class MailSender {

    public void sendMail(String recipient, String subject, String text) {
        Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress("gvbschaden@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient, false));
            msg.setSubject(subject);
            msg.setText(text);
            msg.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        SMTPTransport t = null;
        try {
            t = (SMTPTransport)session.getTransport("smtps");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        try {
            t.connect("smtp.gmail.com", "gvbschaden@gmail.com", "gvbhack18");
            t.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Response: " + t.getLastServerResponse());
            t.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
