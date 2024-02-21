import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        String path = "C:\\tmp\\CreatingFileWithJava.txt";
        String[] coolWordsToBeInserted = {
            "Olá, mundo!",
            "Esse é meu primeiro arquivo!!",
            "Grande conquista!!!",
            "AIJDJIAJIWDIJDIOWAJIDOIDJOAJIDJDAWOJFHNOANEFHUOFNI##J222!"
        };
        // Vamos usar o try with resources
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            for(String words : coolWordsToBeInserted){
                bufferedWriter.write(words);
                bufferedWriter.newLine();
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
} 