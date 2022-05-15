<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.Feedback" %>
<!DOCTYPE html>
<html>
<head>
<!-- Page Header Styles -->
<style>
        .pageHead {
            display: flex;
        }

        .left {
            flex: 25%;
            padding: 15px 0;
        }

        .center {
            flex: 50%;
            padding: 15px 0;
        }
        .right {
            flex: 25%;
            padding: 15px 0;
        }   
</style>
<!-- Page Header Styles -->
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/main.js"></script>
<!-- charset meta tag -->
<meta charset="utf-8">
<!-- head code meta tag -->
<meta name="viewport" content="eidth=device-width, initial-scale=1">
<title>Feedback Management</title>
<!-- CSS Links -->
<link rel ="stylesheet" type="text/css" href="css/Styles.css">
<link rel ="stylesheet" type="text/css" href="css/Jobs & req.css">
<!-- CSS Links -->
</head>
<body>
<!-- Page Header section -->
<div class="pageHead">
	<div class="center" align="center">
		<h1 style="font-family:Brush Script MT;"><span>Electro</span>Grid</h1>
		<h2 style="font-family:Courier New;">Best Services</h2>
	</div >
</div>
<!-- Page Header section -->
<!-- Page Navigation section -->
<div class="pageNav" id="ul">
	<div class="left" id="li">
		<a id="li a" href="ViewPowerUsagePage.jsp" style="font-family:sans-serif;">
                    View Feedback Data
        </a>
	</div>
</div>
<div class="innerpageNav" id="ul2">
	<div class="left1" id="li2">
	<a href="#">
		<font  style="font-family:Brush Script MT ; text-align:center;"><span>Electro</span>Grid</font>
		</a>
    </div>
	<div  style="text-align:center;" class="right1" id="li2">
		<a id="li2 a" style="font-family:sans-serif;">
                    Feedback Management
        </a>
    </div>
</div>
<!-- Page Navigation section -->
<!-- Page Body section -->
<div class="page-wrapper">
	<div class="container">
<form method="post" id="formpowerusage" name="formpowerusage">
 <div class="row">
					<div class="col-25" id="center">
						 USER ID :
					</div>
				 	<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
						 <input  name="userid" id="userid" type="text" >
					</div>
				</div>
				<br>
					<div class="row">
						<div class="col-25" id="center"> 
							PREVIOUS BILL NO:
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="previousbillno" type="text" id="previousbillno">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-25" id="center"> 
							AMOUNT (RS):
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="amount" type="text" id="amount">
						</div>
					</div>
					<br> 
					<div class="row">
						<div class="col-25" id="center"> 
							PAYED AMOUNT (RS):
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="payedamount" type="text" id="payedamount">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-25" id="center">  
							 BALANCE (RS):
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="balance" type="text" id="balance">
						</div>
					</div>
					<br> 
					<div class="row">
						<div class="col-25" id="center">  
							NEW BILL NO:
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="newbillno" type="text" id="newbillno">
						</div>
					</div>
					 <br>
					<div class="row">
						<div class="col-25" id="center">  
							NEW AMOUNT (RS):
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="newamount" type="text" id="newamount">
						</div>
					</div>
					<br> 
					<div class="row">
						<div class="col-25" id="center">  
							TOTAL (RS):
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="total" type="text" id="total">
						</div>
					</div>
					<br> 
					<div class="row">
						<div class="col-25" id="center">  
							COMMENT:
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="comment" type="text" id="comment">
						</div>
					</div>
					<br> 
					<div class="pageNav" >
						<div class="left" id="center">
 							<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
 						</div>
 						<div class="right" id="center">
 							<input type="hidden" id="hididUpdate" name="hididUpdate" value="">
 						</div>
 					</div>		
 
</form>
	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
<br>
	<div class="page-wrapper">
		<div class="container">
			<div style="overflow-x: auto;" id="center" id="divpowerusageGrid">
			 <%
			 feedback feedbackObj = new feedback();
			 out.print(feedbackObj.readFeedback());
			 %>
			</div>
		</div> 
	</div>
</div> 
</div><!-- Footer -->
<div class="footer">
	
	<div class="footer-content">
		  
		<div class="footer-section-about">
			
			<h1 style="font-family:Brush Script MT;"><span>Electro</span>Grid</h1>
			
			<p>We Provide Best Services For You.
			</p>
			
			<h3> Our Location </h3>
			<font size="3">No 220.<br> Malwaththa Rd, <br> Colombo 03 <br> E-Mail :- ElectroGrid@Gmail.com 
			
			</font>
		</div>	
		
		<div class="footer-section-links">
		
		</div>
		
		<div class="footer-section-contact-form">
			<h2>Contact Us</h2>
			
			<h3> Hotline : 011-289-566-1</h3>
		
			<div class="socials">
				<a href="#"><i class="fab fa-facebook"></i></a>
				<a href="#"><i class="fab fa-instagram"></i></a>
				<a href="#"><i class="fab fa-twitter"></i></a>
				<a href="#"><i class="fab fa-youtube"></i></a>
			</div>
			
		</div>
	</div>
	

	<div class="footer-bottom">
		
		&copy; ElectroGrid.com | Designed by Weerasinghe Designer
	</div>

</div>
<!-- /Footer-->
</body>

</html>