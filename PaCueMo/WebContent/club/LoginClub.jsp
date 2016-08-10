<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<Script>
 function showImg(event)  {
	 path = URL.createObjectURL(event.target.files[0]);
	 document.getElementById("img").src=path;
}
</Script>
</head>
<body>
<h3>新增社團</h3>

      <c:forEach var="error" items="${errorMsgs}">
      錯誤訊息:${error}
      </c:forEach>
      <div id="imgDiv">
      <img src='' id='img' style="width:50px;height:50px">
      </div>
      <form enctype="multipart/form-data" method="post" action="/PaCueMo/ClubUp">
        社團名稱:<input type="text" name="clubName" /><p/>
        社團團長:<input type="text" name="clubHead"/><p/>
        社團性質:<select name="clubProp">
         <option value='1'>休閒</option>
         <option value='2'>硬漢</option>
         <option value='3'>競技</option>
         </select><p/>     
        選擇圖片：<input type="file" name="clubImage" onchange="showImg(event);"/><p/>        
        <input type="submit" value="上傳" />
      </form>
</body>
</html>