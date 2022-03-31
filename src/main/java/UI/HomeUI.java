package UI;

import javax.swing.*;
import java.awt.*;

public class HomeUI {
    public HomeUI() {
        JFrame frame = new JFrame();
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        frame.setVisible(true);

        //Creating Buttons
        JButton bookAppointment = new JButton("Book Appointment");
        JButton viewAppointment = new JButton("View Appointment");
        JButton viewSales = new JButton("View Sales");
        JButton viewCustomer = new JButton("View Customer");
        JButton viewEmployee = new JButton("View Employee");
        JButton exit = new JButton("Exit");

        //Setting Bounds For Button
        bookAppointment.setBounds(500, 100, 300, 30);
        viewAppointment.setBounds(500, 150, 300, 30);
        viewSales.setBounds(500, 200, 300, 30);
        viewCustomer.setBounds(500, 250, 300, 30);
        viewEmployee.setBounds(500, 300, 300, 30);
        exit.setBounds(500,350,300,30);
        //Adding Button To Frames
        frame.add(bookAppointment);
        frame.add(viewAppointment);
        frame.add(viewSales);
        frame.add(viewCustomer);
        frame.add(viewEmployee);
        frame.add(exit);

        viewAppointment.addActionListener(e->{
            frame.dispose();
            ViewAppointment viewAppointments = new ViewAppointment();
        });

        bookAppointment.addActionListener(e->{
            frame.dispose();
            BookAppointment bookAppointments = new BookAppointment();
        });

        viewSales.addActionListener(e->{
            frame.dispose();
            ViewSales viewSales1 = new ViewSales();
        });

        viewCustomer.addActionListener(e->{
            frame.dispose();
            ViewCustomer viewCustomers = new ViewCustomer();
        });

        viewEmployee.addActionListener(e->{
            frame.dispose();
            ViewEmployee viewEmployees = new ViewEmployee();
        });

        exit.addActionListener(e->{
            System.exit(0);
        });

//        bookAppointment.addActionListener(e->{
//            frame.dispose();
//            BookAppointment bookAppointment1 = new BookAppointment();
//        });
    }
}
