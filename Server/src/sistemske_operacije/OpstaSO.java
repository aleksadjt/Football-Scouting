
package sistemske_operacije;

import baza.DBBroker;
import enums.Signal;
import zajednicki.OpstiDomenskiObjekat;

public abstract class OpstaSO {
    protected DBBroker dbb;
    protected OpstiDomenskiObjekat odo;
    private Signal signal;
    public Signal izvrsi(){
        try {
            if(!proveriPreduslove()) return signal = Signal.Lose;
            dbb = new DBBroker();
            boolean uspelo = izvrsiOperaciju();
            if(uspelo) {
                dbb.sacuvajIzmene();
                return signal = Signal.Dobro;
            }
            dbb.vratiNaPrethodnoStanje();
        }
        catch (Exception e) {
            try{ dbb.vratiNaPrethodnoStanje(); }
            catch(Exception ee){
                System.out.print(ee);
            }
        }
        return signal = Signal.Lose;
    }
    public abstract boolean izvrsiOperaciju() throws Exception;
    public abstract boolean proveriPreduslove();
    public OpstiDomenskiObjekat vratiODO(){
        return odo;
    }
    public Signal vratiSignal(){
        return signal;
    }
}
