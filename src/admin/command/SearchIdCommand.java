package com.gaji.admin.command;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gaji.admin.dao.MemberDAO;
import com.gaji.member.vo.MemberVO;


public class SearchIdCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		System.out.println(">> SearchIdCommand ---------");
		
		// 1. DB연결하고 데이터 가져오기
		String id = request.getParameter("id"); 
		
		System.out.println(">id : -" + id + "-");
		
		MemberVO mvo = MemberDAO.getSearchId(id);
		
		// 2. 응답할 페이지(list.jsp)에 DB에서 가져온 데이터 전달
		session.setAttribute("mvo", mvo); //MemberVO가 담겨져있는 list 객체를 "list"라는 이름으로 저장

		System.out.println(">> SearchIdCommand 끝---------");
		
		return "viewUser.jsp";
		
		
	}

}
