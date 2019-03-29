package game.ballgame;

import core.GameObjectContainer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class LevelDungeon extends GameObjectContainer
{
    private boolean isPressing;
    private double startTime;
    public Ball ball;

    public LevelDungeon()
    {
        super();
    }

    public Ball getBall()
    {
        return ball;
    }

    @Override
    public void update(GraphicsContext g,  int width, int height, double delta)
    {
        if (ball != null)
        {
            ball.radius = (int) ((System.currentTimeMillis() - startTime) * 0.005) + 10;
            ball.color = Color.color(Math.random(), Math.random(), Math.random());
        }
        physicsEngine();
        List<GameObject> toRemove = new ArrayList<>();

        for (GameObject obj : getObjectList())
        {
            if (obj instanceof Ball)
            {
                Ball b = (Ball) obj;
                if (b.x < 0 || b.x > width || b.y < 0 || b.y > height)
                    toRemove.add(obj);
            }
        }
        removeObjects(toRemove);
    }

    @Override
    public void onMouseEvent(MouseEvent me)
    {
        int mx = (int) me.getX();
        int my = (int) me.getY();
        double absmax = 10;

        if (me.getEventType() == MouseEvent.MOUSE_PRESSED)
        {
            if (!isPressing)
            {
                startTime = System.currentTimeMillis();
                isPressing = true;
                ball = new Ball(mx, my, 0);
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
        else if (me.getEventType() == MouseEvent.MOUSE_DRAGGED)
        {
            Ball b = new Ball(mx, my, ball.radius);
            b.color = ball.color;
            b.ax = Math.random() * absmax * 2 - absmax;
            b.ay = Math.random() * absmax * 2 - absmax;
            addObject(b);
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

    @Override
    public void onKeyEvent(KeyEvent ke)
    {
        System.out.println(ke.getCharacter());
        if (ke.getCode() == KeyCode.SPACE)
        {
            clear();
        }
        System.out.println(ke);
    }

    public void physicsEngine()
    {

    }



}
