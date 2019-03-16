package com.example.demo;

import java.awt.font.TextMeasurer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
@Configuration
@EnableScheduling
public class BulkDataReader {
	@Value("${INPUT_LOC}")
	private String inputLocation;
	@Value("${ERROR_LOC}")
	private String errorLocation;
	@Value("${SUCCESS_LOC}")
	private String successLocation;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private MailSender mailSender;
	@Scheduled(fixedRate=5000)
	@Transactional(value=TxType.REQUIRED)
	
	public void work() {
		InventoryItem item = new InventoryItem();
		item.setItemId(500);
		item.setItemName("JOHN CENA");
		entityManager.persist(item);
		jmsTemplate.setDefaultDestinationName("parthuQueue");
		//jmsTemplate.send(new MessageCreator());
		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				TextMessage msg = session.createTextMessage();
				msg.setText("YOYO ,,,,,this is PARTHU");
				return msg;
			}
			
		});
		
		System.out.println("Entity manager : " + entityManager);
		System.out.println("printing the value : "+ inputLocation);
		System.out.println("printing the value : "+ errorLocation);
		System.out.println("printing the value : "+ successLocation);
		System.out.println("Reading files!!!");
		
		/*File file = new File(inputLocation);
		BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
  String st; 
				while ((st = br.readLine()) != null) 
				    System.out.println(st);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		  } */
		
		
			//System.out.println("datasource is " + dataSource.getConnection("root","root"));
			/*System.out.println("result of mail " + mailSender);
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("acidemo@vinsys.com");
			message.setSubject("hii parthu , let's check the mail");
			message.setReplyTo("acidemo@vinsys.com");
			message.setTo("parthusarathi19@gmail.com");
			message.setText("hey dude !!!!!!!!!!!!!! what's up");
			mailSender.send(message);*/
			
		
		
	}	
	}


