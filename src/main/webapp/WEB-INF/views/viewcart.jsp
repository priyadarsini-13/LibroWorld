<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.alert {
	width: 50%;
	margin-top: 2%;
	margin-left: 25%
}

.table {
	width: 100%;
	margin-top: 2%;
	color: rgb(88, 17, 67);
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	font-size: 20px;
}

.btn10 {
	margin-left: 7%;
	background: rgb(88, 17, 67);
}

.btn11 {
	margin-left: 49%;
}

.jumbotron {
	width: 30%;
	margin-top: 5%;
	height: 5%;
	margin-left: 30%;
	font-size: 25px;
}
</style>
</head>
<body>
	<div class="container" style="margin-bottom: 15px">

		<c:if test="${empty cartinfo}">
			<h2 class="jumbotron">Cart is empty</h2>
			<a href="${cr}/allproducts" class="btn btn-success"><i
				class="fa fa-angle-left"></i>Continue Shopping</a>
		</c:if>
		<c:if test="${not empty cartinfo}">



			<table class="table ">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Product Image</th>
						<th scope="col">Product Name</th>
						<th scope="col">Price</th>
						<th scope="col">Quantity</th>

						<th scope="col">Subtotal</th>

					</tr>
				</thead>
				<tbody>
					<c:set var="Total" value="0" />

					<c:forEach items="${cartinfo}" var="p">
						<c:set var="subtotal"
							value="${p.pro_Quantity*p.prodDetails.price}"></c:set>
						<c:set var="Total" value="${Total+subtotal }" />

						<tr>

							<td><img src="${cr }/pimg/${p.prodDetails.pro_Id}.jpeg"
								width="90px" height="110px"></td>
							<td>${p.prodDetails.pro_Name}

								<div class="row">
									<div class="col-7 text-center" style="margin-top: 10%">
										<a href="${cr}/user/deleteitem?cartid=${p.cart_Id}"
											class="btn btn btn-danger "> Remove<i
											class="fa fa-trash-o"></i>
										</a>
									</div>
									<c:if test="${error && prodid == p.prodDetails.pro_Id}">
										<div class="alert alert-warning">
											<strong>${message}</strong>
										</div>
									</c:if>
									<c:if test="${p.prodDetails.stock==0}">
									<strong>Out of Stock</strong>
									</c:if>
									
								</div>

							</td>

							<td>${p.prodDetails.price}</td>
							<td>
								<form action="${cr }/addtocart" method="post">


									<input type="number" class="text-center" min="1" max="10"
										id="quantity" name="quantity" value="${p.pro_Quantity}">
									<input type="hidden" id="productid" name="productid"
										value="${p.prodDetails.pro_Id}"> <input type="hidden"
										id="cartpage" name="cartpage" value="true">
									<button type="submit">
										<i class="fa fa-plus"></i>
									</button>

								</form>
							</td>

							<td data-th="Total" class="text-center" colspan="1"><label>${subtotal}</label></td>
							<td>
					</c:forEach>

				</tbody>


				<tfoot>
					<tr>
						<td>Subtotal</td>
						<td />
						<td />
						<td data-th="Total" class="text-center" colspan="1">${Total}</td>

					</tr>
					<tr>
						<td>Shipping</td>
						<td />
						<td />
						<td data-th="Total" class="text-center" colspan="1"><c:if
								test="${Total>1000 }">
								<c:set var="shipping" value="0"></c:set>
					Free
					</c:if> <c:if test="${Total<=1000 }">
								<c:set var="shipping" value="100"></c:set>
					${shipping}
				
					</c:if></td>

					</tr>
					<tr>
						<td>Total</td>
						<td />
						<td />
						<td data-th="Total" class="text-center" colspan="1">${Total+shipping}</td>

					</tr>

					<tr>
						<td><a href="${cr }/allproducts" class="btn btn-warning"><i
								class="fa fa-angle-left"></i> Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td />
						<td />


						<td><a href="${cr }/user/selectaddress"
							class="btn btn-success btn-block">Checkout <i
								class="fa fa-angle-right"></i>
						</a></td>
					</tr>
				</tfoot>

			</table>
		</c:if>
	</div>

</body>