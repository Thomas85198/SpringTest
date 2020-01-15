package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import model.Picture;
import model.PictureService;

@Controller
public class FileUploadController {
		
	@Autowired
	private HttpServletRequest request;
	private PictureService pService;
	
	@Autowired
	public FileUploadController(PictureService pService) {
		this.pService = pService;
	}
	
	@RequestMapping(path = "/uploadId.controller", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<byte[]> uploadFile(@RequestParam(name="myFiles") MultipartFile multipartfile) throws Exception{
		String fileName = multipartfile.getOriginalFilename();
		System.out.println("fileName=" + fileName);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		
		String savePath = request.getSession().getServletContext().getRealPath("/")+"uploadTempDir\\" + fileName;
		// 把路徑印出來
		System.out.println("savePath: " + savePath);
		// 請他顯示出來檔案
		File saveFile = new File(savePath);
		multipartfile.transferTo(saveFile);
		
		// 判斷fileName不等於null
		if(fileName != null && fileName.length()!=0) {
			savePicture(fileName, savePath);
		}
		
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);
		
		
		
		
	}


	private void savePicture(String fileName, String savePath){
	try {
		Picture picture = new Picture();
		picture.setFilename(fileName);
		// 指定路徑
		InputStream is1 = new FileInputStream(savePath);
		byte[] data = new byte[is1.available()];
		is1.read(data);
		is1.close();
		
		picture.setPicture(data);
		pService.insert(picture);			
	} catch (Exception e) {
        e.printStackTrace();
	}
	
	}	
		
}
