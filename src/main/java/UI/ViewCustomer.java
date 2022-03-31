package UI;

import Model.Customer;
import Services.CustomerService;

import javax.swing.*;
import javax.xml.ws.Service;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class ViewCustomer {
    public ViewCustomer(Object number){
        String totalCustomer = null;
        JFrame frame;
        frame = new JFrame();
        JButton back = new JButton("BACK");
        back.setBounds(1200, 100, 150, 30);

        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        String data[][] = null;
        data = CustomerService.getCustomersByNumber(number);

        String column[]={"Name", "Number", "Date", "Time"};
        JTable jt=new JTable(data,column);

        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(0, 0, 1000, 1000);
        sp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        frame.add(back);
        frame.add(sp);
        frame.setSize(300,400);
        frame.setLayout(null);
        frame.setVisible(true);


        back.addActionListener(e->{
            frame.dispose();
            ViewCustomer viewCustomer = new ViewCustomer();
        });
    }
    public ViewCustomer(){
        String totalCustomer = null;
        JFrame frame;
        frame = new JFrame();
        JButton back = new JButton("BACK");
        back.setBounds(1200, 100, 150, 30);

        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        String data[][] = null;
        HashMap<Integer, String[][]> map= CustomerService.getCustomers();

        for ( Map.Entry<Integer, String[][]> entry : map.entrySet()) {
            totalCustomer = entry.getKey().toString();
            data = entry.getValue();
        }
        JLabel ttlCustomer = new JLabel("Total Customers= "+totalCustomer);
        ttlCustomer.setBounds(1200, 50, 150, 30);
        String column[]={"Id", "Name", "Number", "Count"};
        JTable jt=new JTable(data,column);

        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(0, 0, 1000, 1000);
        sp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        frame.add(back);
        frame.add(ttlCustomer);
        frame.add(sp);
        frame.setSize(300,400);
        frame.setLayout(null);
        frame.setVisible(true);


        back.addActionListener(e->{
            frame.dispose();
            HomeUI homeUI = new HomeUI();
        });

        jt.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Object obj = jt.getValueAt(jt.getSelectedRow(), 2);
                frame.dispose();
                ViewCustomer viewCustomer = new ViewCustomer(obj);
//                int col = jt.getSelectedColumn();
            }
        });

    }
}