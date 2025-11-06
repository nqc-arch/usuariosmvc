package controller;

import model.Model;
import model.Usuario;
import view.View;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {

    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.getClearBtn().addActionListener(new ClearBtnAction(this));
        view.getDeleteBtn().addActionListener(new DeleteBtnAction(this));
        view.getRegisterBtn().addActionListener(new RegisterBtnAction(this));
    }

    public View getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }

    public void initialize() {
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        updateTable();
    }

    public void updateTable() {
        ArrayList<Usuario> listaUsuarios = model.selectTableUser();
        String[] userData;
        DefaultTableModel tableModel = (DefaultTableModel) view.getUsersTable().getModel();
        tableModel.setRowCount(0);
        for (Usuario usuario : listaUsuarios) {
            userData = new String[]{
                    usuario.getPkusuario().toString(),
                    usuario.getNombre(),
                    usuario.getCorreo()
            };
            tableModel.addRow(userData);
        }
    }
}
