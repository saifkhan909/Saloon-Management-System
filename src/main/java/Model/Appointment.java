package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Appointment {
    private int id;
    private String name, number, date, time, empName, service;
    private int amount;
    private String status;

    public Appointment id(int id) {
        this.id = id;
        return this;
    }
    public Appointment name(String name) {
        this.name = name;
        return this;
    }
    public Appointment number(String number) {
        this.number = number;
        return this;
    }
    public Appointment date(String date) {
        this.date = date;
        return this;
    }
    public Appointment time(String time) {
        this.time = time;
        return this;
    }
    public Appointment empName(String empName) {
        this.empName = empName;
        return this;
    }
    public Appointment service(String service) {
        this.service = service;
        return this;
    }
    public Appointment amount(int amount) {
        this.amount = amount;
        return this;
    }
    public Appointment status(String status) {
        this.status = status;
        return this;
    }
    public  Appointment build(){
        return this;
    }


//    public Appointment(int id, String name, String number, String date, String time, String empName, String service, Integer amount) {
//        this.id = id;
//        this.name = name;
//        this.number = number;
//        this.date = date;
//        this.time = time;
//        this.empName = empName;
//        this.service = service;
//        this.amount = amount;
//    }
//    public Appointment(String name, String number, String date, String time, String empName, String service, Integer amount, String status) {
//        this.name = name;
//        this.number = number;
//        this.date = date;
//        this.time = time;
//        this.empName = empName;
//        this.service = service;
//        this.amount = amount;
//        this.status = status;
//    }
//    public Appointment(int id, String name, String number, String date, String time, String empName, String service, int amount) {
//        this.id = id;
//        this.name = name;
//        this.number = number;
//        this.date = date;
//        this.time = time;
//        this.empName = empName;
//        this.service = service;
//        this.amount = amount;
//    }
//    public Appointment(String date, String time, String empName) {
//        this.date = date;
//        this.time = time;
//        this.empName = empName;
//    }

    //    public Appointment(String date, String time, String number, String emp_name){
//        this.date = date;
//        this.time = time;
//        this.number = number;
//        this.emp_name = emp_name;
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getEmpName() {
        return empName;
    }

    public String getService() {
        return service;
    }

    public int getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public static Appointment result(ResultSet rs) throws SQLException {
        return new Appointment().id(rs.getInt("c_id"))
                  .name(rs.getString("c_name"))
                  .number(rs.getString("c_number"))
                  .date(rs.getString("a_date"))
                  .time(rs.getString("a_time"))
                  .empName(rs.getString("emp_name"));
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", emp_name='" + empName + '\'' +
                ", service='" + service + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public String getEmpName() {
//        return empName;
//    }
//
//    public void setEmpName(String empName) {
//        this.empName = empName;
//    }
//
//    public String getService() {
//        return service;
//    }
//
//    public void setService(String service) {
//        this.service = service;
//    }
//
//    public Integer getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Integer amount) {
//        this.amount = amount;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
}
