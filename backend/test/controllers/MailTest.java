package controllers;

import mail.Mail;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MailTest {

    @Test
    public void testMailSending(){
        Mail mail = new Mail();
        mail.sendMail("", "test", "test");
        assertNotNull(mail);
    }


}
