
package zajednicki;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class OpstiDomenskiObjekat implements Serializable{
    abstract public String vratiImeKlase();
    abstract public String vratiImeKlaseJoin();
    
    abstract public String vratiUslovZaNadjiSlog();
    abstract public void postaviUslovZaNadjiSlog(PreparedStatement ps, int i) throws SQLException; //where
    
    abstract public String vratiVrednostiZaIzmenu();
    abstract public void postaviVrednostiZaIzmenu(PreparedStatement ps) throws SQLException; //set
    
    abstract public String vratiUslovZaPretragu();
    abstract public void postaviUslovZaPretragu(PreparedStatement ps) throws SQLException;
    
    abstract public void popuniVrednostiIzResultSeta(ResultSet rs) throws SQLException;
    abstract public void popuniId(int id);
    
    abstract public String vratiUslovZaBrisanje();
    abstract public void postaviUslovZaBrisanje(PreparedStatement ps) throws SQLException;
    
    abstract public String vratiAtributeZaKreiranje();
    abstract public void postaviAtributeZaKreiranje(PreparedStatement ps) throws SQLException;
    
    public OpstiDomenskiObjekat kreirajPrazanODO(){
        try{return this.getClass().getDeclaredConstructor().newInstance();}
        catch (Exception e){throw new RuntimeException();}
    }

}

