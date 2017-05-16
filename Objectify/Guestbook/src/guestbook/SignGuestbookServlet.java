package guestbook;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignGuestbookServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		// We have one entity group per Guestbook with all Greetings residing
		// in the same entity group as the Guestbook to which they belong.

		// This lets us run a transactional ancestor query to retrieve all

		// Greetings for a given Guestbook. However, the write rate to each

		// Guestbook should be limited to ~1/second.

		String guestbookName = req.getParameter("guestbookName");// 获取表单参数的值
		Key guestbookKey = KeyFactory.createKey("Guestbook", guestbookName);
		String content = req.getParameter("content");
		Date date = new Date();

		Entity greeting = new Entity("Greeting", guestbookKey);
		greeting.setProperty("user", user);
		greeting.setProperty("date", date);
		greeting.setProperty("content", content);
		/*
		 * In our example, each Greeting has the posted content, and also stores
		 * the user information about who posted, and the date on which the post
		 * was submitted. When initializing the entity, we supply the entity
		 * name, Greeting, as well as a guestbookKey argument that sets the
		 * parent of the entity we are storing. Objects in the Datastore that
		 * share a common ancestor belong to the same entity group.
		 */

		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(greeting);
		// After we construct the entity, we instantiate the Datastore service,
		// and put the entity in the Datastore

		resp.sendRedirect("/guestbook.jsp?guestbookName=" + guestbookName);
		// This code creates a new query on the Greeting entity, and sets the
		// guestbookKey as the required parent entity for all entities that will
		// be returned. We also sort on thedate property, returning the newest
		// Greeting first.
	}
}