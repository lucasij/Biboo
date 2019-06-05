package com.example.Main.Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Main.Model.GoogleDriveModel;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

@Controller
public class IndexController {
	
	@CrossOrigin(origins="http://localhost:8080")
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadImages(Model model, @RequestParam(value = "files") MultipartFile[] files) {
		for (MultipartFile file : files) {
			try {
				File fileMetadata = new File();
	        	fileMetadata.setName(file.getOriginalFilename());
	        	fileMetadata.setMimeType("image/*");
	        	java.io.File filePath = this.convert(file);
	        	FileContent mediaContent = new FileContent("image/*", filePath);
	        	GoogleDriveModel.getService().files().create(fileMetadata, mediaContent).setFields("id").execute();
	        	filePath.delete();
			} catch (IOException | GeneralSecurityException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("msg", "Upload concluído!");
		return "upload";
	}
	public String uploadFile(java.io.File image, Drive service) throws IOException {
		File fileMetadata = new File();
		fileMetadata.setName(image.getName());
		fileMetadata.setMimeType("image/*");
		java.io.File filePath = new java.io.File(image.getAbsolutePath());
		FileContent mediaContent = new FileContent("image/*", filePath);
		File file = service.files().create(fileMetadata, mediaContent).setFields("id").execute();
		System.out.println("File ID: " + file.getId());
		String ID = file.getId();
		return ID;
	}

	private java.io.File convert(MultipartFile file) throws IOException {
	    	java.io.File convFile = new java.io.File(file.getOriginalFilename());
	        convFile.createNewFile();
	        FileOutputStream fos = new FileOutputStream(convFile);
	        fos.write(file.getBytes());
	        fos.close();
	        return convFile;
	    }
	
}
