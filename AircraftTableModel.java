package Terminal;

import javax.swing.table.DefaultTableModel;


public class AircraftTableModel extends DefaultTableModel{
    
    String[] colName;
    
    public AircraftTableModel(String[][] aircraftData, String[] colName){
        super(aircraftData, colName);
        initColumnNames();
    }
    
    @Override
    public int getColumnCount(){
        return 3;
    }
    
    private void initColumnNames(){
        colName = new String[]{"", "", "", "", ""};
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
