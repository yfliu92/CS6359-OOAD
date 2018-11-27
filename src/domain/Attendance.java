package domain;

import java.util.Date;

/**
* @author zxy
* @version Nov 27, 2018 3:24:15 PM
* 
*/

public class Attendance {
    private String id;
    private int cid;
    private String uid;
    private Date date;
    private int state;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

}
