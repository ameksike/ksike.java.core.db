package ksike.secretary.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ksike.secretary.EntityManager;
import ksike.secretary.data.DtSqlite;

/**
 * @author Antonio Membrides Espinosa
 * @made 19/04/2019
 * @version 1.0
 */
public class DrSqlite extends DrBase {

    private Connection con;
    private Statement stm;
    private String dsn;

    public DrSqlite() {
        this.con = null;
        this.stm = null;
        this.dsn = "";
    }

    public DrSqlite(String dsn) {
        this.con = null;
        this.stm = null;
        this.dsn = dsn;
    }

    public String getDsn() {
        return dsn;
    }

    public void setDsn(String dsn) {
        this.dsn = dsn;
    }

    @Override
    public void connetc(String dsn) {
        try {
            Class.forName("org.sqlite.JDBC");
            this.con = DriverManager.getConnection("jdbc:sqlite:" + dsn);
            this.stm = this.con.createStatement();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EntityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void exec(String sql) {
        this.query(sql);
    }

    @Override
    public void query(String sql) {
        if (!this.conneted()) {
            this.connetc(this.dsn);
        }
        try {
            if (sql.contains("SELECT") || sql.contains("select")) {
                this.data = new DtSqlite(stm.executeQuery(sql));
            } else {
                this.stm.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            System.out.println(" Error: DrSqlite query");
            Logger.getLogger(DrSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void disconnetc() {
        try {
            this.stm.close();
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DrSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void connetc() {
        this.connetc(this.dsn);
    }

    @Override
    public boolean conneted() {
        return this.con != null;
    }
}
