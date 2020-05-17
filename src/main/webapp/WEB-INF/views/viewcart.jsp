<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.alert {
width:50%;
margin-top:2%;
margin-left:25%
}
.table{
margin-top:2%;
width:100%;
color: rgb(88, 17, 67);
font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
font-size:20px;
}

</style>
</head>
<body>
<c:if test="${empty cartinfo}">
<div class="jumbotron">no items</div>
</c:if>
<c:if test="${not empty cartinfo}">
<c:if test="${error}">
				<div class=" text-center alert alert-danger">
					<strong>${message}</strong>
				</div>
			</c:if>
<div class="container">
<div >
	
		<table class="table table-bordered ">
			<thead class="thead-dark">
				<tr >
					<th scope="col">Product Image</th>
					<th scope="col">Product Name</th>
					<th scope="col">Price</th>
						<th scope="col">Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartinfo}" var="p">
					<tr >
					
						<td ><img src="${cr }/pimg/${p.prodDetails.pro_Id}.jpeg"
							width="90px" height="110px"></td>
						<td >${p.prodDetails.pro_Name}</td>
						
						<td>${p.prodDetails.price}</td>
                        <td >${p.pro_Quantity}</td>

					</tr>
					 <c:set var="total" value="${total + p.prodDetails.price }" />
					
				</c:forEach>
			
			</tbody>
		</table>
             	<h1 class="text-right">Total = ${total }</h1>
	</div>

</div>
</c:if>
</body>
</html>