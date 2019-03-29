package core;


import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Game
{
    private GameSettings settings;
    private GameObjectContainer level;
    private static Game current;

    public Game(GameSettings settings, GameObjectContainer level)
    {
        this.settings = settings;
        Game.current = this;
        setLevel(level);

        settings.getWindowRenderer().putIcon(settings.getWindowIconName());
        GameApplication.launch(GameApplication.class, "");
    }

    public static Game getCurrent()
    {
        return current;
    }

    public GameSettings getSettings()
    {
        return settings;
    }

    public void setLevel(GameObjectContainer level)
    {
        this.level = level;
        settings.getWindowRenderer().setObjectsInstance(level);
    }

    public GameObjectContainer getLevel()
    {
        return level;
    }

    protected void invokeMouseEvent(MouseEvent me)
    {
        level.onMouseEvent(me);
        level.foreach(gameObject -> gameObject.onMouseEvent(me));
    }

    protected void invokeKeyEvent(KeyEvent ke)
    {
        level.onKeyEvent(ke);
        level.foreach(gameObject -> gameObject.onKeyEvent(ke));
    }
}
