package com.seniorsteps.fileuploader.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.seniorsteps.service.SystemFileUploader;

@Controller
@RequestMapping("/file")
public class FileUploaderController {

	@Autowired
	private SystemFileUploader uploader;
	
	@PostMapping(headers=("content-type=multipart/*"))
	@ResponseBody 
	public boolean uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
		return uploader.upload(file);
	}
}
