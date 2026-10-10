
package sistemske_operacije;

import zajednicki.Klub;
import zajednicki.ListaObjekata;
import zajednicki.OpstiDomenskiObjekat;

public class VratiListuSviKlub extends OpstaSO{
    private ListaObjekata lista;
    public VratiListuSviKlub(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        lista = (ListaObjekata)odo;
        lista.setListaObjekata(dbb.vratiListuSvi(new Klub()));
        return true;
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
