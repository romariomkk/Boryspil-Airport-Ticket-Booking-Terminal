package Terminal;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class ScheduleTableModel extends DefaultTableModel{

    public String[] colName;
    
    public ScheduleTableModel(Vector<Vector<String>> scheduleData, Vector<String> columnNames) {
        super(scheduleData, columnNames);
        initColumnNames();
    }

    @Override
    public int getColumnCount(){
        return 5;
    }   
    
    private void initColumnNames(){
        colName = new String[]{"Time", "Flight№", 
                               "Carrier", "Destination", "Status"};
    }
    
    @Override
    public String getColumnName(int columnIndex){
            return colName[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }  
}
