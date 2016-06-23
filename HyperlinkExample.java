package com.pratice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class HyperlinkExample {

	
	public static void main(String[] args) throws IOException {
		
		
		
		        Workbook wb = new HSSFWorkbook(); //or new HSSFWorkbook();
		        CreationHelper createHelper = wb.getCreationHelper();

		        //cell style for hyperlinks
		        //by default hyperlinks are blue and underlined
		        CellStyle hlink_style = wb.createCellStyle();
		        Font hlink_font = wb.createFont();
		        hlink_font.setUnderline(Font.U_SINGLE);
		        hlink_font.setColor(IndexedColors.BLUE.getIndex());
		        hlink_style.setFont(hlink_font);

		        Cell cell;
		        Sheet sheet = wb.createSheet("Hyperlinks");
		        //URL
		        cell = sheet.createRow(0).createCell((short)0);
		        cell.setCellValue("URL Link");

		        Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_URL);
		        link.setAddress("http://poi.apache.org/");
		        cell.setHyperlink(link);
		        cell.setCellStyle(hlink_style);

		        //link to a file in the current directory
		        cell = sheet.createRow(1).createCell((short)0);
		        cell.setCellValue("File Link");
		        link = createHelper.createHyperlink(Hyperlink.LINK_FILE);
		        link.setAddress(getImage().toString());
		        cell.setHyperlink(link);
		        cell.setCellStyle(hlink_style);

		        //e-mail link
		        cell = sheet.createRow(2).createCell((short)0);
		        cell.setCellValue("Email Link");
		        link = createHelper.createHyperlink(Hyperlink.LINK_EMAIL);
		        //note, if subject contains white spaces, make sure they are url-encoded
		        link.setAddress("mailto:poi@apache.org?subject=Hyperlinks");
		        cell.setHyperlink(link);
		        cell.setCellStyle(hlink_style);

		        //link to a place in this workbook

		        //create a target sheet and cell
		        Sheet sheet2 = wb.createSheet("Target Sheet");
		        sheet2.createRow(0).createCell((short)0).setCellValue("Target Cell");

		        cell = sheet.createRow(3).createCell((short)0);
		        cell.setCellValue("Worksheet Link");
		        Hyperlink link2 = createHelper.createHyperlink(Hyperlink.LINK_DOCUMENT);
		        link2.setAddress("'Target Sheet'!A1");
		        cell.setHyperlink(link2);
		        cell.setCellStyle(hlink_style);

		        FileOutputStream out = new FileOutputStream("hyperinks.xls");
		        wb.write(out);
		        out.close();


	}
	
	  public static byte[] getImage(){
	   byte[] imageDataString = null ;
	   File file = new File("C:\\Users\\madhubabu.velpuri\\Desktop\\buildpath1.png");
	   try {            
	    // Reading a Image file from file system
	    FileInputStream imageInFile = new FileInputStream(file);
	    byte imageData[] = new byte[(int) file.length()];
	    imageInFile.read(imageData);

	    // Converting Image byte array into Base64 String
	    imageDataString = encodeImage(imageData);

	    // Converting a Base64 String into Image byte array
	    byte[] imageByteArray = decodeImage(imageDataString);
	    System.out.println("BYTE OUTPUT IS =========="+imageByteArray);

	    // Write a image byte array into file system
	    FileOutputStream imageOutFile = new FileOutputStream(file);

	    imageOutFile.write(imageByteArray);

	    imageInFile.close();
	    imageOutFile.close();

	    System.out.println("Image Successfully Manipulated!" +imageDataString);
	   } 
	   catch (FileNotFoundException e) {
	    System.out.println("Image not found" + e);
	   } catch (IOException ioe) {
	    System.out.println("Exception while reading the Image " + ioe);
	   }
	   finally{
	    return imageDataString;
	   }
	 }

	 /**
	  * Encodes the byte array into base64 string
	  *
	  * @param imageByteArray - byte array
	  * @return String a {@link java.lang.String}
	  */
	 public static byte[] encodeImage(byte[] imageByteArray) {
	  return Base64.encodeBase64(imageByteArray);
	 }

	 /**
	  * Decodes the base64 string into byte array
	  *
	  * @param imageDataString - a {@link java.lang.String}
	  * @return byte array
	  */
	 public static byte[] decodeImage(byte[] imageDataString) {
	  return Base64.decodeBase64(imageDataString);
	 }

}
