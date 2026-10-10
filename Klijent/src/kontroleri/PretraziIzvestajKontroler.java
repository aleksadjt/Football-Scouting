
package kontroleri;

import forme.PretraziIzvestajForma;
import zajednicki.Izvestaj;
import zajednicki.ListaObjekata;
import zajednicki.OpstiDomenskiObjekat;

public class PretraziIzvestajKontroler extends OpstiKontroler{
    public PretraziIzvestajKontroler(PretraziIzvestajForma pif){
        super(pif);
    }
    @Override
    public void konvertujODOuFormu() {
        PretraziIzvestajForma pif = (PretraziIzvestajForma)of;
        pif.obrisiTabelu();
        for(OpstiDomenskiObjekat obj : ((ListaObjekata)odo).getListaObjekata()){
            pif.ubaciItemUTabelu((Izvestaj)obj);
        }
    }
    @Override
    public void konvertujFormuUODO() {
        PretraziIzvestajForma pif = (PretraziIzvestajForma)of;
        Izvestaj izvestaj = (Izvestaj)pif.kreirajObjekat();
        izvestaj.setKlub(pif.vratiComboBoxKlub());
        izvestaj.setSkaut(pif.vratiComboBoxSkaut());
        izvestaj.setIgracZaPretragu(pif.vratiComboBoxIgrac());
        odo=izvestaj;
    }
    public void konvertujFormuUODO2() {
        PretraziIzvestajForma pif = (PretraziIzvestajForma)of;
        Izvestaj izvestaj = (Izvestaj) pif.kreirajObjekat();
        izvestaj.setIdIzvestaj(pif.vratiIdIzabranogIzvestaja());
        odo=izvestaj;
    }
    public Izvestaj vratiIzvestaj(){
        return (Izvestaj)odo;
    }
}
