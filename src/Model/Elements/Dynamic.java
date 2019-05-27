package Model.Elements;

import Model.Model;

import java.awt.*;
import java.util.List;

public abstract class Dynamic extends Sprite {

    /**** CONSTRUCTOR ***/
    public Dynamic(Image _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }
    public Dynamic(List<Image> _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }
    /**** GETTERS and SETTERS ****/
    public void move(int offset_x, int offset_y) {
        this.pos.x += offset_x;
        this.pos.y += offset_y;
    }
    public void move(Point offset) {
        this.pos.x += offset.x;
        this.pos.y += offset.y;
    }

    /**** METHODS ****/
    public abstract Dynamic clone(Point newPos);
    public abstract boolean update(Model world);
    public abstract boolean onCollision(Type collider);
}
