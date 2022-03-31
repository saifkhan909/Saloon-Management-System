package DAO;

import Model.Appointment;
import Model.Employee;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public static List<Employee> employeesData() {
        List<Model.Employee> results = new ArrayList<>();
        try {
            ResultSet rs = DBService.getEmployees();
            while(rs.next()){
                results.add(new Model.Employee(
                        rs.getString("emp_name"),
                        rs.getString("emp_date")));
            }
            return results;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    public static void addEmployeeData(String name, String date){
        try{
            DBService.addEmployeeDataQuery(name, date);
//            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
    }
}

