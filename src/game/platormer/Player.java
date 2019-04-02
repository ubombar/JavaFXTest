package game.platormer;

import core.GameObjectContainer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Player extends GameObjectContainer.GameObject
{
    private boolean isFlying;

    public Player()
    {
        this.isFlying = false;
    }

    @Override
    public void render(GraphicsContext g, double delta)
    {

    }

    @Override
    public void onMouseEvent(MouseEvent me)
    {

    }
}
