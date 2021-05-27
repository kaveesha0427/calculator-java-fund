package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class History {
    public static void CalHistory(String calculatorHistory) throws IOException {
        File file = new File("CalculationHistory.txt");
        FileWriter fileWriter= null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter(file,true);
            printWriter = new PrintWriter(fileWriter,true);
            printWriter.print(calculatorHistory);
            printWriter.println("\n\n\n\n\n");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fileWriter.close();
            printWriter.close();
        }
    }
}
