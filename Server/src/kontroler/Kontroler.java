
package kontroler;

import zajednicki.OpstiDomenskiObjekat;
import sistemske_operacije.*;
import enums.Operacija;

public class Kontroler {
    private static Kontroler kontroler;
    private Kontroler(){};
    public synchronized static Kontroler uzmiInstancu(){
        if(kontroler == null) kontroler=new Kontroler();
        return kontroler;
    }
    public synchronized OpstaSO izvrsiSO(Operacija operacija, OpstiDomenskiObjekat odo){
        OpstaSO so = switch (operacija){
            case KreirajIzvestaj -> new KreirajIzvestaj(odo);
            case PrijaviSkaut -> new PrijaviSkaut(odo);
            case KreirajKlub -> new KreirajKlub(odo);
            case PromeniKlub -> new PromeniKlub(odo);
            case VratiListuSviLiga -> new VratiListuSviLiga(odo);
            case VratiListuSviSkaut -> new VratiListuSviSkaut(odo);
            case VratiListuSviIgrac -> new VratiListuSviIgrac(odo);
            case VratiListuSviKlub -> new VratiListuSviKlub(odo);
            case VratiListuOcenaIgraca -> new VratiListuOcenaIgraca(odo);
            case VratiListuIzvestaj -> new VratiListuIzvestaj(odo);
            case VratiListuKlub -> new VratiListuKlub(odo);
            case ObrisiKlub -> new ObrisiKlub(odo);
            case ObrisiIzvestaj -> new ObrisiIzvestaj(odo);
            case UbaciLicenca -> new UbaciLicenca(odo);
            case KreirajOcenaIgraca -> new KreirajOcenaIgraca(odo);
            case PromeniIzvestaj -> new PromeniIzvestaj(odo);
            case PromeniOcenaIgraca -> new PromeniOcenaIgraca(odo);
            case PretraziKlub -> new PretraziKlub(odo);
            case PretraziIzvestaj -> new PretraziIzvestaj(odo);
            case PretraziOcenaIgraca -> new PretraziOcenaIgraca(odo);
        };
        so.izvrsi();
        return so;
    }
}
