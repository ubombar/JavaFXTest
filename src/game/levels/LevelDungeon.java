package game.levels;

import core.GameObjectContainer;
import game.objects.Ball;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class LevelDungeon extends GameObjectContainer
{
    private boolean isPressing;
    private double startTime;
    public Ball ball;

    public LevelDungeon()
    {
        super();
        Ball b = new Ball(500, 50, 30);
        addObject(b);
    }

    public Ball getBall()
    {
        return ball;
    }

    @Override
    public void render(GraphicsContext g, double delta)
    {
        if (ball != null)
        {
            ball.radius = (int) ((System.currentTimeMillis() - startTime) * 0.05) + 30;
            ball.color = Color.color(Math.random(), Math.random(), Math.random());
        }
        physicsEngine();
    }

    @Override
    public void onMouseEvent(MouseEvent me)
    {
        int mx = (int) me.getX();
        int my = (int) me.getY();

        if (me.getEventType() == MouseEvent.MOUSE_PRESSED)
        {
            if (!isPressing)
            {
                startTime = System.currentTimeMillis();
                isPressing = true;
                ball = new Ball(mx, my, 0);
                double absmax = 1;
                ball.ax = Math.random() * absmax * 2 - absmax;
                ball.ay = Math.random() * absmax * 2 - absmax;
                addObject(ball);
            }
        }
        else if (me.getEventType() == MouseEvent.MOUSE_RELEASED)
        {
            if (isPressing)
            {
                isPressing = false;
                startTime = 0;
                ball = null;
            }
        }
        else
        {
            if (ball != null)
            {
                ball.x = mx;
                ball.y = my;
            }
        }

    }

    public void physicsEngine()
    {

    }



}
