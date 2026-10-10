
package forme;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import kontroleri.PretraziKlubKontroler;
import koordinator.Koordinator;
import zajednicki.Klub;
import zajednicki.Liga;
import enums.Operacija;
import enums.Signal;
import zajednicki.OpstiDomenskiObjekat;

public class PretraziKlubForma extends OpstaForma {
    private PretraziKlubKontroler kontroler;
    private Koordinator koordinator;
    private DefaultListModel<Klub>listmodel = new DefaultListModel<>();
    
    public PretraziKlubForma() {
        initComponents();
    }
    public void ucitaj(){
        kontroler = new PretraziKlubKontroler(this);
        koordinator = Koordinator.uzmiInstancu();
        popuniComboBox(kontroler.vratiSveX(Operacija.VratiListuSviLiga), jComboBox1);
        Liga comboBoxSveLige = new Liga();
        comboBoxSveLige.setNazivLige("Sve lige");
        jComboBox1.insertItemAt(comboBoxSveLige, 0);
        jComboBox1.setSelectedIndex(0);
        jList1.setModel(listmodel);
        
        pack();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv kluba:");

        jLabel2.setText("Liga:");

        jButton1.setText("Pretrazi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane10.setViewportView(jList1);

        jButton2.setText("Prikazi klub");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51))))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(23, 23, 23))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton1)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        kontroler.konvertujFormuUODO();
        Signal signal = kontroler.pozivSO(Operacija.VratiListuKlub);
        if(signal==Signal.Dobro){
            JOptionPane.showMessageDialog(this, "Sistem je nasao klubove po zadatim kriterijumima.");
            kontroler.konvertujODOuFormu();
        }
        else {
            isprazniKlubListu();
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje klubove po zadatim kriterijumima.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        koordinator.zatvoriFormu(this);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        kontroler.konvertujFormuUODO2();
        Signal signal = kontroler.pozivSO(Operacija.PretraziKlub);
        if(signal==Signal.Dobro) {
            JOptionPane.showMessageDialog(this, "Sistem je nasao klub.");
            koordinator.pokreniPrikaziKlubFormu(kontroler.vratiKlub(), this);
        }
        else JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje klub.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<zajednicki.Liga> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<zajednicki.Klub> jList1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public void refreshListaKlubova(){
        kontroler.konvertujFormuUODO();
        Signal signal = kontroler.pozivSO(Operacija.VratiListuKlub);
        if(signal==Signal.Dobro){
            kontroler.konvertujODOuFormu();
        }
        else isprazniKlubListu();
    }
    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        return new Klub();
    }
    public String getText(){
        return jTextField1.getText();
    }
    public Liga getComboBoxLiga(){
        return ((Liga)jComboBox1.getSelectedItem());
    }
    public void dodajKlubUListu(Klub klub){
        listmodel.addElement(klub);
    }
    public void isprazniKlubListu(){
        listmodel.clear();
    }
    public Klub vratiIzabranKlub(){
        return jList1.getSelectedValue();
    }
}
