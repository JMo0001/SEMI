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
	
	
	
	public VoteVo() {
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



	@Override
	public String toString() {
		return "VoteVo [vname=" + vname + ", vbirth=" + vbirth + ", vage=" + vage + ", gender=" + gender + ", mno="
				+ mno + ", vtime=" + vtime + ", vconfirm=" + vconfirm + "]";
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



	
	
}