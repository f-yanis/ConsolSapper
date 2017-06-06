public class Cell {
    private boolean bomb, mark, open;
    private int bombInNextCell;

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getBombInNextCell() {
        return bombInNextCell;
    }

    public void setBombInNextCell(int bombInNextCell) {
        this.bombInNextCell = bombInNextCell;
    }

    public String drowCell() {
        if (!open && mark){
            return "[!]";
        } else if (!open) {
            return "[ ]";
        } else if (open && bomb) {
            return "[*]";
        } else if (open && !bomb) {
            return "[" + bombInNextCell + "]";
        }
        return "12";
    }

}
