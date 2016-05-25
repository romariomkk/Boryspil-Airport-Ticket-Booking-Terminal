package Terminal;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class ScheduleTableRenderer extends DefaultTableCellRenderer{

    DBConnection dataBase = new DBConnection();
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        return new JLabel(new ImageIcon(dataBase.getImages().get(row)));
    }
}
