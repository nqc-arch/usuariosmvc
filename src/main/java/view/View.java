package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class View extends JFrame {

    private JTextField userTextField;
    private JLabel userLabel;
    private JButton clearBtn;
    private JButton registerBtn;
    private JTextField emailTextField;
    private JLabel emailLabel;
    private JButton deleteBtn;
    private JTable usersTable;
    private JScrollPane usersScrollPane;

    public View(){

        super("Usuarios MVC Exercise");
        super.setLayout(new GridBagLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Create GridBagLayout contraints object
        GridBagConstraints c = new GridBagConstraints();

        //UserLabel
        userLabel = new JLabel("Usuario:");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        super.add(userLabel , c);

        //UserTextField
        userTextField = new JTextField();
        userTextField.setText("");
        userTextField.setColumns(10);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        super.add(userTextField , c);
        c.fill = GridBagConstraints.NONE;
        c.weighty = 0.0;

        //EmailLabel
        emailLabel = new JLabel("Email:");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        super.add(emailLabel , c);

        //Password TextField
        emailTextField = new JTextField();
        emailTextField.setText("");
        emailTextField.setColumns(10);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        super.add(emailTextField , c);
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.0;

        //Buttons
        registerBtn = new JButton("Register");
        Dimension defaultSize = registerBtn.getPreferredSize();
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        super.add(registerBtn , c);

        clearBtn = new JButton("Clear");
        clearBtn.setPreferredSize(defaultSize);
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER;
        super.add(clearBtn , c);


        deleteBtn = new JButton("Delete");
        deleteBtn.setPreferredSize(defaultSize);
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        super.add(deleteBtn , c);

        //User Table
        usersTable = new JTable();
        usersScrollPane = new JScrollPane(usersTable);
        //Creamos un modelo de tabla y lo agregamos a nuestra tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("User");
        model.addColumn("Email");
        usersTable.setModel(model);
        usersTable.setPreferredScrollableViewportSize(new Dimension(usersScrollPane.getPreferredSize().width, 100));
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.BOTH;
        super.add(usersScrollPane , c);
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.0;
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JLabel getUserLabel() {
        return userLabel;
    }

    public JButton getClearBtn() {
        return clearBtn;
    }

    public JButton getRegisterBtn() {
        return registerBtn;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    public JTable getUsersTable() {
        return usersTable;
    }

    public JScrollPane getUsersScrollPane() {
        return usersScrollPane;
    }
}
