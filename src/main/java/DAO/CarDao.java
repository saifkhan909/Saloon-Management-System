package DAO;

import Model.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    public static List<Car> getAllCars() {
        List<Car> results = new ArrayList<>();
        try{
            ResultSet rs = DBService.getQuery("select * from car");
            while (rs.next()){
                results.add(new Car(Long.valueOf(rs.getString("id")),
                        rs.getString("c_name"),
                        rs.getString("model")));
            }
//            DBService.con.close();
        }  catch (Exception e){
            System.out.println(e);
        }
        return results;
    }
}
