import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import java.util.LinkedList;

public class Player{

    private Position pos;
    private Rectangle rectPlayer;



    public Player(int col, int row) {
        pos = new Position(col, row);
        rectPlayer = new Rectangle(pos.toPixel(col), pos.toPixel(col), Grid.CELLSIZE,Grid.CELLSIZE);
        rectPlayer.setColor(Color.GREEN);
        rectPlayer.fill();

    }


    public Rectangle getRectPlayer() {
        return rectPlayer;
    }


}
