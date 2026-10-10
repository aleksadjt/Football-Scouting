
package sistemske_operacije;

import zajednicki.*;

public class KreirajKlub extends OpstaSO {
    public KreirajKlub(OpstiDomenskiObjekat odo){
        this.odo=(Klub)odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        return dbb.kreirajPrazanRed((Klub)odo);
    }

    @Override
    public boolean proveriPreduslove() {
        return true;
    }
    
}
