<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib  prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查尋社團</title>
</head>
<body>


<c:forEach var="error" items="${errorMsgs}">
      錯誤訊息:${error}
      </c:forEach>
<form >
社團ID:<input type="text" id="id" name="ClubID"/><br>
<input type="button" id="btn" value="上傳"/>
</form>

<div id="div1"></div>

<Script>

var btn = document.getElementById("btn");
btn.addEventListener("click", load);

function load() {
    var id = "ClubID=" + document.getElementById("id").value;
    var xmlHttp = new XMLHttpRequest();
    if (xmlHttp != null) {
        xmlHttp.addEventListener("load", callback);

        xmlHttp.open("get", "GetClubInfo?" + id, true);
        xmlHttp.send();

    }

    function callback() {

        var data = JSON.parse(xmlHttp.responseText);
        alert(data);


    }

}


</Script>
</body>
</html>