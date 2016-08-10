package com.club.model;

import java.sql.Date;
import java.util.List;

public class ClubMemberService {
	ClubMemberDAO dao = new ClubMemberDAO();

	public void save(int clubId,int clubMemberId,Date joinDate) {
		ClubMemberVO memberVO = new ClubMemberVO();
		memberVO.setClubId(clubId);
		memberVO.setClubMemberId(clubMemberId);
		memberVO.setJoinDate(joinDate);
		dao.insert(memberVO);

	}

	public void delete(int clubMemberId) {
		dao.delete(clubMemberId);
	}

	public ClubMemberVO findOne(int clubMemberId) {
		ClubMemberVO memberVO = dao.findByPK(clubMemberId);
		return memberVO;
	}

	public List<ClubMemberVO> findAll() {
		List<ClubMemberVO> memberVOs = dao.getAll();
		return memberVOs;
	}
	
	public List<ClubMemberVO> findOneClubMmb(int clubId) {
		List<ClubMemberVO> memberVOs = dao.getClubAll(clubId);
		return memberVOs;
	}

}
