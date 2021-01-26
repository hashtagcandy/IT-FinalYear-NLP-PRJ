 import java.io.IOException;
 import java.io.BufferedReader;
 import java.io.FileReader;  
public class getHtml {
    
    public static void main(String[] args) throws IOException {
        StringBuilder html = new StringBuilder();
        FileReader fr = new FileReader("D:\\final year project\\New folder\\base.html");
    try
    {
        BufferedReader br = new BufferedReader (fr);
        String val;
        while((val=br.readLine())!=null){
              html.append(val);
              
        }
        br.close();
        String result = html.toString();
        System.out.println(result);
    }
    
    catch(Exception ex) {
        System.out.println(ex.getMessage());
    }
    
    
    }
   
    }
    
    

