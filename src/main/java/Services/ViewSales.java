package Services;

import DAO.SalesDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ViewSales {
   public static Integer totalSales = 0;
   public static Integer totalProfit = 0;
    public static String[][] getAllSales(){
        Integer count = 0;
        List<Model.ViewSales> datas = SalesDao.viewAllSales();
        List<Model.ViewSales> datas1 = new ArrayList<>();
        int row = 0;
        String [][]data = new String[datas.size()][3];
        for(Model.ViewSales el: datas){
            boolean found = datas1.stream()
                    .anyMatch(p -> p.getDate().equals(el.getDate()));
            if(found==false){
                datas1.add(el);
                for(Model.ViewSales fl: datas){
                    if(LocalDate.parse(el.getDate()).compareTo(LocalDate.parse(fl.getDate())) == 0){
                        count++;
                    }
                }
                data[row][0] = el.getDate();
                data[row][1] = el.getTime();
                data[row][2] = count.toString();
                row++;
                totalSales+=count;
                count = 0;
            }
        }
        totalProfit = totalSales * 100;
        return data;
    }

    public static String[][] getSalesByDate(String to, String from) {
        Integer count = 0;
        List<Model.ViewSales> datas = SalesDao.salesByDate(to, from);
        List<Model.ViewSales> datas1 = new ArrayList<>();
        int row = 0;
        String [][]data = new String[datas.size()][3];
        for(Model.ViewSales el: datas){
            boolean found = datas1.stream()
                    .anyMatch(p -> p.getDate().equals(el.getDate()));
            if(found==false){
                datas1.add(el);
                for(Model.ViewSales fl: datas){
                    if(LocalDate.parse(el.getDate()).compareTo(LocalDate.parse(fl.getDate())) == 0){
                        count++;
                    }
                }
                data[row][0] = el.getDate();
                data[row][1] = el.getTime();
                data[row][2] = count.toString();
                row++;
                count = 0;
            }
        }
        return data;
    }
}
