
package kontroleri;

import forme.UbaciLicencuForma;
import zajednicki.Licenca;

public class UbaciLicencuKontroler extends OpstiKontroler{
    public UbaciLicencuKontroler(UbaciLicencuForma ulf){
        super(ulf);
    }
    @Override
    public void konvertujODOuFormu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void konvertujFormuUODO() {
        UbaciLicencuForma ulf = (UbaciLicencuForma)of;
        Licenca licenca = (Licenca)ulf.kreirajObjekat();
        licenca.setNazivLicence(ulf.getText1());
        licenca.setOpisLicence(ulf.getText2());
        odo=licenca;
    }
    
}
