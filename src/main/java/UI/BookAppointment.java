package UI;

import DAO.AppointmentDao;
import Model.Appointment;
//import Model.CheckAvailableEmployeeForm;
import Model.Customer;
import Model.Saloon;
import Services.AppointmentService;
import Services.CustomerService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BookAppointment {
    @FXML
    DatePicker myDatePicker;
    String empName = null;
    String service = null;
    public BookAppointment(){
        String empName[]={"Asad", "Faiz", "Rehan"};
        JComboBox cb=new JComboBox(empName);

        JFrame frame = new JFrame();
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);


        JLabel customerName = new JLabel("Customer Name");
        JLabel customerNumber = new JLabel("Customer Number");
        JLabel appointmentDate = new JLabel("Appointment Date");
        JLabel appointmentTime = new JLabel("Appointment Time");
        JTextField customerNameText = new JTextField();
        JTextField customerNumberText = new JTextField();
        JTextField customerDateText = new JTextField();
        JTextField customerTimeText = new JTextField();

        JButton book = new JButton("Book It");
        JButton back = new JButton("Back");

        customerName.setBounds(300,100,300,30);
        customerNumber.setBounds(300,150,300,30);
        appointmentDate.setBounds(300,200,300,30);
        appointmentTime.setBounds(300,250,300,30);

        customerNameText.setBounds(500,100,300,30);
        customerNumberText.setBounds(500,150,300,30);
        customerDateText.setBounds(500,200,300,30);
        customerTimeText.setBounds(500,250,300,30);

        cb.setBounds(500, 300,300,30);
        book.setBounds(500,400,300,30);
        back.setBounds(500,450,300,30);

        frame.add(customerName);
        frame.add(customerNumber);
        frame.add(appointmentDate);
        frame.add(appointmentTime);
        frame.add(customerNameText);
        frame.add(customerNumberText);
        frame.add(customerDateText);
        frame.add(customerTimeText);
        frame.add(cb);
        frame.add(book);
        frame.add(back);

        cb.addActionListener(e->{
            this.empName = cb.getSelectedItem().toString();
        });

        book.addActionListener(e->{
                if(AppointmentService.empAvailable(new Appointment().date(customerDateText.getText())
                   .time(customerTimeText.getText()).empName(this.empName).build()) == false){
                    if(CustomerService.checkCustomer(new Customer().number(customerNumberText.getText()).build()) == false){
                        CustomerService.addCustomer(new Customer().name(customerNameText.getText())
                        .number(customerNumberText.getText()).build());
                    }
                    AppointmentService.addAppointment(new Appointment().name(customerNameText.getText())
                            .number(customerNumberText.getText()).date(customerDateText.getText())
                            .time(customerTimeText.getText()).empName(this.empName).build());
                    JOptionPane.showMessageDialog(frame,"your appointment is done");
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Sorry no employee available at that time");
                }
        });
        back.addActionListener(e->{
            frame.dispose();
            HomeUI homeUI = new HomeUI();
        });

    }
}
