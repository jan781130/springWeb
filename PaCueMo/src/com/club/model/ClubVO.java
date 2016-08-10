package com.club.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ClubVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ClubVO() {
		
	}
	private int clubID;
	private String clubName;
	private String clubImageName;
	
	private Date clubDate;
	private int clubHead;
	private int clubProp;
	private List<ClubMemberVO> clubmembers;
	public int getClubID() {
		return clubID;
	}
	public void setClubID(int clubID) {
		this.clubID = clubID;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public Date getClubDate() {
		return clubDate;
	}
	public void setClubDate(Date clubDate) {
		this.clubDate = clubDate;
	}
	public int getClubHead() {
		return clubHead;
	}
	public void setClubHead(int clubHead) {
		this.clubHead = clubHead;
	}
	public int getClubProp() {
		return clubProp;
	}
	public void setClubProp(int clubProp) {
		this.clubProp = clubProp;
	}
	public String getClubImageName() {
		return clubImageName;
	}
	public void setClubImageName(String clubImageName) {
		this.clubImageName = clubImageName;
	}
	public List<ClubMemberVO> getClubmembers() {
		return clubmembers;
	}
	public void setClubmembers(List<ClubMemberVO> clubmembers) {
		this.clubmembers = clubmembers;
	}
}
