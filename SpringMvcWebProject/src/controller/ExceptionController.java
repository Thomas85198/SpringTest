package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	@RequestMapping(path = "/exceptionAction.controller")
	public void processExceptionAction() throws Exception {
		throw new Exception();
	}
}
