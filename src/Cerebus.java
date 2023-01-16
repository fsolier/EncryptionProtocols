import java.util.ArrayList;

public class Cerebus extends Protocol{
    private final int CEREBUS_INIT_VALUE= 32;
    private final int CEREBUS_ALPH_SIZE= 128;

    public Cerebus() {
        //Arraylist of Cerebus keys
        ArrayList<Integer> key_1 = new ArrayList<>();
        ArrayList<Integer> key_2 = new ArrayList<>();

        //adds sample keys from original code given
        key_1.add(18);
        key_2.add(31);

        //adds cerebus keys to master key ArrayList
        keys.add(key_1);
        keys.add(key_2);
    }

    //from original code given
    @Override
    public String encryption(int type, String notification) {
        //master key arraylist
        ArrayList<Integer> key = keys.get(type);
        StringBuilder out = new StringBuilder();
        String use = notification.toLowerCase();
        for(char a : use.toCharArray()) {
            //goes through master key arraylist
            out.append((char)(((a + key.get(0) - CEREBUS_INIT_VALUE) % CEREBUS_ALPH_SIZE) + CEREBUS_INIT_VALUE)+"");
        }
        return out.toString();
    }

    //from original code given
    @Override
    public String decryption(int type, String notification) {
        //master key arraylist
        ArrayList<Integer> key = keys.get(type);
        StringBuilder out = new StringBuilder();
        String use = notification.toLowerCase();
        for(char a : use.toCharArray()) {
            //goes through master key arraylist
            out.append((char)(((a - key.get(0)  - CEREBUS_INIT_VALUE + CEREBUS_ALPH_SIZE) % CEREBUS_ALPH_SIZE) + CEREBUS_INIT_VALUE)+"");
        }
        return out.toString();
    }

}

