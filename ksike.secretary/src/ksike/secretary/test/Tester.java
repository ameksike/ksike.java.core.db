package ksike.secretary.test;

import ksike.secretary.EntityManager;
import ksike.secretary.data.DtBase;

/**
 *
 * @author adm
 */
public class Tester {

    public static void main(String[] args) {
        EntityManager md = new EntityManager();
        md.setPath("C:\\Users\\adm\\Documents\\NetBeansProjects\\test.db");

        //md.query("INSERT INTO user (pass,name) VALUES ('mimositi','kevin2.kaka');");
       // md.connect();
        //md.query(
        
        System.out.println(
                md.lqm()
                .select("user")
                .select("user", "id", "14")
                .select("user", new String[]{"name", "pass"}, new String[]{"tato", "toto"})
                .flush()
        );

        System.out.println(
                md.lqm()
                .delete("user", "id", "14")
                .insert("user", new String[]{"name", "pass"}, new String[]{"maritsa", "tussss"})
                .insert("user", new String[]{"name", "pass"}, new String[]{"tato", "toto"})
                .update("user", new String[]{"name", "pass"}, new String[]{"MAMAMAA", "TITIT"}, "id", "2")
                .update("user", "name", "MUSSSS", "id", "3")
                .flush()
        );
/*
        md.query(md.lqm().select("user").flush());
        while (md.data().next()) {
            System.out.println("---------------------------------");
            System.out.println(md.data().get("name"));
        }

        md.disconnetc();*/

    }
}
