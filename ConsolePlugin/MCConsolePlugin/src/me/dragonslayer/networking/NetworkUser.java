package me.dragonslayer.networking;

import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkUser {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Queue<Packet>

    public NetworkUser(Socket socket) {
        try {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPacket(int id, String info) {
        this.writer.println(id);
        this.writer.println(info);
        this.writer.flush();
    }

    public void listen() {


    }


}
