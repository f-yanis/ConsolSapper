/**
 * Этот класс описывает состояние доски. Группирует ячейки и содержит размер игрового поля.
 */
public class Board {
    /**
     * Размер игрового поля.
     */
    private int fieldSize = 6;

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    /**Метод принимает масив ячеек и расставляет их на игровом поле.
     * @param cells
     */
    public void drowBoard(Cell[][] cells) {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].drowCell());
            }

            System.out.println();
        }
    }
}
