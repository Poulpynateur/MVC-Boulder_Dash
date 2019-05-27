package Model.Elements;

import Model.Model;

import java.awt.*;
import java.util.List;

//This class exist on for the only purpose of clear inheritance
public abstract class Static extends Sprite{
    /**** CONSTRUCTOR ***/
    public Static(Image _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }
    public Static(List<Image> _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }

    /**** METHODS ****/
    public boolean update(Model world) {
        return this.alive;
    }
    public boolean onCollision(Type collider) {
        return false;
    }
    public abstract Static clone(Point newPos);
}
