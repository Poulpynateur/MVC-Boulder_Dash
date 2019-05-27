package Model.Elements.Specialization;

import Model.Elements.Dynamic;
import Model.Elements.Sprite;
import Model.Elements.Type;
import Model.Model;

import java.awt.*;
import java.util.List;

public class Rock extends Dynamic {

    public Rock(Image _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }
    public Rock(List<Image> _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }

    /**** METHODS ****/
    private Point checkCollision(Model world, Point offset, Point previous) {
        Point future = new Point(pos.x + offset.x, pos.y + offset.y);
        Sprite target = world.getSpriteAtPos(future, this);
        if(target != null) {
            if(target.onCollision(Type.ROCK) == false)
                return previous;
        }
        return offset;
    }

    public Rock clone(Point newPos) {
        return new Rock(this.images, newPos.x, newPos.y);
    }

    //Indescriptible mess
    public boolean update(Model world) {

        Point future = checkCollision(world, new Point(-1,1), new Point());
        future = checkCollision(world, new Point(1,1), future);
        future = checkCollision(world, new Point(0,1), future);

        this.move(future);
        return this.alive;
    }
    public boolean onCollision(Type collider) {
        return false;
    }
}
