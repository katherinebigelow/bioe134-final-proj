
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        while(line!=null){
            if(!line.isEmpty()) {
                txtread.add(line);
            }
            line = br.readLine();
        }

        files.add(txtread);

        /**
        int boxCounter = 0;
        ArrayList<String>docFile = files.get(0);
        Pattern p = Pattern.compile("FORMCHECKBOX");
        Matcher m;
        for(String str:docFile){
            m = p.matcher(str);
            while(m.find())
                boxCounter++;
        }
        **/

        return files;


    }
    
    public static void main(String[] args) throws Exception {
        String filename = "data/JCA2.0_TKB in Mice";
        BUAReader br = new BUAReader();
        br.initiate();
        System.out.println(br.read(filename));
    }
}
