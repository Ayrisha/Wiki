import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg ){
        System.out.println("Введите слово для поиска по википедии на английском языке: ");
        Scanner s = new Scanner(System.in);
        String world = s.nextLine();
        try {
            URL u = new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&exchars=500&explaintext=&format=json&titles=" + world);
            HttpURLConnection in = (HttpURLConnection) u.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(in.getInputStream()));
            String answer = br.readLine();
            int index = answer.indexOf("extract");
            char[] str = new char[answer.length() - index - 18];
            answer.getChars(index + 10, answer.length() - 8, str, 0);
            System.out.println("Результат: ");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
