<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
body {
	background-image: url(img/bge2.jpg);
	font-family: Arial, Helvetica, sans-serif;
}

.container {
	margin-top: 5%;
	border: 2px solid rgb(88, 17, 67);
	background-color: rgba(206, 193, 201, 0.5);
	margin-bottom: 5%;
	width: 30%;
	height: 95%;
}

div {
	color: black;
}

.btn {
	background-color: rgb(170, 27, 170);
}

input[type=text] {
	border: 0.5px solid rgb(88, 17, 67);
	border-radius: 0%;
}

.form-label-group {
	display: flex;
	margin-top: 10%;
}

.icon {
	padding: 10px;
	background: rgb(255, 253, 253);
	color: rgb(19, 3, 15);
	min-width: 50px;
	border: 0.5px solid rgb(88, 17, 67);
	text-align: center;
}

.form-control:focus {
	border: 2px solid dodgerblue;
}

.user {
	padding: 0;
}
</style>
<body>

<c:if test="${info}">
				<div class ="alert" role="alert">
				<h3>${message}</h3>
				</div>
			</c:if>
	<div class="container">


		<div class="col-12" style="margin-top: 0.5%">

			<h4 class="text-center">
				Sign up now<i class="fa fa-user-circle  fa-lg" id=" user"></i>
			</h4>
			<CENTER>

				<p>Stay connected!</p>

			</CENTER>
			<div>
				<form:form action="addcustomer" method="post"
					modelAttribute="customerobject">
					<div class="form-label-group">
						<i class="fa fa-user icon"></i> <label for="inputName"></label> 
						<form:input type="text" id="inputName" class="form-control"
							placeholder="Name" path="cust_Name"/>
					</div>
					<div class="form-label-group">
						<i class="fa fa-envelope icon"></i> <label for="inputEmail"></label>
						<form:input type="text" id="inputEmail" class="form-control"
							placeholder="Email Address" path="cust_Email"/>
					</div>
					<div class="form-label-group">
						<i class="fa fa-phone-square icon"></i> <label for="inputPhno"></label>
						<form:input type="text" id="inputPhno" class="form-control"
							placeholder="Phone Number" path="cust_Phno"/>
					</div>
					<div class="form-label-group">
						<i class="fa fa-key icon"></i> <label for="inputPassword"></label> 
						<form:input type="text" id="inputPassword" class="form-control"
							placeholder="Password" path="cust_Password"/>
					</div>   
					<div class="form-label-group">
						<i class="fa fa-lock icon"></i> <label for="inputConfPassword"></label> 
						<input
							type="text" id="inputConfPassword" class="form-control"
							placeholder="Confirm Password" required autofocus >
					</div>

                     
					<div class="text-center">
						<button class="btn  btn-primary  text-uppercase " type="submit">Sign
							up</button>
					</div>
					
					</form:form>
					
					<div class="id" style="text-align: right">
						<center>
							<a class="small " style="color: black" href="#"> Have already
								an account? Login here! </a>
						</center>
					</div>
			</div>
		</div>
	</div>