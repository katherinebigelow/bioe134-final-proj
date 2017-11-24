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
        BUA filled = new BUA();

        //TODO: ADD CHECK FOR TXT
        parseCheckboxes(filled, strs);
        detectNeededAttachments(filled, strs);
        parseHeader(filled, strs.get(0));
        parseBuildingTable(filled, strs.get(0));
        checkValidity(filled);
        //gene bag?


        return filled;
    }

    void detectNeededAttachments(BUA b, ArrayList<ArrayList<String>> strs){
        b.detectAttachments(strs);
    }

    void checkValidity(BUA b){
        if(b.isInvalid()){
            System.out.println("WARNING: INVALID BUA");
        }
    }

    void parseCheckboxes(BUA b, ArrayList<ArrayList<String>> strs){
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
        b.setCheckboxes(checkbox_values);
    }

    void parseHeader(BUA b, ArrayList<String> doc){
        Pattern p = Pattern.compile("BIOLOGICAL USE AUTHORIZATION \\(BUA\\) APPLICATION FORM");
        Matcher m;
        String header = "";
        String currline = doc.get(0);
        int index = 0;
        m = p.matcher(currline);
        while(!m.find()&&index<doc.size()-1){
            index++;
            currline = doc.get(index);
            m = p.matcher(currline);
        }
        index++;
        currline = doc.get(index);
        if(index == doc.size()){
            b.setInvalid(true);
            return;
        }
        p = Pattern.compile("Section I – Type of Experiments");
        m = p.matcher(currline);
        while(!m.find()&&index<doc.size()-1){
            index++;
            header += currline;
            currline = doc.get(index);
            m = p.matcher(currline);
        }
        if(index == doc.size()){
            b.setInvalid(true);
            return;
        }

        b.setHeader(header);
    }

    void parseBuildingTable(BUA b, ArrayList<String> doc){
        Pattern p = Pattern.compile("SHARED ROOM\\*");
        Matcher m;
        String header = "";
        String currline = doc.get(0);
        int index = 0;
        m = p.matcher(currline);
        while(!m.find()&&index<doc.size()-1){
            index++;
            currline = doc.get(index);
            m = p.matcher(currline);
        }
        index++;
        currline = doc.get(index);
        if(index == doc.size()){
            b.setInvalid(true);
            return;
        }
        p = Pattern.compile("BIOLOGICAL MATERIALS STORAGE");
        m = p.matcher(currline);
        while(!m.find()&&index<doc.size()-1){
            index++;
            header += currline;
            currline = doc.get(index);
            m = p.matcher(currline);
        }
        if(index == doc.size()){
            b.setInvalid(true);
            return;
        }

        b.setBSL(header);
    }


    public static void main(String[]args)throws Exception{
        String filename = "data/JCA2.0_TKB in Mice";
        BUAConverter bc = new BUAConverter();
        bc.createBUA("data/JCA2.0_TKB in Mice");
    }



}
