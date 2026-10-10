package zajednicki;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Skaut extends OpstiDomenskiObjekat{
    private int idSkaut;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    public Skaut(){};
    @Override
    public String toString(){
        return ime+" "+prezime;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null) return false;
        if(obj.getClass()!=getClass()) return false;
        return ((Skaut)obj).getIdSkaut()==idSkaut;
    }
    @Override
    public String vratiImeKlase(){return "Skaut";}
    @Override
    public String vratiImeKlaseJoin() {
        return "Skaut";
    }
    @Override
    public String vratiUslovZaNadjiSlog(){
        return "korisnickoIme = ? and lozinka = ?";
    }
    @Override
    public void postaviUslovZaNadjiSlog(PreparedStatement ps, int i)throws SQLException{
        ps.setString(i, korisnickoIme);
        ps.setString(i+1, lozinka);
    }
    @Override
    public String vratiVrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void postaviVrednostiZaIzmenu(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public String vratiUslovZaPretragu() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void postaviUslovZaPretragu(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void popuniVrednostiIzResultSeta(ResultSet rs) throws SQLException{
        this.setIdSkaut(rs.getInt("idSkaut"));
        this.setIme(rs.getString("ime"));
        this.setPrezime(rs.getString("prezime"));
        this.setKorisnickoIme(rs.getString("korisnickoIme"));
        this.setLozinka(rs.getString("lozinka"));
    }
    @Override
    public void popuniId(int id){
        idSkaut=id;
    }
    @Override
    public String vratiUslovZaBrisanje() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void postaviUslovZaBrisanje(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public String vratiAtributeZaKreiranje() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void postaviAtributeZaKreiranje(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public int getIdSkaut() {
        return idSkaut;
    }
    public void setIdSkaut(int idSkaut) {
        this.idSkaut = idSkaut;
    }
    public String getIme() {
        return ime;
    }
    public void setIme(String ime) {
        this.ime = ime;
    }
    public String getPrezime() {
        return prezime;
    }
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public String getKorisnickoIme() {
        return korisnickoIme;
    }
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
    public String getLozinka() {
        return lozinka;
    }
    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}