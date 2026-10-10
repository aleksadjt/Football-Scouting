
package sistemske_operacije;

import zajednicki.OcenaIgraca;
import zajednicki.OpstiDomenskiObjekat;

public class KreirajOcenaIgraca extends OpstaSO{
    public KreirajOcenaIgraca(OpstiDomenskiObjekat odo){
        this.odo = odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        if(dbb.kreiraj(odo)){
            return dbb.ubaci(odo);
        }
        return false;
    }
    @Override
    public boolean proveriPreduslove() {
        OcenaIgraca ocenaIgraca = (OcenaIgraca)odo;
        return ocenaIgraca.getOcena()>=1 &&ocenaIgraca.getOcena()<=10 && ocenaIgraca.getBrojGolova()>=0 && ocenaIgraca.getBrojAsistencija()>=0;
    }
}
