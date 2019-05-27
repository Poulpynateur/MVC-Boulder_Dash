package View.Inputs;

import Controller.InputsListener;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private InputsListener inputsListener;

    /**** CONSTRUCTOR ****/
    public KeyListener(InputsListener _inputsListener) {
        this.inputsListener = _inputsListener;
    }

    /**** METHODS ****/
    @Override
    public void keyPressed(KeyEvent event) {
        Point direction = new Point();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                direction.y = -1;
                break;
            case KeyEvent.VK_DOWN:
                direction.y = 1;
                break;
            case KeyEvent.VK_LEFT:
                direction.x = -1;
                break;
            case KeyEvent.VK_RIGHT:
                direction.x = 1;
                break;
            case KeyEvent.VK_P:
                inputsListener.gameStart();
                break;
        }

        inputsListener.setDirectionInputs(direction);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        Point direction = new Point();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                direction.y = 0;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                direction.x = 0;
                break;
        }

        inputsListener.setDirectionInputs(direction);
    }
}