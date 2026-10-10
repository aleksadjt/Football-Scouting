
package kontroleri;

import forme.KreirajKlubForma;
import zajednicki.Klub;

public class KreirajKlubKontroler extends OpstiKontroler{
    public KreirajKlubKontroler(KreirajKlubForma kkf){
        super(kkf);
    }
    
    @Override
    public void konvertujODOuFormu() {
        
    }
    @Override
    public void konvertujFormuUODO() {
        Klub klub = (Klub)odo;
        KreirajKlubForma kkf = (KreirajKlubForma) of;
        klub.setNazivKluba(kkf.getText());
        klub.setLiga(kkf.getComboBoxLiga());
        this.odo = klub;
        this.of = kkf;
    }
    public void kreirajPrazanKlub(){
        this.odo = (Klub)of.kreirajObjekat();
    }
}
