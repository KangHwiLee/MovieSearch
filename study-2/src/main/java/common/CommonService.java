package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
	
	private String root = "C:\\file-upload\\";
	
//	public String upload(String phone, MultipartFile file) {
//		String path = root+phone;
//		File r = new File( root );
//		File f = new File( path );
//		if( !r.exists() ) r.mkdirs();
//		if( !f.exists() ) f.mkdirs();
//			
//		try {
//		InputStream fileStream = file.getInputStream();
//		FileUtils.copyInputStreamToFile(fileStream, f);
//		}catch(Exception e) {
//			e.getStackTrace();
//		}
//		return "success";
//	}
	public String upload(String phone, MultipartFile file) {
		String path = root+phone;
		File r = new File( root );
		File f = new File( path );
		if( !r.exists() ) r.mkdirs();
		if( !f.exists() ) f.mkdirs();
		
		String uuid = phone + "_updator_" + file.getOriginalFilename();
		try {
			file.transferTo( new File(path, file.getOriginalFilename()) );
		}catch(Exception e) {
			e.getStackTrace();
		}
		return "success";
	}
	
	public String[] file_check(String phone){
		String path = root+phone;
		File d = new File(path);
		System.out.println(path);
		if(!d.exists()) {
			System.out.println("파일이 없음");
			return null;
		}
		File files[] = d.listFiles();
		String result[] = new String[files.length];
		for (int i = 0; i < files.length; i++) {
		    System.out.println("file: " + files[i].getName());
		    result[i] = files[i].getName();
		}
		
		return result;
	}
	
}
