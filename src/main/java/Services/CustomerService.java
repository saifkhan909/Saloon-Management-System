package Services;

import DAO.CustomerDataDao;
import Model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerService {

    public static void addCustomer(Customer obj){
        CustomerDataDao.addCustomerDao(obj);
    }

    public static HashMap<Integer, String[][]> getCustomers(){
        List<Customer> datas = CustomerDataDao.getCustomers();
        String[][] data = new String[datas.size()][4];
        int row = 0;
        for(Model.Customer el: datas){
            data[row][0] = String.valueOf(el.getId());
            data[row][1] = el.getName();
            data[row][2] = el.getNumber();
            data[row][3] = String.valueOf(el.getCount());
            row++;
        }
        HashMap<Integer, String[][]> hashMap = new HashMap<Integer, String[][]>();
        hashMap.put(row, data);
        return hashMap;
    }

    public static Boolean checkCustomer(Customer obj){
        Boolean flag;
        flag = CustomerDataDao.checkCustomer(obj);
        return flag;
    }

    public static String[][] getCustomersByNumber(Object number) {
        List<Customer> datas = CustomerDataDao.getCustomersById(number);
        String[][] data = new String[datas.size()][4];
        int row = 0;
        for(Model.Customer el: datas){
            data[row][0] = el.getName();
            data[row][1] = el.getNumber();
            data[row][2] = el.getDate();
            data[row][3] = el.getTime();
            row++;
        }
        return data;
    }
}
