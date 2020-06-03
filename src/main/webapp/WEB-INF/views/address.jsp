<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr2" value="${pageContext.request.contextPath}" />

<style>

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}


/* Full-width input fields */
input[type=text], input[type=number], textarea, select {
	width: 100%;
	padding: 5px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	font-size: 100%;
}

.card {
	
	height: 500px;
	width:330px;
	border:4px solid rgb(88, 17, 67);
	margin-left:5%;
	border-radius:1%;
	
}
.mytext
{
color: blue;

}
.mytext1
{
color:  rgb(88, 17, 67);
font-style: oblique;

}
.card-img-top {
	height: 230px;
	
}
.card-text{
   font-family:bold;
}

.card-title {
font-family:bold;
font-size:25px;
	white-space: nowrap;
	text-overflow: ellipsis;
	}
	.fa11{
color:  rgb(88, 17, 67);
	}
}
</style>
<h1 class="text-center" style= "margin-top: 1%;" >DELIVERY ADDRESS <i class=" fa11 fa fa-address-book"></i></h1>
<div class="container" style="margin-top: 2%; min-height: 500px">
	<c:if test="${empty (addresslist) }">
		<div class="jumbotron">Please Add Address To Continue</div>

	</c:if>
	<c:if test="${not empty (addresslist) }">
	<c:if test="${info}">
	<div class="alert" role="alert">
		<h3>${message}</h3>
	</div>
</c:if>
		<div class="row">
		
			<c:forEach items="${addresslist}" var="p">
				<div class="col-3">
					<div class="card">
							<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS6W1s270PpJC2R5jtKGJuAcK1uEBpxQfpEisBDLVhucHu8y86e&usqp=CAU" class="card-img-top" />
						<div class="card-body">
							<div class="col-12">
								<h3 class="card-title" data-toggle="tooltip" title="${p.name}">${p.name} <i class=" fa11 fa fa-user-circle-o"></i> </h3>

							</div>
							
							<div class="col-12">
								<p class="card-text">
									<span class="mytext text-uppercase"> ${p.line1}</span>
								</p>
							</div>
							<div class="col-12">
								<p class="card-text">
									<span class="mytext text-uppercase"> ${p.line2}</span>
								</p>
							</div>

							<div class="col-12">
								<p class="card-text">
									<span class="mytext text-uppercase"> ${p.area}</span>
								</p>
							</div>

							<div class="col-12">
								<p class="card-text">
									<span class="mytext"> ${p.pincode}</span>
								</p>
							</div>

							<div class="row" style="margin-top: 2%">
								<div class="col-6">
									<a href="${cr2 }/user/editaddress?addressid=${p.address_Id}"
										class="btn btn-success"><i class="fa fa-edit"></i>Edit</a>
								</div>
								<div class="col-6">
									<a href="${cr2 }/user/deleteaddress?addressid=${p.address_Id}"
										class="btn btn-warning"><i class="fa fa-trash"></i>Delete</a>
								</div>
							</div>
							<div class="row" style="margin-top: 2%">

								<a href="${cr2}/user/placeorder?addressid=${p.address_Id}" class="btn btn-info" style="width: 100%"> <i
									class="fa fa-truck"></i>Ship Here
								</a>

							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>

	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal" style="margin-top: 5%; width: 100%">Add
		New Address</button>

</div>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Address</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="container">

					<form action="addaddress" method="get">
						<div class="form-group">
							<label>Customer Name</label> <input type="text"
								class="form-group" name="name" id="name" required="required" />
						</div>

						<div class="form-group">
							<label>Address line 1</label> <input type="text"
								class="form-group" name="line1" id="line1" required="required" />
						</div>

						<div class="form-group">
							<label>Address Line2</label> <input type="text"
								class="form-group" name="line2" id="line2" required="required" />
						</div>

						<div class="form-group">
							<label>Area</label> <input type="text" class="form-group"
								name="area" id="area" required="required" />
						</div>


						<div class="form-group">
							<label>Pincode</label> <input type="text" class="form-group"
								name="pincode" id="pincode" required="required" />


						</div>

						<div class="form-group">

							<button type="submit" class="btn btn-primary"
								style="width: 100%; background-color: rgb(88, 17, 67)">Submit</button>
						</div>

					</form>

				</div>
			</div>

			<div class="modal-footer">

				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<c:if test="${edit }">
	<div class="container">

		<form action="updateaddress" method="post">
			<div class="form-group">
				<input type="hidden" class="form-group" name="addressid"
					id="addressid" required="required"
					value= "${addressobject.address_Id}"/>
			</div>

			<div class="form-group">
				<label>Customer Name</label> <input type="text" class="form-group"
					name="name" id="name" required="required"
					value="${addressobject.name}" />
			</div>

			<div class="form-group">
				<label>Address line 1</label> <input type="text" class="form-group"
					name="line1" id="line1" required="required"
					value="${addressobject.line1}"/>
			</div>

			<div class="form-group">
				<label>Address Line2</label> <input type="text" class="form-group"
					name="line2" id="line2" required="required"
					value="${addressobject.line2}"/>
			</div>

			<div class="form-group">
				<label>Area</label> <input type="text" class="form-group"
					name="area" id="area" required="required"
					value="${addressobject.area}"/>


			</div>
			<div class="form-group">
				<label>Pincode</label> <input type="text" class="form-group"
					name="pincode" id="pincode" required="required"
					value="${addressobject.pincode}"/>


			</div>

			<div class="form-group">

				<button type="submit" class="btn btn-primary"
					style="width: 100%; background-color: rgb(88, 17, 67)">Submit</button>
			</div>
		</form>
	</div>

</c:if>