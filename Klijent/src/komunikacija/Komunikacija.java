
package komunikacija;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import enums.Operacija;
import enums.Signal;
import zajednicki.OpstiDomenskiObjekat;

public class Komunikacija {
    private static Komunikacija komunikacija;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private OpstiDomenskiObjekat povratniOdo;
    private Komunikacija(){
        try {
            socket=new Socket("127.0.0.1", 1234);
            out=new ObjectOutputStream(socket.getOutputStream());
            in=new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Sistem nije pokrenut.");
            System.exit(0);
        }
    }
    public static synchronized Komunikacija uzmiInstancu(){
        if(komunikacija == null) komunikacija = new Komunikacija();
        return komunikacija;
    }
    
    public Signal posaljiZahtev(Operacija operacija, OpstiDomenskiObjekat odo){
        Signal signal;
        try {
            out.writeObject(operacija);
            out.flush();
            out.writeObject(odo);
            out.flush();
            out.reset();
            signal = (Signal)in.readObject();
            povratniOdo = (OpstiDomenskiObjekat) in.readObject();
        } catch (Exception e) {
            signal = Signal.Lose;
            povratniOdo = null;
        }
        return signal;
    }
    public OpstiDomenskiObjekat vratiODO(){
        return povratniOdo;
    }
    public void zatvoriKomunikaciju(){
        try {
            socket.close();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Komunikacija ne moze da se zatvori.");
        }
    }
}
