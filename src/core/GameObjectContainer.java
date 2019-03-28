package core;

import game.levels.LevelDungeon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class GameObjectContainer
{
    public static final GameObjectContainer LEVEL_DUNGEON = new LevelDungeon();

    public static abstract class GameObject implements Renderable, Inputable
    {
        @Override
        public void initialize()
        {

        }

        @Override
        public void render(GraphicsContext g, double delta)
        {

        }

        @Override
        public void destroy()
        {

        }

        @Override
        public void onMouseEvent(MouseEvent me)
        {

        }

        @Override
        public void onKeyEvent(KeyEvent ke)
        {

        }
    }

    public interface GameObjectContainerListener
    {
        void onConstruct(List<GameObject> objects);
    }

    private List<GameObject> objects;

    public GameObjectContainer(GameObjectContainerListener l)
    {
        objects = new ArrayList<>();
        l.onConstruct(objects);
    }

    public GameObjectContainer()
    {
        this(objects1 -> {});
    }

    protected boolean addObject(GameObject object)
    {
        return objects.add(object);
    }

    protected boolean removeObject(GameObject object)
    {
        return objects.remove(object);
    }

    protected void clear()
    {
        objects.clear();
    }

    public void foreach(Consumer<? super GameObject> action)
    {
        objects.forEach(action);
    }

    public void initialize()
    {

    }

    public void render(GraphicsContext g, double delta)
    {

    }

    public void destroy()
    {

    }

    public void onMouseEvent(MouseEvent me)
    {

    }

    public void onKeyEvent(KeyEvent ke)
    {

    }
}
