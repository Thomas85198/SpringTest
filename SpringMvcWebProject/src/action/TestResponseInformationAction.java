package action;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

// 網頁測試用
public class TestResponseInformationAction {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> entity = template.getForEntity("http://localhost:8080/SpringMvcWebProject/responseMsgBody.controller", String.class);
		
		String body = entity.getBody();
		MediaType mediaType = entity.getHeaders().getContentType();
		HttpStatus statusCode = entity.getStatusCode();
		
		System.out.println("body: " + body);
		System.out.println("mediaType: " + mediaType);
		System.out.println("statusCode: " + statusCode);

}
}
