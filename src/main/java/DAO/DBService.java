package DAO;

import Model.Appointment;
import Model.Customer;
import UI.BookAppointment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBService {
public static Connection con;

       static{
           try {
               Class.forName("com.mysql.jdbc.Driver");
                con= DriverManager.getConnection(
                       "jdbc:mysql://localhost:3306/saloon_management_system","root","");

           } catch (Exception e) {
               e.printStackTrace();
           }

       }
    public static ResultSet getQuery(String query) throws ClassNotFoundException, SQLException {

        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);

            return rs;
        }catch(Exception e){
            System.out.println(e);
        }
            return null;
    }

    public static void adQuery(String query) throws ClassNotFoundException, SQLException {

        try{
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void addAppointmnetQuery(String name, String number, String date, String time, String empName) throws ClassNotFoundException, SQLException {

        try{
            Statement stmt=con.createStatement();
            stmt.executeUpdate("INSERT INTO Appointments "+
                            "(c_name,c_number,a_date,a_time, emp_name)"+
                    "VALUES ('"+name+"','"+number+"','"+date+"','"+time+"','"+empName+"')");

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static Boolean checkAppointmentAvailable(String date, String time, String empName) {
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT emp_name FROM Appointments WHERE a_date = '"+date+"' " +
                    "and a_time = '"+time+"' and emp_name = '"+empName+"'");
            if(rs.next() == true){
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }


    public static ResultSet getSalesQuery(){
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Sales ");
            return rs;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static ResultSet getAppointmentQuery() {
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Appointments");
            return rs;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static void deleteAppointmnetQuery(String number) {
           try {
               Statement stmt = con.createStatement();
               stmt.executeUpdate("DELETE FROM Appointments WHERE c_number = '"+number+"'");
           }catch(Exception e){
               System.out.println(e);
           }
    }

    public static List<Model.Customer> getSingleAppointmentQuery(String number) {
        List<Model.Customer> results = new ArrayList<>();
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT c_name, c_number FROM Appointments WHERE c_number = '"+number+"'");
            while(rs.next()){
                    results.add(new Model.Customer().name(rs.getString("c_name"))
                            .number(rs.getString("c_number")));
            }
            return results;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

//    public static ResultSet getAllCustomers() {
//           List<Model.Customer> results = new ArrayList<>();
//           try {
//               Statement stmt = con.createStatement();
//               ResultSet rs = stmt.executeQuery("SELECT * FROM Customer ");
//               return rs;
//           }catch (Exception ex){
//               System.out.println(ex);
//           }
//           return null;
//    }

    public static List<Appointment> getAppointmentForSale(String number) {
            List<Model.Appointment> results = new ArrayList<>();
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Appointments WHERE c_number = '"+number+"'");
//            while(rs.next()){
//                results.add(new Appointment(Long.valueOf(rs.getString("c_id")),
//                        rs.getString("c_name"),
//                        rs.getString("c_number"),
//                        rs.getString("a_date"),
//                        rs.getString("a_time"),
//                        rs.getString("emp_name")));
//            }
            return results;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static void addSaleQuery(String date, String time, String emp_name) {
        try{
            Statement stmt=con.createStatement();
            stmt.executeUpdate("INSERT INTO Sales "+
                    "(s_date,s_time,emp_name)"+
                    "VALUES ('"+date+"','"+time+"','"+emp_name+"')");

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static ResultSet getSaleByDate(String to, String from) {
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Sales WHERE s_date BETWEEN '"+to+"' AND '"+from+"'");
            return rs;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static ResultSet getEmployees() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee ");
            return rs;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    public static void addEmployeeDataQuery(String name, String date) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Employee "+
                    "(emp_name,emp_date)"+
                    "VALUES ('"+name+"','"+date+"')");
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
