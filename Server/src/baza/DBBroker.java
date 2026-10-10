
package baza;
import konekcija.Konekcija;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import zajednicki.*;

public class DBBroker {
    private Connection con;
    public DBBroker(){
        con = Konekcija.uzmiInstancu().uzmiKonekciju();
    };
    public void sacuvajIzmene() throws SQLException{con.commit();}
    public void vratiNaPrethodnoStanje() throws SQLException{con.rollback();}
    public boolean pretrazi(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "SELECT * FROM "+odo.vratiImeKlaseJoin()+" WHERE "+odo.vratiUslovZaNadjiSlog();
        try (PreparedStatement ps = con.prepareStatement(upit);)
        {
            odo.postaviUslovZaNadjiSlog(ps, 1);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    odo.popuniVrednostiIzResultSeta(rs);
                    return true;
                }
                return false;
            }
        }
    }
    public boolean kreirajPrazanRed(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "INSERT INTO "+odo.vratiImeKlase()+"() VALUES ()";
        try(PreparedStatement ps = con.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);){
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys();){
                if(rs.next()){
                    odo.popuniId(rs.getInt(1));
                    return true;
                }
            }
        }
        return false;
    }
    public boolean ubaci(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "UPDATE "+odo.vratiImeKlase()+" SET "+odo.vratiVrednostiZaIzmenu()+" WHERE "+odo.vratiUslovZaNadjiSlog();
        try(PreparedStatement ps = con.prepareStatement(upit);){
            odo.postaviVrednostiZaIzmenu(ps);
            int i = odo.vratiVrednostiZaIzmenu().split("\\?", -1).length;
            odo.postaviUslovZaNadjiSlog(ps, i);
            return ps.executeUpdate()>0;
        }
    }
    public List<OpstiDomenskiObjekat> vratiListuSvi(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "SELECT * FROM "+odo.vratiImeKlaseJoin();
        try(PreparedStatement ps = con.prepareStatement(upit);){
            try(ResultSet rs = ps.executeQuery();){
                List<OpstiDomenskiObjekat> lista = new ArrayList<>();
                while(rs.next()){
                    OpstiDomenskiObjekat novi = odo.kreirajPrazanODO();
                    novi.popuniVrednostiIzResultSeta(rs);
                    lista.add(novi);
                }   
                return lista;
            }
        }
    }
    public List<OpstiDomenskiObjekat> vratiListu(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "SELECT * FROM "+odo.vratiImeKlaseJoin()+" WHERE "+odo.vratiUslovZaPretragu();
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement(upit);){
            odo.postaviUslovZaPretragu(ps);
            try(ResultSet rs = ps.executeQuery();){
                while(rs.next()){
                    OpstiDomenskiObjekat novi = odo.kreirajPrazanODO();
                    novi.popuniVrednostiIzResultSeta(rs);
                    lista.add(novi);
                }
                return lista;
            }
        }
    }
    public boolean obrisi(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "DELETE FROM "+odo.vratiImeKlase()+" WHERE "+odo.vratiUslovZaBrisanje();
        try(PreparedStatement ps = con.prepareStatement(upit);){
            odo.postaviUslovZaBrisanje(ps);
            return ps.executeUpdate()>0;
        }
    }
    public boolean kreiraj(OpstiDomenskiObjekat odo) throws SQLException{ //ocena
        String upit = "INSERT INTO "+odo.vratiImeKlase()+" "+odo.vratiAtributeZaKreiranje();
        try(PreparedStatement ps = con.prepareStatement(upit);){
            odo.postaviAtributeZaKreiranje(ps);
            return ps.executeUpdate()>0;
        }
    }
}
