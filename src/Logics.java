import java.util.*;

/**
 * Класс содержит логигу игры.
 */
public class Logics {
    private Random random = new Random();
    private Board board = new Board();
    private int fieldSize = board.getFieldSize();
    private Cell[][] cells = new Cell[fieldSize][fieldSize];
    private int numbersOfBomb = 5;
    private int emptyCell = fieldSize * fieldSize - numbersOfBomb;
    private int openEmptyCell;
    private boolean kill;


    public void start() {
        initCells();
        while (true) {
            if (openEmptyCell < emptyCell) {
                board.drowBoard(cells);
                playerProgress();
            } else if (openEmptyCell >= emptyCell) {
                board.drowBoard(cells);
                System.out.println();
                System.out.println("[*][*][*] ПОЗДРАВЛЯЮ!!! ВЫ ВЫИГРАЛИ!!! [*][*][*]");
            }

            if (kill) {
                board.drowBoard(cells);
                System.out.println();
                System.out.println("!!! ВЫ УБИТЫ !!!");
                break;
            }
        }
    }


    /**
     * Метод инициализирует каждую ячейку.
     * Расставляет мины и считает количество мин вокруг ячейки.
     */
    public void initCells() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                cells[i][j] = new Cell();
            }
        }

        for (int i = 0; i < numbersOfBomb; i++) {
            int x = random.nextInt(fieldSize);
            int y = random.nextInt(fieldSize);
            if (!cells[y][x].isBomb()) {
                cells[y][x].setBomb(true);
            }
        }

        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++) {
                if (!cells[x][y].isBomb()) {
                    int count = 0;
                    for (int nx = -1; nx < 2; nx++) {
                        for (int ny = -1; ny < 2; ny++) {
                            int xx = nx + x;
                            int yy = ny + y;
                            if (xx < 0 || yy < 0 || xx > fieldSize - 1 || yy > fieldSize - 1) {
                                xx = x;
                                yy = y;
                            }
                            if (cells[xx][yy].isBomb()) {
                                count++;
                            }
                        }
                    }
                    cells[x][y].setBombInNextCell(count);
                }
            }
        }
    }

    /**
     * Метод получает координаты ячейки и вносит изменения в состояние ячейки.
     */
    public void playerProgress() {
        int x = Integer.parseInt(GamerStep.step("Введите координаты оси y: "));
        int y = Integer.parseInt(GamerStep.step("Введите координаты оси x: "));
        String mark = GamerStep.step("Метка? [!]: ");

        if (mark.equals("!")) {
            if (!cells[x][y].isMark()) {
                cells[x][y].setMark(true);
            }
        } else if (!cells[x][y].isOpen()) {
            cells[x][y].setOpen(true);
            openEmptyCell++;
        }

        if (cells[x][y].isOpen() && cells[x][y].isBomb()) {
            for (int i = 0; i < fieldSize; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    cells[i][j].setOpen(true);
                }
            }

            kill = true;
        }
    }
}
