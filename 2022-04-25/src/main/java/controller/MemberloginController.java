package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login")
public class MemberloginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트가 보낸 데이터를 꺼낸다
		String id =  request.getParameter("id");
		String pw =  request.getParameter("pw");
		
		// 2. 클라이언트가 보낸 데이터를 검증한다 (유효성 검사)
		// ---
		
		// 3. 서비스 객체의 메서드를 호출해서 파리미터를 서비스 객체로 전달한다
		
	}

}
