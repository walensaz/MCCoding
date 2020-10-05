import java.awt.*;
import java.io.*;

public class FileWindowAPI {

    public static File[] openFileSystem() {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setMultipleMode(true);
        dialog.setVisible(true);
        File[] files = dialog.getFiles();
        if(files.length == 0 || files == null) {
            return null;
        }
        return files;
    }


}
