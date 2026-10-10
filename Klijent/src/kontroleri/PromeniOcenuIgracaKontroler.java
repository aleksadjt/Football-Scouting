
package kontroleri;

import forme.PromeniOcenuIgracaForma;
import zajednicki.OcenaIgraca;

public class PromeniOcenuIgracaKontroler extends OpstiKontroler{
    public PromeniOcenuIgracaKontroler(PromeniOcenuIgracaForma pof, OcenaIgraca ocenaIgraca){
        super(pof, ocenaIgraca);
    }
    @Override
    public void konvertujODOuFormu() {
        PromeniOcenuIgracaForma pof = (PromeniOcenuIgracaForma)of;
        OcenaIgraca ocenaIgraca = (OcenaIgraca)odo;
        pof.setText2(ocenaIgraca);
        pof.setText3(ocenaIgraca);
        pof.setText4(ocenaIgraca);
        pof.setComboBoxIgrac(ocenaIgraca);
    }

    @Override
    public void konvertujFormuUODO() {
        PromeniOcenuIgracaForma pof = (PromeniOcenuIgracaForma)of;
        OcenaIgraca ocenaIgraca = (OcenaIgraca)odo;
        ocenaIgraca.setOcena(Double.parseDouble(pof.getText2()));
        ocenaIgraca.setBrojGolova(Integer.parseInt(pof.getText3()));
        ocenaIgraca.setBrojAsistencija(Integer.parseInt(pof.getText4()));
        ocenaIgraca.setIgrac(pof.getComboBoxIgrac());
        odo = ocenaIgraca;
    }
    public void setOcenaIgraca(OcenaIgraca ocenaIgraca){
        odo = ocenaIgraca;
    }
}
