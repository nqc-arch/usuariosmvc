package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearBtnAction implements ActionListener {

    private Controller controller;

    public ClearBtnAction(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.getView().getUserTextField().setText("");
        controller.getView().getEmailTextField().setText("");
    }
}
