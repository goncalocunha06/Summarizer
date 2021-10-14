import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class WordReader implements Iterable<String>{

    String filePath;
    String[] wordsArray;
    LinkedList<String> linkedList;

    public WordReader(String filePath)  {
        this.filePath = filePath;
        try {
            readFileByLine(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFileByLine(String file) throws IOException {

        FileReader reader = new FileReader(file);

        BufferedReader bReader = new BufferedReader(reader);

        String line = "";

        linkedList = new LinkedList<>();

        while((line = bReader.readLine()) != null) {

            if (line.equals("")) {
                continue;

            } else {
                line = line.replace(".", " ");
                wordsArray = line.split(" ");

                for (int i = 0; i < wordsArray.length; i++) {
                    linkedList.add(wordsArray[i]);
                }
            }
        }
        bReader.close();
    }

    @Override
    public Iterator<String> iterator() {
        return linkedList.iterator();
    }

}
