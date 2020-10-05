package server.dragonchat.Main.Objects;

import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class User implements Serializable {

    private static final long serialVersionUID = -942038562193532152L;

    private transient Socket socket;
    private String username;
    private String password;
    private ArrayList<String> history;


    public User(String username, String password, ArrayList<String> history) {
        this.socket = null;
        this.username = username;
        this.password = password;
        this.history = history;
    }

    public User(Socket socket, String username, String password, ArrayList<String> history) {
        this.socket = socket;
        this.username = username;
        this.password = password;
        this.history = history;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
}
