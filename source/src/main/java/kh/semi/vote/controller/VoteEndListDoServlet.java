package kh.semi.vote.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.vote.model.dto.ResultVo;
import kh.semi.vote.model.service.VoteService;

/**
 * Servlet implementation class VoteEndListServlet
 */
@WebServlet("/end")
public class VoteEndListDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteEndListDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VoteService service = new VoteService();
		List<ResultVo> vo = service.VoteEndListServlet();
		
		if(vo != null) {
			request.setAttribute("endList", vo);
			request.getRequestDispatcher("/WEB-INF/view/end.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/error/error.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
