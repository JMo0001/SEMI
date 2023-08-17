package kh.semi.vote.model.service;

import static kh.semi.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.semi.common.mybatis.MybatisTemplate;
import kh.semi.vote.model.dao.VoteDao;
import kh.semi.vote.model.dto.MemberVo;
import kh.semi.vote.model.dto.ResultVo;
import kh.semi.vote.model.dto.VoteDto;
import kh.semi.vote.model.dto.VoteVo;

public class VoteService {
	
	private VoteDao dao = new VoteDao();
	
	//후보 조회
	public List<MemberVo> selectList() {
		SqlSession session = MybatisTemplate.getSqlSession(true);
		List<MemberVo> result = dao.selectList(session);
		session.close();
		return result;
	}
		
	//투표 하기
	public int doVote(VoteDto dto) {
		SqlSession session = MybatisTemplate.getSqlSession(true);
		int result = 0;
		result = dao.doVote(session, dto);
		session.close();
		return result;
	}
	
	//투표 검수 조회
	public Map<String, Object> selectCheck( int currentPage, int pageSize) {
		SqlSession session = MybatisTemplate.getSqlSession(true);
		int totalCnt = dao.totalCnt(session);
		List<VoteVo> result = dao.selectCheck(session, currentPage, pageSize, totalCnt);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("checkList",result);
		session.close();
		return map;
	}	
	
	//투표 결과 조회
	public List<ResultVo> voteEndList(){
		SqlSession session = MybatisTemplate.getSqlSession(true);
		List<ResultVo> result = dao.voteEndList(session);
		session.close();
		return result;
	}
		
		
	//후보자 등수 조회
	public VoteVo selectRowList(String mno){
		VoteVo result = null;
		SqlSession session = MybatisTemplate.getSqlSession(true);
		result = dao.selectRowList(session, mno);
		session.close();
		return result;
	}
}
