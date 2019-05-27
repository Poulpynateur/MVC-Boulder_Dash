package Model.Elements;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Model.Model;

public abstract class Sprite {

    private boolean animated;
    private int image_index;

    protected List<Image> images;
    protected Point pos;

    /**** CONSTRUCTOR ***/
    protected Sprite(Image _image, int origin_x, int origin_y) {
        this.images = new ArrayList<>();
        this.images.add(_image);
        this.pos = new Point(origin_x, origin_y);
        this.animated = false;
        this.image_index = 0;
    }
    protected Sprite(List<Image> _image, int origin_x, int origin_y) {
        this.images = _image;
        this.pos = new Point(origin_x, origin_y);
        this.animated = true;
        this.image_index = 0;
    }

    /**** GETTERS and SETTERS ****/
    public Image getImage() {
        if(animated) {
            image_index = (image_index+1 == images.size())? 0 : image_index+1;
            return images.get(image_index);
        }
        return images.get(0);
    }
    public Point getPos() {
        return pos;
    }
    public void setPos(int x, int y) {
        this.pos.x = x;
        this.pos.y = y;
    }

    /**** METHODS ****/
    public abstract Sprite clone(Point newPos);
    public abstract void update(Model world);
    public abstract Type onCollision();
}
