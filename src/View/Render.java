package View;

import Model.Data;
import Model.Elements.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Render extends JPanel {

    private String gameState;
    private Data data;

    /**** CONSTRUCTOR ****/
    public Render(Data _data) {
        this.data = _data;
        this.setBackground(Color.BLACK);
    }

    /**** METHODS ****/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.WHITE);

        if(data.getGameState() == 0)
            g.drawString( "Press P to start", 32, 30);
        else if (data.getGameState() == 1)
            g.drawString( "RUNNING", 32, 32);

        for(Sprite sprite : data.getSprites()) {
            int y = sprite.getPos().y*32;
            int x = sprite.getPos().x*32;
            g.drawImage(sprite.getImage(), x, y, 32, 32,null);
        }
    }
}
