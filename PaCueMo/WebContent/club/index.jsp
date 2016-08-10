<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="TW-ZH">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>社團查詢結果</title>

<!-- Bootstrap Core CSS -->
<link href="/PaCueMo/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/PaCueMo/css/round-about.css" rel="stylesheet">
<style>
.search {
	position: absolute;
	right: 0px;
	width: 200px;
	font-size: 12px;
}
.memberPhoto{
width:200px;
height:200px;
}
.container-head{
margin-left:20px;
margin-right:20px;
}
.clubImg{
width:200px;
height:200px;

}
</style>
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Start Bootstrap</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">About</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Page Content -->
	<div class="container-head container">
        <div class="col-lg-3" id='clubImg'>
        <img src="/PaCueMo/image/club/girl.jpg" class="img-thumbnail" style="width:200px;height:200px">
        </div>
		<!-- Introduction Row -->
		<div class="row col-lg-9">
			<div class="col-lg-12">
				<h1 class="page-header">
					<strong>About Us</strong><small>It's Nice to Meet You!</small> <small class=search>搜尋社團:<input
						type="text" id="clubId" placeholder="ex:1"></input></small>
				</h1>
			</div>


			<p id='details'></p>
		</div>
	</div>

	<!-- Team Members Row -->
	<div class="row" id='member'>
		<div class="col-lg-12">
			<h2 class="page-header">Our Team</h2>
		</div>
				
	</div>

	<hr>

	<!-- Footer -->
	<footer>
	<div class="row">
		<div class="col-lg-12">
			<p>Copyright &copy; Your Website 2014</p>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row --> </footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="/PaCueMo/js/jquery.js"></script>
	<script src="/PaCueMo/js/bootstrap.min.js"></script>
	<script>
		$(function(){
			$('#clubId').keyup(function(e){
				if((e.keyCode||e.which)==13){
					$('#s').remove();
					var divall = $('<div/>').attr('id','s');
					var clubID=$('#clubId').val();				
					$.get("/PaCueMo/club/GetClubInfo",'ClubID='+clubID,function(data){
						$('#clubImg>Img').attr('src','/PaCueMo/image/club/'+data.clubImageName);
						$('.page-header>strong').empty().text(data.clubName);
						var day =$('<strong></strong>)').text('成立日期:'+data.clubDate);
						$('#details').empty().append(day);
						$.each(data.clubmembers,function(idx,clubmember){
							if(data.clubHead==clubmember.member.memberId){
								
							};
							var joindate=$('<small></small>').text(clubmember.joinDate);
							var name=$('<h3></h3>').text(clubmember.member.memberLastName+clubmember.member.memberFirstName+'/').append(joindate);
							var img=$('<img></img>').addClass('img-circle img-responsive img-center memberPhoto').attr("src","/PaCueMo/image/member/"+clubmember.member.memberFileName);
							var div=$('<div></div>').addClass('col-lg-4 col-sm-6 text-center').append([img,name]);
							divall.append(div);
						});
					});
					$('#member').append(divall);
				};
			});
		});
	</script>

</body>

</html>
