package com.greedy.section02.otherservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// redirect -> 사용자의 url 재작성한다. -> get 방식으로 작성해야한다. 
	// otherservlet의 연결고리를 끊고 redirect 주소로 이동한다. 
	// 최초 url이 남아있는 forward와의 차이가 있다. 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctype html>\n")
				.append("<html>\n")
				.append("<head>\n")
				.append("</head>\n")
				.append("<body>\n")
				.append("<h1 align='center'>")
				.append("이 Servlet으로 redirect 성공! 난 체고야.")
				.append("</h1>\n")
				.append("</body>\n")
				.append("</html>");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(responseText.toString());
		out.flush();
		out.close();
		
		/* redirect를 하는 경우 url이 재작성되어서 새로고침하여도 redirect된 페이지에 대한 요청만을 반복한다. 
		 * 즉, 이전 요청에 남아있던 정보는 더 이상 남아있지 않게 된다. 
		 * 
		 * HTTP 통신은 요청시에 잠시 Connection을 맺고 응답시에도 잠시 Connection을 맺으며
		 * 요청 단위 당 request 객체는 한 개만 생성된다. 
		 * 따라서 첫 요청의 request와 redirect된 페이지의 request는 서로 다른 객체이고 
		 * redirect 를 사용하면 이전 서블릿과의 값을 공유해서 사용할 수 없게 된다. 
		 * 
		 * redirect시에도 값을 유지하는 방법으로 크게 쿠키와 세션을 이용할 수 있다 . */
	}

}
