package com.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.UserInfo;
import com.servce.UserServce;


@WebServlet("/user_add")
public class AddUserCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServce userSverce = new UserServce();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userId=  request.getParameter("uerId");
		String userPsw=  request.getParameter("userPsw");
		String userAlice=  request.getParameter("userAlice");
		String userEmail=  request.getParameter("userEmail");
		String userSex=  request.getParameter("userSex");
		
		UserInfo userInfo = new UserInfo(userId, userPsw, userAlice, userEmail, userSex, null, null, 0, null, null, null);
		
		userSverce.addUser(userInfo);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
