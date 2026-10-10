
package sistemske_operacije;

import zajednicki.ListaObjekata;
import zajednicki.OpstiDomenskiObjekat;
import zajednicki.Skaut;

public class VratiListuSviSkaut extends OpstaSO {
    private ListaObjekata lista;
    public VratiListuSviSkaut(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        lista = (ListaObjekata)odo;
        lista.setListaObjekata(dbb.vratiListuSvi(new Skaut()));
        return true;
    }
    
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
