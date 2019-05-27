package Model.Elements.Specialization;

import Model.Elements.Type;
import Model.Elements.Dynamic;
import Model.Model;
import Model.Elements.Sprite;

import java.awt.*;
import java.util.List;
import java.util.ListIterator;

public class Player extends Dynamic {
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
    public void update(Model world) {
        Point future = new Point(pos.x + world.getDirection().x, pos.y + world.getDirection().y);

        ListIterator<Sprite> iter = world.getSprites().listIterator();
        while(iter.hasNext()){
            Sprite next = iter.next();
            if(future.x == next.getPos().x && future.y == next.getPos().y) {
                Type response = next.onCollision();

                if(response == Type.BLOCK)
                    return;
                else if(response == Type.SCORE) {
                    iter.remove();
                    break;
                }
            }
        }

        this.move(world.getDirection());
    }
    public Type onCollision() {
        return Type.PLAYER;
    }
}
