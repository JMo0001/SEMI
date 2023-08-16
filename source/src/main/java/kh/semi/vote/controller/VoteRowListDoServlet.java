package kh.semi.vote.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.vote.model.dto.VoteVo;
import kh.semi.vote.model.service.VoteService;

/**
 * Servlet implementation class VoteRowListServlet
 */
@WebServlet("/row")
public class VoteRowListDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteRowListDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mno = request.getParameter("mno");
		System.out.println(mno);
		VoteService service = new VoteService();
		VoteVo vo = service.selectRowList(mno);
		
			request.setAttribute("rowList", vo);
			request.getRequestDispatcher("/WEB-INF/view/row.jsp").forward(request, response);
			
		System.out.println("rowList :"+vo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
