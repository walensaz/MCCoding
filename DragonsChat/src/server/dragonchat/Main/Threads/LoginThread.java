package server.dragonchat.Main.Threads;

import server.dragonchat.Main.Objects.User;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class LoginThread extends Thread implements Runnable {

    BufferedReader input;
    PrintWriter output;
    Socket socket;
    User user;

    public LoginThread(Socket socket) throws IOException {
        this.socket = socket;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream());
    }


    public void run() {
        try {
            String temp = "";
            if ((temp = input.readLine()) != null) {
                String username;
                String password;
                String packet =



            }


        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
