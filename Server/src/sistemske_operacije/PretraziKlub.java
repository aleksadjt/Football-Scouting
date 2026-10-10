
package sistemske_operacije;

import zajednicki.*;


public class PretraziKlub extends OpstaSO{
    public PretraziKlub(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception{
        return dbb.pretrazi((Klub)odo);
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
