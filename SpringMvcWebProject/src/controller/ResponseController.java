package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
	
	@RequestMapping(path = "/responseMsgBody.controller", method=RequestMethod.GET)
	public @ResponseBody String responseBody() {
		return "This Message For ResponseBody";
	}
	
	@RequestMapping(path = "/responseMsgCharsetBody.controller", method=RequestMethod.GET)
	public @ResponseBody String responseCharsetBody() {
		
		return "你好：This Message For ResponseBody";
		
	}
	
	@RequestMapping(path = "/responseMsgCharsetBody2.controller", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public @ResponseBody String responseCharsetBody2() {
		
		return "你好：This Message For ResponseBody";
		
	}
	
	@RequestMapping(path = "/responseByteArrayImage.controller", method=RequestMethod.GET, 
	        produces = "image/jpeg;charset=UTF-8") 
    public @ResponseBody byte[] responseByteArrayImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/image01.jpg");
		// 告訴回應的格式
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        return IOUtils.toByteArray(is);
     }
}
