package com.club.model;


import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.member.model.MemberDAO;
import com.member.model.MemberVO;



public class ClubService {
   ClubDAO dao = new ClubDAO();
	  

	public void save(String clubName,String clubImageName,Date clubDate,int clubHead, int clubProp ){
	    ClubVO clubVO = new ClubVO();
        clubVO.setClubName(clubName);
        clubVO.setClubImageName(clubImageName);
        clubVO.setClubDate(clubDate);
        clubVO.setClubHead(clubHead);
        clubVO.setClubProp(clubProp);
        dao.insert(clubVO);
       
	}
	public void delete(int clubID){
		dao.delete(clubID);
	}
	public String findOne(int clubID){
		ClubVO clubVO = dao.findByPK(clubID);
		//一個社團全部成員	
		ClubMemberService ms = new ClubMemberService();
		List<ClubMemberVO> clubMembers = ms.findOneClubMmb(clubID);
         
		for(ClubMemberVO mmb:clubMembers){
		    MemberDAO mdao = new MemberDAO(); 
		    mmb.setMember(mdao.findByPrimaryKey(mmb.getClubMemberId()));
		}
		//透過傳入社團ID找尋社團全部成員
		clubVO.setClubmembers(clubMembers);
		
		Gson gson = new Gson();
		String club = gson.toJson(clubVO);
		return club;
	}
	
	public List<ClubVO> findAll(){
		List<ClubVO> clubVOs=dao.getAll();
		return clubVOs;
	}
	
	public static void main(String[] args){
		ClubService s = new ClubService();
		String club = s.findOne(3);
		System.out.println(club);
	}
	
}
