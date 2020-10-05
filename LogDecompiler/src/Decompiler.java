import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Decompiler {

    public static void main(String[] args) throws Exception {
        String path = JOptionPane.showInputDialog("Enter path!");
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        PrintWriter printWriter = new PrintWriter(file.getParentFile() + "\\decompiled.txt");
        String temp = "";
        String contains = JOptionPane.showInputDialog("Enter what the log contains seperated by commas!");
        ArrayList<String> list = new ArrayList<>();
        for(String s : contains.split(",")) {
            list.add(s.trim());
        }
        while((temp = reader.readLine()) != null) {
            for (String s : list) {
                if (temp.contains(s)) {
                    printWriter.println(temp);
                    printWriter.flush();
                    break;
                }
            }
        }
    }


}
