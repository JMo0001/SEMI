package kh.semi.vote.model.dto;

public class VoteDto {

//	VJUMIN   NOT NULL CHAR(13)     
//	VNAME             VARCHAR2(20) 
//	VTIME             CHAR(4)      
//	VAREA             CHAR(20)     
//	VCONFIRM          CHAR(1)      
//	MNO      NOT NULL CHAR(1) 
	

	private String vjumin;
	private String vname;
	private String vtime;
	private String varea;
	private String vconfirm;
	private String mno;
	
	
	
	public VoteDto() {
		super();
	}
	public VoteDto(String vjumin, String vname, String vtime, String varea, String vconfirm, String mno) {
		super();
		this.vjumin = vjumin;
		this.vname = vname;
		this.vtime = vtime;
		this.varea = varea;
		this.vconfirm = vconfirm;
		this.mno = mno;
	}
	@Override
	
	public String toString() {
		return "VoteDto [vjumin=" + vjumin + ", vname=" + vname + ", vtime=" + vtime + ", varea=" + varea
				+ ", vconfirm=" + vconfirm + ", mno=" + mno + "]";
	}
	public String getVjumin() {
		return vjumin;
	}
	public void setVjumin(String vjumin) {
		this.vjumin = vjumin;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVtime() {
		return vtime;
	}
	public void setVtime(String vtime) {
		this.vtime = vtime;
	}
	public String getVarea() {
		return varea;
	}
	public void setVarea(String varea) {
		this.varea = varea;
	}
	public String getVconfirm() {
		return vconfirm;
	}
	public void setVconfirm(String vconfirm) {
		this.vconfirm = vconfirm;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	
	
	
}

