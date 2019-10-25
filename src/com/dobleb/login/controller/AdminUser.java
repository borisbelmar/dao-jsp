package com.dobleb.login.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dobleb.login.model.User;
import com.dobleb.login.dao.UserDAO;

/**
 * Servlet implementation class AdminUser
 */
@WebServlet("/AdminUser")
public class AdminUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

    /**
	 * @see HttpServlet#HttpServlet()
	*/
    public AdminUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			/*
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/show.jsp");
			List<User> users = userDAO.findAll();
			for(User user : users) {
				System.out.println(user.getUsername());
			}
			request.setAttribute("users", users);
			dispatcher.forward(request, response);
			*/
			
			String username = request.getParameter("username");
			String pass = request.getParameter("pass");
			
			User user = userDAO.checkUser(username, pass);
			
			HttpSession session = request.getSession(true);
			
			if(user != null) {
				session.setAttribute("user", user);
				session.setAttribute("error", false);
				response.sendRedirect(request.getContextPath() + "/welcome.jsp");
			} else {
				session.setAttribute("user", null);
				session.setAttribute("error", true);
				response.sendRedirect(request.getContextPath() + "/");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
