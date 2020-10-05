package server.dragonchat.Main.Objects.Packets;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import server.dragonchat.Main.Objects.User;

public class LoginPacket implements Packet {

    int id = 1;
    String packet;

    public LoginPacket(String packet) {
        this.packet = packet;
    }

    public void login() {
        if(isMyPacket()) {
            if()
        }

    }

    @Override
    public void setID(int id) {

    }

    @Override
    public int getID() {
        return 0;
    }

    public User decode() {
        String[] split = packet.split("#");



    }

    @Override
    public boolean isMyPacket() {
        if(packet.isEmpty()) {
            return false;
        }
        String[] split = packet.split("#");
        if(split[0].equalsIgnoreCase("login") || split[0].equalsIgnoreCase("1") || split[0].equalsIgnoreCase("loginpacket")) {
            return true;
        }
        return false;
    }
}
