package server.dragonchat.Main.Objects.Packets;

public interface Packet {

    void setID(int id);

    int getID();

    boolean isMyPacket();

}
