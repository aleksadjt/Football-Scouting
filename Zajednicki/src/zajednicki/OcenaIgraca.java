package zajednicki;

import enums.Pozicija;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OcenaIgraca extends OpstiDomenskiObjekat {
    private int idOcenaIgraca;
    private Izvestaj izvestaj;
    private double ocena;
    private int brojGolova;
    private int brojAsistencija;
    private Igrac igrac;
    @Override
    public String toString(){
        return igrac.getImePrezime()+": Ocena: "+ocena+". Broj golova: "+brojGolova+". Broj asistencija: "+brojAsistencija+".";
    }
    @Override
    public String vratiImeKlase() {
        return "OcenaIgraca";
    }
    @Override
    public String vratiImeKlaseJoin() {
        return "OcenaIgraca JOIN Igrac USING(idIgrac) JOIN izvestaj USING(idIzvestaj) JOIN skaut USING(idSkaut) JOIN klub USING(idklub) JOIN liga USING(idLiga)";
    }
    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idIzvestaj = ? and idOcenaIgraca = ?";
    }
    @Override
    public void postaviUslovZaNadjiSlog(PreparedStatement ps, int i) throws SQLException {
        ps.setInt(i, izvestaj.getIdIzvestaj());
        ps.setInt(i+1, idOcenaIgraca);
    }
    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ocena = ?, brojGolova = ?, brojAsistencija = ?, idIgrac = ?";
    }
    @Override
    public void postaviVrednostiZaIzmenu(PreparedStatement ps) throws SQLException {
        ps.setDouble(1, ocena);
        ps.setInt(2, brojGolova);
        ps.setInt(3, brojAsistencija);
        ps.setInt(4, igrac.getIdIgrac());
    }
    @Override
    public String vratiUslovZaPretragu() {
        return "idIzvestaj = ?";
    }
    @Override
    public void postaviUslovZaPretragu(PreparedStatement ps) throws SQLException {
        ps.setInt(1, izvestaj.getIdIzvestaj());
    }
    @Override
    public void popuniVrednostiIzResultSeta(ResultSet rs) throws SQLException {
        idOcenaIgraca = rs.getInt("idOcenaIgraca");
        brojGolova = rs.getInt("brojGolova");
        brojAsistencija = rs.getInt("brojAsistencija");
        ocena = rs.getDouble("ocena");
        
        Skaut skaut = new Skaut();
        skaut.setIdSkaut(rs.getInt("idSkaut"));
        skaut.setIme(rs.getString("ime"));
        skaut.setPrezime(rs.getString("prezime"));
        skaut.setKorisnickoIme(rs.getString("korisnickoIme"));
        skaut.setLozinka(rs.getString("lozinka"));
        
        Liga liga = new Liga();
        liga.setIdLiga(rs.getInt("idLiga"));
        liga.setNazivLige(rs.getString("nazivLige"));
        liga.setZemlja(rs.getString("zemlja"));
        
        Klub klub = new Klub();
        klub.setIdKlub(rs.getInt("idKlub"));
        klub.setNazivKluba(rs.getString("nazivKluba"));
        klub.setLiga(liga);
        
        izvestaj = new Izvestaj();
        izvestaj.setIdIzvestaj(rs.getInt("idIzvestaj"));
        izvestaj.setSkaut(skaut);
        izvestaj.setKlub(klub);
        izvestaj.setDatum(rs.getDate("datum").toLocalDate());
        
        igrac = new Igrac();
        igrac.setIdIgrac(rs.getInt("idIgrac"));
        igrac.setGodinaRodjenja(rs.getInt("godinaRodjenja"));
        igrac.setImePrezime(rs.getString("imePrezime"));
        igrac.setPozicija(Pozicija.valueOf(rs.getString("pozicija")));
    }
    @Override
    public void popuniId(int id) {
        idOcenaIgraca = id;
    }
    @Override
    public String vratiUslovZaBrisanje() {
        return "idIzvestaj=?";
    }
    @Override
    public void postaviUslovZaBrisanje(PreparedStatement ps) throws SQLException {
        ps.setInt(1, izvestaj.getIdIzvestaj());
    }
    @Override
    public String vratiAtributeZaKreiranje(){
        return "(idIzvestaj, idOcenaIgraca) VALUES (?,?)";
    }
    @Override
    public void postaviAtributeZaKreiranje(PreparedStatement ps) throws SQLException{
        ps.setInt(1, izvestaj.getIdIzvestaj());
        ps.setInt(2, idOcenaIgraca);
    }
    public int getIdOcenaIgraca() {
        return idOcenaIgraca;
    }
    public void setIdOcenaIgraca(int idOcenaIgraca) {
        this.idOcenaIgraca = idOcenaIgraca;
    }
    public Izvestaj getIzvestaj() {
        return izvestaj;
    }
    public void setIzvestaj(Izvestaj izvestaj) {
        this.izvestaj = izvestaj;
    }
    public double getOcena() {
        return ocena;
    }
    public void setOcena(double ocena) {
        this.ocena = ocena;
    }
    public int getBrojGolova() {
        return brojGolova;
    }
    public void setBrojGolova(int brojGolova) {
        this.brojGolova = brojGolova;
    }
    public int getBrojAsistencija() {
        return brojAsistencija;
    }
    public void setBrojAsistencija(int brojAsistencija) {
        this.brojAsistencija = brojAsistencija;
    }
    public Igrac getIgrac() {
        return igrac;
    }
    public void setIgrac(Igrac igrac) {
        this.igrac = igrac;
    }
}