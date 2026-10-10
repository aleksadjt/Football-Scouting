
package server;

import java.io.IOException;
import java.net.*;
import niti.ObradaKlijenta;

public class Server {
    private ServerSocket serverSocket;
    private boolean pokrenut=false;
    public void pokreniServer() {
        try {
            pokrenut=true;
            serverSocket = new ServerSocket(1234);
            System.out.print("Server je pokrenut.\n");
            while(pokrenut){
                Socket socket = serverSocket.accept();
                new ObradaKlijenta(socket).start();
            }
        } catch (IOException ex) {
            if(pokrenut) System.out.print("Server nije pokrenut.\n");
        }
    }
    
    public void zaustaviServer() {
        try {
            if (serverSocket!=null && !serverSocket.isClosed()) {
                pokrenut = false;
                serverSocket.close();
            }
            System.out.println("Server je zaustavljen.");
        } catch (IOException ex) {
            System.out.println("Greska pri zaustavljanju servera.");
        }
    }
}
