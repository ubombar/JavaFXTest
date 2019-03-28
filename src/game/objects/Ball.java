package game.objects;

import core.Game;
import core.GameObjectContainer;
import game.levels.LevelDungeon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Ball extends GameObjectContainer.GameObject
{
    public int x;
    public int y;
    public int radius;
    public Color color;

    public double ax;
    public double ay;

    public double vx;
    public double vy;

    public Ball(int x, int y, int radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = Color.MAGENTA;
    }

    @Override
    public void render(GraphicsContext g, double delta)
    {
        if (((LevelDungeon)Game.getCurrent().getLevel()).ball != this)
        {
            x += vx * delta * 0.001;
            y += vy * delta * 0.001;
            vx += ax * delta * 0.01;
            vy += ay * delta * 0.01;
        }
        g.setFill(color);
        g.fillOval(x - radius / 2, y - radius / 2, radius, radius);
    }

    @Override
    public void onMouseEvent(MouseEvent me)
    {
        int mx = (int) me.getX();
        int my = (int) me.getY();

        if (Math.pow(mx - x, 2) <= radius * radius && Math.pow(my - y, 2) <= radius * radius)
        {
            double absmax = 50;
            ax = Math.random() * absmax * 2 - absmax;
            ay = Math.random() * absmax * 2 - absmax;
        }
    }

    public void addForce(double fx, double fy)
    {
        this.ax += fx;
        this.ay += fy;
    }
}
