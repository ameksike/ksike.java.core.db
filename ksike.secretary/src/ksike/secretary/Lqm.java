package ksike.secretary;
/**
 * @author Antonio Membrides Espinosa
 * @made 19/04/2019
 * @version 1.0
 */
public class Lqm {

    private String sql;

    public Lqm() {
        this.sql = "";
    }

    public String flush() {
        String tmp = this.sql;
        this.sql = "";
        return tmp;
    }

    public Lqm delete(String table, String field, String value) {
        String tmp = "DELETE FROM " + table;
        tmp += " WHERE " + table + "." + field + "=" + value + ";";
        this.sql += " " + tmp;
        return this;
    }

    public Lqm insert(String table, String[] field, String[] value) {
        String tmp = "INSERT INTO " + table;
        tmp += " ( ";
        tmp += this.list(field, ", ");
        tmp += " ) VALUES ( ";
        tmp += this.list(value, ", ", "'");
        tmp += ");";
        this.sql += " " + tmp;
        return this;
    }

    public Lqm update(String table, String[] fields, String[] values, String field, String value) {
        String tmp = " " + "UPDATE " + table + " SET ";
        tmp += this.list(fields, values, ", ", "'");
        tmp += " WHERE " + table + "." + field + "=" + value;
        tmp += ";";
        this.sql += " " + tmp;
        return this;
    }

    public Lqm update(String table, String fields, String values, String field, String value) {
        this.update(table, new String[]{fields}, new String[]{values}, field, value);
        return this;
    }

    public Lqm select(String table) {
        this.sql += " " + "SELECT * FROM " + table + ";";
        return this;
    }

    public Lqm select(String table, String[] field, String[] value) {
        String tmp = " " + "SELECT * FROM " + table;
        tmp += " WHERE " + this.list(field, value, " AND ", "'");
        tmp += ";";
        this.sql += " " + tmp;
        return this;
    }

    public Lqm select(String table, String field, int value) {
        this.select(table, field, Integer.toString(value) );
        return this;
    }

    public Lqm select(String table, String field, String value) {
        String tmp = " " + "SELECT * FROM " + table;
        tmp += " WHERE " + table + "." + field + "=" + value;
        tmp += ";";
        this.sql += " " + tmp;
        return this;
    }

    public String list(String[] value, String sep) {
        return this.list(value, sep, "");
    }

    public String list(String[] value, String sep, String in) {
        return this.list(value, sep, in, in);
    }

    public String list(String[] value, String sep, String in, String out) {
        String str = "";
        for (int i = 0; i < value.length; i++) {
            str += (i == 0 ? "" : sep) + in + value[i] + out;
        }
        return str;
    }

    public String list(String[] field, String[] value, String sep) {
        return this.list(field, value, sep, "");
    }

    public String list(String[] field, String[] value, String sep, String in) {
        return this.list(field, value, sep, in, in);
    }

    public String list(String[] field, String[] value, String sep, String in, String out) {
        String str = "";
        for (int i = 0; i < field.length; i++) {
            str += (i == 0 ? "" : sep) + field[i] + "=" + in + value[i] + out;
        }
        return str;
    }
}
