<#import "layout.ftl" as layout>
<@layout.myLayout>
	<div class="container">
			<div class="row">
				<div >
					<div class="panel panel-login">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-6">
									<a href="#" class="active" id="login-form-link">Login</a>
								</div>
								<div class="col-xs-6">
									<a href="#" id="register-form-link">Register</a>
								</div>
							</div>
							<hr>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form id="login-form" action="/doLogin" method="post" role="form" style="display: block;">
										<div class="form-group">
											<input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="">
										</div>
										<div class="form-group">
											<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
										</div>
										<#--  <div class="form-group text-center">
											<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
											<label for="remember"> Remember Me</label>
										</div>  -->
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-lg-12">
													<div class="text-center">
														<div id="recover-link" tabindex="5" class="forgot-password">Forgot Password?</div>
													</div>
												</div>
											</div>
										</div>
									</form>
									<form id="recover-form" action="/recover" method="post" role="form" style="display: none;">
										<div class="form-group">
											<input type="email" name="email" id="recoverEmail" tabindex="1" class="form-control" placeholder="Email Address" value="">
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="recover-submit" id="recover-submit" tabindex="4" class="form-control btn btn-login" value="Reset Password">
												</div>
											</div>
										</div>
									</form>
									<form id="register-form" action="/doRegister" method="post" role="form" style="display: none;">
										<div class="form-group">
											<input type="text" name="userName" tabindex="1" class="form-control" placeholder="Username" value="">
										</div>
										<div class="form-group">
											<input type="email" name="email"  tabindex="2" class="form-control" placeholder="Email Address" value="">
										</div>
										<div class="form-group">
											<input type="password" name="password" tabindex="3" class="form-control" placeholder="Password">
										</div>
										<div class="form-group">
											<input type="password" name="confirmPassword"  tabindex="4" class="form-control" placeholder="Confirm Password">
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="register-submit" id="register-submit" tabindex="5" class="form-control btn btn-register" value="Register Now">
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</@layout.myLayout>