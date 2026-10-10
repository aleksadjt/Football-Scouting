
package sistemske_operacije;

import zajednicki.Klub;
import zajednicki.ListaObjekata;
import zajednicki.OpstiDomenskiObjekat;

public class VratiListuKlub extends OpstaSO {
    public VratiListuKlub(OpstiDomenskiObjekat odo){
        this.odo = odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        ListaObjekata lista = new ListaObjekata();
        lista.setListaObjekata(dbb.vratiListu((Klub)odo));
        odo = lista;
        return !lista.praznaLista();
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
    
}
