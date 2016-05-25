package Terminal;

import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class StatusRenderer extends DefaultTableCellRenderer{

    DBConnection dataBase = new DBConnection();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        try {
            Calendar calend = Calendar.getInstance();
            int hour = calend.get(Calendar.HOUR_OF_DAY);
            int minute = calend.get(Calendar.MINUTE);
            String flightTime = dataBase.getTimeList().get(row);
            Integer dataBaseHour = Integer.valueOf(flightTime.substring(0, 2));
            Integer dataBaseMinute = Integer.valueOf(flightTime.substring(3, 5));

            String idStatus = dataBase.getStatusList().get(row);

            //convert everything to minutes
            if (dataBaseHour != 0)
                dataBaseMinute += dataBaseHour*60;
            if (hour != 0)
                minute += hour*60;

            if (!idStatus.equals("Отменен/Cancelled")){
                //registration 1.5 hour before the flight
                if (dataBaseMinute - minute <= 90 && dataBaseMinute - minute > 0){
                    dataBase.updateStatus(2, row);
                    comp.setForeground(Color.YELLOW);
                }else if (dataBaseMinute - minute <= 0){//departed right after the dataBase time
                    dataBase.updateStatus(3, row);
                    comp.setForeground(Color.GREEN);
                }else{//just active
                    dataBase.updateStatus(1, row);
                    comp.setForeground(Color.WHITE);
                }
            }else{
                comp.setForeground(Color.RED);
            }
            
            dataBase.init();
        } catch (SQLException ex) {
            Logger.getLogger(StatusRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comp;
    }
}
