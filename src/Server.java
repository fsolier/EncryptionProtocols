import java.util.ArrayList;
import java.util.Random;

public abstract class Server {
    Random random = new Random();
    ArrayList<Spectator> spectators = new ArrayList<>();
    ArrayList<Protocol> protocols = new ArrayList<>();

    //adds new site
    public void addSpec(Spectator spectator){

        spectators.add(spectator);
    }

    //removes exiting site
    public void removeSpec(Spectator spectator) {

        spectators.remove(spectator);
    }

    //adds a new instance of protocol (ex: adding Cerebrus)
    public void addProt(Protocol protocol){

        protocols.add(protocol);
    }

    //removes an instance of existing protocol
    public void removeProt(Protocol protocol){

        protocols.remove(protocol);
    }

    //updates spectators with protocol used
    protected void watch(Protocol protocol) {
        for (Spectator spectator : spectators) {
            spectator.update(protocol);
        }
    }
    public void setProtocol() {
        watch(protocols.get(random.nextInt(protocols.size())));
    }
}
