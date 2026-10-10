package zajednicki;

import enums.Pozicija;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Igrac extends OpstiDomenskiObjekat {
    private int idIgrac;
    private String imePrezime;
    private int godinaRodjenja;
    private Pozicija pozicija;
    @Override
    public String toString(){
        return imePrezime;
    }
    @Override
    public boolean equals(Object obj){
        if(obj==this)return true;
        if(obj==null) return false;
        if(obj.getClass()!=getClass()) return false;
        return ((Igrac)obj).getIdIgrac()==idIgrac;
    }
    @Override
    public String vratiImeKlase() {
        return "Igrac";
    }
    @Override
    public String vratiImeKlaseJoin() {
        return "Igrac";
    }
    @Override
    public String vratiUslovZaNadjiSlog() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void postaviUslovZaNadjiSlog(PreparedStatement ps, int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public void popuniVrednostiIzResultSeta(ResultSet rs) throws SQLException {
        idIgrac = rs.getInt("idIgrac");
        imePrezime = rs.getString("imePrezime");
        setGodinaRodjenja(rs.getInt("godinaRodjenja"));
        pozicija = Pozicija.valueOf(rs.getString("pozicija"));
    }
    @Override
    public void popuniId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public int getIdIgrac() {
        return idIgrac;
    }
    public void setIdIgrac(int idIgrac) {
        this.idIgrac = idIgrac;
    }
    public String getImePrezime() {
        return imePrezime;
    }
    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }
    public int getGodinaRodjenja() {
        return godinaRodjenja;
    }
    public void setGodinaRodjenja(int godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }
    public Pozicija getPozicija() {
        return pozicija;
    }
    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }
}


