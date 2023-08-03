package kh.semi.vote.model.dto;

public class VoteVo {

//	VJUMIN   NOT NULL CHAR(13)     
//	VNAME             VARCHAR2(20) 
//	VTIME             CHAR(4)      
//	VAREA             CHAR(20)     
//	VCONFIRM          CHAR(1)      
//	MNO      NOT NULL CHAR(1) 
	
	private String vname;
	private String vjumin;
	private String mno;
	private String vtime;
	private String vconfirm;
	
	
	
	public VoteVo() {
	}
	
	
	@Override
	public String toString() {
		return "VoteVo [vname=" + vname + ", vjumin=" + vjumin + ", mno=" + mno + ", vtime=" + vtime + ", vconfirm="
				+ vconfirm + "]";
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVjumin() {
		return vjumin;
	}
	public void setVjumin(String vjumin) {
		this.vjumin = vjumin;
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
