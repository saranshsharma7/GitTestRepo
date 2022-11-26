package com.sframework.testCases;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sframework.utilities.ReadConfig;
import org.apache.commons.io.comparator.LastModifiedFileComparator;



public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	
	//getting data from ReadConfig class
	
	public String baseurl=readconfig.getApplicationUrl();
	public String username=readconfig.getApplicationUsernamel();	
	public String password=readconfig.getApplicationPassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	public ExtentReports htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	
	{
		
	
	//Print logs for test cases
	Logger = org.apache.log4j.Logger.getLogger("Demo Project");
	PropertyConfigurator.configure("log4j.properties");
	
	//Call different browsers
	
	if(br.equals("chrome"))
	{
    Logger.info("---------------Test run Start-------------");		
	Logger.info("opening Browser...chrome");	
	System.setProperty("webdriver.chrome.driver",readconfig.getChromeDriver());
	driver=new ChromeDriver();

	
	}
	
	else if(br.equals("firefox"))
	{
		Logger.info("---------------Test run Start-------------");	
		Logger.info("opening Browser...firefox");	
		System.setProperty("webdriver.gecko.driver",readconfig.getFireFoxDriver());
		driver=new FirefoxDriver();
	
	}
	
	else if(br.equals("ie"))
	{
		Logger.info("---------------Test run Start-------------");	
		Logger.info("opening Browser...ie");
		System.setProperty("webdriver.ie.driver",readconfig.getIEDriver());
		driver=new InternetExplorerDriver();
		
	}
	
	
	
	//get site URL
	driver.get(baseurl);
	Logger.info("OpenURL"+" ");
	driver.manage().window().maximize();
	
	
	
}
	
	
	
	//Capture screenshot
	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	//Check current output file
	
	
	public static File getLastModified(String filePath,String ext)
	{
		File theNewestFile = null;
	    File dir = new File(filePath);
	    FileFilter fileFilter = new WildcardFileFilter("*." + ext);
	    File[] files = dir.listFiles(fileFilter);

	    if (files.length > 0) {
	        /* The newest file comes first */
	        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
	        theNewestFile = files[0];
	    }

	return theNewestFile;
	}
	
	
//@AfterClass
//public void closeBrowser()
//{
//driver.close();
//}
	
	// Send Mail after script execution
//	@AfterClass
//	public void sendmail()
//	{
//		
//
//		// Create object of Property file
//		Properties props = new Properties();
//
//		// this will set host of server- you can change based on your requirement 
//		props.put("mail.smtp.host", "smtpout.secureserver.net");
//
//		// set the port of socket factory 
//		props.put("mail.smtp.socketFactory.port", "465");
//
//		// set socket factory
//		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//
//		// set the authentication to true
//		props.put("mail.smtp.auth", "true");
//
//		// set the port of SMTP server
//		props.put("mail.smtp.port", "465");
//
//		// This will handle the complete authentication
//		Session session = Session.getDefaultInstance(props,
//
//				new javax.mail.Authenticator() {
//
//					protected PasswordAuthentication getPasswordAuthentication() {
//
//					return new PasswordAuthentication("saransh.sharma@bayatree.com", "ssa#123");
//
//					}
//
//				});
//
//		try {
//
//			// Create object of MimeMessage class
//			Message message = new MimeMessage(session);
//
//			// Set the from address
//			message.setFrom(new InternetAddress("saransh.sharma@bayatree.com"));
//
//			// Set the recipient address
//			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("saransh.sharma@bayatree.com"));
//            
//                        // Add the subject link
//			message.setSubject("Test Report");
//
//			// Create object to add multimedia type content
//			BodyPart messageBodyPart1 = new MimeBodyPart();
//
//			// Set the body of email
//			messageBodyPart1.setText("Please find the attached Automation Test Report.");
//
//			// Create another object to add another content
//			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//
//			// Mention the file which you want to send
//			String path="D:/Workspace/Selenium_FrameWork/Test Reports";
//		
//			String ext="html";
//			String filename = getLastModified(path,ext).toString();
//
//			// Create data source and pass the filename
//			DataSource source = new FileDataSource(filename);
//
//			// set the handler
//			messageBodyPart2.setDataHandler(new DataHandler(source));
//
//			// set the file
//			messageBodyPart2.setFileName(filename);
//
//			// Create object of MimeMultipart class
//			Multipart multipart = new MimeMultipart();
//
//			// add body part 1
//			multipart.addBodyPart(messageBodyPart2);
//
//			// add body part 2
//			multipart.addBodyPart(messageBodyPart1);
//
//			// set the content
//			message.setContent(multipart);
//
//			// finally send the email
//			Transport.send(message);
//
//			System.out.println("=====Email Sent=====");
//
//		} catch (MessagingException e) {
//
//			throw new RuntimeException(e);
//
//		}
		
	
	}


