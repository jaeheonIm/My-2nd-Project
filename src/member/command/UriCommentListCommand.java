package com.gaji.member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gaji.member.dao.MemberDAO;
import com.gaji.dongnae.vo.UriCommentVO;
import com.gaji.member.vo.MemberVO;

public class UriCommentListCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("uriCommentList command 도착");
		
		MemberVO mvo = (MemberVO) request.getSession().getAttribute("mvo");
		
		List<UriCommentVO> uriCommentList = MemberDAO.uriCommentList(mvo.getId());
		
		System.out.println("uriCommentList : " + uriCommentList);
		
		request.setAttribute("uriCommentList", uriCommentList);
		
		return "uriCommentList.jsp";
	}

}
