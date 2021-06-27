import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;

public class Dictionary {
	private HashMap < String, String > map;  //intializing an empty map

	public Dictionary(String filePath) throws Exception {
		map = new HashMap < String, String > ();     //intializing an empty map
		BufferedReader mainBR = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));           //using buffr for reading the dictionary

		String line = mainBR.readLine();
		while (line != null) {
			int seperator = line.indexOf('|', 1);
			map.put(line.substring(1, seperator), line.substring(seperator + 1));      //returns the prevoius value associated with the key
			line = mainBR.readLine();
		}

		mainBR.close();                       //always close buffr
	}

	public String search(String tokenstr) {
		return map.get(tokenstr);
	}
/*
	public static void main(String[] args) {
		String str = "this is me";

		String[] str1 = new String[] {
				"Heading",
				"name",
				"this"
		};
		char[] ch = str.toCharArray();

			try {
				for(int i=0 ; i<str1.length; i++) {
				Dictionary dictionary = new Dictionary("D:\\final year project\\New folder\\BanglaDictionary");

					System.out.println(dictionary.search(str1[i].toLowerCase(Locale.ROOT).trim()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

	}*/
}