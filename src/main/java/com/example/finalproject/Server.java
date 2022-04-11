package com.example.finalproject;
import java.io.Serializable;
import java.util.function.Consumer;

public class Server extends Connection{

    private int port;

    public Server(int port,Consumer<Serializable> onCallback){
        super(onCallback);
        this.port = port;

    }
    @Override
    protected boolean isServer() {
        return true;
    }

    @Override
    protected String getIP() {
        return null;
    }

    @Override
    protected int getPort() {
        return port;
    }
}
