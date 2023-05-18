package controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import dto.GuestDTO;

@RestController

@RequestMapping("/guest")
public class GuestController {

	@Autowired CommonService common;
	
	@PostMapping("/movies")
	public String movies(@RequestBody GuestDTO movie){
		//List<JSONObject> list = common.MovieSearch(movie.getKeyword());
		JSONArray arr = common.MovieSearch(movie.getKeyword());
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("data", arr.toString());
		return arr.toString();
	}
	
	@PostMapping("/file-upload")
	public String file_uploae(GuestDTO dto, MultipartFile file) {
		common.upload(dto.getPhone(), file);
		return null;
	}
	
	@PostMapping("/file-check")
	public String[] file_check(String phone) {
		String[] result = common.file_check(phone);
		return result;
	}
	
	@GetMapping("/file-download")
	public void file_download(HttpServletRequest request, HttpServletResponse response, String phone, String file_name) 
			throws IOException {
		File downloadFile = new File("C:\\file-upload\\" + phone + "\\" + file_name);
        System.out.println(downloadFile.getName());
        byte fileByte[] = FileUtils.readFileToByteArray(downloadFile);
        
        response.setContentType("application/octet-stream");
        response.setContentLength(fileByte.length);
        
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(file_name,"UTF-8") +"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        
        response.getOutputStream().write(fileByte);
        response.getOutputStream().flush();
        response.getOutputStream().close();
	}
	
}
