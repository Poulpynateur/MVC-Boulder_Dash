package Model;

import Model.Elements.Dynamic;
import Model.Elements.Specialization.Bonus;
import Model.Elements.Specialization.Dirt;
import Model.Elements.Specialization.Player;
import Model.Elements.Specialization.Wall;
import Model.Elements.Sprite;
import Model.Elements.Static;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Factory into singleton (ʘᗩʘ ’)
 */
public class Factory {

    private Map<String, Image> images;
    private static Factory INSTANCE = null;

    /**** CONSTRUCTOR ***/
    private Factory() {
        this.images = Loader.loadImages();
    }

    /**** GETTERS and SETTERS ****/
    public static Factory getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Factory();

        return INSTANCE;
    }

    /**** METHODS ****/
    private List<Image> getImages(String name) {
        List<Image> anim_images = new ArrayList<>();
        for ( String key : images.keySet() ) {
            if(key.contains(name)) {
                anim_images.add(images.get(key));
            }
        }
        return anim_images;
    }

    public Player deliverPlayer(Point mapBounds) {
        return new Player(getImages("CHAR"), mapBounds.x/2,mapBounds.y/2);
    }

    public List<Sprite> deliverMap(Point mapBounds) {
        List<Sprite> map = new ArrayList<Sprite>();

        map.add(new Wall(images.get("BRICK"), mapBounds.x-2, 0));
        map.add(new Bonus(getImages("BONUS"), mapBounds.x-6, 0));
        map.add(new Dirt(images.get("DIRT"), mapBounds.x-4, 0));

/*
        map.add(new Static(getImages("BONUS"), mapBounds.x-6, 0));
        map.add(new Static(getImages("BOMB"), mapBounds.x-5, 0));
        map.add(new Static(images.get("DIRT"), mapBounds.x-4, 0));
        map.add(new Static(images.get("ROCK"), mapBounds.x-3, 0));
        map.add(new Static(images.get("BRICK"), mapBounds.x-2, 0));
*/
        for(int y=0; y<mapBounds.y; y++) {
            for(int x=0; x<mapBounds.x; x++) {
                if(x == mapBounds.x -1 || x == 0 || y == mapBounds.y -1 || y == 1) {
                    map.add(new Wall(images.get("WALL"), x, y));
                }
            }
        }
        return map;
    }
}
