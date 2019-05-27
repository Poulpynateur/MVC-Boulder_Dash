package Model;

import Model.Elements.Sprite;

import java.awt.*;
import java.util.List;

public interface Data {
    List<Sprite> getSprites();
    Point getBounds();
    int getGameState();
    int getScore();
}
