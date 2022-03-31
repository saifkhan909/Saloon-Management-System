package Services;

import DAO.AppointmentDao;
import DAO.DBService;
import Model.Appointment;
//import Model.CheckAvailableEmployeeForm;

import java.util.List;

public class AppointmentService {
    public static String[][] getAllAppointments(){
        List<Appointment> datas = AppointmentDao.getAppointments();
        int row = 0;
        String [][]data = new String[datas.size()][6];
        for(Model.Appointment el: datas){
            data[row][0] = String.valueOf(el.getId());
            data[row][1] = el.getName();
            data[row][2] = el.getNumber();
            data[row][3] = el.getDate();
            data[row][4] = el.getTime();
            data[row][5] = el.getEmpName();
            row++;
        }
        return data;
    }

    public static Boolean empAvailable(Appointment obj){
        Boolean flag = AppointmentDao.checkAvailEmp(obj);
        return flag;
    }


    public static void addAppointment(Appointment obj){
        AppointmentDao.addAppointmentDao(obj);
    }

    public static void updateAppointment(Appointment obj) {
        AppointmentDao.updateAppointment(obj);
    }

    public static int getServicePrice(String service){
        switch (service){
            case "Hair Cut":{
                return 200;
            }
            case "Shave":{
                return 150;

            }
            case "Facial":{
                return 500;
            }
            case "Massage":{
                return 200;
            }
            default:return 0;
        }
    }

    public static void completeAppointment(Appointment obj){
        AppointmentDao.completeAppointment(obj);
    }
}
