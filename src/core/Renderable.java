package core;

import javafx.scene.canvas.GraphicsContext;

public interface Renderable
{
    void initialize();
    void render(GraphicsContext g, double delta);
    void destroy();
}
