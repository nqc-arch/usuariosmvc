package controller;

import model.Model;
import view.View;

import java.awt.*;
import java.awt.event.ActionListener;

public class Controller{

    private View view;
    private Model model;

    public  Controller(View view, Model model) {
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

    public void initialize(){
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
