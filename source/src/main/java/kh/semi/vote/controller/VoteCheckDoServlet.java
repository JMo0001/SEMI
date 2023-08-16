package kh.semi.vote.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.vote.model.dto.VoteVo;
import kh.semi.vote.model.service.VoteService;

/**
 * Servlet implementation class VoteCheckGetServlet
 */
@WebServlet("/vote/check")
public class VoteCheckDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteCheckDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VoteService service = new VoteService();
		
		int currentPage = 1;
		int pageSize = 10;
		String pageNoStr = request.getParameter("pageNo");
		if(pageNoStr != null) {
			try {
			currentPage = Integer.parseInt(pageNoStr);
			} catch ( NumberFormatException e){
				e.printStackTrace();
			}
		}
		Map<String, Object> map = null;
		
		map = service.selectCheck(currentPage, 10);
		request.setAttribute("checkList", map.get("checkList"));
				
		int pageBlockSize = 5;
		int totalCnt = (Integer)map.get("totalCnt");
		int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0:1);
		int startPageNum = 1;
		if((currentPage%pageBlockSize) == 0) {
			startPageNum = ((currentPage/pageBlockSize)-1)*pageBlockSize +1;
		} else {
			startPageNum = ((currentPage/pageBlockSize))*pageBlockSize +1;
		}
		int endPageNum = (startPageNum+pageBlockSize > totalPageNum) ? totalPageNum : startPageNum+pageBlockSize-1;
		request.setAttribute("totalPageNum", totalPageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage); 
	
		if(map!=null) {
			request.getRequestDispatcher("/WEB-INF/view/check.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/error/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
