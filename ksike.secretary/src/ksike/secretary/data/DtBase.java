package ksike.secretary.data;


/**
 * @author Antonio Membrides Espinosa
 * @made 19/04/2019
 * @version 1.0
 */
public abstract class DtBase {
    public abstract boolean next();
    public abstract String get(String key);
    public abstract String get(int key);
}
