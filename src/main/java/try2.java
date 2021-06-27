import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML.Attribute;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.IOException;

import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;
import java.security.GeneralSecurityException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class try2 {
    public static void main(String[] argv) throws Exception {
        ArrayList<String> data =new ArrayList<String>();
        HTMLDocument doc = new HTMLDocument() {
            public HTMLEditorKit.ParserCallback getReader(int pos) {
                return new HTMLEditorKit.ParserCallback() {
                    public void handleText(char[] data, int pos) {
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


                        try {
                            RandomAccessFile f = new RandomAccessFile(new File("D:\\final year project\\New folder\\new.html"), "rw");
                            f.seek(pos);
                            // f.writeChars(translationsResource.getTranslatedText());
                            f.write(data1);

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
