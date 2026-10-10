
package forme;
import enums.Operacija;
import enums.Signal;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kontroleri.PretraziIzvestajKontroler;
import koordinator.Koordinator;
import zajednicki.Igrac;
import zajednicki.Izvestaj;
import zajednicki.Klub;
import zajednicki.OpstiDomenskiObjekat;
import zajednicki.Skaut;


public class PretraziIzvestajForma extends OpstaForma {
    Koordinator koordinator;
    PretraziIzvestajKontroler kontroler;
    DefaultTableModel tableModel;
    
    public PretraziIzvestajForma() {
        initComponents();
        koordinator=Koordinator.uzmiInstancu();
        kontroler = new PretraziIzvestajKontroler(this);
        
        popuniComboBox(kontroler.vratiSveX(Operacija.VratiListuSviSkaut), jComboBox1);
        Skaut comboBoxSviSkauti = new Skaut();
        comboBoxSviSkauti.setIme("Svi");
        comboBoxSviSkauti.setPrezime("skauti");
        jComboBox1.insertItemAt(comboBoxSviSkauti, 0);
        jComboBox1.setSelectedIndex(0);
        
        popuniComboBox(kontroler.vratiSveX(Operacija.VratiListuSviKlub), jComboBox2);
        Klub comboBoxSviKlubovi = new Klub();
        comboBoxSviKlubovi.setNazivKluba("Svi klubovi");
        jComboBox2.insertItemAt(comboBoxSviKlubovi, 0);
        jComboBox2.setSelectedIndex(0);
        
        popuniComboBox(kontroler.vratiSveX(Operacija.VratiListuSviIgrac), jComboBox3);
        Igrac comboBoxSviIgraci = new Igrac();
        comboBoxSviIgraci.setImePrezime("Svi igraci");
        jComboBox3.insertItemAt(comboBoxSviIgraci, 0);
        jComboBox3.setSelectedIndex(0);
        
        tableModel = new DefaultTableModel();
        tableModel.setColumnCount(0);
        tableModel.addColumn("Redni broj izvestaja");
        tableModel.addColumn("Skaut");
        tableModel.addColumn("Klub");
        tableModel.addColumn("Datum");
        jTable1.setModel(tableModel);
        
        pack();
    }
    public void pretraziIzvestaje(){
        kontroler.konvertujFormuUODO();
        Signal signal = kontroler.pozivSO(Operacija.VratiListuIzvestaj);
        if(signal==Signal.Dobro){
            kontroler.konvertujODOuFormu();
        }
        else {
            obrisiTabelu();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Skaut");

        jLabel2.setText("Klub");

        jButton1.setText("Prikazi izvestaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nazad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pretrazi izvestaje");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Igrac");

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jButton1)
                .addGap(179, 179, 179)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        koordinator.zatvoriFormu(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        kontroler.konvertujFormuUODO();
        Signal signal = kontroler.pozivSO(Operacija.VratiListuIzvestaj);
        if(signal==Signal.Dobro){
            JOptionPane.showMessageDialog(this, "Sistem je nasao izvestaje po zadatim kriterijumima.");
            kontroler.konvertujODOuFormu();
        }
        else {
            obrisiTabelu();
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje izvestaje po zadatim kriterijumima", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(vratiIdIzabranogIzvestaja()<1) { 
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje izvestaj.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        kontroler.konvertujFormuUODO2();
        Signal signal = kontroler.pozivSO(Operacija.PretraziIzvestaj);
        if(signal == Signal.Dobro){
            JOptionPane.showMessageDialog(this, "Sistem je nasao izvestaj.");
            koordinator.pokreniPromeniIzvestajFormu(kontroler.vratiIzvestaj(), this);
        }
        else JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje izvestaj.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        return new Izvestaj();
    }
    public Skaut vratiComboBoxSkaut(){
        Skaut skaut = (Skaut)jComboBox1.getSelectedItem();
        return ((skaut==null) || skaut.getIdSkaut()==0) ? null:skaut;
    }
    public Klub vratiComboBoxKlub(){
        Klub klub = (Klub)jComboBox2.getSelectedItem();
        return ((klub==null) || klub.getIdKlub()==0) ? null:klub;
    }
    public Igrac vratiComboBoxIgrac(){
        Igrac igrac = (Igrac)jComboBox3.getSelectedItem();
        return ((igrac==null) || igrac.getIdIgrac()==0) ? null:igrac;
    }
    public void ubaciItemUTabelu(Izvestaj izvestaj){
        tableModel.addRow(new Object[]{izvestaj.getIdIzvestaj(), izvestaj.getSkaut(), izvestaj.getKlub(), String.valueOf(izvestaj.getDatum())});
    }
    public void obrisiTabelu(){
        tableModel.setRowCount(0);
    }
    public int vratiIdIzabranogIzvestaja(){
        if(jTable1.getSelectedRow()<0) return -1;
        return (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<zajednicki.Skaut> jComboBox1;
    private javax.swing.JComboBox<zajednicki.Klub> jComboBox2;
    private javax.swing.JComboBox<zajednicki.Igrac> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
