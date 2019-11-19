package LearnScala;
import java.io.Serializable;
/**
 * Created by lyk on 2019-11-19.
 * Package name: LearnScala
 * Porject name: LearnScala
 */
public class Event implements Serializable {

    private String data;
    private String uuid;

    public Event(String data) {
        super();
        this. data = data;
    }

    public Event(String data, String uuid) {
        this. data = data;
        this. uuid = uuid;
    }

    public String getData() {
        return data;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Event{" + "data='" + data + '\'' + ", uuid='" + uuid + '\'' + '}' ;
    }
}