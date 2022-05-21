package mailservice.Email;

import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;  

public class Pdf {    
   public static void main(String args[]) throws Exception {              
	// Creating a PdfWriter       
	      String dest = "C:/sample/addingParagraph.pdf";       
	      PdfWriter writer = new PdfWriter(dest);           
	      
	      // Creating a PdfDocument       
	      PdfDocument pdf = new PdfDocument(writer);              
	      
	      // Creating a Document        
	      Document document = new Document(pdf);              
	      String para1 = "A car (or automobile) is a wheeled motor vehicle used for transportation. "
	      		+ "Most definitions of cars say that they run primarily on roads,"
	      		+ " seat one to eight people, "
	      		+ "have four wheels, and mainly "
	      		+ "transport people rather than goods ";
	    		  
	      // Creating Paragraphs       
	      Paragraph paragraph1 = new Paragraph(para1);             
	             
	      
	      // Adding paragraphs to document       
	      document.add(paragraph1);       
	    
	      // Closing the document       
	      document.close();             
	      System.out.println("Paragraph added");   
   } 
} 