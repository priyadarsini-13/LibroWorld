<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.jumbotron {
	margin-top:1%;
	border: 2px solid rgb(88, 17, 67);
	background-color: rgba(206, 193, 201, 0.5);
	margin-bottom:1%;
	margin-left:35%;

	width: 30%;
	height: 75%;
}

.form-label-group {
	display: flex;
	
	margin-top: 7%;
}

.icon1 {
	padding: 9px;
	background: rgb(255, 253, 253);
	color: rgb(19, 3, 15);
	min-width: 50px;
	border: 1px solid rgb(19, 1, 13);
	text-align: center;
}

body {
	background-image: url(img/bge2.jpg);
}

div {
	color: rgb(10, 9, 9);
}

.btn2 {
	background-color:rgb(88, 17, 67);
}

img {
	margin-top: 2%;
	margin-left: 4%;
}

input[type=text] {
	border: 1px solid rgb(88, 17, 67);
	border-radius: 0%;
	
}
input[type=password]{
	border: 1px solid rgb(88, 17, 67);
	border-radius: 0%;
	
}

hr.new1 {
	border-top: 2px solid rgb(88, 17, 67);
}

.ul1 {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	align-items: center;
	color: rgb(12, 1, 9);
}

.li1 {
	padding-left: 5%;
	font-size: xx-large;
	list-style-type: none;
}

.fa1 {
	color: rgb(88, 17, 67);
}

.pencil {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	align-items: center;
}
}
</style>
<body>
<c:if test="${info}">
				<div class ="alert" role="alert">
				<h3>${message}</h3>
				</div>
				</c:if>

	<div class="jumbotron">
		<div class="col-12">
			<h2 class="text-center">
				Sign in<i class="fa fa-pencil fa-lg" id="pencil"></i>
			</h2>
			<div>
			
				<form action="perform_login" method="post">

					<div class="form-label-group">
						<label for="user_name"></label> <i class="fa fa-user icon1"></i> <input
							type="text" id="user_name"  name="user_name" class="form-control"
							placeholder="Name" required autofocus>

					</div>

					<div class="form-label-group">
						<label for="user_password"></label> <i class="fa fa-key icon1"></i>
						<input type="password" id="user_password" name="user_password" class="form-control"
							placeholder="Password" required autofocus>

					</div>

					<div class="custom-control custom-checkbox mb-3">
						<input type="text" class="custom-control-input" id="customCheck1">
						<label class="custom-control-label" for="customCheck1">Remember
							password</label>
					</div>
					<button
						class="btn2 btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
						type="submit">Sign in</button>
					<div class="text-center">
						<a class="small" style="color: black" href="#">Forgot
							password?</a>
					</div>
					<hr class="new1">
					<p style="text-align: center">LOGIN HERE|NEW OFFERS AVAILABLE!</p>
					<p style="text-align: center">Lower levels of Stress and
						Tension Relief</p>

					<div class="footer-social-icons">
						<ul class="ul1">
						
							<li class="li1"><a href="#" target="blank"><i
									class="fa1 fa fa-google" aria-hidden="true"></i></a></li>
							<li class="li1"><a href="#" target="blank"><i
									class="fa1  fa fa-facebook" aria-hidden="true"></i></a></li>
							<li class="li1"><a href="#" target="blank"><i
									class="fa1 fa fa-twitter" aria-hidden="true"></i></a></li>
							<li class="li1"><a href="#" target="blank"><i
									class="fa1 fa  fa-instagram" aria-hidden="true"></i></a></li>
						</ul>
					</div>
				</form>
			</div>

		</div>
	</div>