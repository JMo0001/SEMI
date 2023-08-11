package kh.semi.vote.model.dto;

public class VoteVo {

//	VJUMIN   NOT NULL CHAR(13)     
//	VNAME             VARCHAR2(20) 
//	VTIME             CHAR(4)      
//	VAREA             CHAR(20)     
//	VCONFIRM          CHAR(1)      
//	MNO      NOT NULL CHAR(1) 
	
	private String vname;
	private String vbirth;
	private String vage;
	private String gender;
	private String mno;
	private String vtime;
	private String vconfirm;
	private String mname;
	private String cnt;
	private String per;
	
	
	
	public VoteVo() {
	}


	



	public VoteVo(String mno, String mname, String cnt, String per) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.cnt = cnt;
		this.per = per;
	}


	



	public VoteVo(String vname, String vbirth, String vage, String gender, String mno, String vtime, String vconfirm) {
		super();
		this.vname = vname;
		this.vbirth = vbirth;
		this.vage = vage;
		this.gender = gender;
		this.mno = mno;
		this.vtime = vtime;
		this.vconfirm = vconfirm;
	}






	public VoteVo(String vname, String vbirth, String vage, String gender, String mno, String vtime, String vconfirm,
			String mname, String cnt, String per) {
		super();
		this.vname = vname;
		this.vbirth = vbirth;
		this.vage = vage;
		this.gender = gender;
		this.mno = mno;
		this.vtime = vtime;
		this.vconfirm = vconfirm;
		this.mname = mname;
		this.cnt = cnt;
		this.per = per;
	}






	@Override
	public String toString() {
		return "VoteVo [vname=" + vname + ", vbirth=" + vbirth + ", vage=" + vage + ", gender=" + gender + ", mno="
				+ mno + ", vtime=" + vtime + ", vconfirm=" + vconfirm + ", mname=" + mname + ", cnt=" + cnt + ", per="
				+ per + "]";
	}






	public String getPer() {
		return per;
	}






	public void setPer(String per) {
		this.per = per;
	}






	public String getVname() {
		return vname;
	}



	public void setVname(String vname) {
		this.vname = vname;
	}



	public String getVbirth() {
		return vbirth;
	}



	public void setVbirth(String vbirth) {
		this.vbirth = vbirth;
	}



	public String getVage() {
		return vage;
	}



	public void setVage(String vage) {
		this.vage = vage;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getMno() {
		return mno;
	}



	public void setMno(String mno) {
		this.mno = mno;
	}



	public String getVtime() {
		return vtime;
	}



	public void setVtime(String vtime) {
		this.vtime = vtime;
	}



	public String getVconfirm() {
		return vconfirm;
	}



	public void setVconfirm(String vconfirm) {
		this.vconfirm = vconfirm;
	}

	public String getMname() {
		return mname;
	}



	public void setMname(String mname) {
		this.mname = mname;
	}



	public String getCnt() {
		return cnt;
	}



	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	
	
}
