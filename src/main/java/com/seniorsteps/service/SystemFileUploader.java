package com.seniorsteps.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Component
public class SystemFileUploader {
	BufferedOutputStream stream = null;
	boolean uploaded=true;

	public boolean upload(MultipartFile file) throws Exception { 
	
		try {
			String path = "C:\\Users\\SMARTCS\\Pictures\\Screenshots\\New folder (2)\\photos\\";
			File serverFile = new File(path + file.getOriginalFilename());
			stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(file.getBytes());
			stream.flush();
		} catch (Exception  e) {
			
			e.printStackTrace();
			uploaded=false;
		}finally {
			if(stream !=null) {
				stream.close();
			}
		}
		return uploaded;
		
	}
}
