
import View.View;
import Model.Model;
import Controller.Controller;

public class Game {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    private static final int MAP_SIZE_X = 25;
    private static final int MAP_SIZE_Y = 25;

    public static void main (String[] args) {
        Model model = new Model(MAP_SIZE_X, MAP_SIZE_Y);
        View view = new View(model, WIDTH, HEIGHT);
        Controller controller = new Controller(view, model);

        controller.setUpdateFPS(10);
        view.setInputsListener(controller);

        controller.loop();
    }
}
