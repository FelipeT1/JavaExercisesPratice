package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {
    public static void main(String[] args) {
        
        String path = "C:\\tmp\\exerciseReadingFile\\sales.txt";

        List<Product> products = new ArrayList<>();

        File filePath = new File(path);
        String newFolder = filePath.getParent() + "\\out";

        boolean isFolderCreated = new File(newFolder).mkdir();

        String summaryCSV = "C:\\tmp\\exerciseReadingFile\\out\\summary.csv";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath)))
        {
            String infoCSV = bufferedReader.readLine();

            while(infoCSV != null){

                String[] p = infoCSV.split(", ");
                String productName = p[0];
                double productPrice = Double.parseDouble(p[1]);
                int productQuantity = Integer.parseInt(p[2]);

                products.add(new Product(productName, productPrice, productQuantity));

                infoCSV = bufferedReader.readLine();
            }


            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(summaryCSV))){
                
                for(Product productInfo : products){
                    bufferedWriter.write( productInfo.getName() + ", " + productInfo.totalValue());
                    bufferedWriter.newLine();    
                }
            }
            catch (IOException e){

            }

        }
        catch (IOException e)
        {

        }

    
    }
}
