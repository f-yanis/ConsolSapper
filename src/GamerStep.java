import java.io.*;


/**
 * Этот класс принимает входящюю информацию от игрока.
 */
public class GamerStep {

    /**Метод принимает координаты ячейки.
     * @param text
     * @return step
     */
    public static String step(String text) {
        String step = null;

        System.out.print(text);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            step = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return step;
    }
}
