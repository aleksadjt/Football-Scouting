package zajednicki;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Klub extends OpstiDomenskiObjekat {
    private int idKlub;
    private String nazivKluba;
    private Liga liga;
    @Override
    public String toString(){
        return nazivKluba;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null) return false;
        if(obj.getClass()!=getClass()) return false;
        return ((Klub)obj).getIdKlub()==idKlub;
    }
    @Override
    public String vratiImeKlase() {
        return "Klub";
    }
    @Override
    public String vratiImeKlaseJoin(){
        return "Klub LEFT JOIN Liga using(idLiga)";
    }
    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idKlub = ?";
    }
    @Override
    public void postaviUslovZaNadjiSlog(PreparedStatement ps, int i) throws SQLException {
        ps.setInt(i, idKlub);
    }
    @Override
    public String vratiVrednostiZaIzmenu() {
        return "nazivKluba = ?, idLiga = ?";
    }
    @Override
    public void postaviVrednostiZaIzmenu(PreparedStatement ps) throws SQLException {
        ps.setString(1, nazivKluba);
        ps.setInt(2, liga.getIdLiga());
    }
    @Override
    public String vratiUslovZaPretragu() {
        ArrayList<String>uslov = new ArrayList<>();
        if(nazivKluba!=null) uslov.add("LOWER(nazivKluba) LIKE ?");
        if(liga!=null && liga.getIdLiga()>=1) uslov.add("idLiga = ?");
        if (uslov.isEmpty()) return "1=1";
        return String.join(" AND ", uslov);
    }
    @Override
    public void postaviUslovZaPretragu(PreparedStatement ps) throws SQLException {
        int indeks = 1;
        if(nazivKluba!=null) ps.setString(indeks++, "%"+nazivKluba.toLowerCase()+"%");
        if(liga.getIdLiga()>=1) ps.setInt(indeks, liga.getIdLiga());
    }
    @Override
    public void popuniVrednostiIzResultSeta(ResultSet rs) throws SQLException {
        idKlub = rs.getInt("idKlub");
        nazivKluba = rs.getString("nazivKluba");
        liga = new Liga();
        liga.setIdLiga(rs.getInt("idLiga"));
        liga.setNazivLige(rs.getString("nazivLige"));
        liga.setZemlja(rs.getString("zemlja"));
    }
    @Override
    public void popuniId(int id){
        idKlub=id;
    }
    @Override
    public String vratiUslovZaBrisanje(){
        return "idKlub = ?";
    }
    @Override
    public void postaviUslovZaBrisanje(PreparedStatement ps) throws SQLException {
        ps.setInt(1, idKlub);
    }
    @Override
    public String vratiAtributeZaKreiranje() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void postaviAtributeZaKreiranje(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public int getIdKlub() {
        return idKlub;
    }
    public void setIdKlub(int idKlub) {
        this.idKlub = idKlub;
    }
    public String getNazivKluba() {
        return nazivKluba;
    }
    public void setNazivKluba(String naziv) {
        this.nazivKluba = naziv;
    }
    public Liga getLiga() {
        return liga;
    }
    public void setLiga(Liga liga) {
        this.liga = liga;
    }
}