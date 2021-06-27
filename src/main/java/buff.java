import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML.Attribute;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.parser.ParserDelegator;

public class buff {
    public final static void main(String[] args) throws Exception {
        final ArrayList<String> list = new ArrayList<String>();

        ParserDelegator parserDelegator = new ParserDelegator();
        ParserCallback parserCallback = new ParserCallback() {
            public void handleText(final char[] data, final int pos) {
                // System.out.println(data);
            }

     /* public void handleStartTag(Tag tag, MutableAttributeSet attribute, int pos) {
        if (tag == Tag.A) {
          String address = (String) attribute.getAttribute(Attribute.HREF);
          list.add(address);
        //  System.out.println(tag);
        }
      }*/

            public void handleStartTag(Tag tag, MutableAttributeSet attribute,final int pos){

                System.out.println(tag +" "+"opening" + "-----"+ pos);
                //System.out.println(tag.toString());
                System.out.println(pos);
                // System.out.println(arr);
                String arr = tag.toString();

                // byte data1[] = arr.getBytes();
                try{


                    File file =new File("D:\\final year project\\New folder\\new.html");


                    if(!file.exists()){
                        file.createNewFile();
                    }


                    FileWriter fw = new FileWriter(file,true);

                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("<"+arr+">"+"\n");

                    bw.close();

                    //System.out.println("Data successfully appended at the end of file");

                }catch(IOException ioe){
                    System.out.println("Exception occurred:");
                    ioe.printStackTrace();
                }

            }
            public void handleEndTag(Tag t, final int pos) {
                System.out.println(t +" "+"closing "+"-----"+ pos);
                //  System.out.println(pos);
                String arr2 = t.toString();
                try{


                    File file =new File("D:\\final year project\\New folder\\new.html");


                    if(!file.exists()){
                        file.createNewFile();
                    }


                    FileWriter fw = new FileWriter(file,true);

                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write("</"+arr2+">"+"\n");

                    bw.close();



                }catch(IOException ioe){
                    System.out.println("Exception occurred:");
                    ioe.printStackTrace();
                }

            }

            public void handleSimpleTag(Tag t, MutableAttributeSet a, final int pos) {
            }

            public void handleComment(final char[] data, final int pos) {
            }

            public void handleError(final java.lang.String errMsg, final int pos) {
            }
        };
        parserDelegator.parse(new FileReader("D:\\final year project\\New folder\\basic.html"), parserCallback, false);
        //System.out.println(list);

        System.out.println("DATA ADDED");

    }
}

