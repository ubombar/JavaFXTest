package core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class Renderer
{
    private Map<String, Image> images;
    private GameObjectContainer objectsInstance;

    public Renderer()
    {
        this.images = new HashMap<>();
    }

    public void initialize()
    {
        objectsInstance.initialize();
        objectsInstance.foreach(Renderable :: initialize);
    }

    public void render(GraphicsContext gc, double delta)
    {
        gc.setFill(Color.WHITE);
        gc.fillRect(
                0,
                0,
                Game.getCurrent().getSettings().getWindowWidth(),
                Game.getCurrent().getSettings().getWindowHeight());
        objectsInstance.render(gc, delta);
        objectsInstance.foreach(gameObject -> gameObject.render(gc, delta));
    }

    public void destroy()
    {
        objectsInstance.destroy();
        objectsInstance.foreach(Renderable :: destroy);
    }

    public void setObjectsInstance(GameObjectContainer objectsInstance)
    {
        this.objectsInstance = objectsInstance;
    }

    public Image getIcon(String name)
    {
        return images.getOrDefault(name, null);
    }

    public void putIcon(String name)
    {
        images.put(name, new Image(Renderer.class.getResourceAsStream("./icons/" + name)));
    }

    public void putIcon(String name, Image image)
    {
        images.put(name, image);
    }

}
