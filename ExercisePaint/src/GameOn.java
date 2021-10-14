import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

public class GameOn implements KeyboardHandler {

    private Grid grid;
    private RectangleGrid[][] rectangleGrids;
    private Player player;
    private Keyboard keyboard;
    private LinkedList<RectangleGrid> blocksDrawn;
    private LinkedList<RectangleGrid> blocksSaved;

    public GameOn() {

        keyboard = new Keyboard(this);

        listeners();

        grid = new Grid(20,20);
        player = new Player(10,10);
        rectangleGrids = grid.getDrawGrid();

        blocksDrawn = new LinkedList<>();
        blocksSaved = new LinkedList<>();



    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            if (player.getRectPlayer().getY() - Grid.CELLSIZE > 0) {
                player.getRectPlayer().translate(0, -Grid.CELLSIZE);
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            if (player.getRectPlayer().getY() + Grid.CELLSIZE < Grid.getRows() * Grid.CELLSIZE)
                player.getRectPlayer().translate(0, Grid.CELLSIZE);

        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            if (player.getRectPlayer().getX() - Grid.CELLSIZE > 0) {
                player.getRectPlayer().translate(-Grid.CELLSIZE, 0);
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            if (player.getRectPlayer().getX() + Grid.CELLSIZE < Grid.getCols() * Grid.CELLSIZE)
                player.getRectPlayer().translate(Grid.CELLSIZE, 0);

        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

            for (int i = 0; i < rectangleGrids.length; i++) {
                for (int j = 0; j < rectangleGrids[i].length; j++) {
                    if (rectangleGrids[i][j].getY() == player.getRectPlayer().getY() && rectangleGrids[i][j].getX() == player.getRectPlayer().getX()) {
                        if (rectangleGrids[i][j].isFilled()) {

                            rectangleGrids[i][j].draw();
                            rectangleGrids[i][j].setFilled(false);
                            blocksDrawn.remove(rectangleGrids[i][j]);
                        } else {
                            rectangleGrids[i][j].fill();
                            rectangleGrids[i][j].setFilled(true);
                            blocksDrawn.add(rectangleGrids[i][j]);
                        }
                    }

                }
            }
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            blocksSaved.clear();
            for (RectangleGrid block : blocksDrawn) {
                blocksSaved.add(block);
           }

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
            for (RectangleGrid block : blocksSaved) {
                block.fill();
                block.setFilled(true);
                blocksDrawn.add(block);
            }

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_C) {
            for(RectangleGrid block : blocksDrawn) {
                block.draw();
                block.setFilled(false);
            }
            blocksDrawn.clear();

        }
    }




    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
    public void listeners () {

        KeyboardEvent keyC = new KeyboardEvent();
        keyC.setKey(KeyboardEvent.KEY_C);
        keyC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyC);

        KeyboardEvent keyS = new KeyboardEvent();
        keyS.setKey(KeyboardEvent.KEY_S);
        keyS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyS);

        KeyboardEvent keyL = new KeyboardEvent();
        keyL.setKey(KeyboardEvent.KEY_L);
        keyL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyL);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);


    }

}
