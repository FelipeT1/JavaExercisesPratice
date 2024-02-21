import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String path = "C:\\tmp\\OlaMundo.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            String line = bufferedReader.readLine();

            while(line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}