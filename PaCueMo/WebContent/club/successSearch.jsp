<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td>ClubID: ${sessionScope.ClubVO.clubID}</td></tr>
<tr><td>ClubName: ${sessionScope.ClubVO.clubName}</td></tr>
<tr><td>ClubDate: ${sessionScope.ClubVO.clubDate}</td></tr>
<tr><td>ClubProp: ${sessionScope.ClubVO.clubProp}</td></tr>
<tr><td>ClubImage: <img src='${pageContext.servletContext.contextPath}/GetImage?type=Club'/></td></tr>
</table>
</body>
</html> 