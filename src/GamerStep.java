import java.io.*;

public class GamerStep {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static String step;

    public static String step(String text) {
        System.out.print(text);
        try {
            step = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return step;
    }
}
