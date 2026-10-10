
package kontroleri;

import enums.Operacija;
import enums.Signal;
import forme.OpstaForma;
import java.util.ArrayList;
import java.util.List;
import komunikacija.Komunikacija;
import zajednicki.*;

public abstract class OpstiKontroler {
    private Komunikacija komunikacija = Komunikacija.uzmiInstancu();
    protected OpstiDomenskiObjekat odo;
    protected OpstaForma of;
    public OpstiKontroler(OpstaForma of){
        this.of=of;
    }
    public OpstiKontroler(OpstaForma of, OpstiDomenskiObjekat odo){
        this.of=of;
        this.odo=odo;
    }
    public Signal pozivSO(Operacija operacija){
        Signal signal = komunikacija.posaljiZahtev(operacija, odo);
        odo = komunikacija.vratiODO();
        return signal;
    }
    public abstract void konvertujODOuFormu();
    public abstract void konvertujFormuUODO();
    
    public List<OpstiDomenskiObjekat> vratiSveX(Operacija operacija){
        this.odo = new ListaObjekata();
        pozivSO(operacija);
        List<OpstiDomenskiObjekat>lista=new ArrayList<>();
        for(OpstiDomenskiObjekat tmp : ((ListaObjekata)odo).getListaObjekata()){
            lista.add(tmp);
        }
        return lista;
    }
}
