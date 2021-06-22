import java.net.*;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
public class Main {
	public static void main(String[] args) throws Exception {
		for(int i = 0; i < 4; i++){
			printquote();
		}
	}
	public static void printquote() throws Exception {
		JSONParser parser = new JSONParser();
		URL url = new URL("http://api.quotable.io/random");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("accept","application/json");
		InputStream responseStream = conn.getInputStream();
		String output = new String(responseStream.readAllBytes());
		Object obj = parser.parse(output);
		JSONObject jobj = (JSONObject)obj;
		System.out.printf("\"%s\"\n- %s\n\n",jobj.get("content"),jobj.get("author"));
	}
}
