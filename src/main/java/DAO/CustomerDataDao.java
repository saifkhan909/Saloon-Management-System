package DAO;

import Model.Appointment;
import Model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataDao {
    public static void addCustomerDao(Customer obj) {
        try {
            DBService.adQuery("INSERT INTO Customer "+
                    "(c_name,c_number)"+
                    "VALUES ('"+obj.getName()+"','"+obj.getNumber()+"')");
//                DBService.con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Customer> getCustomers(){
        //"SELECT * FROM Customer "+" ORDER BY c_id DESC"
        List<Customer> results = new ArrayList<>();
           try {
               ResultSet rs = DBService.getQuery("SELECT COUNT(Customer.c_number) AS Count,Customer.c_id,Customer.c_name,Customer.c_number" +
                       " FROM Customer" +
                       " INNER JOIN Appointment ON Customer.c_number=Appointment.c_number" +
                       " WHERE Appointment.a_status = 'completed'"+
                       " GROUP BY Customer.c_number");
               while(rs.next()){
                   results.add(Customer.result(rs));
               }
               return results;
           }catch (Exception ex){
               System.out.println(ex);
           }
           return null;
    }

    public static Boolean checkCustomer(Customer obj) {
        try{
           ResultSet rs =  DBService.getQuery("SELECT * FROM Customer Where c_number = '"+obj.getNumber()+"'");
           if(rs.next() == true){
               return true;
           }
           else{
               return false;
           }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    public static List<Customer> getCustomersById(Object number) {
        List<Customer> results = new ArrayList<>();
        try {
            ResultSet rs = DBService.getQuery("SELECT c_name, c_number, a_date, a_time FROM Appointment"+
                    " WHERE a_status = 'completed' AND c_number = '"+number+"'");
            while(rs.next()){
                results.add(Customer.result1(rs));
            }
            return results;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }
}

