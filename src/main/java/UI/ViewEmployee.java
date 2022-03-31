package UI;

import Services.EmployeeService;

import javax.swing.*;
import javax.xml.ws.Service;

public class ViewEmployee {
    public ViewEmployee(){
        String[][] data;
//        data[0][0] = "1";
//        data[0][1] = "2";
//        data[0][2] = "3";
//        data[0][3] = "4";
//        data[0][4] = "5";
        String column[]={"Employee Name", "Date", "Total Sales"};
        Services.EmployeeService.getEmployeeProfit();
        JLabel asadProfit = new JLabel("Profit of Asad = "+Services.EmployeeService.asadProfit.toString());
        JLabel qasimProfit = new JLabel("Profit of Qasim = "+EmployeeService.qasimProfit.toString());
        JLabel rehanProfit = new JLabel("Profit of rehan = "+EmployeeService.rehanProfit.toString());
        asadProfit.setBounds(500,600,200,30);
        qasimProfit.setBounds(500,630,200,30);
        rehanProfit.setBounds(500,660,200,30);
        JFrame frame;
        frame = new JFrame();
        JButton back = new JButton("BACK");
        back.setBounds(500,500,200,30);
        frame.add(back);
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        data = Services.EmployeeService.getEmployeesData();
        JTable jt=new JTable(data,column);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(0, 0, 600, 1000);
        sp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        frame.add(asadProfit);
        frame.add(qasimProfit);
        frame.add(rehanProfit);
        frame.add(sp);
        frame.setSize(300,400);
        frame.setVisible(true);

        back.addActionListener(e->{
            frame.dispose();
            HomeUI homeUI = new HomeUI();
        });
    }
}