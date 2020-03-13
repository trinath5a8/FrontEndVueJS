
package com.lc.sk.notification.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lc.sk.notification.bean.MessageBean;
import com.lc.sk.notification.util.ConstantValues;


/**
 * @author Mastanvali Shaik
 * LittleCarrotsEMailService
 * 2020
 */
@Service
public class MessangerInit {

	@Autowired
	MailContentBuilder contentBuilder;
	
	public  SimpleMailMessage getMessageData(MessageBean messageBean) 
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(messageBean.getToEmail());
		mail.setSubject(messageBean.getSubject());
		String infomation = messageBean.getInformation()+"\n\n\n\n\n\n\n\n"+ConstantValues.TAG_MESSAGE+"\n\n"+ConstantValues.TRADE_MARK;
		mail.setText(infomation);
		
		return mail;
		
	}
	public  MimeMessagePreparator  getMimeMessageData(MessageBean messageBean)
	{
		 MimeMessagePreparator messagePreparator = mimeMessage -> {
		        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
		        messageHelper.setTo(messageBean.getToEmail());
		        messageHelper.setSubject(messageBean.getSubject());

			 String content = contentBuilder.build(messageBean.getInformation());
		        messageHelper.setText(content, true);
		       
		    };
		    return messagePreparator;
		    
	}
	
}

