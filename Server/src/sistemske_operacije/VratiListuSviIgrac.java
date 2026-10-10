
package sistemske_operacije;

import zajednicki.Igrac;
import zajednicki.ListaObjekata;
import zajednicki.OpstiDomenskiObjekat;

public class VratiListuSviIgrac extends OpstaSO{
    private ListaObjekata lista;
    public VratiListuSviIgrac(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        lista = (ListaObjekata)odo;
        lista.setListaObjekata(dbb.vratiListuSvi(new Igrac()));
        return true;
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
