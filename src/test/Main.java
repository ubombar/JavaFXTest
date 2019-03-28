package test;

import core.Game;
import core.GameObjectContainer;
import core.GameSettings;
import javafx.scene.canvas.GraphicsContext;

public class Main
{
    public static void main(String[] args)
    {
        new Game(GameSettings.DEFAULT, GameObjectContainer.LEVEL_DUNGEON);
    }
}
