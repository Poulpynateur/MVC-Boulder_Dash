package View.Inputs;

import Controller.InputsListener;
import View.Render;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class MouseListener extends MouseInputAdapter {

    private InputsListener inputsListener;
    /**** CONSTRUCTOR ****/
    public MouseListener(InputsListener _inputsListener) {
        this.inputsListener = _inputsListener;
    }

    /**** METHODS ****/
    @Override
    public void mousePressed(MouseEvent e) {
        inputsListener.mouseState(true);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        inputsListener.mouseState(false);
    }
}
