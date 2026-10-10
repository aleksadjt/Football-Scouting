
package kontroleri;

import forme.KreirajIzvestajForma;
import java.time.LocalDate;
import zajednicki.Izvestaj;
import zajednicki.OcenaIgraca;

public class KreirajIzvestajKontroler extends OpstiKontroler{
    public KreirajIzvestajKontroler(KreirajIzvestajForma kif){
        super(kif);
    }
    @Override
    public void konvertujODOuFormu() {
        KreirajIzvestajForma kif = (KreirajIzvestajForma)of;
        kif.dodajOcenuIgraca(vratiOcenuIgraca());
        kif.izbrisiText();
    }

    @Override
    public void konvertujFormuUODO() {
        KreirajIzvestajForma kif = (KreirajIzvestajForma)of;
        Izvestaj izvestaj = new Izvestaj();
        izvestaj.setIdIzvestaj(kif.vratiIzvestaj().getIdIzvestaj());
        izvestaj.setKlub(kif.getComboBoxKlub());
        izvestaj.setSkaut(kif.getComboBoxSkaut());
        izvestaj.setDatum(LocalDate.parse(kif.getText1()));
        odo = izvestaj;
    }
    public OcenaIgraca vratiOcenuIgraca(){
        return (OcenaIgraca)odo;
    }
    public void konvertujFormuUOcenu() {
        KreirajIzvestajForma kif = (KreirajIzvestajForma)of;
        OcenaIgraca ocenaIgraca = new OcenaIgraca();
        ocenaIgraca.setOcena(Double.parseDouble(kif.getText2()));
        ocenaIgraca.setBrojGolova(Integer.parseInt(kif.getText3()));
        ocenaIgraca.setBrojAsistencija(Integer.parseInt(kif.getText4()));
        ocenaIgraca.setIgrac(kif.getComboBoxIgrac());
        ocenaIgraca.setIzvestaj(kif.vratiIzvestaj());
        ocenaIgraca.setIdOcenaIgraca(kif.vratiIdOcenaIgraca());
        odo = ocenaIgraca;
    }
    public Izvestaj vratiIzvestaj(){
        return (Izvestaj)odo;
    }
    public void postaviIzvestaj(){
        odo = ((KreirajIzvestajForma)of).vratiIzvestaj();
    }
    public void kreirajPrazanIzvestaj(){
        this.odo = (Izvestaj)of.kreirajObjekat();
    }
}
