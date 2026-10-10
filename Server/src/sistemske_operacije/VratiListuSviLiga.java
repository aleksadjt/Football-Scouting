
package sistemske_operacije;

import zajednicki.Liga;
import zajednicki.ListaObjekata;
import zajednicki.OpstiDomenskiObjekat;

public class VratiListuSviLiga extends OpstaSO{
    private ListaObjekata lista;
    public VratiListuSviLiga(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        lista = (ListaObjekata)odo;
        lista.setListaObjekata(dbb.vratiListuSvi(new Liga()));
        return true;
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
    
}
