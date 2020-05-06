<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
.jumbotron {
	margin-top: 5%;
	border: 2px solid rgb(88, 17, 67);
	background-color: rgba(252, 252, 252,);
	margin-bottom: 2%;
	margin-left: 25%;
	width: 50%;
	height: 70%;
}

.form-label-group {
	display: flex;
	flex-flow: row-reverse;
	margin-top: 2%;
}

div {
	color: rgb(10, 9, 9);
}

.btn1 {
	background-color: rgb(170, 27, 170);
	margin-top: 5%;
}

input[type=text] {
	border: 1px solid rgb(88, 17, 67);
	border-radius: 0%;
}

hr.new1 {
	border-top: 2px solid rgb(88, 17, 67);
}

table {
	width: 50%;
	margin-left:25%;

	
}
</style>
<c:if test="${info}">
	<div class="alert" role="alert">
		<h3>${message}</h3>
	</div>
</c:if>

<div class="jumbotron">
	<div class="col-12" style="margin-top: 1%">
		<h2 class="text-center">Add Your Category Here.</h2>
		<div>

			<hr class="new1">
			<c:if test="${edit}">
				<c:set var="url" value="updatecategory"></c:set>
			</c:if>
			<c:if test="${!edit}">
				<c:set var="url" value="addcategory"></c:set>
			</c:if>
			<form:form action="${url}" method="post"
				modelAttribute="categoryobject">
				<c:if test="${edit}">
					<form:hidden id="inputEmail" class="form-control"
						placeholder="category " path="cat_Id" />

				</c:if>
				<div class="form-label-group">
					<label for="inputEmail"></label>
					<form:input type="text" id="inputEmail" class="form-control"
						placeholder="category " path="cat_Name" />
					<form:errors path="cat_Name" cssStyle="color:Red"></form:errors>
				</div>
				<button
					class="btn1 btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
					type="submit">Submit</button>
			</form:form>
		</div>

	</div>
	
	
</div>
<div  class="table-responsive table-bordered movie-table">

		<table >
			<tr>
				<th>Category Id</th>
				<th>Category Name</th>
				<th>Edit/Delete</th>
			</tr>
			<c:forEach var="c" items="${categorylist}">
				<tr>
					<td>${c.cat_Id}</td>
					<td>${c.cat_Name}</td>
					<td>
						<div class="row">
							<div class="col-6">
								<a href="deletecategory?catname=${c.cat_Name}"
									class="btn btn-danger">Delete</a>
							</div>
							<div class="col-6">
								<a href="getdatatoedit?catname=${c.cat_Name}"
									class="btn btn-success">Edit</a>
							</div>
						</div>
					</td>
				</tr>

			</c:forEach>
		</table>
	</div>
