package Controller;

import Model.Elements.Sprite;
import View.View;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.time.Clock;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class Controller implements InputsListener {

    private long MS_PER_UPDATE;
    private boolean editor_draw;

    private MapEditor mapEditor;

    private View view;
    private Model model;

    /**** CONSTRUCTOR ***/
    public Controller(View _view, Model _model) {
        this.view = _view;
        this.model = _model;

        this.mapEditor = new MapEditor(_model);

        this.MS_PER_UPDATE = 40;
    }

    /**** GETTERS and SETTERS ****/
    public void setUpdateFPS(int FPS) {
        this.MS_PER_UPDATE = 1000/FPS;
    }

    @Override
    public void setDirectionInputs(Point _direction) {
        this.model.setDirection(_direction);
    }
    @Override
    public void mouseState(boolean draw) {
        editor_draw = draw;
    }
    @Override
    public void gameStart() {
        model.setGameState(1);
    }

    /**** METHODS ****/
    public void loop() {
        Clock clock = Clock.systemDefaultZone();
        boolean game_running = true;

        while (model.getGameState() >= 0) {
            long start = clock.millis();

            if(model.getGameState() == 1)
                updateLogic();
            else if(model.getGameState() == 0 && editor_draw)
                mapEditor.createElement(view.getRender().getMousePosition());

            view.refresh();
            try {
                TimeUnit.MILLISECONDS.sleep(start + MS_PER_UPDATE - clock.millis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateLogic() {
        ListIterator<Sprite> iter = model.getSprites().listIterator();
        while(iter.hasNext()){
            Sprite next = iter.next();

            if(next.isAlive())
                next.update(model);
            else
                iter.remove();
        }
    }
}