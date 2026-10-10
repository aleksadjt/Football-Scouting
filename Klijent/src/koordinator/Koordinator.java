
package koordinator;

import forme.*;
import zajednicki.Izvestaj;
import zajednicki.Klub;
import zajednicki.OcenaIgraca;
import zajednicki.Skaut;

public class Koordinator {
    private static Koordinator koordinator;
    private Skaut ulogovaniSkaut;
    private Koordinator(){};
    public static Koordinator uzmiInstancu(){
        if(koordinator == null) koordinator = new Koordinator();
        return koordinator;
    }
    //pokreni stvari
    public void pokreniAplikaciju(){
        java.awt.EventQueue.invokeLater(()->{
            new PrijavaForma().setVisible(true);
        });
    }
    public void pokreniGlavnuFormu(Skaut skaut){
        ulogovaniSkaut=skaut;
        new GlavnaForma().setVisible(true);
    }
    public void pokreniKreirajIzvestajFormu(){
        KreirajIzvestajForma kif = new KreirajIzvestajForma();
        kif.setVisible(true);
        kif.ucitaj();
    }
    public void pokreniKreirajKlubFormu(){
        KreirajKlubForma kkf = new KreirajKlubForma();
        kkf.setVisible(true);
        kkf.ucitaj();
    }
    public void pokreniPretraziKlubFormu(){
        PretraziKlubForma pkf = new PretraziKlubForma();
        pkf.ucitaj();
        pkf.setVisible(true);
    }
    public void pokreniPrikaziKlubFormu(Klub klub, PretraziKlubForma roditelj){
        new PrikaziKlubForma(klub, roditelj).setVisible(true);
    }
    public void pokreniPromeniKlubFormu(Klub klub, PrikaziKlubForma roditelj){
        new PromeniKlubForma(klub, roditelj).setVisible(true);
    }
    public void pokreniUbaciLicencaFormu(){
        new UbaciLicencuForma().setVisible(true);
    }
    public void pokreniPretraziIzvestajFormu(){
        new PretraziIzvestajForma().setVisible(true);
    }
    public void pokreniPromeniIzvestajFormu(Izvestaj izvestaj, PretraziIzvestajForma roditelj){
        PromeniIzvestajForma pif = new PromeniIzvestajForma(izvestaj, roditelj);
        pif.ucitaj();
        pif.setVisible(true);
    }
    public void pokreniPromeniOcenuIgracaFormu(OcenaIgraca ocenaIgraca, PromeniIzvestajForma roditelj){
        new PromeniOcenuIgracaForma(ocenaIgraca, roditelj).setVisible(true);
    }
    public void zatvoriFormu(OpstaForma of){
        of.dispose();
    }
    public Skaut vratiUlogovanogSkauta(){
        return ulogovaniSkaut;
    }
}
