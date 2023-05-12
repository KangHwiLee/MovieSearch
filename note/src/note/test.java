package note;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

public class test {
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(test.class);
	
	
	public static void main(String[] args) {
		
		String url = "https://api.themoviedb.org/3/movie/76341?api_key=6a97a5c35f6fafb1f16fa0aed98bb804&language=ko-KR";
		String search = "https://api.themoviedb.org/3/search/movie?api_key=6a97a5c35f6fafb1f16fa0aed98bb804&language=ko-KR&query=범";
		String result = "";
		
		try{
			HttpURLConnection conn 
				= (HttpURLConnection)(new URL( search )).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			BufferedReader reader;
			if( conn.getResponseCode()>=200 && conn.getResponseCode()<=300){
				reader = new BufferedReader( new InputStreamReader( conn.getInputStream(), "utf-8" ) );
			}else{
				reader = new BufferedReader( new InputStreamReader( conn.getErrorStream(), "utf-8" ) );
			}
			StringBuilder data = new StringBuilder();
			String line;
			while( (line = reader.readLine()) !=null ){ 
				data.append( line );
			}
			reader.close();
			conn.disconnect();
			result = data.toString();
		
		}catch(Exception e){
			logger.error("데이터 조회 중 오류:{}", e.getMessage());
		}
		JSONObject json = new JSONObject(result);
		//System.out.println(json.get("results"));
		JSONArray array = (JSONArray)json.get("results");
//		System.out.println(json);
		array.forEach(a -> 	{
			System.out.println(a);
			System.out.println("");
		}); 

	}

}
