<!DOCTYPE html>
<!-- saved from url=(0048)http://localhost:8080/spring-mvc-final/showLogin -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Simple Login Form</title>
<link rel="stylesheet" href="./resources/login_files/bootstrap.min.css">
<script src="./resources/login_files/jquery.min.js.download"></script>
<script src="./resources/login_files/bootstrap.min.js.download"></script> 
<style type="text/css">
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>
</head>
<body data-gr-c-s-loaded="true">


	<div class="login-form">
		<h3>${error}</h3>
		<form method="POST" action="${pageContext.request.contextPath}/auth/login">
			<h2 class="text-center">Log in</h2>
			<div class="form-group">
				<input type="text" name="username" class="form-control" value="" placeholder="Username" required="required">
			</div>
			<div class="form-group">
				<input type="password" name="password" class="form-control" placeholder="Password" required="required">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">Log
					in</button>
			</div>
		</form>
	</div>

                                		                            </body></html>