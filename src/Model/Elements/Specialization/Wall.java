package Model.Elements.Specialization;

import Model.Elements.Type;
import Model.Elements.Static;
import Model.Model;

import java.awt.*;
import java.util.List;

public class Wall extends Static {
    public Wall(Image _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }
    public Wall(List<Image> _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }

    /**** METHODS ****/
    public Wall clone(Point newPos) {
        return new Wall(this.images, newPos.x, newPos.y);
    }
    public void update(Model world) {}
    public Type onCollision() {
        return Type.BLOCK;
    }
}
