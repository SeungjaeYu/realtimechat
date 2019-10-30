package kr.co.awethumb;

import java.util.Map;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
public class ChatController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/chat", method = RequestMethod.POST)
	public String chat(Map<String, Object> map) {
		
		
		return null;
	}
	
	
}
