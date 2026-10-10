
package niti;

import java.io.EOFException;
import java.net.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import kontroler.Kontroler;
import sistemske_operacije.OpstaSO;
import enums.Operacija;
import zajednicki.OpstiDomenskiObjekat;

public class ObradaKlijenta extends Thread{
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private OpstiDomenskiObjekat odo;
    private Operacija operacija;
    private Kontroler kontroler;
    private String idKlijent;
    public ObradaKlijenta(Socket socket){
        this.socket=socket;
        kontroler = Kontroler.uzmiInstancu();
        idKlijent = socket.getInetAddress().getHostAddress()+":"+socket.getPort();
        System.out.print("Klijent "+idKlijent+" se povezao na server.\n");
    }
    @Override
    public void run(){
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            while(true){
                operacija = (Operacija) in.readObject();
                odo = (OpstiDomenskiObjekat) in.readObject();
                OpstaSO sistemskaOperacija = kontroler.izvrsiSO(operacija, odo);
                out.writeObject(sistemskaOperacija.vratiSignal());
                out.flush();
                out.writeObject(sistemskaOperacija.vratiODO());
                out.flush();
                out.reset();
            }
            
        } catch (EOFException | SocketException e) {
            System.out.print("Klijent "+idKlijent+" se odjavio sa servera.\n");
        } catch (Exception e){System.out.print("Serverska greska. "+e);}
        finally {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.print("Socket ne moze da se zatvori. "+e);
            }
        }  
    }
}
