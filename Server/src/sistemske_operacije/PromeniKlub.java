
package sistemske_operacije;

import zajednicki.Klub;
import zajednicki.OpstiDomenskiObjekat;

public class PromeniKlub extends OpstaSO {
    public PromeniKlub(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        return dbb.ubaci((Klub)odo);
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
    
}
