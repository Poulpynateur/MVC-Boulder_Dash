package View;

import Controller.InputsListener;
import Model.Data;
import View.Inputs.KeyListener;
import View.Inputs.MouseListener;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    private Data data;

    private Render render;

    /**** CONSTRUCTOR ****/
    public View(Data _data, int width, int height) {
        this.data = _data;
        this.render = new Render(data);

        render.setPreferredSize(new Dimension(width, height));
        this.getContentPane().add(this.render);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**** GETTERS and SETTERS ****/
    public void setInputsListener(InputsListener inputsListener) {
        this.addKeyListener(new KeyListener(inputsListener));
        this.addMouseListener(new MouseListener(inputsListener));
    }

    public JPanel getRender() {
        return render;
    }

    /**** METHODS ****/
    public void refresh() {
        render.revalidate();
        render.repaint();
    }
}
