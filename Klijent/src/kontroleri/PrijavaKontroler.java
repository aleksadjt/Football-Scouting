package kontroleri;

import forme.PrijavaForma;
import zajednicki.Skaut;

public class PrijavaKontroler extends OpstiKontroler{
    public PrijavaKontroler(PrijavaForma form){
        super(form);
    }
    public Skaut uzmiUlogovanogSkauta(){
        return (Skaut)odo;
    }
    @Override
    public void konvertujODOuFormu(){
        
    }
    @Override
    public void konvertujFormuUODO() {
        PrijavaForma loginforma=(PrijavaForma)of;
        Skaut skaut=(Skaut)of.kreirajObjekat();
        skaut.setKorisnickoIme(loginforma.getText1());
        skaut.setLozinka(loginforma.getText2());
        this.odo=skaut;
        this.of=loginforma;
    }
}
