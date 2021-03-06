package com.bank.mail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bank.mail.util.Util;

public class UploadEmails {
	
	//TODO: To be even more object-oriented, create a UserInfo POJO class!
	//private List<ArrayList<String>> userInfoList = new ArrayList<ArrayList<String>>();

	public static List<ArrayList<String>> uploadEmails(FileInputStream fis) throws IOException {
		
		List<ArrayList<String>> userInfoList = new ArrayList<ArrayList<String>>();
		
		System.out.println("Creating Row Iterator...");		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		workbook.close();
		
		System.out.println("Row Iterator created successfully. Now iterating throught rows...");
		
		while (rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			
			System.out.println("Cell Iterator created. Now iterating through cells...");
			ArrayList<String> userInfo = new ArrayList<String>();
			while (cellIterator.hasNext()) {
				Cell cell = (Cell) cellIterator.next();
				System.out.println("Cell contents:::" + cell);
				userInfo.add(cell.toString());
			}
			userInfoList.add(userInfo);
		}
		return userInfoList;
	}
	
	public void sendEmails(List<ArrayList<String>> userInfoList) {
		for (ArrayList<String> userInfo : userInfoList) {
			String recipient = userInfo.get(0);
			//String password = userInfo.get(1);
			SendMail.sendMail(recipient, Util.setHtmlBody(), new HashMap<String, String>());
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		UploadEmails uploadEmails = new UploadEmails();
		List<ArrayList<String>> userInfoList = uploadEmails.uploadEmails(new FileInputStream("emails.xlsx"));
		
		System.out.println("Contents of List:" + userInfoList);
		uploadEmails.sendEmails(userInfoList);
	}
}
