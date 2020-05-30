<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<style>
body{
color:rgb(19, 3, 15);

	
}

</style>

<div class="container" style="margin-top: 5%">
	
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					
					<c:forEach items="${orderlist}" begin="0" end="0" var="o">
					<div class="row">
					<div class="col-8">
					<h4>Order Id :${o.order_Id}</h4>
					<h4>Order Date :${o.order_date}</h4>
					
					</div>
					<div class="col-4">
					<div class="col-12">
								<h2 class="card-title" data-toggle="tooltip" title="${o.address.name}">${o.address.name}</h2>

							</div>
							<div class="col-12">
								<h5 class="card-text">
									<span class="mytext"> ${o.address.line1}</span>
								</h5>
							</div>
							<div class="col-12">
								<h5 class="card-text">
									<span class="mytext"> ${o.address.line2}</span>
								</h5>
							</div>

							<div class="col-12">
								<h5 class="card-text">
									<span class="mytext"> ${o.address.area}</span>
								</h5>
							</div>

							<div class="col-12">
								<h5 class="card-text">
									<span class="mytext"> ${o.address.pincode}</span>
								</h5>
							</div>
					
					</div>
					</div>
					</c:forEach>
					
				</tr>
			</thead>
			<tbody>
				<c:set var="Total" value="0" />
				<c:forEach items="${cartinfo}" var="p">  
					<c:set var="subtotal"
						value="${p.pro_Quantity*p.prodDetails.price}"></c:set>


					<tr>

						<td data-th="Product">
							<div class="row">
								<div class="col-3">
									<img src="${cr }/pimg/${p.prodDetails.pro_Id}.jpeg" alt="..."
										width="100%" />
								</div>
								<div class="col-5">
									<h3  style="margin-top:90px;">${p.prodDetails.pro_Name}</h3>
							
									
								</div>
							</div>
						</td>
						<td data-th="Price">
						<h4 style="margin-top:90px;">
									 <span > ${p.prodDetails.price}</span>
								</h4>
						</td>
						<td data-th="Quantity">
							
								<h4 style="margin-top:90px;" >
									 <span > ${p.pro_Quantity}</span>
								</h4>
							
						</td>
						<td data-th="Total" class="text-center">
						<h4 style="margin-top:90px;">
									 <span > ${p.prodDetails.price}</span>
								</h4>
						</td>
					</tr>


				</c:forEach>
			

			</tbody>
			<tfoot>
				<tr>
					
					<td class="text-uppercase">Subtotal</td>
					<td />
					<td />
					<td data-th="Total" class="text-center" colspan="1">${subtotal}</td>

				</tr>
				<tr>
					<td class="text-uppercase">Shipping</td>
					<td />
					<td />
					<td data-th="Total" class="text-center" colspan="1"><c:if test="${total>1000 }">
					<c:set var="shipping" value="0"></c:set>
					Free
					</c:if>
					<c:if test="${total<=1000 }">
					<c:set var="shipping" value="100"></c:set>
					${shipping}
				
					</c:if></td>

				</tr>
				<tr>
					<td class="text-uppercase">Total</td>
					<td />
					<td />
					<td data-th="Total" class="text-center" colspan="1">${subtotal+shipping}</td>

				</tr>

				<tr>
					<td><a href="${cr }/allproducts"
						class="btn btn-warning"><i class="fa fa-angle-left"></i>
							Continue Shopping</a></td>
					<td colspan="2" class="hidden-xs"></td>
					<td />
					<td />


					<td><a href=""
						class="btn btn-success btn-block">Buy Now <i
							class="fa fa-angle-right"></i>
					</a>
					</td>
				</tr>
			</tfoot>
		</table>
	
</div>