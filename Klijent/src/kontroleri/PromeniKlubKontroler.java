
package kontroleri;

import forme.PromeniKlubForma;
import zajednicki.Klub;

public class PromeniKlubKontroler extends OpstiKontroler{
    public PromeniKlubKontroler(PromeniKlubForma pkf, Klub klub){
        super(pkf, klub);
    }
    public void zapamtiKlub(Klub klub){
        odo=klub;
    }
    @Override
    public void konvertujODOuFormu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void konvertujFormuUODO() {
        PromeniKlubForma pkf = (PromeniKlubForma)of;
        Klub klub = (Klub)odo;
        klub.setNazivKluba(pkf.vratiText());
        klub.setLiga(pkf.vratiComboBoxItem());
        odo=klub;
    }
}
