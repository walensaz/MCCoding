import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewDecompiler {


    public static void main(String[] args) throws IOException {
        openFileSystem();
    }


    public static void maindecompile(String contains, File[] files) {
        try {
            if(contains.length() == 0) {
                if(keepOpen("You didn't enter anything to search for.  Would you like to close this program?")) {
                    enterLogContains(files);
                    return;
                }
                System.exit(0);
            }
            PrintWriter printWriter = new PrintWriter(files[0].getParentFile() + "\\decompiled.txt");
            for(File file : files) {
                System.out.println(file.getAbsolutePath() + " chosen.");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                ArrayList<String> list = new ArrayList<>();
                for (String s : contains.split(",")) {
                    list.add(s.trim());
                }

                String temp = "";
                while ((temp = reader.readLine()) != null) {
                    for (String s : list) {
                        if (temp.contains(s)) {
                            printWriter.println(temp);
                            printWriter.flush();
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Done! Logs have been saved to decompiled.txt in the selected directory.");
            if(keepOpen("Would you like to close the program?")) {
                openFileSystem();
                return;
            }
            System.exit(0);
        } catch(Exception e) {
            System.exit(0);
        }
    }

    public static void enterLogContains(File[] files) {
        if(files.length == 0) {
            if(keepOpen("You didn't select any files!  Would you like to close this program?")) {
                openFileSystem();
                return;
            }
            System.exit(0);
        }
        String contains = JOptionPane.showInputDialog("Enter what the log contains separated by commas!");
        maindecompile(contains,files);
    }


    public static void openFileSystem() {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setMultipleMode(true);
        dialog.setFile("*.log");
        dialog.setVisible(true);
        enterLogContains(dialog.getFiles());
    }

    public static boolean keepOpen(String message) {
        int choice = JOptionPane.showConfirmDialog(null, message);
        return choice >= 1;
    }



}
