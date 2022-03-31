package Services;

import DAO.AppointmentDao;
import DAO.EmployeeDao;
import DAO.SalesDao;
import Model.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    public static Integer totalSales = 0;
    public static Integer totalProfit = 0;
    public static Integer asadProfit = 0;
    public static Integer qasimProfit = 0;
    public static Integer rehanProfit = 0;
    public static String[][] getEmployeesData(){
        Integer count = 0;

        List<Model.Employee> datas = EmployeeDao.employeesData();
        List<Model.Employee> datas1 = new ArrayList<>();
        int row = 0;
        String [][]data = new String[datas.size()][3];
        for(Model.Employee el: datas){
            boolean found = datas1.stream()
                    .anyMatch(p -> p.getDate().equals(el.getDate()) && p.getName().equalsIgnoreCase(el.getName()));
            if(found==false){
                datas1.add(el);
                for(Model.Employee fl: datas){
                    if(LocalDate.parse(el.getDate()).compareTo(LocalDate.parse(fl.getDate())) == 0 && el.getName().equalsIgnoreCase(fl.getName())){
                        count++;
                    }
                }
                data[row][0] = el.getDate();
                data[row][1] = el.getName();
                data[row][2] = count.toString();
                row++;
                totalSales+=count;
                count = 0;
            }
        }
        totalProfit = totalSales * 100;
        return data;
    }

    public static void getEmployeeProfit(){
        String empNames[]  = {"Asad", "Qasim", "Rehan"};
        int i = -1;
        List<Model.Employee> datas = EmployeeDao.employeesData();
        for(String el: empNames){
            if(el.equalsIgnoreCase("asad")) {
                Long var = datas.stream().filter(p -> p.getName().equalsIgnoreCase(el)).count();
                asadProfit= var.intValue();
            }
            if(el.equalsIgnoreCase("qasim")) {
                Long var = datas.stream().filter(p -> p.getName().equalsIgnoreCase(el)).count();
                qasimProfit= var.intValue();
            }
            else{
                Long var = datas.stream().filter(p -> p.getName().equalsIgnoreCase(el)).count();
                rehanProfit = var.intValue();
            }
        }

    }
}
