package DAO;

import Model.Car;
import Model.ViewSales;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalesDao {
    public static List<ViewSales> viewAllSales(){
        List<ViewSales> results = new ArrayList<>();
            try{
               ResultSet rs = DBService.getSalesQuery();
                while (rs.next()){
                    results.add(new ViewSales(
                            rs.getString("s_date"),
                            rs.getString("s_time"),
                            rs.getString("emp_name")));
                }
                return results;
//            DBService.con.close();
            }  catch (Exception e){
                System.out.println(e);
            }
            return null;
        }

    public static void addSale(String date, String time, String emp_name) {
        try{
            DBService.addSaleQuery(date, time, emp_name);
//            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
    }

    public static List<ViewSales> salesByDate(String to, String from) {
        List<ViewSales> results = new ArrayList<>();
        try{
            ResultSet rs = DBService.getSaleByDate(to, from);
            while (rs.next()){
                results.add(new ViewSales(
                        rs.getString("s_date"),
                        rs.getString("s_time"),
                        rs.getString("emp_name")));
            }
            return results;
//            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
