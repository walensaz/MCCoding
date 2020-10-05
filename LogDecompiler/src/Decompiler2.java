import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Decompiler2 {

    public static void main(String[] args) throws Exception {
        File[] files = {new File("C:\\Users\\Zachary\\Documents\\logs\\latest.log"),
                new File("C:\\Users\\Zachary\\Documents\\logs\\2018-06-29-7.log"),
                new File("C:\\Users\\Zachary\\Documents\\logs\\2018-06-30-1.log"),
                new File("C:\\Users\\Zachary\\Documents\\logs\\2018-07-01-1.log")};
        PrintWriter printWriter = new PrintWriter(files[0].getParentFile() + "\\decompiled.txt");
        for(int i = 0; i < 1; i++) {
            File file = files[i];
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                if (temp.contains("DragonSlayer")) {
                    printWriter.println(temp);
                    printWriter.flush();
                }
            }
        }
    }


}
