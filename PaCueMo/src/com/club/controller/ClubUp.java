package com.club.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.club.model.ClubService;

/**
 * Servlet implementation class ClubUp
 */
@WebServlet("/ClubUp")
public class ClubUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClubUp() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		String clubName = null;
		int clubHead = 0;
		byte[] clubImage = null;
		String clubImageName=null;
		int clubProp = 0;
		Date clubDate = new Date(System.currentTimeMillis());
		
		List<FileItem> items = null;
		
		List<String> errorMsg = new LinkedList<String>();
		request.setAttribute("errorMsgs", errorMsg);
		
		ClubService clubService = null;

		try {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024 * 1024 * 2);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(1024 * 1024 * 10);

			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}

			Iterator<FileItem> iters = items.iterator();
			while (iters.hasNext()) {
				FileItem fileItem = iters.next();
				// form��Ƭ����`��r
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					if (value == null || value.trim().length() == 0) {
						errorMsg.add("檔案名稱空白");
						if(!errorMsg.isEmpty()){
			            	RequestDispatcher failureView = request.getRequestDispatcher("/club/LoginClub.jsp");
			    			failureView.forward(request, response);
			    			return;
			            }
					}
					// Ū�����ΦW��
					if ("clubName".equalsIgnoreCase(name)) {
						if (value.length() > 10) {
							errorMsg.add("檔案名稱太長");
						}
						System.out.println(name);
						System.out.println(value);
						clubName = value;
						System.out.println(clubName);
						
					}
					// Ū�����ιΪ�
					else if ("clubHead".equalsIgnoreCase(name)) {
						try {
							clubHead = new Integer(value);
						} catch (Exception e) {
							errorMsg.add("資料格式錯誤");
						}

					}
					// Ū�����Ωʽ�
					else if ("clubProp".equalsIgnoreCase(name)) {
						try {
							clubProp = new Integer(value);
						} catch (Exception e) {
							errorMsg.add("資料格式錯誤");
						}

					}

					else {
						errorMsg.add("表格資料錯誤");
					}
					// Ū���Ϥ��ɮ�
				} else {
					String fieldName = fileItem.getFieldName();
					String contentType = fileItem.getContentType();
					String fileName = fileItem.getName();
					long sizeInBytes = fileItem.getSize();
                    int i=fileName.lastIndexOf("/");
                    clubImageName=fileName.substring(i+1);
					if (fieldName.equalsIgnoreCase("clubImage")) {
						String[] type = contentType.split("/");
						if (!type[0].equalsIgnoreCase("image")) {
							errorMsg.add("資料格式錯誤");
						}
						if (sizeInBytes > 1024 * 1024 * 2) {
							errorMsg.add("檔案太大");
						}

						clubImage = fileItem.get();
					} 
					else {
						errorMsg.add("表格輸入錯誤");
					}
				}

			}
            if(!errorMsg.isEmpty()){
            	RequestDispatcher failureView = request.getRequestDispatcher("/club/LoginClub.jsp");
    			failureView.forward(request, response);
    			return;
            }
            clubService = new ClubService() ;
			clubService.save(clubName, clubImageName,clubDate, clubHead, clubProp);
			RequestDispatcher successView = request.getRequestDispatcher("/club/success.jsp");
			successView.forward(request, response);
			return;
		} catch (Exception e) {
			errorMsg.add("上傳錯誤:" + e.getMessage());
			RequestDispatcher failureView = request.getRequestDispatcher("/club/LoginClub.jsp");
			failureView.forward(request, response);
			return;
		}
	}

}
