package com.greedy.section01.othercite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/othercite")
public class OtherCiteRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/* a태그 doGet방식*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* redirect는 sendRedirect메소드를 사용하면 된다. */
		System.out.println("GET요청 후 naver사이트로 redirect");
		
		/* 브라우저의 개발자 도구 netword탭에서 확인하면 statuscode와 함께 location에 기재된
		 * naver 사이트로 이동하는 것을 볼 수 있다. 
		 * >> 사용자 url 재작성<< 이라고도 불리는 redirect방식은 302번 응답코드인 경우
		 * 요청에 대한 처리를 잘 했으며 사용자의 url을 강제적으로 redirect경로로 이동시키라는 의미이다. */
		response.sendRedirect("https://www.naver.com");
		/* redirect는 302 statusCode를 가지고있다. */
	}


}
