
package sistemske_operacije;

import zajednicki.OcenaIgraca;
import zajednicki.OpstiDomenskiObjekat;

public class PromeniOcenaIgraca extends OpstaSO {
    public PromeniOcenaIgraca(OpstiDomenskiObjekat odo){
        this.odo = odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        return dbb.ubaci(odo);
    }
    
    @Override
    public boolean proveriPreduslove() {
        OcenaIgraca ocenaIgraca = (OcenaIgraca)odo;
        return ocenaIgraca.getOcena()>=1 &&ocenaIgraca.getOcena()<=10 && ocenaIgraca.getBrojGolova()>=0 && ocenaIgraca.getBrojAsistencija()>=0;
    }
}
