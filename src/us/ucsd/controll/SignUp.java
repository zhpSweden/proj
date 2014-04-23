package us.ucsd.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.ucsd.bean.User;
import us.ucsd.daoimpl.UserDao;
import us.ucsd.utils.WebUtils;

public class SignUp extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = WebUtils.form2Bean(request, User.class);
		try {
			System.out.println("post");
			System.out.println(user.getAge());
			System.out.println(user.getName());
			UserDao.addUser(user);
		} catch (Exception e) {
			response.sendRedirect("/CSE135/html/signup_error.html");
			return;
		}
		response.sendRedirect("/CSE135/html/signup_succeed.html");
	}
}
