package com.KITE.SignUP;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Member/SignUp/idCheck.do")
public class IdCheckController {
	private static final long serialVersinUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.confirmID(userId);
		

		request.setAttribute("userId", userId);
		request.setAttribute("result", result);
		mDao.closeAll();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Member/SignUp/IdCheck.jsp");
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
