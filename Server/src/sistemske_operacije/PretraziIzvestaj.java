
package sistemske_operacije;

import zajednicki.*;


public class PretraziIzvestaj extends OpstaSO{
    public PretraziIzvestaj(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception{
        return dbb.pretrazi((Izvestaj)odo);
    }

    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
