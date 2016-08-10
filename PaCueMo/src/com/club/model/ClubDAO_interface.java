package com.club.model;

import java.util.List;

public interface ClubDAO_interface {

	public void insert(ClubVO clubVO);
	public void delete(int clubId);
	public void update(ClubVO clubVO);
	public ClubVO findByPK(int clubId);
	public List<ClubVO> getAll();
	
	
}
