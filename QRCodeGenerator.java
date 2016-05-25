package Terminal;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class QRCodeGenerator {
    BufferedImage image;
    public QRCodeGenerator(String text) throws IOException, WriterException{
        BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 150, 150);
        image = MatrixToImageWriter.toBufferedImage(matrix);
    }
    
    public BufferedImage getImage(){
        return image;
    }
}
