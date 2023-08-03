package kh.semi.vote.model.dto;

public class MemberVo {
//	MNO     NOT NULL CHAR(1)      
//	MNAME            VARCHAR2(20) 
//	MJUMIN           CHAR(13)     
//	PSCHOOL          CHAR(1)      
//	MCITY            VARCHAR2(20) 
//	+	PCODE	PK(join) (tbl_member + tbl_party)
//	PNAME            VARCHAR2(20) 
//	PTEL1            CHAR(3)      
//	PTEL2            CHAR(4)      
//	PTEL3            CHAR(4)      
	private String mno;
	private String mname;
	private String mjumin;
	private String pschool;
	private String mcity;
	private String pname;
	private String tel;

	
	public MemberVo() {
		super();
	}


	@Override
	public String toString() {
		return "MemberVo [mno=" + mno + ", mname=" + mname + ", mjumin=" + mjumin + ", pschool=" + pschool + ", mcity="
				+ mcity + ", pname=" + pname + ", tel=" + tel + "]";
	}


	public String getMno() {
		return mno;
	}


	public void setMno(String mno) {
		this.mno = mno;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getMjumin() {
		return mjumin;
	}


	public void setMjumin(String mjumin) {
		this.mjumin = mjumin;
	}


	public String getPschool() {
		return pschool;
	}


	public void setPschool(String pschool) {
		this.pschool = pschool;
	}


	public String getMcity() {
		return mcity;
	}


	public void setMcity(String mcity) {
		this.mcity = mcity;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}

	

}
