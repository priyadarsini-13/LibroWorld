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
	margin-top: 10%;
	height: 400px;
	width:305px;
	border:4px solid rgb(88, 17, 67);
	margin-left:5%;
	border-radius:1%;
	
}


.mytext
{
color: blue;
font-style: oblique;
}
.mytext1
{
color:  rgb(88, 17, 67);
font-style: oblique;

}



.card-img-top {
	height: 200px;
	widht: 100px;
}
.card-text{
 margin-top: 2%;
   font-family:bold;
 
}

.card-title {
font-family:bold;
font-size:25px;
	white-space: nowrap;
	text-overflow: ellipsis;
	}
	
}
</style>
</head>
<body>


	<div class="container">

		<div class="row">
			<c:forEach items="${productlist}" var="p">
				<div class="col-4">
					<div class="card">
						<img src="${cr }/pimg/${p.pro_Id}.jpeg" class="card-img-top" />
						<div class="card-body">
							<div class="col-12">
								<p class="card-title" data-toggle="tooltip"
									title="${p.description}">${p.pro_Name}</p>
							</div>
							
							
								<div class="col-12">
									<p class="card-text">
										Price:  <span class="mytext">&#8377 ${p.price}</span>
									</p>
								</div>
								<div class="col-12">
									<c:if test="${p.stock > 2}">
										<p class="card-text">
											Stock:<span class="mytext">  In Stock</span>
										</p>
									</c:if>
									<c:if test="${p.stock < 2 }">
										<p class="card-text">
											Stock:<span class="mytext">  Only  ${p.stock}  Available</span>
										</p>
									</c:if>
								</div>

							<div class="row"style=" margin-top:2%">
								<div class="col-6">
									<a href="${cr }/addtocart?productid=${p.pro_Id}" class="btn btn-success"> Add to cart<i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
								</div>
								<div class="col-6">
									<a href="${cr }/oneproduct?prodid=${p.pro_Id}" class="btn btn-warning">View Details<i class="fa fa-info-circle" aria-hidden="true"></i></a>
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