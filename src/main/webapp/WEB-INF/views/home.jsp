<!DOCTYPE html>
<html lang="en">
<head>
	<title>Web and Graphics Home</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootsrap CSS Library -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<!-- Google Font Library -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:400,700,800,900" rel="stylesheet">

	<!-- FontAwesome Library -->
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

	<!-- Animatation Library -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">

	<!-- Custom Style Sheet -->
	<link rel="stylesheet" href="/static/css/style.css">

</head>
<body>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">WebSiteName</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="javascript:void(0)" id="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="javascript:void(0)" id="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</div>
</nav>
<div id="myModal" class="modal">

	<div class="modal-content">
		<div class="modal-header">
			<span class="close">&times;</span>
			<h2>LOGIN</h2>
		</div>
		<div class="modal-body">

			<form action="/home" method="post">
				<input type="text" name="username" placeholder="Enter Name" class="form-control" required>
				<input type="password" name="password" placeholder="Enter password" class="form-control" required>
				<input type="submit" value="Login" class="btn btn-primary">
			</form>
		</div>
		<div class="modal-footer">
			<h4>SignUp!</h4>
		</div>
	</div>
</div>

<div id="myModalSignup" class="modal">

	<div class="modal-content">
		<div class="modal-header">
			<span class="close1">&times;</span>
			<h2>Signup</h2>
		</div>
		<div class="modal-body">
			<form action="index.html" method="get">
				<input type="text" name="name" placeholder="Enter Name" class="form-control" required>
				<input type="email" name="email" placeholder="Enter Mail" class="form-control" required>
				<input type="password" name="password" placeholder="Enter password" class="form-control" required>
				<input type="password" name="cpassword" placeholder="Confirm password" class="form-control" required>
				<input type="submit" value="submit" class="btn btn-primary">
			</form>
		</div>
		<div class="modal-footer">
			<h4>Login!</h4>
		</div>
	</div>
</div>





<!-- Jquery Library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Bootstrap Js Library -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="js/custom.js"></script>

<script>
    var modal = document.getElementById('myModal');
    var modalsignup = document.getElementById('myModalSignup');

    var btn = document.getElementById("login");
    var btnsignup = document.getElementById("signup");

    var span = document.getElementsByClassName("close")[0];
    var spansignup = document.getElementsByClassName("close1")[0];

    btn.onclick = function() {
        modal.style.display = "block";
    }

    span.onclick = function() {
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    btnsignup.onclick = function() {
        modalsignup.style.display = "block";
    }

    spansignup.onclick = function() {
        modalsignup.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == modalsignup) {
            modalsignup.style.display = "none";
        }
    }



</script>
</body>
</html>