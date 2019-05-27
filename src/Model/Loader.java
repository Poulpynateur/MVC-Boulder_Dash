package Model;

import Model.Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Loader {

    private static BufferedImage buffer;
    private static Map<String, Image> images;

    private static void putMultipleImages(String name, Point start, int number_x, int number_y) {
        for(int x=0; x < number_x; x++) {
            for(int y=0; y < number_y; y++) {
                images.put(name+x+y, buffer.getSubimage(start.x + 16*x, start.y + 16*y, 16, 16));
            }
        }
    }

    public static Map<String, Image> loadImages() {
        try {
            buffer = ImageIO.read(new File("./Src/Model/Ressources/sprites.png"));
            images = new HashMap<String, Image>();

            images.put("TEST", buffer.getSubimage(0, 0, 16, 16));

            images.put("WALL", buffer.getSubimage(0, 48, 16, 16));
            images.put("DIRT", buffer.getSubimage(48, 48, 16, 16));
            images.put("BRICK", buffer.getSubimage(32, 48, 16, 16));
            images.put("ROCK", buffer.getSubimage(80, 48, 16, 16));

            putMultipleImages("BONUS", new Point(0,64), 2, 4);
            putMultipleImages("BOMB", new Point(80,64), 1, 4);

            return images;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
