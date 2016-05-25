package Terminal;

import com.google.zxing.WriterException;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class PDFCreator {
    Document ticketDoc;
    PdfPTable table;
            
    public void generate(ArrayList<String> arr) throws DocumentException, FileNotFoundException, IOException {

        Font boldLargeFont = FontFactory.getFont("Calibri", 20, Font.BOLD);
        Font boldSmallFont = FontFactory.getFont("Calibri", 14, Font.BOLD);
        
        ticketDoc = new Document();
        PdfWriter.getInstance(ticketDoc, new FileOutputStream("src/PDF/Complete tickets/" + arr.get(0) + ' ' + arr.get(3) + ".pdf"));
        
        ticketDoc.open();
        
        ticketDoc.add(new Paragraph("/////Boryspil automated booking system/////", FontFactory.getFont("Calibri", 12, Font.NORMAL)));
        
        //addHeaderImage();
        Image img1 = Image.getInstance("src/images/borispol_logo.jpg");
        img1.scaleToFit(200, 150);
        img1.setAlignment(0);
        ticketDoc.add(img1);
        
        addSpace();addSpace();
        
        Paragraph par1 = new Paragraph("ELECTRONIC TICKET / ITINERARY RECEIPT",boldLargeFont);
        par1.setAlignment(1);
        ticketDoc.add(par1);
        
        addSpace();addSpace();addSpace();addSpace();
        addSpace();addSpace();addSpace();addSpace();
        addSpace();addSpace();addSpace();addSpace();
        addSpace();addSpace();addSpace();addSpace();
        
        table = new PdfPTable(4);
        PdfPCell headCell = new PdfPCell(new Paragraph("This e-ticket is the reason for journey",boldSmallFont));
        headCell.setColspan(4);
        table.addCell(headCell);
        
        table.addCell(new Paragraph("First Name, Last Name"));
        table.addCell(new Paragraph(arr.get(0),boldSmallFont));
        table.addCell(new Paragraph("Flight"));
        table.addCell(new Paragraph(arr.get(1),boldSmallFont));
        
        table.addCell(new Paragraph("Departure"));
        table.addCell(new Paragraph("Kyiv Boryspil", boldSmallFont));
        PdfPCell seatLabelCell = new PdfPCell(new Paragraph("Seat"));
        PdfPCell seatCell = new PdfPCell(new Paragraph(arr.get(4),boldSmallFont));
        seatLabelCell.setRowspan(2);
        seatCell.setRowspan(2);
        table.addCell(seatLabelCell);
        table.addCell(seatCell);
        
        table.addCell(new Paragraph("Destination"));
        PdfPCell destCell = new PdfPCell(new Paragraph(arr.get(3),boldSmallFont));
        destCell.setColspan(3);
        table.addCell(destCell);
        
        
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH),
            month = cal.get(Calendar.MONTH) + 1,
            year = cal.get(Calendar.YEAR);
        table.addCell(new Paragraph("Date/Departure time"));
        String dateTimeStamp = day + "." + month + "." + year + ' ' + arr.get(2);
        table.addCell(new Paragraph(dateTimeStamp, boldSmallFont));
        table.addCell(new Paragraph("LOCAL (KYIV) TIME"));
        table.addCell(new Paragraph(""));
        
        PdfPCell qrCell = new PdfPCell(addQRCode(arr.get(0) + '\n' 
                + arr.get(3) + '\n' + dateTimeStamp));
        qrCell.setColspan(4);
        table.addCell(qrCell);
        
        ticketDoc.add(table);
        
        ticketDoc.close();
    }
    
    private void addSpace() throws DocumentException{
        ticketDoc.add(new Paragraph('\n'));
    }
    
    public void addHeaderImage() throws BadElementException, DocumentException, IOException{
        
    }
    
    private Image addQRCode(String textToEncode){
        Image img2 = null;
        try {
            BufferedImage bufferedImage = new QRCodeGenerator(textToEncode).getImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            img2 = Image.getInstance(baos.toByteArray());
            
            //ticketDoc.add(img2);
        } catch (IOException | WriterException | BadElementException ex) {
            Logger.getLogger(PDFCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img2;
    }
    
    public static void main(String[] args) throws DocumentException, FileNotFoundException, IOException, WriterException {
        //new PDFCreator().generate();
    }
}
