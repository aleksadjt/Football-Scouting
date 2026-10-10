
package sistemske_operacije;

import zajednicki.OpstiDomenskiObjekat;

public class PromeniIzvestaj extends OpstaSO{
    public PromeniIzvestaj(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        return dbb.ubaci(odo);
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
