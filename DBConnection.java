package Terminal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;


public class DBConnection {
    
    Connection connectDB;
    ResultSet scheduleResultSet;
    Statement statement;
    ArrayList<ArrayList<String>> userList;
    ArrayList<String> imageSet = new ArrayList<>(),
                      timeArray = new ArrayList<>(),
                      statusList = new ArrayList<>(),
                      userRow = new ArrayList<>();
    
    
    private final Vector<Vector<String>> tableData = new Vector<>();
    private Vector<String> columnNames;
    private Vector<String> tableRow;
    
    public DBConnection(){
        setConnectionAndReadDB();
    }
    
    private void setConnectionAndReadDB(){
        try{
            primaryConnectionSettings();
            init();
        }catch (ClassNotFoundException exc){
            System.err.println("Class is not found");
        }catch(SQLException sqlExc){
            System.err.println("Wrong SQLi connection");
        }
    }
    
    private void primaryConnectionSettings() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        connectDB = DriverManager.getConnection("jdbc:sqlite:src/DataBase/Airport.sqlite");   
        statement = connectDB.createStatement();
    }
    
    public void init() throws SQLException{
        tableData.removeAllElements();
        refreshTable();
    }
    private void refreshTable() throws SQLException{
        scheduleResultSet = statement.executeQuery
                ( "SELECT FlightList.DepartTime, FlightList.FlightNum, Company.ImageCompany, CityList.NameCity, FlightStatus.NameStatus "
                + "FROM ((FlightList INNER JOIN CityList ON FlightList.IdCity = CityList.IdCity) "
                + "INNER JOIN Company ON FlightList.IdCompany = Company.IdCompany) "
                + "INNER JOIN FlightStatus ON FlightList.IdStatus = FlightStatus.IdStatus "
                + "ORDER BY FlightList.DepartTime;");
        int colCount = scheduleResultSet.getMetaData().getColumnCount();
        fillTable(colCount);
    }
    
    private void fillTable(int columnCount) throws SQLException{
        while(scheduleResultSet.next()){
            tableRow = new Vector<>();
            for (int i = 1; i <= columnCount; i++){
                tableRow.add(scheduleResultSet.getString(i));
                switch(i){
                    case 1:
                        timeArray.add(scheduleResultSet.getString(i));
                        break;
                    case 3:
                        imageSet.add(scheduleResultSet.getString(i));
                        break;
                    case 5:
                        statusList.add(scheduleResultSet.getString(i));
                        break;
                    default:
                        break;
                }
            }
            tableData.add(tableRow);    
        }
    }
    
    public ArrayList<ArrayList<String>> getUserList()throws SQLException{
        userList = new ArrayList<>();
        ResultSet users = statement.executeQuery("SELECT UserList.Name, UserList.Surname, UserList.Password FROM UserList;");
        Integer usersColCount= users.getMetaData().getColumnCount();
        while (users.next()){
            userRow = new ArrayList<>();
            for (int i=1; i<=usersColCount; i++){
                userRow.add(users.getString(i));
            }
            userList.add(userRow);
        }
        return userList;
    }
    
    public void updateStatus(Integer newStatus, Integer row) throws SQLException{
        statement.executeUpdate("UPDATE FlightList SET IdStatus = " + newStatus + " WHERE ID = " + (row+1) + ";");
    }
    
    public void addUser(String name, String surname, String password, String passportCode) throws SQLException{
        statement.executeUpdate("INSERT INTO UserList('Name', 'Surname', 'Password', 'PassportCode') "
                             + "VALUES ('" + name + "','" + surname + "','" + password + "','" + passportCode + "');");
    }
    
    public Vector<Vector<String>> getTableData() {
        return tableData;
    }

    public Vector<String> getColumnNames() {
        return columnNames;
    }
    
    public ArrayList<String> getImages(){
        return imageSet;
    }
    
    public ArrayList<String> getTimeList(){
        return timeArray;
    }

    public ArrayList<String> getStatusList() {
        return statusList;
    }
    
}
