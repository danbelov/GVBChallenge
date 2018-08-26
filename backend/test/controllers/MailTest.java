package controllers;

import mail.MailSender;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MailTest {

    @Test
    public void testMailSending(){
        MailSender mail = new MailSender();
        mail.sendMail("", "test", "test");
        assertNotNull(mail);
    }


}
