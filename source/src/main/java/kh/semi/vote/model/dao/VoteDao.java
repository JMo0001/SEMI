package kh.semi.vote.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import static kh.semi.common.jdbc.JdbcTemplate.*;
import kh.semi.vote.model.dto.MemberVo;
import kh.semi.vote.model.dto.ResultVo;
import kh.semi.vote.model.dto.VoteDto;
import kh.semi.vote.model.dto.VoteVo;

public class VoteDao {
	
	//후보 조회
	public List<MemberVo> selectList(SqlSession session) {
		List<MemberVo> result = session.selectList("voteMapper.selectList");
		return result;
	}
	
	
	//투표 하기
	public int doVote(SqlSession session, VoteDto dto) {
		int result = session.insert("voteMapper.doVote", dto);
		return result;
	}
	
	
	//투표 검수 조회
	public List<VoteVo> selectCheck(SqlSession session, int currentPage, int pageSize, int totalCnt) {
	
		// case A:
//		RowBounds rb = new RowBounds(currentPage*pageSize, pageSize );
//		List<VoteVo> result = session.selectList("voteMapper.selectCheckByRowBound", null, rb);
		
		// case B:		
		Map<String, Object> map=new HashMap<String, Object>();
		int startNum = currentPage*10-9;
		int endNum = currentPage*pageSize;
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		System.out.println(map);
		System.out.println(currentPage);
		
		List<VoteVo> result = session.selectList("voteMapper.selectCheck", map);
		return result;
	}
	
	//페이징 위한 total count
	public int totalCnt(SqlSession session) {
		int result = session.selectOne("voteMapper.totalCnt");
		 System.out.println("totalCnt return :"+result);
		return result;
	}
	
	
	//투표 결과 조회
	public List<ResultVo> voteEndList(SqlSession session){
		List<ResultVo> result = session.selectList("voteMapper.voteEndList");
		return result;
	}
	

	
	
	//후보자 득표 조회
	public VoteVo selectRowList(SqlSession session, String mno){
		VoteVo result = session.selectOne("voteMapper.selectRowList", mno);
		return result;
	}
}
