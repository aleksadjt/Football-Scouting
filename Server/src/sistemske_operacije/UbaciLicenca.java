
package sistemske_operacije;

import zajednicki.Licenca;
import zajednicki.OpstiDomenskiObjekat;

public class UbaciLicenca extends OpstaSO{
    public UbaciLicenca(OpstiDomenskiObjekat odo){
        this.odo = odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        if(dbb.kreirajPrazanRed(odo)){
            return dbb.ubaci(odo);
        }
        return false;
    }
    @Override
    public boolean proveriPreduslove() {
        return !((Licenca)odo).getNazivLicence().equals("")  && !((Licenca)odo).getOpisLicence().equals("");
    }
    
}
