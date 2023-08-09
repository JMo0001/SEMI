package kh.semi.vote.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.semi.common.jdbc.JdbcTemplate.*;
import kh.semi.vote.model.dto.MemberVo;
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
				+ " from tbl_member join tbl_party using (pcode) "
				+ " order by mno asc";
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
	public List<VoteVo> selectCheck(Connection conn, int currentPage, int pageSize, int totalCnt) {
		List<VoteVo> result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from "
				+ " (select rownum r1, tb1.* from "
				+ " (select vname, "
				+ " extract(year from to_date(substr(vjumin,1,6),'rrmmdd'))||'년'|| "
				+ " substr(vjumin,3,2)||'월'||substr(vjumin,5,2)||'일' vbirth, "
				+ " '만'||trunc(to_number(sysdate-to_date(substr(vjumin,1,6),'rrmmdd'))/365)||'세' vage, "
				+ " decode(substr(vjumin,7,1),1,'남',2,'여') gender, mno, "
				+ " vtime, vconfirm from tbl_vote) tb1 )tb2 "
				+ " where r1 between ? and ?";
		
		int startRownum =0;
		int endRownum = 0;
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRownum);
			pstmt.setInt(2, endRownum);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<VoteVo>();
			
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
	
	//페이징 위한 total count
	public int totalCnt(Connection conn) {
		int result = 0;
		String tQuery ="select count(*) cnt from tbl_vote";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(tQuery);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	
	//투표 결과 조회
	public List<ResultVo> VoteEndListServlet(Connection conn){
		List<ResultVo> result = new ArrayList<ResultVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select rank() over(partition by mcity order by cnt desc) rnk, mcity, mno, pname, mname, cnt, "
				+ " gschool_Name||' 졸업' gschoolname, "
				+ "	extract(year from to_date(substr(mjumin,1,6),'rrmmdd'))||'년'||substr(mjumin,3,2)||'월'||substr(mjumin,5,2)||'일'||' "
				+ "(만'||trunc(to_number(sysdate-to_date(substr(mjumin,1,6),'rrmmdd'))/365)||'세)' birth, "
				+ "    decode(substr(mjumin,7,1),1,'남',2,'여') gender "
				+ "    from (select mjumin, pcode, mno, mname, mcity, count(mno) cnt "
				+ "    from (select mno, vconfirm from tbl_vote where vconfirm ='Y') v "
				+ "    join tbl_member m using(mno) group by mjumin, mno, mname, mcity, pcode order by mcity, cnt desc) "
				+ "    join tbl_party using (pcode) "
				+ "    join tbl_grade using(mno)";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ResultVo vo = new ResultVo(
						rs.getString("mcity"), 
						rs.getString("mno"),
						rs.getString("pname"),
						rs.getString("mname"),
						rs.getString("birth"),
						rs.getString("gender"),
						rs.getString("gschoolname"),
						rs.getString("cnt"),
						rs.getString("rnk")
						);
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
	

	
	
	//후보자 등수 조회
	public VoteVo selectRowList(Connection conn, String mno){
		VoteVo result = null;
		System.out.println("aaaaaa"+mno);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select mno, mname, count(mno) cnt "
				+ "    from "
				+ "    (select mno, vconfirm from tbl_vote where vconfirm ='Y') v "
				+ "    join tbl_member m using(mno) "
				+ "	   where mno =? "
				+ "    group by mno, mname "
//				+ "    order by cnt desc, mno asc "
				;
		
		try {
			pstmt = conn.prepareStatement(query);
			System.out.println("bbb2"+mno);
			pstmt.setString(1, mno);
			System.out.println("bbb3"+mno);
			rs = pstmt.executeQuery();
			System.out.println("bbb4"+mno);
			if(rs.next()) {
				System.out.println("bbb"+mno);
				result = new VoteVo(
						rs.getString("mno"),
						rs.getString("mname"),
						rs.getString("cnt")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("후보자 번호로 검색하기 :"+result);
		
		return result;
	}
}
