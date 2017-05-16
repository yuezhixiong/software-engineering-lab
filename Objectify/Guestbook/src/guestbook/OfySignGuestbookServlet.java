package guestbook;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import com.googlecode.objectify.*;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import static com.googlecode.objectify.ObjectifyService.ofy;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OfySignGuestbookServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Access the User object from the UserService.
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		String guestbookName = req.getParameter("guestbookName");
		
		// Get the content from the request.
		String content = req.getParameter("content");

		// Create a new Greeting using the user and the content.
		Greeting greeting = new Greeting(user, content);

		// Chuck the Greeting into Objectify using a synchronous call (see
		// above).
		ofy().save().entity(greeting).now();

		// Send the response (be sure to redirect the user to the
		// ofyguestbook.jsp that you defined instead of guestbook.jsp).

		resp.sendRedirect("/ofyguestbook.jsp?guestbookName=" + guestbookName);

	}
}