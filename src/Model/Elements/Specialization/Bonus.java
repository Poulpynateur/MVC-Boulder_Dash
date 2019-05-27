package Model.Elements.Specialization;

        import Model.Elements.Type;
        import Model.Elements.Dynamic;
        import Model.Elements.Sprite;
        import Model.Model;

        import java.awt.*;
        import java.util.List;
        import java.util.ListIterator;

public class Bonus extends Dynamic {
    public Bonus(Image _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }
    public Bonus(List<Image> _image, int origin_x, int origin_y) {
        super(_image, origin_x, origin_y);
    }

    /**** METHODS ****/
    public Bonus clone(Point newPos) {
        return new Bonus(this.images, newPos.x, newPos.y);
    }
    public void update(Model world) {
        Point future = new Point(pos.x , pos.y + 1);

        ListIterator<Sprite> iter = world.getSprites().listIterator();
        while(iter.hasNext()){
            Sprite next = iter.next();
            if(future.x == next.getPos().x && future.y == next.getPos().y) {
                Type response = next.onCollision();
                if(response == Type.PLAYER) {
                    world.setScoreUp();
                    world.getSprites().remove(this);
                    return;
                }
                if(response == Type.BLOCK)
                    return;
            }
        }

        this.move(0, 1);
    }
    public Type onCollision() {
        return Type.SCORE;
    }
}
