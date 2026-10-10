
package forme;

import javax.swing.JOptionPane;
import kontroleri.PrikaziKlubKontroler;
import koordinator.Koordinator;
import zajednicki.Klub;
import enums.Operacija;
import enums.Signal;
import zajednicki.OpstiDomenskiObjekat;

public class PrikaziKlubForma extends OpstaForma {
    Koordinator koordinator;
    PrikaziKlubKontroler kontroler;
    PretraziKlubForma roditelj;
    Klub klub;
    public PrikaziKlubForma(Klub klub, PretraziKlubForma roditelj) {
        initComponents();
        this.roditelj=roditelj;
        this.klub=klub;
        kontroler = new PrikaziKlubKontroler(this, klub);
        koordinator = Koordinator.uzmiInstancu();
        kontroler.konvertujODOuFormu();
    }
    public void refreshKlub(){
        kontroler.konvertujODOuFormu();
        roditelj.refreshListaKlubova();
    }
    public void setLabelTekst(String tekst){
        jLabel1.setText(tekst);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jButton1.setText("Promeni klub");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Obrisi klub");
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
                        .addGap(66, 66, 66)
                        .addComponent(jButton1)
                        .addGap(66, 66, 66)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jButton3)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(54, 54, 54)
                .addComponent(jButton3)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        koordinator.pokreniPromeniKlubFormu(kontroler.vratiKlub(), this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Signal signal = kontroler.pozivSO(Operacija.ObrisiKlub);
        if(signal==Signal.Dobro){
            JOptionPane.showMessageDialog(this, "Sistem je obrisao klub.");
            roditelj.refreshListaKlubova();
            koordinator.zatvoriFormu(this);
        }
        else JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise klub.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        koordinator.zatvoriFormu(this);
    }//GEN-LAST:event_jButton3ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
