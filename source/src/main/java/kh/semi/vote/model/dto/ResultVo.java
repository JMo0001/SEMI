package kh.semi.vote.model.dto;

public class ResultVo {
	
//	MCITY            VARCHAR2(20) 
//	MNO     NOT NULL CHAR(1)      (PK)	(tbl_member + tbl_party + tbl_grade)
//	PNAME            VARCHAR2(20) 
//	MNAME            VARCHAR2(20) 
//	MJUMIN           CHAR(13)     
//	GSCHOOL_NAME          VARCHAR2(20) 
// cnt >> tbl_vote 에서 mno 개수 count
	
	private String mcity;
	private String mno;
	private String pname;
	private String mname;
	private String gschoolName;
	private String gender;
	private String birth;
	
	
	
	
	public ResultVo() {
		super();
	}




	public ResultVo(String mcity, String mno, String pname, String mname, String gschoolName, String gender,
			String birth) {
		super();
		this.mcity = mcity;
		this.mno = mno;
		this.pname = pname;
		this.mname = mname;
		this.gschoolName = gschoolName;
		this.gender = gender;
		this.birth = birth;
	}




	@Override
	public String toString() {
		return "ResultVo [mcity=" + mcity + ", mno=" + mno + ", pname=" + pname + ", mname=" + mname + ", gschoolName="
				+ gschoolName + ", gender=" + gender + ", birth=" + birth + "]";
	}




	public String getMcity() {
		return mcity;
	}




	public void setMcity(String mcity) {
		this.mcity = mcity;
	}




	public String getMno() {
		return mno;
	}




	public void setMno(String mno) {
		this.mno = mno;
	}




	public String getPname() {
		return pname;
	}




	public void setPname(String pname) {
		this.pname = pname;
	}




	public String getMname() {
		return mname;
	}




	public void setMname(String mname) {
		this.mname = mname;
	}




	public String getGschoolName() {
		return gschoolName;
	}




	public void setGschoolName(String gschoolName) {
		this.gschoolName = gschoolName;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getBirth() {
		return birth;
	}




	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
	
	

	
}
