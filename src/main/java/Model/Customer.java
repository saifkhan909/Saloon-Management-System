package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Customer {

    private int id, count;
    private String name, number, date, time;

    public Customer id(int id){
        this.id = id;
        return this;
    }
    public Customer name(String name){
        this.name = name;
        return this;
    }
    public Customer number(String number){
        this.number = number;
        return this;
    }
    public Customer count(int count){
        this.count = count;
        return this;
    }
    public Customer date(String date){
        this.date = date;
        return this;
    }
    public Customer time(String time){
        this.time = time;
        return this;
    }

    public Customer build(){
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getCount() {
        return count;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public static Customer result(ResultSet rs) throws SQLException {
        return new Customer().id(rs.getInt("c_id"))
                .name(rs.getString("c_name"))
                .number(rs.getString("c_number"))
                .count(rs.getInt("Count"));
    }

    public static Customer result1(ResultSet rs) throws SQLException {
        return new Customer()
                .name(rs.getString("c_name"))
                .number(rs.getString("c_number"))
                .date(rs.getString("a_date"))
                .time(rs.getString("a_time"));
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
