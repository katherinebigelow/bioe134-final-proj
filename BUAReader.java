
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author J. Christopher Anderson
 * @author Katherine Bigelow
 */
public class BUAReader {
    ReadDocFile rd;


    void initiate() {
        rd = new ReadDocFile();
     }

    ArrayList<ArrayList<String>> read(String filename) throws Exception {
        ArrayList<ArrayList<String>> files = new ArrayList<>();
        files.add(rd.read(filename + ".doc"));

        FileReader fr = new FileReader(filename + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        ArrayList<String>txtread = new ArrayList<>();
        //reads in prices.txt line by line and adds costs to the right type
        while(line!=null){
            if(!line.isEmpty()) {
                txtread.add(line);
            }
            line = br.readLine();
        }

        files.add(txtread);
        return files;
    }
    
    public static void main(String[] args) throws Exception {
        String filename = "data/JCA2.0_TKB in Mice";
        BUAReader br = new BUAReader();
        br.initiate();
        System.out.println(br.read(filename));
    }
}
