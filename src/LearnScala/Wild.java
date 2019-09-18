package LearnScala;

import java.util.Collection;
import java.util.Vector;

/**
 * Created by lyk on 2019-9-18.
 * Package name: LearnScala
 * Porject name: LearnScala
 */
public class Wild {
    public Collection<?> contents() {
        Collection<String> stuff = new Vector<String>();
        stuff.add("a");
        stuff.add("b");
        stuff.add("see");
        return stuff;
    }
}