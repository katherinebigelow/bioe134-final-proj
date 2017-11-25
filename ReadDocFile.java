import java.io.*;
import java.util.ArrayList;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Fields;

/**
 * Source: Stack Overflow. https://stackoverflow.com/questions/7102511/how-read-doc-or-docx-file-in-java
 */
public class ReadDocFile
{
    public ArrayList<String> read(String args)
    {
        ArrayList<String> output = new ArrayList<>();
        File file = null;
        WordExtractor extractor = null;
        try
        {
            file = new File(args);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);
            String[] fileData = extractor.getParagraphText();
            for (int i = 0; i < fileData.length; i++)
            {
                if (fileData[i] != null) {
                    output.add(fileData[i].replaceAll("FORMTEXT", ""));
                }
            }
        }
        catch (Exception exep)
        {
            exep.printStackTrace();
        }
        return output;
    }
}