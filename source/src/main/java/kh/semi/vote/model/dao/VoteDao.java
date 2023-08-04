package kh.semi.vote.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.semi.common.jdbc.JdbcTemplate.*;
import kh.semi.vote.model.dto.MemberVo;
import kh.semi.vote.model.dto.ResultDto;
import kh.semi.vote.model.dto.ResultVo;
import kh.semi.vote.model.dto.VoteDto;
import kh.semi.vote.model.dto.VoteVo;

public class VoteDao {
	
	//후보 조회
	public List<MemberVo> selectList(Connection conn) {
		List<MemberVo> result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qeury = "select mno, mname, pname, "
				+ " decode(pschool, 1,'고졸' ,2,'대졸', 3,'석사', 4,'박사') pschool, "
				+ " mjumin, mcity, "
				+ " ptel1||'-'|| ptel2||'-'||ptel3 tel "
				+ " from tbl_member join tbl_party using (pcode)";
		result = new ArrayList<MemberVo>();
		try {
			pstmt=conn.prepareStatement(qeury);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setMno(rs.getString("mno"));
				vo.setMname(rs.getString("mname"));
				vo.setMjumin(rs.getString("mjumin"));
				vo.setPschool(rs.getString("pschool"));
				vo.setMcity(rs.getString("mcity"));
				vo.setPname(rs.getString("pname"));
				vo.setTel(rs.getString("tel"));
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	
	//투표 하기
	public int doVote(Connection conn, VoteDto dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO TBL_VOTE "
				+ " ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO) "
				+ " values (?, ?, ?, ?, ?, ?)";
			try {
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dto.getVjumin());
				pstmt.setString(2, dto.getVname());
				pstmt.setString(3, dto.getVtime());
				pstmt.setString(4, dto.getVarea());
				pstmt.setString(5, dto.getVconfirm());
				pstmt.setString(6, dto.getMno());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			System.out.println("투표하기"+result);
			return result;
	}
	
	
	//투표 검수 조회
	public List<VoteVo> selectCheck(Connection conn) {
		List<VoteVo> result = new ArrayList<VoteVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select vname, "
				+ " extract(year from to_date(substr(vjumin,1,6),'rrmmdd'))||'년'|| "
				+ " substr(vjumin,3,2)||'월'||substr(vjumin,5,2)||'일' vbirth, "
				+ " '만'||trunc(to_number(sysdate-to_date(substr(vjumin,1,6),'rrmmdd'))/365)||'세' vage, "
				+ " decode(substr(vjumin,7,1),1,'남',2,'여') gender, mno, "
				+ " vtime, vconfirm from tbl_vote";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VoteVo vo = new VoteVo(
						rs.getString("vname"), 
						rs.getString("vbirth"), 
						rs.getString("vage"), 
						rs.getString("gender"), 
						rs.getString("mno"), 
						rs.getString("vtime"), 
						rs.getString("vconfirm")
						);
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("투표검수조회"+result);
		return result;
	}
	
	
	//후보자 등수 조회
	public List<ResultDto> selectRowList(Connection conn, String mno){
		List<ResultDto> result = null;
		//TODO
		return result;
	}
	
	
	//투표 결과 조회
	public List<ResultVo> endList(Connection conn){
		List<ResultVo> result = null;
		//TODO
		return result;
	}
}
