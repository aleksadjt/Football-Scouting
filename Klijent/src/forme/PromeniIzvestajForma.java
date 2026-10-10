
package forme;

import enums.Operacija;
import enums.Signal;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kontroleri.PromeniIzvestajKontroler;
import koordinator.Koordinator;
import zajednicki.Izvestaj;
import zajednicki.Klub;
import zajednicki.OcenaIgraca;
import zajednicki.OpstiDomenskiObjekat;
import zajednicki.Skaut;

public class PromeniIzvestajForma extends OpstaForma {
    private Koordinator koordinator;
    private PromeniIzvestajKontroler kontroler;
    private DefaultTableModel tableModel;
    private Izvestaj izvestaj;
    private PretraziIzvestajForma roditelj;
    public PromeniIzvestajForma(Izvestaj izvestaj, PretraziIzvestajForma roditelj) {
        initComponents();
        this.izvestaj = izvestaj;
        this.roditelj=roditelj;
    }
    public void ucitaj(){
        koordinator = Koordinator.uzmiInstancu();
        kontroler = new PromeniIzvestajKontroler(this);
        tableModel = new DefaultTableModel();
        jLabel1.setText("Izvestaj broj: "+izvestaj.getIdIzvestaj());
        jTextField1.setText(String.valueOf(izvestaj.getDatum()));
        popuniComboBox(kontroler.vratiSveX(Operacija.VratiListuSviSkaut), jComboBox1);
        popuniComboBox(kontroler.vratiSveX(Operacija.VratiListuSviKlub), jComboBox2);
        jComboBox1.setSelectedItem(izvestaj.getSkaut());
        jComboBox2.setSelectedItem(izvestaj.getKlub());
        
        tableModel.setColumnCount(0);
        tableModel.addColumn("RB");
        tableModel.addColumn("Igrac");
        tableModel.addColumn("Ocena");
        tableModel.addColumn("Broj golova");
        tableModel.addColumn("Broj asistencija");
        jTable1.setModel(tableModel);
        prikaziOceneIgraca();
        
        pack();
    }
    
    public boolean validan(String s){
        try {
            LocalDate.parse(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void prikaziOceneIgraca(){ //refresh
        kontroler.setOcenaIgraca(izvestaj);
        Signal signal = kontroler.pozivSO(Operacija.VratiListuOcenaIgraca);
        if(signal==Signal.Dobro) kontroler.konvertujODOuFormu();
        else JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita ocene igraca", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("label 1");

        jLabel4.setText("Klub:");

        jLabel2.setText("Skaut:");

        jButton1.setText("Prikazi ocenu igraca");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Promeni izvestaj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Nazad");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Datum:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton1)
                        .addGap(41, 41, 41)
                        .addComponent(jButton2)
                        .addGap(38, 38, 38)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        koordinator.zatvoriFormu(this);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTable1.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da pronadje ocenu igraca", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        kontroler.setOcenaIgraca((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0), izvestaj);
        Signal signal = kontroler.pozivSO(Operacija.PretraziOcenaIgraca);
        if(signal==Signal.Dobro){
            koordinator.pokreniPromeniOcenuIgracaFormu(kontroler.getOcenaIgraca(), this);
        }
        else JOptionPane.showMessageDialog(this, "Sistem ne moze da pronadje ocenu igraca", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!validan(jTextField1.getText())){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti izvestaj.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        kontroler.setIzvestaj(izvestaj);
        kontroler.konvertujFormuUODO();
        Signal signal = kontroler.pozivSO(Operacija.PromeniIzvestaj);
        if(signal==Signal.Dobro) {
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio izvestaj.");
            roditelj.pretraziIzvestaje();
        }
        else JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti izvestaj.", "Error", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    
    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Skaut getComboBoxSkaut(){
        return (Skaut)jComboBox1.getSelectedItem();
    }
    public Klub getComboBoxKlub(){
        return (Klub)jComboBox2.getSelectedItem();
    }
    public String getText1(){
        return jTextField1.getText();
    }
    public void obrisiTabelu(){
        tableModel.setRowCount(0);
    }
    public void dodajOcenuIgraca(OcenaIgraca ocenaIgraca){
        tableModel.addRow(new Object[]{ocenaIgraca.getIdOcenaIgraca(), ocenaIgraca.getIgrac().getImePrezime(),ocenaIgraca.getOcena(), ocenaIgraca.getBrojGolova(), ocenaIgraca.getBrojAsistencija()});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<zajednicki.Skaut> jComboBox1;
    private javax.swing.JComboBox<zajednicki.Klub> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
