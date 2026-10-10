
package sistemske_operacije;

import zajednicki.Izvestaj;
import zajednicki.OcenaIgraca;
import zajednicki.OpstiDomenskiObjekat;

public class ObrisiIzvestaj extends OpstaSO {
    public ObrisiIzvestaj(OpstiDomenskiObjekat odo){
        this.odo = odo;
    }

    @Override
    public boolean izvrsiOperaciju() throws Exception {
        OcenaIgraca ocenaIgraca = new OcenaIgraca();
        ocenaIgraca.setIzvestaj((Izvestaj)odo);
        dbb.obrisi(ocenaIgraca);
        return dbb.obrisi(odo);
    }

    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
