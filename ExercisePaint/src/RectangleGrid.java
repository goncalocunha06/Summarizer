import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class RectangleGrid extends Rectangle {

    private boolean isFilled;

    public RectangleGrid(double var1, double var3, double var5, double var7) {
        super(var1,var3, var5,var7);
        isFilled = false;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }
}
