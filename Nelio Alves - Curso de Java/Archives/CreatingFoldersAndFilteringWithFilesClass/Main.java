import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter the path: ");
        String path = sc.next();

        File pathInserted = new File(path);

        File[] folders = pathInserted.listFiles(File::isDirectory);

        File[] files = pathInserted.listFiles(File::isFile);

        System.out.println("FOLDERS: ");
        for(File file: files){
            System.out.println(file);
        }

        System.out.println("FILES: ");
        for(File file: files){
            System.out.println(file);
        }

        // Creating a folder inside a directory
        boolean criadoComSucesso = new File(pathInserted + "\\newFolderWithProgram").mkdir();
        System.out.println(criadoComSucesso);
    }
}