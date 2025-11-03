package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterBtnAction implements ActionListener {

    private Controller controller;

    public RegisterBtnAction(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String newUser = controller.getView().getUserTextField().getText();
        String newEmail =  controller.getView().getEmailTextField().getText();

    }
}
