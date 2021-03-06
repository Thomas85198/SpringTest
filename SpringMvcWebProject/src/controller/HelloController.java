package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 接受資料
		String name = request.getParameter("name");
		// 驗證資料
		Map<String, String> map = new HashMap<String, String>();

		request.setAttribute("errors", map);

		//如果是空的的錯誤訊息		
		if (name == null || name.length() == 0) {
			map.put("name", "name is required");
		}
		if (map != null && !map.isEmpty()) {
			return new ModelAndView("form");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);

		return new ModelAndView("success");
	}

}
