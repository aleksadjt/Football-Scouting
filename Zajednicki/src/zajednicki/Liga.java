package zajednicki;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Liga extends OpstiDomenskiObjekat{
    private int idLiga;
    private String nazivLige;
    private String zemlja;
    @Override
    public String toString(){
        return getNazivLige();
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null) return false;
        if(obj.getClass()!=getClass()) return false;
        return this.idLiga==((Liga)obj).getIdLiga();
    }
    @Override
    public String vratiImeKlase() {
        return "Liga";
    }
    @Override
    public String vratiImeKlaseJoin() {
        return "Liga";
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
        idLiga = rs.getInt("idLiga");
        nazivLige = rs.getString("nazivLige");
        zemlja = rs.getString("zemlja");
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
    public int getIdLiga() {
        return idLiga;
    }
    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }
    public String getNazivLige() {
        return nazivLige;
    }
    public void setNazivLige(String nazivLige) {
        this.nazivLige = nazivLige;
    }
    public String getZemlja() {
        return zemlja;
    }
    public void setZemlja(String zemlja) {
        this.zemlja = zemlja;
    }
}