package controller;

import java.util.HashMap;
import java.util.List;

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
	
}
