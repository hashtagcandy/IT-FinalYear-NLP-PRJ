import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.util.ArrayList;

public class text {
    public static void main(String[] argv) throws Exception {
        ArrayList < String > data = new ArrayList < String > ();
        HTMLDocument doc = new HTMLDocument() {
            public HTMLEditorKit.ParserCallback getReader(int pos) {
                return new HTMLEditorKit.ParserCallback() {
                    public void handleText(char[] data, int pos) {
                        String str3 = new String(data);
                        System.out.println(str3 + "----" + pos);
                        // byte data1[] = str3.getBytes();
                        //String str5 = str4.toString();
                        String str5 = str3.toString();
                        System.out.println(str5 + "--------str5");
                        byte data1[] = str5.getBytes(StandardCharsets.UTF_8);
                        //String str5="java string split method by javatpoint";
                        //String[] wo=str5.split("\\s");
                        //System.out.println(wo+"======WO");

                        String data2 = null;
                        String tokenstr = null; //creating a string for the tokens
                        StringTokenizer tokenizer = new StringTokenizer(str5); //spilting the sentences into words
                        while (tokenizer.hasMoreTokens()) {
                            //  tokenstr = new String(tokenizer.toString().getBytes(StandardCharsets.UTF_8));
                            //tokenstr = new String[]{tokenizer.nextToken()};
                            tokenstr = tokenizer.nextToken(); //adding values  to tokenstr

                            // System.out.println(tokenizer.nextToken()+"++++++++");
                            // +++++++++++++++++++++++++++++         Translation     +++++++++++++++++++++++++++++++++++++++
                            try {

                                Dictionary dictionary = new Dictionary("D:\\final year project\\New folder\\BanglaDictionary.txt"); //using the method from dictonary
                                data2 = dictionary.search(tokenstr.toLowerCase(Locale.ROOT)); //convert into smallercase then replacing into Bengali then saving to data2 array
                                System.out.println(dictionary.search(tokenstr.toLowerCase(Locale.ROOT)));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        //Using Random Access File for file pointer
                        try {
                            RandomAccessFile f = new RandomAccessFile(new File("D:\\final year project\\New folder\\test.html"), "rw");
                            f.seek(pos);
                            // f.writeChars(translationsResource.getTranslatedText());
                            f.writeUTF(data2); //adding values to the html

                            f.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
        };
        FileReader xyz = new FileReader("D:\\final year project\\New folder\\basic.html");
        EditorKit kit = new HTMLEditorKit();
        kit.read(xyz, doc, 0);

    }
}