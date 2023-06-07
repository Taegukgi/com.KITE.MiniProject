package com.KITE.SignUP;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Member/SignUp/SignUp.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.sendRedirect("/Member/SignUp/signUpTest.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		LisencekeyCreate lc = new LisencekeyCreate();

		MemberDAO mDao = MemberDAO.getInstance();

		String userId = request.getParameter("userId");
		String password = request.getParameter("PWD");
		String confirmPassword = request.getParameter("PWD2");
		String licenseKey = lc.Licencekey();
		String email = request.getParameter("EMAIL");

		MemberDTO mDto = new MemberDTO();

		mDto.setUserId(userId);
		mDto.setPassword(password);
		mDto.setConfirmPassword(confirmPassword);
		mDto.setEmail(email);
		mDto.setLicenseKey(licenseKey);

		int result = mDao.join(mDto);

		if (result > 0) {
			request.setAttribute("licenseKey", mDto.getLicenseKey());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/Member/SignUp/successSignUp.jsp");
			dispatcher.forward(request, response);
		}
	}
}
		
	
