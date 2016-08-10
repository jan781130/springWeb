package com.club.controller;

import java.io.IOException;

import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.club.model.ClubVO;

/**
 * Servlet implementation class GetImage
 */
@WebServlet("/GetImage")
public class GetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetImage() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		ClubVO clubVO = null;
		OutputStream os =null;
		if (type.equalsIgnoreCase("club")) {
			
			if (session.getAttribute("ClubVO") instanceof ClubVO) {
				clubVO = (ClubVO) session.getAttribute("ClubVO");
			}
//			byte[] clubImage=clubVO.getClubImage();
			String clubImageName = clubVO.getClubImageName();
		    String mimeType = getServletContext().getMimeType(clubImageName);
		    response.setContentType(mimeType);
		    os=response.getOutputStream();
		    
//		    os.write(clubImage,0,clubImage.length);
		}
	}

}
