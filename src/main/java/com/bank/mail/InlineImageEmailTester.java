package com.bank.mail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InlineImageEmailTester {

	/**
	 * main entry of the program
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		final String filePath = "//Users//joshuagoldwasser//Pictures//Saved Images//Cool&Interesting//";
		
		// SMTP info
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "synergisticitsessionusc6@gmail.com";
		String password = "session6";

		// message info
		String mailTo = "trantunglam032016@gmail.com";// "nhiluong2303@icloud.com";
														// //
		String subject = "Banking Information";
		
		
		
		
		
		StringBuffer body = new StringBuffer("<!DOCTYPE html>");
		body.append("<html>");
		body.append("<head>");
		
		//Javascript part to apply Popup ( does not work)
		body.append(
				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"><script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script><script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
        
		
		//Javascript function to call Popup Form( does not work)
		body.append(
				"<script type=\"text/javascript\"> function openPopup() {$(\"#sendFormPopup\").modal('show');} </script>");

		
		body.append("</head>");

		body.append("<body>");

		body.append("<br>");
		body.append("Hi new Customer,<br><br>");
		body.append("<img src=\"cid:image1\" width=\"10%\" height=\"10%\" style =\"border-radius: 70%;\"/><br>");
		body.append(
				"<p style = \"color:blue;\">RBL Bank currently services approximately 3.15 million customers and has a total business size of over Rs. 64,000 Crores. It offers a range of banking products and services categorized largely in 5 verticals - Corporate & Institutional Banking, Commercial Banking, Retail Banking, Agri & Development Banking and Financial Markets.<p><br>");
		
		//The link to call Javascript Popup function (does not work)
		body.append("<p><a href = \"javascript:openPopup();\">FAQ</a></p><br><br><br>");
		
		body.append(
				"<button id = \"myBtn\" style = \" color:red; font-size:25px;border-radius: 5px;margin-left: 8cm;\">&#9989; <a href = \"http://localhost:8080/FirstSpring/Customer.jsp\">Apply Now</a></button><br><br>");

		body.append(
				"<img src=\"cid:image2\" width=\"10%\" height=\"10%\" style =\"border-radius: 70%; margin-left: 1cm;\"/><p style =\"color:red;margin-left: 1cm;\">We always win</p><br>");

		body.append(
				"<div class=\"modal fade\" id=\"sendFormPopup\" role=\"dialog\"><div class=\"modal-dialog\"><div class=\"modal-content\"><div class=\"modal-body\"><form action=\"\" method=\"post\" name=\"sendMailForm\"id=\"sendMailForm\"><input type=\"hidden\" class=\"form-control\" id=\"sdid\" name=\"id\"style=\"width: 200px;\" /><div class=\"form-group\"> <label  style = \"color:#00ff80;\">Name : </label> <input type=\"text\" class=\"form-control\" name=\"name\" placeholder=\"Name\"style=\"width: 300px; display: inline; margin-left: 40px;\" /> <br /></div>");

		body.append(
				"<div class=\"form-group\"><label  style = \"color:#00ff80;\">Age :</label> <input type=\"text\" class=\"form-control\" name=\"age\" placeholder=\"Age\"style=\"margin-left: 50px; width: 300px; display: inline;\"/> <br /></div>");
		body.append(
				"<div class=\"form-group\"><label  style = \"color:#00ff80;\">Address :</label> <input type=\"text\" class=\"form-control\" name=\"address\" placeholder=\"Address\" style=\"margin-left: 20px; width: 300px; display: inline;\" /> <br /></div>");
		body.append(
				"<div class=\"form-group\"><label  style = \"color:#00ff80;\">Contact Number :</label> <input type=\"text\" class=\"form-control\" name=\"contactNumber\" placeholder=\"Contact Number\"style=\"margin-left: 20px; width: 300px; display: inline;\" /> <br /></div>");

		body.append(
				"<div class=\"form-group\"><label  style = \"color:#00ff80;\">Loan Amount :</label> <input type=\"text\" class=\"form-control\" name=\"loanAmount\" placeholder=\"Loan Amount\"style=\"margin-left: 40px; width: 300px; display: inline;\" /> <br /></div>");
		body.append(
				"<div class=\"form-group\"><label  style = \"color:#00ff80;\">SSN :</label> <input type=\"password\" class=\"form-control\" name=\"ssn\" placeholder=\"SSN\" style=\"margin-left: 20px; width: 300px; display: inline;\" /> <br /></div><div class=\"modal-footer\"><button type=\"button\" data-dismiss=\"modal\" class=\"btn btn-danger\"id=\"cancel\">Cancel</button><button type=\"submit\" class=\"btn btn-danger\"id=\"Button\">Send</button></div></form></div></div></div></div>");

		body.append("</body>");
		body.append("</html>");

		// inline images
		Map<String, String> inlineImages = new HashMap<String, String>();
		inlineImages.put("image1", filePath + "rzv85dn.png");
		inlineImages.put("image2", filePath + "12523111_1308995862584941_7592751505767359414_n.png");
		
		// Get list of emails in Excel sheet
		List<ArrayList<String>> userInfoList = UploadEmails.uploadEmails(new FileInputStream("emails.xlsx"));

		try {
			System.out.println("Sending emails...");
			//SendMail.sendMail(recipient, body.toString(), inlineImages);
			
			for (ArrayList<String> userInfo : userInfoList) { //iterate through email list and send emails
				String recipient = userInfo.get(0);
				SendMail.sendMail(recipient, body.toString(), inlineImages);
			}
			
			System.out.println("Emails sent.");
		} catch (Exception ex) {
			System.out.println("Could not send emails.");
			ex.printStackTrace();
		}
	}
	
}
