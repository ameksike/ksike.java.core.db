package ksike.secretary.driver;

import ksike.secretary.data.DtBase;

/**
 * @author Antonio Membrides Espinosa
 * @made 19/04/2019
 * @version 1.0
 */
public abstract class DrBase {

    protected DtBase data;

    public DtBase getData() {
        return data;
    }

    public abstract boolean conneted();

    public abstract void connetc();

    public abstract void connetc(String dsn);

    public abstract void disconnetc();

    public abstract void exec(String sql);

    public abstract void query(String sql);
}
