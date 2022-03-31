package DAO;

import Model.Appointment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao{
    public static void addAppointmentDao(Model.Appointment obj) {
        try{
            DBService.adQuery("INSERT INTO Appointment "+
            "(c_name,c_number,a_date,a_time,emp_name)"+
            "VALUES ('"+obj.getName()+"','"+obj.getNumber()+"','"+obj.getDate()+"','"+obj.getTime()+"','"+obj.getEmpName()+"')");
            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
    }
    public static List<Appointment> getAppointments(){
        List<Appointment> results = new ArrayList<>();
        try{
            ResultSet rs = DBService.getQuery("SELECT * FROM Appointment Where a_status = '"+"active"+"'" + " ORDER BY a_date ASC, a_time ASC");
            while (rs.next()){
                    results.add(Appointment.result(rs));
            }
            //            while (rs.next()){
            //                results.add(new Appointment().id(rs.getInt("c_id"))
            //                                             .name(rs.getString("c_name"))
            //                                             .number(rs.getString("c_number"))
            //                                             .date(rs.getString("a_date"))
            //                                             .time(rs.getString("a_time"))
            //                                             .empName(rs.getString("emp_name")));
            //            }

            return results;
//            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static Boolean checkAvailEmp(Appointment obj) {
        try {
            ResultSet rs = DBService.getQuery("SELECT * FROM Appointment WHERE a_date = '"+obj.getDate().toString()+"' " +
                    "and a_time = '"+obj.getTime()+"' and emp_name = '"+obj.getEmpName()+"'");
            if(rs.next() == true){
                return true;
            }
            else {
                return false;
            }
//            DBService.con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void updateAppointment(Appointment obj) {
        try{
            DBService.adQuery("UPDATE Appointment SET c_name = '"+obj.getName()+"', c_number = '"+obj.getNumber()+"'," +
                    "a_date = '"+obj.getDate()+"', a_time = '"+obj.getTime()+"', emp_name = '"+obj.getEmpName()+"' WHERE c_id = '"+obj.getId()+"'");
//            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
    }

    public static void completeAppointment(Appointment obj) {
        try{
            DBService.adQuery("UPDATE Appointment SET service = '"+obj.getService()+"', a_status = '"+"completed"+"'," +
                    " amount = '"+obj.getAmount()+"' WHERE c_id = '"+obj.getId()+"'");
//            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }

    }

}
