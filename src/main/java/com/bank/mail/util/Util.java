package com.bank.mail.util;

public class Util {
	public static String setHtmlBody() {
		
	    StringBuffer body = new StringBuffer("<!DOCTYPE html>");
	    body.append("<html>");
	    body.append("<head><style>.modal {display: none; position: fixed; z-index: 1; padding-top: 100px;left: 0;top: 0;width: 100%; height: 100%; overflow: auto; background-color: rgb(0,0,0);background-color: rgba(0,0,0,0.4);}.modal-content {position: relative;background-color: #fefefe;margin: auto;padding: 0;border: 1px solid #888;width: 80%;box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);-webkit-animation-name: animatetop;-webkit-animation-duration: 0.4s;animation-name: animatetop;animation-duration: 0.4s}@-webkit-keyframes animatetop {from {top:-300px; opacity:0} to {top:0; opacity:1}}@keyframes animatetop {from {top:-300px; opacity:0}to {top:0; opacity:1}}.close {color: white;float: right;font-size: 28px;font-weight: bold;}.close:hover,.close:focus {color: #000;text-decoration: none;cursor: pointer;}.modal-header {padding: 2px 16px;background-color: #5cb85c;color: white;}.modal-body {padding: 2px16px;}.modal-footer {padding: 2px 16px;background-color: #5cb85c;color: white;}</style></head>");
	    body.append("<body>");
	    
	    body.append("<br>");
	    body.append("Hi new Customer,<br><br>");
	    body.append("<img src=\"cid:image1\" width=\"10%\" height=\"10%\" style =\"border-radius: 70%;\"/><br>"); 
	    body.append("<p style = \"color:blue;\">RBL Bank currently services approximately 3.15 million customers and has a total business size of over Rs. 64,000 Crores. It offers a range of banking products and services categorized largely in 5 verticals - Corporate & Institutional Banking, Commercial Banking, Retail Banking, Agri & Development Banking and Financial Markets.<p><br>");
	    body.append("If you have any questions, please feel free to read through our <a href = \"https://en.wikipedia.org/wiki/RBL_Bank\">FAQ</a> (we add to this every day in an attempt to improve our service).<br><br><br>");
	    
	    body.append("<button id = \"myBtn\" style = \" color:red; font-size:25px;border-radius: 5px;margin-left: 8cm;\">&#9989; <a href = \"http://localhost:8080/BankApp/Register.jsp\">Apply Now</a></button><br><br>");
	    
	    body.append("<img src=\"cid:image2\" width=\"10%\" height=\"10%\" style =\"border-radius: 70%; margin-left: 1cm;\"/><p style =\"color:red;margin-left: 1cm;\">We always win</p><br>");
	    body.append("</body>");
	    body.append("</html>");
			
	    return body.toString();
	}
}
