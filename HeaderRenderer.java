package Terminal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class HeaderRenderer extends DefaultTableCellRenderer{
    private JLabel label;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        label = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setBackground(new Color(102,0,102));
        label.setHorizontalAlignment(CENTER);
        label.setFont(new Font("Calibri", Font.ITALIC, 25));
        label.setForeground(new Color(59,131,189));
        return label;
    }
    
}
