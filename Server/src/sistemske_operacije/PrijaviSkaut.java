
package sistemske_operacije;

import zajednicki.*;


public class PrijaviSkaut extends OpstaSO{
    public PrijaviSkaut(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception{
        return dbb.pretrazi((Skaut)odo);
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
