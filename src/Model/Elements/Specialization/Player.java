package Model.Elements.Specialization;

import Model.Elements.Type;
import Model.Elements.Dynamic;
import Model.Model;
import Model.Elements.Sprite;

import java.awt.*;
import java.util.List;
import java.util.ListIterator;

public class Player extends Dynamic {


    /**** CONSTRUCTOR ***/
    public Player(Image _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }
    public Player(List<Image> _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }

    /**** METHODS ****/
    public Player clone(Point newPos) {
        return new Player(this.images, newPos.x, newPos.y);
    }
    public boolean update(Model world) {
        Point direction = world.getDirection();
        Point future = new Point(pos.x + direction.x, pos.y + direction.y);

        Sprite target = world.getSpriteAtPos(future, this);
        if(target != null) {
            if(target.onCollision(Type.PLAYER) == false)
                return this.alive;
        }

        this.move(direction);
        return this.alive;
    }
    public boolean onCollision(Type collider) {
        return true;
    }
}
