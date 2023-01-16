
import java.util.ArrayList;

public abstract class Protocol {
    //Master key ArrayList of protocol keys
    protected ArrayList<ArrayList<Integer>> keys= new ArrayList<ArrayList<Integer>>();

    //methods extended by instances of protocol (ex: Cerebus, Ouroboros)
    public abstract String encryption(int type, String notification);
    public abstract String decryption(int type, String notification);
}