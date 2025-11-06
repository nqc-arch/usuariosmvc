package controller;

import model.Usuario;
import view.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBtnAction implements ActionListener {

    private Controller controller;

    public DeleteBtnAction(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) controller.getView().getUsersTable().getModel();
        JTable table = controller.getView().getUsersTable();
        if (table.getSelectedRowCount() == 1) {
            int pkTableSelectedRow = Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
            controller.getModel().setUsuario(new Usuario());
            controller.getModel().getUsuario().setPkusuario(pkTableSelectedRow);
            controller.getModel().deleteUser();
            controller.updateTable();
            JOptionPane.showMessageDialog(controller.getView(), "User deleted Successfully!");
        } else if(table.getSelectedRowCount() ==  0) {
            JOptionPane.showMessageDialog(controller.getView(), "You must Select a Row Please");
        } else if(table.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(controller.getView(), "You must select only one Row please");
        }
    }
}
