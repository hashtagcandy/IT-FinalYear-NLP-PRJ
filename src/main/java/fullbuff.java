import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;

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
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML.Attribute;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.parser.ParserDelegator;

public class fullbuff {
    public final static void main(String[] args) throws Exception {
        final ArrayList<String> list = new ArrayList<String>();

        ParserDelegator parserDelegator = new ParserDelegator();
        ParserCallback parserCallback = new ParserCallback() {
            public void handleText(final char[] data, final int pos) {
                String str3 = new String(data);
                System.out.println(str3 + "----" + pos);
                // byte data1[] = str3.getBytes();
                //Translation
                Translate t = null;
                try {
                    t = new Translate.Builder(
                            GoogleNetHttpTransport.newTrustedTransport()
                            , GsonFactory.getDefaultInstance(), null)
                            // Set your application name
                            .setApplicationName("Stackoverflow-Example")
                            .build();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Translate.Translations.List list = null;
                try {
                    list = t.new Translations().list(
                            Arrays.asList(
                                    // Pass in list of strings to be translated
                                    str3),
                            // Target language
                            "bn");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // TODO: Set your API-Key from https://console.developers.google.com/
                list.setKey("AIzaSyCYboZn91TmaCvN20Ik0sPOKT18y4qk2i4");
                TranslationsListResponse response = null;
                try {
                    response = list.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String str4 = null;
                for (TranslationsResource translationsResource : response.getTranslations()) {
                    str4 = new String(translationsResource.getTranslatedText());
                    // System.out.println(translationsResource.getTranslatedText());
                    System.out.println(str4);
                }
                String str5 = str4.toString();
                System.out.println(str5+"--------str5");



                byte data1[] = str5.getBytes(StandardCharsets.UTF_8);
                try{


                    File file =new File("D:\\final year project\\New folder\\new.html");


                    if(!file.exists()){
                        file.createNewFile();
                    }


                    FileWriter fw = new FileWriter(file,true);

                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(str5+"\n");

                    bw.close();

                    //System.out.println("Data successfully appended at the end of file");

                }catch(IOException ioe){
                    System.out.println("Exception occurred:");
                    ioe.printStackTrace();
                }



            }



            public void handleStartTag(Tag tag, MutableAttributeSet attribute,final int pos){

                System.out.println(tag +" "+"opening" + "-----"+ pos);
                //System.out.println(tag.toString());
                System.out.println(pos);
               // System.out.println(arr);
                //String arr = "<"+tag.toString()+">";
                String arr = tag.toString();

                byte data1[] = arr.getBytes();
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



                // byte data1[] = arr.getBytes();


            }
            public void handleEndTag(Tag t, final int pos) {
                System.out.println(t +" "+"closing "+"-----"+ pos);
                //  System.out.println(pos);
                String arr2 =  t.toString();
                byte[] data2 = arr2.getBytes();
                try{

                    File file =new File("D:\\final year project\\New folder\\new.html");


                    if(!file.exists()){
                        file.createNewFile();
                    }


                    FileWriter fw = new FileWriter(file,true);

                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("</"+arr2+">"+"\n");

                    bw.close();

                    //System.out.println("Data successfully appended at the end of file");

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

