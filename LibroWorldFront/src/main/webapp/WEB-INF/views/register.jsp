<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
body {
	background-image: url(img/bge2.jpg);
	
}

.jumbotron{
	margin-top:2%;
	border: 2px solid rgb(88, 17, 67);
	background-color: rgba(206, 193, 201, 0.5);
	margin-left: 35%;
	width: 30%;
	height: 80%;
}

div {
	color: black;
}

.btn3 {
	background-color:rgb(88, 17, 67);
	margin-top:6%;
	}

input[type=text] {
	border: 0.5px solid rgb(88, 17, 67);
	border-radius: 0%;
	
}

.form-label-group {
	display: flex;
	margin-top: 10%;
}

.icon9 {
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


</style>
<body>

<c:if test="${info}">
				<div class ="alert" role="alert">
				<h3>${message}</h3>
				</div>
			</c:if>
	<div class="jumbotron">


		<div class="col-12" >

			<h3 class="text-center">
				Sign up now<i class="fa fa-user-circle  fa-lg" id=" user"></i>
			</h3>
			<CENTER>

				<h6>Stay connected!</h6>

			</CENTER>
			<div>
				<form:form action="addcustomer" method="post"
					modelAttribute="customerobject">
					
					<div class="form-label-group">
						<i class="fa fa-user icon9"></i> <label for="inputName"></label> 
						<form:input type="text" id="inputName" class="form-control"
							placeholder="Name" path="cust_Name"/>
							<form:errors path="cust_Name" cssStyle="color:Red"></form:errors>
					</div>
					<div class="form-label-group">
						<i class="fa fa-envelope icon9"></i> <label for="inputEmail"></label>
						<form:input type="text" id="inputEmail" class="form-control"
							placeholder="Email Address" path="cust_Email"/>
							<form:errors path="cust_Email" cssStyle="color:Red"></form:errors>
					</div>
					<div class="form-label-group">
						<i class="fa fa-phone-square icon9"></i> <label for="inputPhno"></label>
						<form:input type="text" id="inputPhno" class="form-control"
							placeholder="Phone Number" path="cust_Phno"/>
							<form:errors path="cust_Phno" cssStyle="color:Red"></form:errors>
					</div>
					<div class="form-label-group">
						<i class="fa fa-key icon9"></i> <label for="inputPassword"></label> 
						<form:input type="text" id="inputPassword" class="form-control"
							placeholder="Password" path="cust_Password"/>
							<form:errors path="cust_Password" cssStyle="color:Red"></form:errors>
					</div>   
					

                     
					<div class="text-center">
						<button class="btn3 btn  btn-primary  text-uppercase " type="submit">Sign
							up</button>
					</div>
					
					</form:form>
					
					<div class="id" style="text-align: right">
						<center>
							<a style="color: black" href="login"> Have already
								an account? Login here! </a>
						</center>
					</div>
			</div>
		</div>
	</div>