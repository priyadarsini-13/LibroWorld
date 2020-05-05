<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
.jumbotron {
	margin-top: 5%;
	border: 2px solid rgb(88, 17, 67);
	background-color: rgba(252, 252, 252,);
	margin-bottom: 2%;
	margin-left: 23%;
	width:50%;
	height: 85%;
}

.icon {
	padding: 10px;
	background: rgb(255, 253, 253);
	color: rgb(19, 3, 15);
	min-width: 50px;
	border: 0.5px solid rgb(88, 17, 67);
	text-align: center;
}

.form-label-group {
	display: flex;
	flex-flow: row-reverse;
	margin-top: 2%;
}

div {
	color: rgb(10, 9, 9);
}

.btn5 {
	background-color: rgb(170, 27, 170);
	margin-top: 5%;
}

.form-control{
	border: 1px solid rgb(88, 17, 67);
	border-radius: 0%;
	margin-top:3%;
}
} 
input[type=text] {
	border: 1px solid rgb(88, 17, 67);
	border-radius: 0%;
}

hr.new1 {
	border-top: 2px solid rgb(88, 17, 67);
}
table {
	width: 100%;
	margin-left:10%;
}
</style>
<body>

	
	<c:if test="${info}">
		<div class="alert">
		${message}
		</div>
	</c:if>
	

	<div class="jumbotron">
		<div class="col-12" style="margin-top: 1%">
			<center>
				<h2>ProductDetails</h2>
			</center>

			<div>
				<hr class="new1">
<c:if test="${edit}">
				<c:set var="url" value="updateproduct"></c:set>
			</c:if>
			<c:if test="${!edit}">
				<c:set var="url" value="addproduct"></c:set>
			</c:if>
				<form:form action="${url}" method="post"
				modelAttribute="productobject">
				<c:if test="${edit}">
					<form:hidden id="pro_id" class="form-control"
						placeholder="productid" path="pro_Id" />

				</c:if>

					<div class="form-label-group">
						<label for="inputname"></label>
						<form:input type="text" id="pro_name" class="form-control"
							placeholder="ProductName" path="pro_Name" />
						<form:errors path="pro_Name" cssStyle="color:Red"></form:errors>
					</div>
					<div class="form-label-group">
						<label for="description"></label>
						<form:textarea class="form-control" placeholder="Descripton"
							rows="4" path="description"></form:textarea>
						<form:errors path="description" cssStyle="color:Red"></form:errors>
					</div>
						<form:select id="cat_Name" name="cat_Name"
							path="pro_Category.cat_Id"  class="form-control">
							<c:forEach items="${catlist}" var="c">
								<form:option value="${c.cat_Id}">${c.cat_Name}</form:option>
							</c:forEach>
						</form:select>
					

					<form:errors path="pro_Category" cssStyle="color:Red"></form:errors>
			
			<div class="form-label-group">
				<label for="Stocks"></label>
				<form:input type="text" id="stock" class="form-control"
					placeholder="stock" path="stock" />
				<form:errors path="stock" cssStyle="color:Red"></form:errors>
			</div>
			<div class="form-label-group">
				<label for="inputname"></label>
				<form:input type="text" id="price" class="form-control"
					placeholder="price" path="price" />
				<form:errors path="price" cssStyle="color:Red"></form:errors>
			</div>


			<button
				class="btn5 btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
				type="submit">Submit</button>
			</form:form>
</div>
</div>
	</div>
	
	
	<div class="col-10">

		<table>
			<tr>
				            <th>ProductId</th>
							<th> Name</th>
							<th>Description</th>
							<th>Stock</th>
							<th>Price</th>
							<th>Product Category</th>
							<th>Edit/Delete</th>
			</tr>
			<c:forEach items="${productlist}" var="c" >
				<tr>
					<td>${c.pro_Id}</td>
					<td>${c.pro_Name}</td>
					<td>${c.description}</td>
					<td>${c.stock}</td>
					<td>${c.price}</td>
					<td>${c.pro_Category.cat_Name}</td>
					<td>
						<div class="row">
							<div class="col-6">
								<a href="deleteproduct?prodid=${c.pro_Id}"
									class="btn btn-danger">Delete</a>
							</div>
							<div class="col-6">
								<a href="getproducttoedit?prodid=${c.pro_Id}"
									class="btn btn-success">Edit</a>
							</div>
						</div>
					</td>
				</tr>

			</c:forEach>
		</table>



		</div>
	