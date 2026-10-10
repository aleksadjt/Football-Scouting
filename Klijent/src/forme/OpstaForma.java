
package forme;

import java.util.List;
import javax.swing.JComboBox;
import zajednicki.OpstiDomenskiObjekat;

abstract public class OpstaForma extends javax.swing.JFrame{
    abstract public OpstiDomenskiObjekat kreirajObjekat();
    
    public void popuniComboBox(List<OpstiDomenskiObjekat>odolist, JComboBox cb){
        cb.removeAllItems();
        for(OpstiDomenskiObjekat tmp : odolist){
            cb.addItem(tmp);
        }
    }
}