package Model.Elements.Specialization;

import Model.Elements.Type;
import Model.Elements.Dynamic;
import Model.Elements.Sprite;
import Model.Model;

import java.awt.*;
import java.util.List;
import java.util.ListIterator;

public class Bonus extends Dynamic {

    private static int score;

    public Bonus(Image _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }
    public Bonus(List<Image> _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }

    /**** GETTERS and SETTERS ****/
    public static int getScore() {
        return score;
    }

    /**** METHODS ****/
    public Bonus clone(Point newPos) {
        return new Bonus(this.images, newPos.x, newPos.y);
    }
    public boolean update(Model world) {
        Point future = new Point(pos.x , pos.y + 1);

        Sprite target = world.getSpriteAtPos(future, this);
        if(target != null) {
            if(target.onCollision(Type.SCORE) == false)
                return this.alive;
        }

        this.move(0, 1);
        return this.alive;
    }
    public boolean onCollision(Type collider) {
        if(collider.equals(Type.PLAYER)) {
            this.score++;
            this.kill();
            return true;
        }
        return false;
    }
}
