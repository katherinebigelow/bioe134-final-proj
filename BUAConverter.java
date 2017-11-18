import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Converts the raw data read in into a BUA object.
 * Created by Katherine on 11/10/2017.
 */
public class BUAConverter {

    BUAReader br;

    public BUAConverter(){
        br = new BUAReader();
        br.initiate();
    }

    BUA createBUA(String filename)throws Exception{
        ArrayList<ArrayList<String>> strs = br.read(filename);
        ArrayList<Integer>original_ints = new ArrayList<>();
        ArrayList<Integer>new_ints = new ArrayList<>();
        Pattern p = Pattern.compile("0|1");
        Matcher m;
        for(String line:strs.get(0)){
            m = p.matcher(line);
            while(m.find()){
                original_ints.add(Integer.parseInt(m.group()));
            }
        }
        for(String line:strs.get(1)){
            m = p.matcher(line);
            while(m.find()){
                new_ints.add(Integer.parseInt(m.group()));
            }
        }
        int ptra = 0;
        int ptrb = 0;
        ArrayList<Integer>checkbox_values = new ArrayList<>();
        while(ptrb<new_ints.size()){
            int val = new_ints.get(ptrb);
            if(ptra<original_ints.size()){
                if(!original_ints.get(ptra).equals(val)){
                    checkbox_values.add(val);
                    ptrb++;
                } else{
                    ptra++;
                    ptrb++;
                }
            } else{
                checkbox_values.add(val);
                ptrb++;
            }
        }


        BUA filled = new BUA();
        filled.setCheckboxes(checkbox_values);

        //TODO: DO THE REST OF THE FORM


        return filled;
    }

    public static void main(String[]args)throws Exception{
        String filename = "data/JCA2.0_TKB in Mice";
        BUAConverter bc = new BUAConverter();
        bc.createBUA("data/JCA2.0_TKB in Mice");
    }



}
