<!doctype html>
<%@page import="com.model.EducationPojo"%>
<%@page import="com.model.ExperiencePojo"%>
<%@page import="com.dao.ExperienceDaoImpl"%>
<%@page import="com.dao.EducationDaoImpl"%>
<%@page import="com.model.UploadProjectPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.UploadprojectDaoImpl"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Marvel HTML Bootstrap 4 Template</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/unicons.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<!-- MAIN STYLE -->
<link rel="stylesheet" href="css/tooplate-style.css">

<!--

Tooplate 2115 Marvel

https://www.tooplate.com/view/2115-marvel

-->
</head>
<body>


	<!-- MENU -->
	<nav class="navbar navbar-expand-sm navbar-light">
		<div class="container">
			<a class="navbar-brand" href="index.html"><i class='uil uil-user'></i>
				Naim</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span> <span
					class="navbar-toggler-icon"></span> <span
					class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav mx-auto">
					<li class="nav-item"><a href="#about" class="nav-link"><span
							data-hover="About">About</span></a></li>
					<li class="nav-item"><a href="#project" class="nav-link"><span
							data-hover="Projects">Projects</span></a></li>
					<li class="nav-item"><a href="#resume" class="nav-link"><span
							data-hover="Resume">Resume</span></a></li>
					<li class="nav-item"><a href="#contact" class="nav-link"><span
							data-hover="Contact">Contact</span></a></li>
				</ul>

				<ul class="navbar-nav ml-lg-auto">
					<div class="ml-lg-4">
						<div
							class="color-mode d-lg-flex justify-content-center align-items-center">
							<i class="color-mode-icon"></i> Color mode
						</div>
					</div>
				</ul>
			</div>
		</div>
	</nav>
	
	
	
	
	<%@include file="messageprint.jsp" %>

	<!-- ABOUT -->
	<section
		class="about full-screen d-lg-flex justify-content-center align-items-center"
		id="about">
		<div class="container">
			<div class="row">

				<div class="col-lg-7 col-md-12 col-12 d-flex align-items-center">
					<div class="about-text">
						<small class="small-text">Welcome to <span
							class="mobile-block">my portfolio website!</span></small>
						<h1 class="animated animated-text">
							<span class="mr-2">MY NAME ,IS</span>
							<div class="animated-info">
								<span class="animated-item">Md Naimullah</span> <span
									class="animated-item">Md Naimullah</span> <span
									class="animated-item">Md Naimullah</span>
							</div>
						</h1>

						<p> I am a responsible, goal-oriented and hardworking person with keen interest 
						    in learning, seeking for anopportunity to work in a challenging environment.</p>

						<div class="custom-btn-group mt-4">
							<a href="DownloadResume" class="btn mr-lg-2 custom-btn"><i
								class='uil uil-file-alt'></i> Download Resume</a> <a href="#contact"
								class="btn custom-btn custom-btn-bg custom-btn-link">Get a
								free quote</a>
						</div>
					</div>
				</div>

				<div class="col-lg-5 col-md-12 col-12">
					<div class="about-image svg">
						<img src="images/undraw/undraw_software_engineer_lvl5.svg"
							class="img-fluid" alt="svg image">
					</div>
				</div>

			</div>
		</div>
	</section>

	<!-- PROJECTS -->
	<section class="project py-5" id="project">
		<div class="container">

			<div class="row">
				<div class="col-lg-11 text-center mx-auto col-12">

					<div class="col-lg-8 mx-auto">
				     <h2>WELCOME TO MY PROJECTS </h2>
					</div>
					<div class="owl-carousel owl-theme">
					
					<%
					UploadprojectDaoImpl uploadprojectDaoImpl=new UploadprojectDaoImpl();
								ArrayList<UploadProjectPojo> al= uploadprojectDaoImpl.readProject();
								for(UploadProjectPojo pojo : al)
								{
					%>
						<div class="item">
							<div class="project-info">
								<img src="myproject/<%=pojo.getForfilename() %>" class="img-fluid"
									alt="project image">
							</div>
						</div>
						
						<%} %>

					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- FEATURES -->
	<section
		class="resume py-5 d-lg-flex justify-content-center align-items-center"
		id="resume">
		<div class="container">
			<div class="row">

				<div class="col-lg-6 col-12">
					<h2 class="mb-4">Experiences</h2>

					<div class="timeline">
						

						
							<%
							
						ArrayList<ExperiencePojo> al3= new ExperienceDaoImpl().readExperience();
							
							for(ExperiencePojo ep: al3)
							{
							%>


						<div class="timeline-wrapper">
							<div class="timeline-yr">
								<span><%=ep.getYear() %></span>
							</div>
							<div class="timeline-info">
								<h3>
									<span><%=ep.getTitle() %></span><small><%=ep.getSubtitle() %></small>
								</h3>
								<p><%=ep.getDiscription() %></p>
							</div>
						</div>
						
						<%} %>

						

						</div>

					</div>

				<div class="col-lg-6 col-12">
					<h2 class="mb-4 mobile-mt-2">Educations</h2>

					<div class="timeline">
					
						
							<%
							
						ArrayList<EducationPojo> al2= new EducationDaoImpl().readEducationS();
							
							for(EducationPojo ep: al2)
							{
							%>


						<div class="timeline-wrapper">
							<div class="timeline-yr">
								<span><%=ep.getYear() %></span>
							</div>
							<div class="timeline-info">
								<h3>
									<span><%=ep.getTitle() %></span><small><%=ep.getSubtitle() %></small>
								</h3>
								<p><%=ep.getDiscription() %></p>
							</div>
						</div>
						
						<%} %>

					</div>
				</div>

			</div>
		</div>
	</section>

	<!-- CONTACT -->
	<section class="contact py-5" id="contact">
		<div class="container">
			<div class="row">

				<div class="col-lg-5 mr-lg-5 col-12">
					<div class="google-map w-100">
					
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3556.270856512166!2d80.99540157522603!3d26.95832067662001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x399bff2addd9b239%3A0xc21a9bbd557936ec!2sIntegral%20University!5e0!3m2!1sen!2sin!4v1720046446610!5m2!1sen!2sin"
							width="400" height="300" frameborder="0" style="border: 0"
							allowfullscreen></iframe>
					</div>

					<div
						class="contact-info d-flex justify-content-between align-items-center py-4 px-lg-5">
						<div class="contact-info-item">
							<h3 class="mb-3 text-white">Say hello</h3>
							<p class="footer-text mb-0">010 020 0960</p>
							<p>
								<a href="mailto:hello@company.co">hello@company.co</a>
							</p>
						</div>

						<ul class="social-links">
							<li><a href="#" class="uil uil-dribbble"
								data-toggle="tooltip" data-placement="left" title="Dribbble"></a></li>
							<li><a href="#" class="uil uil-instagram"
								data-toggle="tooltip" data-placement="left" title="Instagram"></a></li>
							<li><a href="#" class="uil uil-youtube"
								data-toggle="tooltip" data-placement="left" title="Youtube"></a></li>
						</ul>
					</div>
				</div>

				<div class="col-lg-6 col-12">
					<div class="contact-form">
						<h2 class="mb-4">Interested to work together? Let's talk</h2>

						<form action="ContactServlet1" method="post">
							<div class="row">
								<div class="col-lg-6 col-12">
									<input type="text" class="form-control" name="name"
										placeholder="Your Name" id="name">
								</div>

								<div class="col-lg-6 col-12">
									<input type="email" class="form-control" name="email"
										placeholder="Email" id="email">
								</div>

								<div class="col-12">
									<textarea name="message" rows="6" class="form-control"
										id="message" placeholder="Message"></textarea>
								</div>

								<div class="ml-lg-auto col-lg-5 col-12">
									<input type="submit" class="form-control submit-btn"
										value="Send Button">
								</div>
							</div>
						</form>



					</div>
				</div>

			</div>
		</div>
	</section>

	<!-- FOOTER -->
	<footer class="footer py-5">
		<div class="container">
			<div class="row">

				<div class="col-lg-12 col-12">
					<p class="copyright-text text-center">Copyright &copy; 2019
						Company Name . All rights reserved</p>
					<p class="copyright-text text-center">
						Designed by <a rel="nofollow"
							href="https://www.facebook.com/tooplate">Tooplate</a>
					</p>
				</div>

			</div>
		</div>
	</footer>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/Headroom.js"></script>
	<script src="js/jQuery.headroom.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/smoothscroll.js"></script>
	<script src="js/custom.js"></script>

</body>
</html>