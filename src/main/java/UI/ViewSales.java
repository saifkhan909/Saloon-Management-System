package UI;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ViewSales {
    ViewSales(){
        JFrame frame = new JFrame();
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

        JButton back = new JButton("BACK");
        back.setBounds(1200,250,150,30);

        JLabel startDate = new JLabel("Enter Start Date");
        JLabel endDate = new JLabel("Enter End Date");
        startDate.setBounds(1100,50,300,30);
        endDate.setBounds(1100,100,300,30);

        JTextField to = new JTextField();
        JTextField from = new JTextField();
        to.setBounds(1200,50,200,30);
        from.setBounds(1200,100,250,30);

        JButton enter = new JButton("Enter");
        enter.setBounds(1200,150,150,30);

        JButton viewAllSales = new JButton("View All Sales");
        viewAllSales.setBounds(1200,200,150,30);


        frame.add(back);
        frame.add(startDate);
        frame.add(endDate);
        frame.add(to);
        frame.add(from);
        frame.add(enter);
        frame.add(viewAllSales);
        frame.setSize(300,400);
        frame.setLayout(null);
        frame.setVisible(true);

        viewAllSales.addActionListener(e->{
            JLabel totalSales = new JLabel("jkhkhj");
            totalSales.setBounds(1200,300,150,30);
            JLabel totalProfit = new JLabel("jbnjj");
            totalProfit.setBounds(1200,400,150,30);
            String[][] data;
            data = Services.ViewSales.getAllSales();
            String column[]={"Date", "Time", "Sales"};
            JTable jt=new JTable(data,column);
            jt.setBounds(30,40,200,300);
            JScrollPane sp=new JScrollPane(jt);
            sp.setBounds(0, 0, 1100, 400);
            sp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            frame.add(sp);
            frame.add(totalSales);
            frame.add(totalProfit);
        });

        enter.addActionListener(e->{
//            JLabel lb = new JLabel("ghgk");
//            lb.setBounds(30,30,200,300);
//            frame.add(lb);
            String[][] data;
            data = Services.ViewSales.getSalesByDate(to.getText(), from.getText());
            String column[]={"Date", "Time", "Sales"};
            JTable jt=new JTable(data,column);
            jt.setBounds(30,40,200,300);
            JScrollPane sp=new JScrollPane(jt);
            sp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            sp.setBounds(0, 0, 1100, 1000);
            frame.add(sp);
        });

        back.addActionListener(e->{
            frame.dispose();
            HomeUI homeUI = new HomeUI();
        });

    }
}
