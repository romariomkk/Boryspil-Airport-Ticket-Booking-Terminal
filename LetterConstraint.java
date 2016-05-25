package Terminal;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class LetterConstraint extends PlainDocument{
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        String chars = "QWERTYUIOPLKJHGFDSAZXCVBNM ";
        if (chars.indexOf(str) != -1)
            super.insertString(offs, str, a);
    }    

}
