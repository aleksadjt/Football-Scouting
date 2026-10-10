
package sistemske_operacije;

import zajednicki.OpstiDomenskiObjekat;

public class ObrisiKlub extends OpstaSO {
    public ObrisiKlub(OpstiDomenskiObjekat odo){
        this.odo = odo;
    }

    @Override
    public boolean izvrsiOperaciju() throws Exception {
        return dbb.obrisi(odo);
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
