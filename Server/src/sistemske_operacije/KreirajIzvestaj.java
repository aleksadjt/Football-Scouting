
package sistemske_operacije;

import zajednicki.Izvestaj;
import zajednicki.OpstiDomenskiObjekat;

public class KreirajIzvestaj extends OpstaSO{
    public KreirajIzvestaj(OpstiDomenskiObjekat odo){
        this.odo=(Izvestaj)odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        return dbb.kreirajPrazanRed((Izvestaj)odo);
    }

    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
