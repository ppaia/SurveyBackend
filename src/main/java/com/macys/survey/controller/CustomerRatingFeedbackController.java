package com.macys.survey.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macys.survey.model.CustomerFeedRating;
import com.macys.survey.model.SurveyCounter;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/rest/chatbot/customer")
public class CustomerRatingFeedbackController {
	private static final Logger logger = LoggerFactory.getLogger(SurveyCounter.class);
	@PostMapping(value="/RatingFeedback")
	public ResponseEntity<Object> uploadFile( 
			@RequestBody final CustomerFeedRating customerFeedRating,  
			@Value("${toAddress}") String toAddress,
			@Value("${fromAddress}") String fromAddress,
			@Value("${subject}") String subject,
			@Value("${body}") String body,
			@Value("${spring.mail.username}") String username,
			@Value("${spring.mail.password}") String password,
			@Value("${spring.mail.properties.mail.smtp.auth}") String auth,
			@Value("${spring.mail.properties.mail.smtp.starttls.enable}") String starttlsEnable,
			@Value("${spring.mail.host}") String host,
			@Value("${spring.mail.port}") String port,
			@Value("${filePath}") String filePath) throws IOException{
			logger.info("START:: CustomerRatingFeedbackController :: uploadFile");
	
	
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", auth);
			properties.put("mail.smtp.starttls.enable", starttlsEnable);
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", port);
		
			Session emailSession = Session.getInstance(properties,
		         new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(
		            		   username, password);
		            }
		         });
			
			Multipart emailContent = new MimeMultipart();
			String bodyData= "";
			String screenShot="No";
			String base64Data="";
	        StringBuffer emailBodyContent = new StringBuffer();

	        //Generate random UUID 
	        UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString();
			String[] arraySplit = fileName.split("-");
			fileName = arraySplit[0];
			fileName = fileName.toString().concat(".png");

			base64Data = customerFeedRating.getBase64();
			@SuppressWarnings("restriction")
			byte[] btDataFile = new sun.misc.BASE64Decoder().decodeBuffer(base64Data);
		    File file = new File(filePath + fileName);
			//File file = new File(".");
		    System.out.println("filePath : " + file.getAbsolutePath() );
		    System.out.println("filePath 2222: " + filePath + fileName );
		    FileOutputStream osf = new FileOutputStream(file);
		    osf.write(btDataFile);
		    osf.flush();
	        
			try {
				File exisFile = new File(filePath + file.getName());
				if (exisFile.exists()){
					exisFile.delete();
					logger.info("Existing File deleted.");
				}else{
					logger.info("No file exists to delete.");
				}
			
				/*if(!file.isEmpty()){
					boolean fileExists = convertFile.createNewFile();
					logger.info("Is new file created : " + fileExists);
					FileOutputStream fout = new FileOutputStream(convertFile);
					fout.write(file.getBytes());
					fout.close();
				}*/
			
				MimeMessage msg = new MimeMessage(emailSession);
				msg.setFrom(new InternetAddress(fromAddress));
				//msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
				msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
				msg.setSubject(subject);
					
				//attach body part
				if(!base64Data.isEmpty() && base64Data !=null){
					MimeBodyPart attachementImage = new MimeBodyPart();
					attachementImage.attachFile(filePath + file.getName());
					emailContent.addBodyPart(attachementImage);
					emailBodyContent.append("\nPlease find attached Error Screenshot for issue reported by User.");
					screenShot="Yes";
				}
				
				if (!customerFeedRating.getName().isEmpty() && customerFeedRating.getName() != null){
		        	emailBodyContent.append("\n\n Name : " + customerFeedRating.getName());
		        }
		        if (!customerFeedRating.getEmail().isEmpty() && customerFeedRating.getEmail() != null){
		        	emailBodyContent.append("\n\n Email : " + customerFeedRating.getEmail());
		        }
		        if (!customerFeedRating.getOverallRating().isEmpty() && customerFeedRating.getOverallRating() != null){
		        	emailBodyContent.append(" \n\n OverAll Rating : " + customerFeedRating.getOverallRating());
		        }else{
		        	emailBodyContent.append(" \n\n OverAll Rating : Rating not provided.");
		        }
		        if (!customerFeedRating.getProductAvailability().isEmpty() && customerFeedRating.getProductAvailability() != null){
		        	emailBodyContent.append("\n\n Product Availability : " + customerFeedRating.getProductAvailability());
		        }else{
		        	emailBodyContent.append(" \n\n Product Availability : Rating not provided.");
		        }
		        if (!customerFeedRating.getSearchProducts().isEmpty() && customerFeedRating.getSearchProducts() != null){
		        	emailBodyContent.append("\n\n Easiness to navigate/search products : " + customerFeedRating.getSearchProducts());
		        }else{
		        	emailBodyContent.append(" \n\n Easiness to navigate/search products : Rating not provided.");
		        }
		        if (!customerFeedRating.getCompletProducts().isEmpty() && customerFeedRating.getCompletProducts() != null){
		        	emailBodyContent.append("\n\n Easiness to check-out/complete purchase: " + customerFeedRating.getCompletProducts());
		        }else{
		        	emailBodyContent.append(" \n\n Easiness to check-out/complete purchase: Rating not provided.");
		        }
		        if (!customerFeedRating.getIssue().isEmpty() && customerFeedRating.getIssue() != null){
		        	emailBodyContent.append("\n\n Customer Issue : " + customerFeedRating.getIssue());
		        }
		        if (!customerFeedRating.getComment().isEmpty() && customerFeedRating.getComment() != null){
		        	emailBodyContent.append("\n\n Customer Comment : " + customerFeedRating.getComment());
		        }
		        if(!screenShot.isEmpty() && screenShot != null){
		        	emailBodyContent.append("\n\n Screenshot Attached : " + screenShot);
		        }
		        
				bodyData = emailBodyContent.toString();
				//Text body part
				MimeBodyPart textBodyPart = new MimeBodyPart();
				textBodyPart.setText("Hi Team, \n"
						+ body 
						+ bodyData
						+ "	\n\n Thanks"
						+ "	\n Macys Team"
						);
					emailContent.addBodyPart(textBodyPart);
					msg.setContent(emailContent);
					Transport.send(msg);
				} catch (MessagingException e) {
					e.getLocalizedMessage();
				}
			logger.info("END:: CustomerRatingFeedbackController :: uploadFile");
			return new ResponseEntity<>("Feedback/Survey Submit Successfully", HttpStatus.OK);
		}
	}
