package kh.semi.vote.model.service;

import static kh.semi.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.semi.vote.model.dao.VoteDao;
import kh.semi.vote.model.dto.MemberVo;
import kh.semi.vote.model.dto.ResultDto;
import kh.semi.vote.model.dto.ResultVo;
import kh.semi.vote.model.dto.VoteDto;
import kh.semi.vote.model.dto.VoteVo;

public class VoteService {
	
	private VoteDao dao = new VoteDao();
	
	//후보 조회
	public List<MemberVo> selectList() {
		Connection conn = getConnection();
		List<MemberVo> result = dao.selectList(conn);
		close(conn);
		return result;
	}
		
	//투표 하기
	public int doVote(VoteDto dto) {
		Connection conn = getConnection();
		int result = 0;
		result = dao.doVote(conn, dto);
		close(conn);
		return result;
	}
	
	//투표 검수 조회
	public List<VoteVo> selectCheck() {
		Connection conn = getConnection();
		List<VoteVo> result = dao.selectCheck(conn);
		close(conn);
		return result;
	}	
	
	//투표 결과 조회
	public List<ResultVo> VoteEndListServlet(){
		List<ResultVo> result = null;
		Connection conn = getConnection();
		result = dao.VoteEndListServlet(conn);
		close(conn);
		return result;
	}
		
		
	//후보자 등수 조회
		public VoteVo selectRowList(String mno){
			VoteVo result = null;
			Connection conn =getConnection();
			result = dao.selectRowList(conn, mno);
			close(conn);
			return result;
		}
}
