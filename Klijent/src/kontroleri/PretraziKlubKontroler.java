
package kontroleri;

import forme.PretraziKlubForma;
import zajednicki.Klub;
import zajednicki.ListaObjekata;
import zajednicki.OpstiDomenskiObjekat;

public class PretraziKlubKontroler extends OpstiKontroler {
    public PretraziKlubKontroler(PretraziKlubForma pkf){
        super(pkf);
        this.odo = (Klub)of.kreirajObjekat();
    }
    @Override
    public void konvertujODOuFormu() {
        PretraziKlubForma pkf = (PretraziKlubForma)of;
        pkf.isprazniKlubListu();
        for(OpstiDomenskiObjekat tmp : ((ListaObjekata)odo).getListaObjekata()) {
            pkf.dodajKlubUListu((Klub)tmp);
        }
    }
    @Override
    public void konvertujFormuUODO() {
        PretraziKlubForma pkf = (PretraziKlubForma)of;
        Klub klub = (Klub)of.kreirajObjekat();
        klub.setNazivKluba(pkf.getText());
        klub.setLiga(pkf.getComboBoxLiga());
        odo = klub;
    }
    public void konvertujFormuUODO2() {
        PretraziKlubForma pkf = (PretraziKlubForma)of;
        Klub klub = pkf.vratiIzabranKlub();
        odo = klub;
    }
    public Klub vratiKlub(){
        return (Klub)odo;
    }
}
