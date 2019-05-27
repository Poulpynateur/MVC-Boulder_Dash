package Model.Elements.Specialization;

import Model.Elements.Dynamic;
import Model.Elements.Sprite;
import Model.Elements.Static;
import Model.Elements.Type;
import Model.Model;

import java.awt.*;
import java.util.List;

public class Dirt  extends Static {
    public Dirt(Image _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }
    public Dirt(List<Image> _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }

    /**** METHODS ****/
    public Dirt clone(Point newPos) {
        return new Dirt(this.images, newPos.x, newPos.y);
    }
    public boolean onCollision(Type collider) {
        if(collider == Type.PLAYER) {
            this.kill();
            return true;
        }
        return false;
    }
}
