public class Position {

    private int col;
    private int row;

    public Position(int col, int row) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return toPixel(row);
    }

    public void setRow(int row) {
        this.row = toPixel(row);
    }

    public int toPixel (int i) {
        return i*Grid.CELLSIZE + Grid.PADDING;
    }
}
