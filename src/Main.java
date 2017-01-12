import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            BabelFish bf = new BabelFish();
            bf.start();
        } catch (Exception ex){
            System.err.println(ex);
        }
    }
}

class BabelFish {
    private Map<String, String> dictionary = new HashMap<>();
    private List<String> searchList = new ArrayList<>();

    public void start() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] _rowsAndColumns = br.readLine().split(" ");
        int dictionaryLength = Integer.parseInt(_rowsAndColumns[0]);
        for(int i = 0; i < dictionaryLength; i++){
            String[] input = br.readLine().split(" ");
            dictionary.put(input[0], input[1]);
        }

        int searchLength = Integer.parseInt(_rowsAndColumns[1]);
        for(int i = 0; i < searchLength; i++) {
            searchList.add(br.readLine());
        }

        for(String search : searchList){
            String output = (dictionary.containsKey(search) ? dictionary.get(search) : "???");
            System.out.println(output);
        }
    }
}
