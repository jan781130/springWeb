package com.club.model;

import java.util.List;

public interface ClubMemberDAO_interface {
	public void insert(ClubMemberVO clubMemberVO);
	public void delete(int clubMemberId);
	public ClubMemberVO findByPK(int clubMemberId);
	public List<ClubMemberVO> getAll();
	public List<ClubMemberVO> getClubAll(int clubId);
}
