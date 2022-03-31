package Model;

public class ViewSales {
    String date, time, emp_name;

    public ViewSales(String date, String time, String emp_name) {
        this.date = date;
        this.time = time;
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

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    @Override
    public String toString() {
        return "ViewSales{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", emp_name='" + emp_name + '\'' +
                '}';
    }
}
