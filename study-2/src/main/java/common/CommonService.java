package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonService {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(CommonService.class);
	
	String url = "https://api.themoviedb.org/3/movie/76341?api_key=6a97a5c35f6fafb1f16fa0aed98bb804&language=ko-KR";
	String search_url = "https://api.themoviedb.org/3/search/movie?api_key=6a97a5c35f6fafb1f16fa0aed98bb804&language=ko-KR";
	private final String query = "&query=";
	
	public JSONArray MovieSearch(String keyword){
		System.out.println("====================keyword : " + keyword);
		String url = search_url+query+keyword;
		String result = "";
		System.out.println("===============url : " + url);
	try{
		
		HttpURLConnection conn 
			= (HttpURLConnection)(new URL( url )).openConnection();
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
	JSONArray array = (JSONArray)json.get("results");
//	List<JSONObject> list = new ArrayList<>();
//	array.forEach(a -> {
//		JSONObject json2 = new JSONObject(a.toString());
//		list.add(json2);
//	});
	
//	array.forEach(a -> 	{
//		HashMap<String, Object> map = new HashMap<>();
//		JSONObject json2 = new JSONObject(a.toString());
//		map.put("title", json2.getString("title"));
//		map.put("original_title", json2.getString("original_title"));
//		map.put("vote_average", json2.getDouble("vote_average"));
//		System.out.println("줄거리 : " + json2.getString("overview"));
//		System.out.println("");
//	}); 
	
	return array;
	
	}
	
	public String upload(String phone, MultipartFile file) {
		String path = "C:\\project\\file-upload\\"+phone;
	//	String path = "C:\\Users\\User\\Desktop\\test (1)\\";
		File f = new File( path );
		if( !f.exists() ) f.mkdirs();
			
		String uuid = phone + "_updator_" + file.getOriginalFilename();
		try {
			file.transferTo( new File(path, uuid) );
		}catch(Exception e) {
			e.getStackTrace();
		}
		System.out.println("??");
		return "success";
		
	}
	
}
