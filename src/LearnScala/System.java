package LearnScala;

/**
 * Created by lyk on 2019-11-19.
 * Package name: LearnScala
 * Porject name: LearnScala
 */

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;


/**
 *
 * @author lcq
 *
 */
public class System {
    public static void main(String... args) throws Exception {
        final ActorSystem actorSystem = ActorSystem.create("actor-system");
        Thread.sleep(5000);
        final ActorRef actorRef = actorSystem.actorOf(Props.create(SimpleActor. class), "simple-actor");
        actorRef.tell( new Command("CMD 1" ), null);
        actorRef.tell( new Command("CMD 2" ), null);
        actorRef.tell( new Command("CMD 3" ), null);
        actorRef.tell( new Command("CMD 4" ), null);
        actorRef.tell( new Command("CMD 5" ), null);
        Thread.sleep(5000);
        actorSystem.shutdown();
    }
}