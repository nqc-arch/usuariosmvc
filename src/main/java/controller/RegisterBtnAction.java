package controller;

import model.Model;
import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class RegisterBtnAction implements ActionListener {

    private Controller controller;

    public RegisterBtnAction(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String newUser = controller.getView().getUserTextField().getText();
        String newEmail = controller.getView().getEmailTextField().getText();

        Model model = controller.getModel();
        ArrayList<Usuario> listaActualUsuarios = model.selectTableUser();
        int pkCounter = 0;
        listaActualUsuarios.sort(new Comparator<Usuario>() {
            @Override
            public int compare(Usuario o1, Usuario o2) {
                return o1.getPkusuario().compareTo(o2.getPkusuario());
            }
        });

        for (Usuario usuario : listaActualUsuarios) {
            if (usuario.getPkusuario() ==  pkCounter) {
                pkCounter++;
            } else {
                break;
            }
        }
        controller.getModel().setUsuario(new Usuario(pkCounter,newUser, newEmail));
        if (!model.insertUser()) {
            JOptionPane.showMessageDialog(controller.getView(), "ERROR");
        }else {
            controller.updateTable();
            JOptionPane.showMessageDialog(controller.getView(), "User registered successfully!");
        }
    }
}
