package ksike.secretary;

import ksike.secretary.data.DtBase;
import ksike.secretary.driver.DrBase;
import ksike.secretary.driver.DrSqlite;

/**
 * @author Antonio Membrides Espinosa
 * @made 19/04/2019
 * @version 1.0
 */
public class EntityManager {

    private String user;
    private String pass;
    private String server;
    private String port;
    private String path;
    private String driver;

    private DrBase drv;
    private DtBase dta;
    private final Lqm dsq;

    public EntityManager() {
        this.dsq = new Lqm();
        this.driver = "sqlite";
        this.server = "localhost";
        this.port = "";
        this.user = "root";
        this.pass = "";
        this.drv = null;
        this.dta = null;
    }

    private DrBase load(String id) {
        switch (id) {
            case "sqlite":
                this.drv = new DrSqlite(this.path);
                break;
        }
        return this.drv;
    }

    public DtBase query(String sql) {
        if (this.drv == null) {
            this.load(this.driver);
        }
        this.drv.query(sql);
        this.dta = this.drv.getData();
        return this.dta;
    }

    public void connect() {
        if (this.drv != null) {
            this.drv.connetc();
        }
    }

    public void disconnetc() {
        if (this.drv != null) {
            this.drv.disconnetc();
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Lqm lqm() {
        return this.dsq;
    }

    public DtBase data() {
        return this.dta;
    }
}
