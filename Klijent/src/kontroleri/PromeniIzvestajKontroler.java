
package kontroleri;

import forme.PromeniIzvestajForma;
import java.time.LocalDate;
import zajednicki.Izvestaj;
import zajednicki.ListaObjekata;
import zajednicki.OcenaIgraca;
import zajednicki.OpstiDomenskiObjekat;

public class PromeniIzvestajKontroler extends OpstiKontroler{
    public PromeniIzvestajKontroler(PromeniIzvestajForma pif){
        super(pif);
    }
    @Override
    public void konvertujODOuFormu() {
        PromeniIzvestajForma pif = (PromeniIzvestajForma)of;
        pif.obrisiTabelu();
        for(OpstiDomenskiObjekat tmp : ((ListaObjekata)odo).getListaObjekata()){
            pif.dodajOcenuIgraca((OcenaIgraca)tmp);
        }
    }

    @Override
    public void konvertujFormuUODO() {
        PromeniIzvestajForma pif = (PromeniIzvestajForma)of;
        Izvestaj izvestaj = (Izvestaj)odo;
        izvestaj.setKlub(pif.getComboBoxKlub());
        izvestaj.setSkaut(pif.getComboBoxSkaut());
        izvestaj.setDatum(LocalDate.parse(pif.getText1()));
        odo = izvestaj;
    }
    public void setOcenaIgraca(Izvestaj izvestaj){
        OcenaIgraca ocenaIgraca = new OcenaIgraca();
        ocenaIgraca.setIzvestaj(izvestaj);
        odo=ocenaIgraca;
    }
    public void setOcenaIgraca(int idOcenaIgraca, Izvestaj izvestaj){
        OcenaIgraca ocenaIgraca = new OcenaIgraca();
        ocenaIgraca.setIzvestaj(izvestaj);
        ocenaIgraca.setIdOcenaIgraca(idOcenaIgraca);
        odo=ocenaIgraca;
    }
    public OcenaIgraca getOcenaIgraca(){
        return (OcenaIgraca)odo;
    }
    public void setIzvestaj(Izvestaj izvestaj){
        odo = izvestaj;
    }
}
