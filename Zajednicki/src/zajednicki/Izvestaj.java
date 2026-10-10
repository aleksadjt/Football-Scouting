package zajednicki;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Izvestaj extends OpstiDomenskiObjekat{
    private int idIzvestaj;
    private Skaut skaut;
    private Klub klub;
    private LocalDate datum;
    private Igrac igracZaPretragu;
    @Override
    public String toString(){
        return "Izvestaj broj "+idIzvestaj+". Skaut: "+skaut.toString()+". Klub: "+klub.toString()+". Datum: "+datum;
    }
    @Override
    public String vratiImeKlase() {
        return "Izvestaj";
    }
    @Override
    public String vratiImeKlaseJoin() {
        return "Izvestaj JOIN Skaut using(idSkaut) JOIN Klub using(idKlub) JOIN Liga using(idLiga)";
    }
    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idIzvestaj = ?";
    }
    @Override
    public void postaviUslovZaNadjiSlog(PreparedStatement ps, int i) throws SQLException {
        ps.setInt(i, idIzvestaj);
    }
    @Override
    public String vratiVrednostiZaIzmenu() {
        return "idSkaut = ?, idKlub = ?, datum = ?";
    }
    @Override
    public void postaviVrednostiZaIzmenu(PreparedStatement ps) throws SQLException {
        ps.setInt(1, skaut.getIdSkaut());
        ps.setInt(2, klub.getIdKlub());
        ps.setDate(3, Date.valueOf(datum));
    }
    @Override
    public String vratiUslovZaPretragu() {
        ArrayList<String>uslov = new ArrayList<>();
        if(klub!=null && klub.getIdKlub()>0) uslov.add("idKlub = ?");
        if(skaut!=null && skaut.getIdSkaut()>0) uslov.add("idSkaut = ?");
        if(igracZaPretragu!=null && igracZaPretragu.getIdIgrac()>0) uslov.add("idIzvestaj in (select idIzvestaj from ocenaIgraca where idIgrac = ?)");
        if(uslov.isEmpty()) return "1=1";
        return String.join(" AND ", uslov);
    }
    @Override
    public void postaviUslovZaPretragu(PreparedStatement ps) throws SQLException {
        int indeks = 1;
        if(klub!=null && klub.getIdKlub()>0) ps.setInt(indeks++, klub.getIdKlub());
        if(skaut!=null && skaut.getIdSkaut()>0) ps.setInt(indeks++, skaut.getIdSkaut());
        if(igracZaPretragu!=null && igracZaPretragu.getIdIgrac()>0) ps.setInt(indeks, igracZaPretragu.getIdIgrac());
    }
    @Override
    public void popuniVrednostiIzResultSeta(ResultSet rs) throws SQLException {
        idIzvestaj = rs.getInt("idIzvestaj");
        
        skaut = new Skaut();
        skaut.setIdSkaut(rs.getInt("idSkaut"));
        skaut.setIme(rs.getString("ime"));
        skaut.setPrezime(rs.getString("prezime"));
        skaut.setKorisnickoIme(rs.getString("korisnickoIme"));
        skaut.setLozinka(rs.getString("lozinka"));
        
        Liga liga = new Liga();
        liga.setIdLiga(rs.getInt("idLiga"));
        liga.setNazivLige(rs.getString("nazivLige"));
        liga.setZemlja(rs.getString("zemlja"));
        
        klub = new Klub();
        klub.setIdKlub(rs.getInt("idKlub"));
        klub.setNazivKluba(rs.getString("nazivKluba"));
        klub.setLiga(liga);
        
        datum = rs.getDate("datum").toLocalDate();
    }
    @Override
    public void popuniId(int id) {
        idIzvestaj = id;
    }
    @Override
    public String vratiUslovZaBrisanje() {
        return "idIzvestaj = ?";
    }
    @Override
    public void postaviUslovZaBrisanje(PreparedStatement ps) throws SQLException {
        ps.setInt(1, idIzvestaj);
    }
    @Override
    public String vratiAtributeZaKreiranje() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void postaviAtributeZaKreiranje(PreparedStatement ps) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public int getIdIzvestaj() {
        return idIzvestaj;
    }
    public void setIdIzvestaj(int idIzvestaj) {
        this.idIzvestaj = idIzvestaj;
    }
    public Skaut getSkaut() {
        return skaut;
    }
    public void setSkaut(Skaut skaut) {
        this.skaut = skaut;
    }
    public Klub getKlub() {
        return klub;
    }
    public void setKlub(Klub klub) {
        this.klub = klub;
    }
    public LocalDate getDatum() {
        return datum;
    }
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
    public Igrac getIgracZaPretragu() {
        return igracZaPretragu;
    }
    public void setIgracZaPretragu(Igrac igracZaPretragu) {
        this.igracZaPretragu = igracZaPretragu;
    }
}