package Controller;

import Model.Elements.Sprite;
import Model.Model;

import java.awt.*;

public class MapEditor {

    private Model model;
    private Sprite clone_target;
    private Point last_draw;

    /**** CONSTRUCTOR ***/
    public MapEditor(Model _model) {
        this.model = _model;
        this.clone_target = model.getSprites().get(0);
        this.last_draw = new Point();
    }

    /**** METHODS ****/
    public void createElement(Point mousePos) {
        Point pos = new Point((int)(mousePos.x/32), (int)(mousePos.y/32));

        if(pos.y <= 1 || pos.y == model.getBounds().y - 1 || pos.x == 0 || pos.x == model.getBounds().x - 1) {
            if(pos.y == 0 && pos.x != 0 && pos.x != model.getBounds().x - 1 && model.getSpriteAtPos(pos) != null)
                clone_target = model.getSpriteAtPos(pos);
        }
        else if((last_draw.x != pos.x || last_draw.y != pos.y)) {
            Sprite target = model.getSpriteAtPos(pos);

            if(target != null)
                model.delete(target);
            else
                model.createClone(clone_target, pos);

            last_draw = pos;
        }
    }
}
