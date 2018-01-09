<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>




<div class="contactPage container">

	<div class="row">

		<div class="contact-form col-sm-6 col-sm-offset-3">

			<h1 id="contact-form-title">Contact us</h1>
			<form id="contact-form-fields" method="post" action="contact.php"
				role="form">

				<div class="messages"></div>

				<div class="controls">

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="form_name">Firstname *</label> <input id="form_name"
									type="text" name="name" class="form-control"
									placeholder="Please enter your firstname *" required="required"
									data-error="Firstname is required.">
								<div class="help-block with-errors"></div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="form_lastname">Lastname *</label> <input
									id="form_lastname" type="text" name="surname"
									class="form-control" placeholder="Please enter your lastname *"
									required="required" data-error="Lastname is required.">
								<div class="help-block with-errors"></div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group">
								<label for="form_email">Email *</label> <input id="form_email"
									type="email" name="email" class="form-control"
									placeholder="Please enter your email *" required="required"
									data-error="Valid email is required.">
								<div class="help-block with-errors"></div>
							</div>
						</div>
						
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group">
								<label for="form_message">Message *</label>
								<textarea id="form_message" name="message" class="form-control"
									placeholder="Message for me *" rows="4" required="required"
									data-error="Please,leave us a message."></textarea>
								<div class="help-block with-errors"></div>
							</div>
						</div>
						<div class="col-sm-12">
							<input type="submit" class="btn btn-send"
								value="Send message">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-12">
							<p class="text-muted">
								<strong>*</strong> These fields are required. 
							</p>
						</div>
					</div>
				</div>

			</form>


		</div>

	</div>

</div>