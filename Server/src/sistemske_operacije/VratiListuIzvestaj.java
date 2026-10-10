
package sistemske_operacije;

import zajednicki.ListaObjekata;
import zajednicki.OpstiDomenskiObjekat;

public class VratiListuIzvestaj extends OpstaSO {
    
    public VratiListuIzvestaj(OpstiDomenskiObjekat odo){
        this.odo=odo;
    }
    @Override
    public boolean izvrsiOperaciju() throws Exception {
        ListaObjekata lista = new ListaObjekata();
        lista.setListaObjekata(dbb.vratiListu(odo));
        odo = lista;
        return !lista.praznaLista();
    }
    @Override
    public boolean proveriPreduslove() {
        return true;
    }
}
