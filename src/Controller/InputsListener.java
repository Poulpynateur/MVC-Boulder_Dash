package Controller;

import javax.swing.*;
import java.awt.*;


public interface InputsListener {
    void setDirectionInputs(Point _direction);
    void mouseState(boolean draw);
    void gameStart();
}
