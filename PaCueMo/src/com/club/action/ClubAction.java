package com.club.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import com.club.model.ClubServiceS;
import com.club.model.ClubVO;
import com.opensymphony.xwork2.ActionSupport;

public class ClubAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClubVO clubVO;
	private File file;
    private String filename;
    public void setUpload(File file) {
        this.file = file;
     }

     public void setUploadFileName(String filename) {
        this.filename = filename;
     }

	public ClubVO getClubVO() {
		return clubVO;
	}

	public void setClubVO(ClubVO clubVO) {
		this.clubVO = clubVO;
	}
	
	public String excute(){
		
		return "success";
	}
    public String add(){
    	try {
			InputStream is = new FileInputStream(file);
			
			byte[] b =new byte[(int)file.length()]; 
				is.read(b);
			 clubVO.setClubImageName(filename);
			 Date clubDate = new Date(System.currentTimeMillis());
			 clubVO.setClubDate(clubDate);
			 System.out.println("success");
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClubServiceS service = new ClubServiceS();
		service.save(clubVO);
		return "success";
	}
}
