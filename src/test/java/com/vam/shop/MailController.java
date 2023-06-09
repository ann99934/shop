package com.vam.shop;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MailController {
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	@Test
	public void sendMailTest2() throws Exception {
	String subject = "test 메일";
	String content = "메일 테스트 내용" + "<img src=\"https://t1.daumcdn.net/cfile/tistory/214DCD42594CC40625\">";
	String from = "ann99923@naver.com";
	String to = "ann99923@naver.com";
	
	final MimeMessagePreparator preparator = new MimeMessagePreparator() {
		
		@Override
		public void prepare(MimeMessage mimeMessage) throws Exception {
			// TODO Auto-generated method stub
			final MimeMessageHelper mailHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mailHelper.setFrom(from);
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content, true);
			FileSystemResource file = new FileSystemResource(new File("c:\\Temp\\test.txt"));
			mailHelper.addAttachment("test.txt", file);
		}
	};
	mailSender.send(preparator);
}

}
