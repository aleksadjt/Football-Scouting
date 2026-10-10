
package sistemske_operacije;

import zajednicki.*;


public class PretraziOcenaIgraca extends OpstaSO{
    public PretraziOcenaIgraca(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception{
        return dbb.pretrazi((OcenaIgraca)odo);
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
