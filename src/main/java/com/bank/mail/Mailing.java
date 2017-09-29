package com.bank.mail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailing {

	public static void userBankUpdateMail(String empCode, String bankName,
			String branchName, String accountNumber, String ifscCode) {
		String empName = "";
		String emailId = "";
		String locationName = "";
		try {

			String toMail = emailId;
			String ccMail = "salarysupport@eosglobe.com";

			/* String toMail="aarora1982@gmail.com"; */
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", "172.16.10.98");
			prop.put("mail.smtp.auth", "true");
			Session s = Session.getInstance(prop, null);
			MimeMessage message = new MimeMessage(s);
			String fromMail = "salarysupport@eosglobe.com";

			message.setFrom(new InternetAddress(fromMail));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					toMail));
			message.addRecipients(Message.RecipientType.CC,
					InternetAddress.parse("eospayroll@eosglobe.com"));

			// message.addRecipient(Message.RecipientType.TO,new
			// InternetAddress((String)"suvarnak@eosglobe.com"));
			message.setSubject("BANK ACCOUNT DETAILS");

			StringBuilder sb = null;

			sb = new StringBuilder();
			sb.append("<!DOCTYPE html>");
			sb.append("<html>");
			sb.append("<style> <!-- /* Font Definitions */ @font-face {font-family:Calibri; panose-1:2 15 5 2 2 2 4 3 2 4;} @font-face {font-family:Tahoma; panose-1:2 11 6 4 3 5 4 4 2 4;} @font-face {font-family:'Trebuchet MS'; panose-1:2 11 6 3 2 2 2 2 2 4;} /* Style Definitions */ p.MsoNormal, li.MsoNormal, div.MsoNormal {margin:0in; margin-bottom:.0001pt; font-size:11.0pt; font-family:'Calibri','sans-serif';} a:link, span.MsoHyperlink {mso-style-priority:99; color:blue; text-decoration:underline;} a:visited, span.MsoHyperlinkFollowed {mso-style-priority:99; color:purple; text-decoration:underline;} p.MsoAcetate, li.MsoAcetate, div.MsoAcetate {mso-style-priority:99; mso-style-link:'Balloon Text Char'; margin:0in; margin-bottom:.0001pt; font-size:8.0pt; font-family:'Tahoma','sans-serif';} span.MsoPlaceholderText {mso-style-priority:99; color:gray;} span.BalloonTextChar {mso-style-name:'Balloon Text Char'; mso-style-priority:99; mso-style-link:'Balloon Text'; font-family:'Tahoma','sans-serif';} span.EmailStyle20 {mso-style-type:personal; font-family:'Trebuchet MS','sans-serif'; color:windowtext;} span.EmailStyle21 {mso-style-type:personal; font-family:'Trebuchet MS','sans-serif'; color:windowtext;} span.EmailStyle22 {mso-style-type:personal; font-family:'Trebuchet MS','sans-serif'; color:windowtext;} span.EmailStyle23 {mso-style-type:personal-reply; font-family:'Trebuchet MS','sans-serif'; color:windowtext;} .MsoChpDefault {mso-style-type:export-only; font-size:10.0pt;} @page Section1 {size:8.5in 11.0in; margin:1.0in 1.0in 1.0in 1.0in;} div.Section1 {page:Section1;} --> </style>");
			sb.append("<style>table {border-collapse: collapse;}table, td, th {border: 1px solid black;}</style>");
			sb.append("<body>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>DEAR "
					+ empName + "<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''><o:p>&nbsp;</o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>EMPLOYEE CODE :"
					+ empCode + "<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>LOCATION : "
					+ locationName + "<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''><o:p>&nbsp;</o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>DATE &amp; TIME : "
					+ new Date() + "<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''><o:p>&nbsp;</o:p></span></b></p>");
			sb.append("<p class=MsoNormal><b><span style='color:black'>YOU HAVE SUCCESSFULLY SUBMITTED BELOW BANK ACCOUNT DETAILS IN OUR RECORDS FOR YOUR MONTHLY SALARY TRANSFER.<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''><o:p>&nbsp;</o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>BENEFICIARY BANK NAME : "
					+ bankName + "<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>BENEFICIARY BRANCH NAME : "
					+ branchName + "<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>BENEFICIARY BANK ACCOUNT NUMBER : "
					+ accountNumber + "<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>BENEFICIARY BANK IFSC CODE : "
					+ ifscCode + "<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><o:p>&nbsp;</o:p></b></p>");
			sb.append("<p class=MsoNormal><b><u><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>Terms &amp; Conditions:<o:p></o:p></span></u></b></p>");
			sb.append("<p class=MsoNormal><b><u><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''><o:p><span style='text-decoration:none'>&nbsp;</span></o:p></span></u></b></p>");
			sb.append("<p class=MsoNormal><b><span style='font-size:9.0pt;font-family:'Trebuchet MS','sans-serif''>1. I hereby authorize Eureka Outsourcing Solutions Pvt. Ltd. to transfer salary to the account mentioned above. <span style='font-family:Wingdings'>þ</span><o:p></o:p></p><o:p></o:p></span></b>");
			sb.append("<p class=MsoNormal><b><span style='font-size:9.0pt;font-family:'Trebuchet MS','sans-serif''>2. I hereby agree that the aforesaid details including the IFSC code and the beneficiary account are correct. <span style='font-family:Wingdings'>þ</span><o:p></o:p></p><o:p></o:p></span></b>");
			sb.append("<p class=MsoNormal><b><span style='font-size:9.0pt;font-family:'Trebuchet MS','sans-serif''>3. I further acknowledge that Eureka Outsourcing Solutions Pvt. Ltd. accepts no liability for any consequences arising out of erroneous details provided by me. <span style='font-family:Wingdings'>þ</span><o:p></o:p></p><o:p></o:p></span></b>");
			sb.append("<p class=MsoNormal><b><span style='font-size:9.0pt;font-family:'Trebuchet MS','sans-serif''>4. I agree that the credit will be affected solely on the beneficiary account number information and beneficiary name particulars will not be used for the same. <span style='font-family:Wingdings'>þ</span><o:p></o:p></p><o:p></o:p></span></b>");
			sb.append("<p class=MsoNormal><b><span style='font-size:9.0pt;font-family:'Trebuchet MS','sans-serif''>5. I agree that requests submitted after the cut off time will be sent in next batch or next working day as applicable. <span style='font-family:Wingdings'>þ</span><o:p></o:p></p><o:p></o:p></span></b>");
			sb.append("<p class=MsoNormal><o:p>&nbsp;</o:p></p>");
			sb.append("<p class=MsoNormal><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''><o:p>&nbsp;</o:p></span></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>THANKS &amp; REGARDS,<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>PAYROLL TEAM<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal style='text-align:justify'><b><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''>EUREKA OUTSOURCING SOLUTIONS PVT LTD<o:p></o:p></span></b></p>");
			sb.append("<p class=MsoNormal><span style='font-size:10.0pt;font-family:'Trebuchet MS','sans-serif''><o:p>&nbsp;</o:p></span></p>");
			sb.append("<p class=MsoNormal><o:p>&nbsp;</o:p></p>");
			sb.append("</body>");
			sb.append("</html>");

			message.setContent(sb.toString(), "text/html");

			Transport trans = s.getTransport("smtp");
			System.out.println("4");
			trans.connect("172.16.10.98", "salarysupport@eosglobe.com",
					"salSup&369");
			trans.sendMessage(message, message.getAllRecipients());
			trans.close();
			System.out.println("sent ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
