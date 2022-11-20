package s22.mySongCollection.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		// get error status
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if (status != null) {
			int statusCode = Integer.parseInt(status.toString());
			
			// display error page 404
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "404";
			} 
			// display error page 500
			else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "500";
			} 
			// display error page 403
			else if (statusCode == HttpStatus.FORBIDDEN.value()) {
				return "403";
			} 
		}
		// display generic error
		return "error";
	}
}