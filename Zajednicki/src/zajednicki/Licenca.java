package zajednicki;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Licenca extends OpstiDomenskiObjekat{
    private int idLicenca;
    private String nazivLicence;
    private String opisLicence;
    @Override
    public String vratiImeKlase() {
        return "Licenca";
    }
    @Override
    public String vratiImeKlaseJoin() {
        return "Licenca";
    }
    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idLicenca = ?";
    }
    @Override
    public void postaviUslovZaNadjiSlog(PreparedStatement ps, int i) throws SQLException {
        ps.setInt(i, idLicenca);
    }
    @Override
    public String vratiVrednostiZaIzmenu() {
        return "nazivLicence = ?, opisLicence = ?";
    }
    @Override
    public void postaviVrednostiZaIzmenu(PreparedStatement ps) throws SQLException {
        ps.setString(1, nazivLicence);
        ps.setString(2, opisLicence);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void popuniId(int id) {
        this.idLicenca=id;
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
    public int getIdLicenca() {
        return idLicenca;
    }
    public void setIdLicenca(int idLicenca) {
        this.idLicenca = idLicenca;
    }
    public String getNazivLicence() {
        return nazivLicence;
    }
    public void setNazivLicence(String naziv) {
        this.nazivLicence = naziv;
    }
    public String getOpisLicence() {
        return opisLicence;
    }
    public void setOpisLicence(String opis) {
        this.opisLicence = opis;
    }
}