package Model;

import Model.Elements.Dynamic;
import Model.Elements.Specialization.Bonus;
import Model.Elements.Specialization.Player;
import Model.Elements.Sprite;
import Model.Elements.Static;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model implements Data {

    private Point mapBounds;
    private int gameState;
    private int score;

    private Factory factory;

    private Player player;
    private Point direction;

    private List<Sprite> map;
    private List<Dynamic> updatable;

    /**** CONSTRUCTOR ***/
    public Model(int map_size_x, int map_size_y) {
        this.gameState = 0;
        this.score = 0;

        this.factory = Factory.getInstance();
        this.mapBounds = new Point(map_size_x, map_size_y);

        this.map = factory.deliverMap(mapBounds);
        this.player = factory.deliverPlayer(mapBounds);
        this.map.add(player);
    }

    /**** GETTERS and SETTERS ****/
    @Override
    public List<Sprite> getSprites() {
        return this.map;
    }
    @Override
    public Point getBounds() {
        return this.mapBounds;
    }

    @Override
    public int getScore() {
        return Bonus.getScore();
    }

    @Override
    public int getGameState() {
        return this.gameState;
    }
    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public Point getDirection() {
        Point dir = direction;
        direction = new Point();
        return dir;
    }
    public void setDirection(Point direction) {
        this.direction = direction;
    }

    public Dynamic getPlayer() {
        return this.player;
    }

    public Sprite getSpriteAtPos(Point pos, Sprite requester) {
        for(Sprite sprite : map) {
            if(sprite.getPos().x == pos.x && sprite.getPos().y == pos.y && sprite != requester) {
                return sprite;
            }
        }
        return null;
    }

    /**** METHODS ****/
    public void delete(Sprite target) {
        if(target != null && target!= player) {
            map.remove(target);
        }
    }
    public void createClone(Sprite source, Point newPos) {
        map.add(source.clone(newPos));
    }
}
