package cn.demo.email;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class SendEmail {

	public static void main(String[] args) throws AddressException, MessagingException {
		MailUtils.sendMail("lucy@gbk.com", "lala", "lalalala");
	}
}
