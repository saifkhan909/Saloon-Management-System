package Model;

public class UpdateAppointmentData {
    public String date;
    public String time;
    public String number;
    public String emp_name;

    public UpdateAppointmentData(String date, String time, String number, String emp_name){
        this.date = date;
        this.time = time;
        this.number = number;
        this.emp_name = emp_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    @Override
    public String toString() {
        return "UpdateAppointmentData{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", number='" + number + '\'' +
                ", emp_name='" + emp_name + '\'' +
                '}';
    }
}
