<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<title>Register</title>
</head>
<body>


	<%-- Display warning message --%>
	<% String warningMessage = (String) request.getAttribute("warningMessage"); %>
	<% if (warningMessage != null) { %>
	<div class="alert alert-warning">
		<%= warningMessage %>
	</div>
	<% } %>

	<section class="vh-100 gradient-custom">


		<div class="container py-5 h-100">

			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">

						<div class="card-body p-5 text-center">

							<div class="mb-md-5 mt-md-4 pb-5">

								<h2 class="fw-bold mb-2 text-uppercase">Sign Up</h2>
								<p class="text-white-50 mb-5">Please enter your information!</p>

								<form action="../register" method="POST">



									<div class="row">
										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<input type="text" id="first_name" class="form-control"
													name="firstName" placeholder="Enter first name" required />
												<label class="form-label" for="first_name">First
													name</label>
											</div>
										</div>

										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<input type="text" id="last_name" class="form-control"
													name="lastName" placeholder="Enter last name" required /> <label
													class="form-label" for="last_name">Last name</label>
											</div>
										</div>

									</div>

									<div class="form-outline form-white mb-4">
										<input type="tel" class="form-control" id="phone" name="phone"
											placeholder="Enter your phone number" pattern="[0-9]+"
											oninput="validatePhoneNumber(this)" required> <label
											class="form-label" for="phone"> Phone Number </label> <small
											id="phoneError" class="text-danger"></small>
									</div>

									<script>
			  function validatePhoneNumber(input) {
			    const phoneError = document.getElementById('phoneError');
			    if (input.validity.patternMismatch) {
			      input.setCustomValidity('Please enter a valid phone number.');
			      phoneError.textContent = 'Please enter a valid phone number.';
			    } else {
			      input.setCustomValidity('');
			      phoneError.textContent = '';
			    }
			  }
			</script>



									<div class="row">
										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<input type="text" id="user_name" class="form-control"
													name="username" placeholder="Enter username" required /> <label
													class="form-label" for="user_name">Account Username</label>
											</div>
										</div>

										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<input type="password" id="acc_password"
													class="form-control" name="password"
													placeholder="Enter password" required /> <label
													class="form-label" for="acc_password">Account
													Password</label>
											</div>
										</div>
									</div>


									<button class="btn btn-outline-light btn-lg px-5" type="submit">Sign
										up</button>


								</form>

								<br>
								<br>
								<div>
									<p class="mb-0">
										Already have account? <a href="login_page.jsp"
											class="text-white-50 fw-bold"> Login </a>
									</p>
								</div>

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


</body>
</html>