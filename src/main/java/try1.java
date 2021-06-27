// for basic gettext and new html

import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class try1 {
    public static void main(String[] argv) throws Exception {
        ArrayList<String> data = new ArrayList<>();
        HTMLDocument doc = new HTMLDocument() {
            public HTMLEditorKit.ParserCallback getReader(int pos) {
                return new HTMLEditorKit.ParserCallback() {
                    public void handleText(char[] data, int pos){
                        // int i;
                        // for(i=0;i<pos;i++){
                        // System.out.println(pos);
                        //  System.out.println(popDepth);
                        // System.out.println( data);
            /* for (int i = 0; i < data.length; i++) {
               System.out.print(data[i] + " ");
           }*/
                       // String str2 = String.valueOf(data);
                        //  System.out.println(str2+" "+pos);
                        //String str2 = data.toString();

                        String str3 = new String(data);
                      //  System.out.println(str3+"----"+pos);
                        //String str3 = new String(data);
                     //   System.out.println(str3);
                        //String str4 = ("the title");
                        byte[] data1 = str3.getBytes();
                        try {
                            RandomAccessFile f = new RandomAccessFile(new File("D:\\final year project\\New folder\\new.html"), "rw");

                            f.seek(pos+2);
                            //    f.writeUTF(str4);
                            f.write(data1);
                            f.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    // }
                };
            }
        };


        FileReader xyz = new FileReader("D:\\final year project\\New folder\\basic.html");
        EditorKit kit = new HTMLEditorKit();
        kit.read(xyz,doc,0);


    }
}

