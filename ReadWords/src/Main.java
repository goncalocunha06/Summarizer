
import java.util.Iterator;

public class Main {

    private  static final String FILE_PATH = "resources/textExemple.txt";

    public static void main(String[] args) {
        WordReader wordReader = new WordReader(FILE_PATH);

        Iterator<String> iterator = wordReader.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
