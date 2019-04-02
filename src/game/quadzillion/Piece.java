package game.quadzillion;

import core.GameObjectContainer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Piece extends GameObjectContainer.GameObject
{
    public static class PieceData
    {
        private int width;
        private int height;
        private boolean[] data;

        public PieceData(int width, int height)
        {
            this.width = width;
            this.height = height;
            this.data = new boolean[width * height];
        }

        public PieceData put(int x, int y)
        {
            data[(y) * width + (x)] = true;
            return this;
        }

        public boolean get(int x, int y)
        {
            return data[(y) * width + (x)];
        }

        public int getWidth()
        {
            return width;
        }

        public int getHeight()
        {
            return height;
        }
    }

    public static final Piece PIECE_CYAN = new Piece(
            50,
            50,
            Color.CYAN,
            new Piece.PieceData(2, 2)
                    .put(0, 0)
                    .put(1, 1)
                    .put(1, 0)
    );

    private PieceData data;
    private int radius;
    private int x;
    private int y;
    private Color color;

    Piece(int x, int y, Color color, PieceData data)
    {
        this.x = x;
        this.y = y;
        this.radius = 50;
        this.color = color;
        this.data = data;
    }


    @Override
    public void render(GraphicsContext g, double delta)
    {
        g.setFill(color);
        for (int i = 0; i < data.getHeight(); i++)
        {
            for (int j = 0; j < data.getWidth(); j++)
            {
                if (data.get(j, i))
                    g.fillOval(
                            (x - radius / 2) - (j - data.getHeight() / 2) * radius,
                            (y - radius / 2) - (i - data.getWidth() / 2) * radius,
                            radius,
                            radius);
            }
        }
    }

    @Override
    public void onMouseEvent(MouseEvent me)
    {

    }

    public Piece setPos(int x, int y)
    {
        this.x = x;
        this.y = y;
        return this;
    }

    public boolean isInside(int mx, int my)
    {
        int centerX = 0;
        int centerY = 0;

        for (int i = 0; i < data.getHeight(); i++)
        {
            for (int j = 0; j < data.getWidth(); j++)
            {
                centerX = x + j * radius - radius / 2 - mx;
                centerY = y + i * radius - radius / 2 - my;
                if (centerX * centerX + centerY * centerY < radius * radius)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public PieceData getData() {
        return data;
    }

    public void setData(PieceData data) {
        this.data = data;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
