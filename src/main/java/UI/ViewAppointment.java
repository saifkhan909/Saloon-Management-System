package UI;
import DAO.*;
import Model.*;
import Services.AppointmentService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.ws.Service;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;
import java.util.Locale;

public class ViewAppointment {
    String[][] data;
    String column[]={"Id","Name", "Number", "Date", "Time", "Employee"};
    JFrame frame;
    JTable jt;
    JScrollPane sp;
    JButton back;
    JButton deleteNumber;
    JButton updateNumber;
    String c_name, c_number;
    String date, time, emp_name;

    ViewAppointment(){
        frame = new JFrame();
        back = new JButton("BACK");
        deleteNumber = new JButton("Delete");
        updateNumber = new JButton("Update");
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

        data = AppointmentService.getAllAppointments();
        jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        deleteNumber.setBounds(1200, 50, 150, 30);
        updateNumber.setBounds(1200, 100, 150, 30);
        back.setBounds(1200, 150, 150, 30);
        sp = new JScrollPane(jt);
        sp.setBounds(0, 0, 1000, 1000);
        sp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        frame.add(sp);
        frame.add(back);
        frame.add(deleteNumber);
        frame.add(updateNumber);
        frame.setSize(300, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        back.addActionListener(e -> {
            frame.dispose();
            HomeUI homeUI = new HomeUI();
        });

        deleteNumber.addActionListener(e -> {
            JPanel myPanel = new JPanel();
            JTextField id = new JTextField(5);
            JTextField services = new JTextField(5);
            JTextField amount = new JTextField(5);
            myPanel.add(new JLabel("Enter id:"));
            myPanel.add(id);
            myPanel.add(new JLabel("Enter services:"));
            myPanel.add(services);
            myPanel.add(new JLabel("Enter amount:"));
            myPanel.add(amount);
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                AppointmentService.completeAppointment(new Appointment().id(Integer.parseInt(id.getText()))
                .service(services.getText()).amount(Integer.parseInt(amount.getText())).build());
            }

//            SalesDao.addSale(date, time, emp_name);
//            EmployeeDao.addEmployeeData(emp_name, date);
            frame.dispose();
            ViewAppointment viewAppointment = new ViewAppointment();
            });

            updateNumber.addActionListener(e->{
            JTextField id = new JTextField(5);
            JTextField nameChange = new JTextField(5);
            JTextField dateChange = new JTextField(5);
            JTextField timeChange = new JTextField(5);
            JTextField numberChange = new JTextField(5);
            String empName = null;
            String empNames[]={"Asad", "Faiz", "Rehan"};
            JComboBox cb=new JComboBox(empNames);

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Enter id:"));
            myPanel.add(id);
            myPanel.add(new JLabel("Enter Date:"));
            myPanel.add(dateChange);
            myPanel.add(new JLabel("Enter name:"));
            myPanel.add(nameChange);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Enter Time:"));
            myPanel.add(timeChange);
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Enter Number:"));
            myPanel.add(numberChange);
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Emp:"));
            myPanel.add(cb);
            myPanel.add(Box.createHorizontalStrut(15));
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {

                if(AppointmentService.empAvailable(new Appointment().date(dateChange.getText())
                    .time(timeChange.getText()).empName(cb.getSelectedItem().toString()).build()) == false){
                    AppointmentService.updateAppointment(new Appointment().id(Integer.parseInt(id.getText()))
                    .name(nameChange.getText()).number(numberChange.getText()).date(dateChange.getText())
                    .time(timeChange.getText()).empName(cb.getSelectedItem().toString()).build());
                    JOptionPane.showMessageDialog(frame,"your appointment is updated");
                    frame.dispose();
                    ViewAppointment viewAppointment = new ViewAppointment();
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Employee Not Available");
                }
            }
        });

        }
    }



