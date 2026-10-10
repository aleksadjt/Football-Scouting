
package konekcija;

import java.sql.*;

public class Konekcija {
    private Connection konekcija;
    private static Konekcija instanca;
    private Konekcija(){};
    public static synchronized Konekcija uzmiInstancu(){
        if(instanca==null){
            instanca = new Konekcija();
        }
        return instanca;
    }
    public Connection uzmiKonekciju(){
        if(konekcija == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/skautovanje2", "root", "");
                konekcija.setAutoCommit(false);
            } catch (Exception e) {
                throw new RuntimeException("Losa konekcija.");
            }
        }
        return konekcija;
    }
}
