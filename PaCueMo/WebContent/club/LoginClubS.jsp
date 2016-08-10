<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<s:head theme="xhtml" />
<Script>
 function showImg(event)  {
	 path = URL.createObjectURL(event.target.files[0]);
	 document.getElementById("img").src=path;
}
</Script>
</head>
<body>
<h3>新增社團</h3>

     
      <div id="imgDiv">
      <img src='' id='img' style="width:50px;height:50px">
      </div>
      <s:form enctype="multipart/form-data" action="clubAction!add" namespace="/PaCueMo">
        <s:textfield label="社團名稱" name="clubVO.clubName" />
        <s:textfield label="社團團長" name="clubVO.clubHead"/>
        <s:select emptyOption="true" label="社團性質" name="clubVO.clubProp" 
        list="#{1:'休閒',2:'硬漢',3:'競技'}" 
        listKey="key" listValue="value"
 		headerValue="--請選擇--" headerKey="-1"></s:select> 
        <s:file label="選擇圖片" name="upload" onchange="showImg(event);"/>       
        <s:submit value="上傳" />
      </s:form>
</body>
</html>