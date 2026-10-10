
package kontroleri;

import forme.PrikaziKlubForma;
import zajednicki.Klub;

public class PrikaziKlubKontroler extends OpstiKontroler{
    public PrikaziKlubKontroler(PrikaziKlubForma pkf, Klub klub){
        super(pkf, klub);   
    }
    @Override
    public void konvertujODOuFormu() {
        PrikaziKlubForma pkf = (PrikaziKlubForma)of;
        pkf.setLabelTekst(((Klub)odo).toString());
    }

    @Override
    public void konvertujFormuUODO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Klub vratiKlub(){
        return (Klub)odo;
    }
}
