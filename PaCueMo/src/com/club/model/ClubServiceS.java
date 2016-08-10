package com.club.model;


import java.sql.Date;


public class ClubServiceS {
   ClubDAO dao = new ClubDAO();
	  
//	public static void main(String[] args) {
//		ClubService service = new ClubService();
//		
//		FileInputStream is;
//		byte[] img=null;
//		try {
//			is = new FileInputStream("E:\\club\\spurs.png");
//			img=new byte[1048];
//			is.read(img);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//       service.save("°¨¨ë¶¤",img,Date.valueOf("1995-10-01"),150,2);
//		service.delete(11);
//		int clubID=10;
//		ClubVO clubVO = service.find(clubID);
//		System.out.print(clubVO.getClubID());
//	}

	public void save(ClubVO clubVO){
        dao.insert(clubVO);
       
	}
	public void delete(int clubID){
		dao.delete(clubID);
	}
	public ClubVO find(int clubID){
		ClubVO clubVO = dao.findByPK(clubID);
		return clubVO;
	}
	
	
}
