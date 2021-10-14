import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.w3c.dom.css.Rect;

public class Grid {
    public static final int CELLSIZE = 20;
    public static final int PADDING = 10;
    private static int rows;
    private static int cols;

    RectangleGrid[][] drawGrid;


    public Grid(int cols, int rows) {
        Grid.cols = cols;
        Grid.rows = rows;
        drawGrid();

    }

    public void drawGrid() {
        drawGrid = new RectangleGrid[cols][rows];
        for (int i = 0; i < drawGrid.length; i ++) {
            for (int j = 0; j < drawGrid[i].length; j++) {
                drawGrid[i][j] = new RectangleGrid(i*CELLSIZE+PADDING,j*CELLSIZE+PADDING,CELLSIZE,CELLSIZE);
                drawGrid[i][j].draw();
            }
        }
    }

    public RectangleGrid[][] getDrawGrid() {
        return drawGrid;
    }

    public static int getCols() {
        return cols;
    }
    public static int getRows() {
        return rows;
    }
}
