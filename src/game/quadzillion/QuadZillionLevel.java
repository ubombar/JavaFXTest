package game.quadzillion;

import core.GameObjectContainer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class QuadZillionLevel extends GameObjectContainer
{
    private Piece holdingPiece;
    private boolean pressed;
    private int mouseX;
    private int mouseY;
    private int pieceMouseDistanceX;
    private int pieceMouseDistanceY;

    public QuadZillionLevel()
    {
        holdingPiece = Piece.PIECE_CYAN.setPos(50, 50);
        addObject(holdingPiece);
    }

    @Override
    public void update(GraphicsContext g, int width, int height, double delta)
    {

        holdingPiece.setPos(mouseX, mouseY);

    }

    @Override
    public void onMouseEvent(MouseEvent me)
    {
        mouseX = (int) me.getX();
        mouseY = (int) me.getY();
    }

    @Override
    public void onKeyEvent(KeyEvent ke)
    {

    }
}
