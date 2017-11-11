
import java.util.ArrayList;

/**
 *
 * @author J. Christopher Anderson
 * @author Katherine Bigelow
 */
public class BUAReader {
    ReadDocFile rd;
    ArrayList<ArrayList<String>>files;
    //an arraylist of BUAs read in.


     public void initiate() throws Exception {
        rd = new ReadDocFile();
        files = new ArrayList<>();
     }

    public void run(String[] filenames) throws Exception {
        for(String name:filenames){
            files.add(rd.read(name));
        }
        //extract data
    }
    
    public ArrayList<ArrayList<String>> main(String[] args) throws Exception {
        BUAReader br = new BUAReader();
        br.initiate();
        return files;
    }
}
