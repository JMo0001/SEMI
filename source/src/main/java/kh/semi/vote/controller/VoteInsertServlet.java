package kh.semi.vote.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.vote.model.dto.VoteDto;
import kh.semi.vote.model.service.VoteService;

/**
 * Servlet implementation class VoteInsertServlet
 */
@WebServlet("/vote/do")
public class VoteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/vote.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vjumin = request.getParameter("vjumin");
		String vname = request.getParameter("vname");
		String mno = request.getParameter("mno");
		String vtime = request.getParameter("vtime");
		String varea = request.getParameter("varea");
		String vconfirm = request.getParameter("vconfirm");
		System.out.println(vname);
		
		VoteDto dto = new VoteDto();
		
		dto.setVjumin(vjumin);
		dto.setVname(vname);
		dto.setMno(mno);
		dto.setVtime(vtime);
		dto.setVarea(varea);
		dto.setVconfirm(vconfirm);
		
		System.out.println("투표 "+dto);
		
		VoteService service = new VoteService();
		int result = service.doVote(dto);
	
		response.sendRedirect(request.getContextPath()+"/index");
	}
	
}
