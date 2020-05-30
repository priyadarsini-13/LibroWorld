<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>

.card {
	margin-top: 3%;
	height: 180px;
border:2px solid rgb(88, 17, 67);
}

.mytext
{
color: blue;
 font-family:bold;
font-size:20px;
}

.card-text
{
   margin-top: 20%;
   font-family:bold;
font-size:23px;
}

.card-img-top {
	height: 140px;
	width: 150px;
	
}

.card-title {
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
	margin-top: 20%;
	font-family:bold;
font-size:23px;

}
.btn{
margin-top: 20%;

}

</style>
</head>
<body>


	<div class="container">

		<div class="row">
			<c:forEach items="${orderlist}" var="p">
				<div class="col-12">
					<div class="card"> 
						<div class="card-body">
						<div class="row">
						<div class="col-3">
						<img src="${cr}/pimg/${p.prod_Details.pro_Id}.jpeg" class="card-img-top" />
						</div>
						<div class="col-3">
								<p class="card-title" data-toggle="tooltip"
									title="${p.prod_Details.pro_Name}">${p.prod_Details.pro_Name}
									</p>
							</div>
							<div class="col-3">
								<p class="card-text">
									OrderDate: <span class="mytext"> ${p.order_date}</span>
								</p>
							</div>
							<div class="col-3">
									<a href="${cr}/user/viewdetails?oid=${p.order_Id}" class="btn btn-warning">View Details <i class="fa fa-info-circle" aria-hidden="true"></i></a>
								</div>
						</div>
							
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>


</body>
</html>
