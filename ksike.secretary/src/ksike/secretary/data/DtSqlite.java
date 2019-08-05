package ksike.secretary.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Antonio Membrides Espinosa
 * @made 19/04/2019
 * @version 1.0
 */
public class DtSqlite extends DtBase {

    private ResultSet res;

    public DtSqlite() {
        this.res = null;
    }

    public DtSqlite(ResultSet rss) {
        this.res = rss;
    }

    public ResultSet getRes() {
        return res;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }

    @Override
    public boolean next() {
        if(this.res == null) return false;
        try {
            return this.res.next();
        } catch (SQLException ex) {
            Logger.getLogger(DtSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public String get(String key) {
        if (this.res == null) {
            return "null";
        }
        try {
            return this.res.getString(key);
        } catch (SQLException ex) {
            Logger.getLogger(DtSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "null";
    }

    @Override
    public String get(int key) {
        if (this.res == null) {
            return "null";
        }
        try {
            return this.res.getString(key);
        } catch (SQLException ex) {
            Logger.getLogger(DtSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
