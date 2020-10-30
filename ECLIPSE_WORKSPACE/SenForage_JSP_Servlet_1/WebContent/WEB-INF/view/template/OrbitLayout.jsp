<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page import="services.UrlHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- /* === 🌌 WELCOME TO ORBIT WP REMIX 🌌  === -->
<!-- *                      -->
<!-- *	  By : -->
<!-- * -->
<!-- *     ██████╗ ██████╗ ██████╗ ██╗████████╗    ████████╗██╗   ██╗██████╗ ███╗   ██╗███████╗██████╗  -->
<!-- *    ██╔═══██╗██╔══██╗██╔══██╗██║╚══██╔══╝    ╚══██╔══╝██║   ██║██╔══██╗████╗  ██║██╔════╝██╔══██╗ -->
<!-- *    ██║   ██║██████╔╝██████╔╝██║   ██║          ██║   ██║   ██║██████╔╝██╔██╗ ██║█████╗  ██████╔╝ -->
<!-- *    ██║   ██║██╔══██╗██╔══██╗██║   ██║          ██║   ██║   ██║██╔══██╗██║╚██╗██║██╔══╝  ██╔══██╗ -->
<!-- *    ╚██████╔╝██║  ██║██████╔╝██║   ██║          ██║   ╚██████╔╝██║  ██║██║ ╚████║███████╗██║  ██║ -->
<!-- *     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝          ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝ -->
<!-- *           -->
<!-- *  AUTHOR : MOHAMED GUEYE [Orbit Turner] - Linkedin: www.linkedin.com/in/orbitturner - Email: orbitturner@orbitturner.com - Country: Senegal -->
<!-- *                              GITHUB : Orbit Turner    -   Website: http://orbitturner.com/  -->
<!-- */ -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href=<c:out value="${UrlHelper.getImgRepos()}favicon.ico"/> />

    <title><c:out value="${pageTitle}" default="SEN FORAGE - Dashboard"/> •&nbsp;</title>
    
	<!-- Vendors Style-->
	<link rel="stylesheet" href="${UrlHelper.getCssRepos()}vendors_css.css">
	  
	<!-- Style-->  
	<link type="text/css" rel="stylesheet" href="${UrlHelper.getCssRepos()}style.css">
	<link type="text/css" rel="stylesheet" href="${UrlHelper.getCssRepos()}skin_color.css">
     
  </head>

<body class="hold-transition dark-skin sidebar-mini theme-primary fixed" onload="titleMarquee()">
<%-- 	<c:out value="${baseUrl }public/css/bootstrap.css"/> --%>
<div class="wrapper">

  <header class="main-header">
    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top pl-30">
      <!-- Sidebar toggle button-->
	  <div>
		  <ul class="nav">
			<li class="btn-group nav-item">
				<a href="#" class="waves-effect waves-light nav-link rounded svg-bt-icon" data-toggle="push-menu" role="button">
					<i class="nav-link-icon mdi mdi-menu"></i>
			    </a>
			</li>
			<li class="btn-group nav-item">
				<a href="#" data-provide="fullscreen" class="waves-effect waves-light nav-link rounded svg-bt-icon" title="Full Screen">
					<i class="nav-link-icon mdi mdi-crop-free"></i>
			    </a>
			</li>			
			<li class="btn-group nav-item d-none d-xl-inline-block">
				<a href="#" class="waves-effect waves-light nav-link rounded svg-bt-icon" title="">
					<i class="ti-check-box"></i>
			    </a>
			</li>
			<li class="btn-group nav-item d-none d-xl-inline-block">
				<a href="calendar.html" class="waves-effect waves-light nav-link rounded svg-bt-icon" title="">
					<i class="ti-calendar"></i>
			    </a>
			</li>
		  </ul>
	  </div>
		
      <div class="navbar-custom-menu r-side">
        <ul class="nav navbar-nav">
        	<li class="btn-group nav-item welcome-message">
        		<a class="nav-link">Welcome : ${sessionScope.actualUser.username} 👋🏿</a>
        	</li>
		  <!-- Search-Bar -->
	      <li class="search-bar">		  
			  <div class="lookup lookup-circle lookup-right">
			     <input type="text" name="s">
			  </div>
		  </li>			
		  <!-- Notifications -->
		  <li class="dropdown notifications-menu">
			<a href="#" class="waves-effect waves-light rounded dropdown-toggle" data-toggle="dropdown" title="Notifications">
			  <i class="ti-bell"></i>
			</a>
			<ul class="dropdown-menu animated bounceIn">

			  <li class="header">
				<div class="p-20">
					<div class="flexbox">
						<div>
							<h4 class="mb-0 mt-0">Notifications</h4>
						</div>
						<div>
							<a href="#" class="text-danger">Clear All</a>
						</div>
					</div>
				</div>
			  </li>

			  <li>
				<!-- inner menu: contains the actual data -->
				<ul class="menu sm-scrol">
				  <li>
					<a href="#">
					  <i class="fa fa-users text-info"></i> Curabitur id eros quis nunc suscipit blandit.
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-warning text-warning"></i> Duis malesuada justo eu sapien elementum, in semper diam posuere.
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-users text-danger"></i> Donec at nisi sit amet tortor commodo porttitor pretium a erat.
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-shopping-cart text-success"></i> In gravida mauris et nisi
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-user text-danger"></i> Praesent eu lacus in libero dictum fermentum.
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-user text-primary"></i> Nunc fringilla lorem 
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-user text-success"></i> Nullam euismod dolor ut quam interdum, at scelerisque ipsum imperdiet.
					</a>
				  </li>
				</ul>
			  </li>
			  <li class="footer">
				  <a href="#">View all</a>
			  </li>
			</ul>
		  </li>	
		  
	      <!-- User Account-->
          <li class="dropdown user user-menu">	
			<a href="#" class="waves-effect waves-light rounded dropdown-toggle p-0" data-toggle="dropdown" title="User">
				<img src="${UrlHelper.getImgRepos()}avatar/1.gif" alt="">
			</a>
			<ul class="dropdown-menu animated flipInX">
			  <li class="user-body">
			  	
			  	 <a class="dropdown-item text-white" href="#"><i class="ti-user mr-2"></i> <span>${sessionScope.actualUser.prenom} ${sessionScope.actualUser.nom} </span></a>
			 	 <span class="dropdown-item text-white">Connected as : ${sessionScope.actualUser.role.libelle}</span>
			 	 <div class="dropdown-divider"></div>
				 <a class="dropdown-item" href="<c:url value="/profile" />"><i class="ti-user text-muted mr-2"></i> Profile</a>
				 <a class="dropdown-item" href="mailto:orbitturner@orbitturner.com"><i class="ti-headphone-alt text-muted mr-2"></i> Contact The Admin</a>
				 <a class="dropdown-item" href="<c:url value="/settings" />"><i class="ti-settings text-muted mr-2"></i> Settings</a>
				 <div class="dropdown-divider"></div>
				 <a class="dropdown-item logout" href="<c:url value="/logout" />"><i class="ti-lock text-muted mr-2"></i> Logout</a>
			  </li>
			</ul>
          </li>	
		  <li>
              <a href="#" data-toggle="control-sidebar" title="Setting" class="waves-effect waves-light">
			  	<i class="ti-settings"></i>
			  </a>
          </li>
			
        </ul>
      </div>
    </nav>
  </header>
  
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar-->
    <section class="sidebar">	
		
        <div class="user-profile">
			<div class="ulogo">
				 <a href="<c:url value="/home" />">
				  <!-- logo for regular state and mobile devices -->
					 <div class="d-flex align-items-center justify-content-center">					 	
						  <img src="${UrlHelper.getImgRepos()}logo-dark.png" alt="">
						  <h3><b>Sen</b> Forage</h3>
					 </div>
				</a>
			</div>
        </div>
      
      <!-- ◾◾◾◾ sidebar menu ◾◾◾◾ -->
      <ul class="sidebar-menu" data-widget="tree">  
		<%-- ======= SIDEBAR DEPENDING ON USER ROLE ======= --%>
		<c:import url="/WEB-INF/view/template/${sessionScope.actualUser.role.libelle}.menu.jsp"></c:import>
		<%-- ======= FIN SIDEBAR DEPENDING ON USER ROLE ======= --%>
      </ul>
      <!-- ◾◾◾◾ end of sidebar menu ◾◾◾◾ -->
    </section>
	
	<div class="sidebar-footer">
		<!-- item-->
		<a href="<c:url value="/profile" />" class="link" data-toggle="tooltip" title="" data-original-title="Profile" aria-describedby="tooltip92529"><i class="ti-user"></i></a>
		<!-- item-->
		<a href="<c:url value="/calendar" />" class="link" data-toggle="tooltip" title="" data-original-title="Calendar"><i class="ti-calendar"></i></a>
		<!-- item-->
		<a href="<c:url value="/logout" />" class="link" data-toggle="tooltip" title="" data-original-title="Logout"><i class="ti-lock"></i></a>
	</div>
  </aside>

  <!-- ◾◾◾◾ Content Wrapper. Contains page content ◾◾◾◾ -->
  <div class="content-wrapper">
	  <div class="container-full">
		<%-- ======= CONTENU DE LA PAGE ======= --%>
		<%-- <c:out value="${view }"></c:out> --%>
		<c:import url="/WEB-INF/view/${view}.jsp"></c:import>
		<%-- ======= FIN CONTENU DE LA PAGE ======= --%>
      </div>
   </div>
  <!-- ◾◾◾◾ /.content-wrapper ◾◾◾◾ -->
  
  <!-- ◾◾◾◾ NOTIFICATION / ALERTS ◾◾◾◾ -->
  <div class="d-none">
		<h4>Alert Full top </h4>
		<button class="btn btn-success btn-outline btn-sm showtop btn-block mb-15" id="alertUserCreated">Alert Top Full width</button>
		<!-- Start an Alert -->
	</div>
		<div class="myadmin-alert myadmin-alert-icon myadmin-alert-click alert-success myadmin-alert-top alerttop"> <i class="ti-user"></i> User Successfully Created <a href="#" class="closed">&times;</a> </div>
  <!-- ◾◾◾◾ END OF NOTIFICATION / ALERTS ◾◾◾◾ -->
  
  <footer class="main-footer">
    <div class="pull-right d-none d-sm-inline-block">
        <ul class="nav nav-primary nav-dotted nav-dot-separated justify-content-center justify-content-md-end">
		  <li class="nav-item">
			<a class="nav-link" href="javascript:void(0)">Help</a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="https://orbitturner.com" target="_blank">Report a Bug</a>
		  </li>
		</ul>
    </div>
	  &copy; 2020 <a href="<c:url value="https://orbitturner.com" />">ORBIT TURNER | FUTURIZE</a>. All Rights Reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar">
	  
	<div class="rpanel-title"><span class="pull-right btn btn-circle btn-danger"><i class="ion ion-close text-white" data-toggle="control-sidebar"></i></span> </div>  <!-- Create the tabs -->
    <ul class="nav nav-tabs control-sidebar-tabs">
      <li class="nav-item"><a href="#control-sidebar-home-tab" data-toggle="tab" class="active">Chat</a></li>
      <li class="nav-item"><a href="#control-sidebar-settings-tab" data-toggle="tab">Todo</a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane active" id="control-sidebar-home-tab">
          <div class="flexbox">
			<a href="javascript:void(0)" class="text-grey"><i class="ti-minus"></i></a>	
			<p>Users</p>
			<a href="javascript:void(0)" class="text-right text-grey"><i class="ti-plus"></i></a>
		  </div>
		  <div class="lookup lookup-sm lookup-right d-none d-lg-block">
			<input type="text" name="s" placeholder="Search" class="w-p100">
		  </div>
          <div class="media-list media-list-hover mt-20">
			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-success" href="#">
				<img src="${UrlHelper.getImgRepos()}avatar/1.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Tyler</strong></a>
				</p>
				<p>Praesent tristique diam...</p>
				  <span>Just now</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-danger" href="#">
				<img src="${UrlHelper.getImgRepos()}avatar/2.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Luke</strong></a>
				</p>
				<p>Cras tempor diam ...</p>
				  <span>33 min ago</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-warning" href="#">
				<img src="${UrlHelper.getImgRepos()}avatar/3.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Evan</strong></a>
				</p>
				<p>In posuere tortor vel...</p>
				  <span>42 min ago</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-primary" href="#">
				<img src="${UrlHelper.getImgRepos()}avatar/4.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Evan</strong></a>
				</p>
				<p>In posuere tortor vel...</p>
				  <span>42 min ago</span>
			  </div>
			</div>			
			
			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-success" href="#">
				<img src="${UrlHelper.getImgRepos()}avatar/1.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Tyler</strong></a>
				</p>
				<p>Praesent tristique diam...</p>
				  <span>Just now</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-danger" href="#">
				<img src="${UrlHelper.getImgRepos()}avatar/2.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Luke</strong></a>
				</p>
				<p>Cras tempor diam ...</p>
				  <span>33 min ago</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-warning" href="#">
				<img src="${UrlHelper.getImgRepos()}avatar/3.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Evan</strong></a>
				</p>
				<p>In posuere tortor vel...</p>
				  <span>42 min ago</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-primary" href="#">
				<img src="${UrlHelper.getImgRepos()}avatar/4.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Evan</strong></a>
				</p>
				<p>In posuere tortor vel...</p>
				  <span>42 min ago</span>
			  </div>
			</div>
			  
		  </div>

      </div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
          <div class="flexbox">
			<a href="javascript:void(0)" class="text-grey"><i class="ti-minus"></i></a>	
			<p>Todo List</p>
			<a href="javascript:void(0)" class="text-right text-grey"><i class="ti-plus"></i></a>
		  </div>
        <ul class="todo-list mt-20">
			<li class="py-15 px-5 by-1">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_1" class="filled-in">
			  <label for="basic_checkbox_1" class="mb-0 h-15"></label>
			  <!-- todo text -->
			  <span class="text-line">Nulla vitae purus</span>
			  <!-- Emphasis label -->
			  <small class="badge bg-danger"><i class="fa fa-clock-o"></i> 2 mins</small>
			  <!-- General tools such as edit or delete-->
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_2" class="filled-in">
			  <label for="basic_checkbox_2" class="mb-0 h-15"></label>
			  <span class="text-line">Phasellus interdum</span>
			  <small class="badge bg-info"><i class="fa fa-clock-o"></i> 4 hours</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5 by-1">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_3" class="filled-in">
			  <label for="basic_checkbox_3" class="mb-0 h-15"></label>
			  <span class="text-line">Quisque sodales</span>
			  <small class="badge bg-warning"><i class="fa fa-clock-o"></i> 1 day</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_4" class="filled-in">
			  <label for="basic_checkbox_4" class="mb-0 h-15"></label>
			  <span class="text-line">Proin nec mi porta</span>
			  <small class="badge bg-success"><i class="fa fa-clock-o"></i> 3 days</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5 by-1">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_5" class="filled-in">
			  <label for="basic_checkbox_5" class="mb-0 h-15"></label>
			  <span class="text-line">Maecenas scelerisque</span>
			  <small class="badge bg-primary"><i class="fa fa-clock-o"></i> 1 week</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_6" class="filled-in">
			  <label for="basic_checkbox_6" class="mb-0 h-15"></label>
			  <span class="text-line">Vivamus nec orci</span>
			  <small class="badge bg-info"><i class="fa fa-clock-o"></i> 1 month</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5 by-1">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_7" class="filled-in">
			  <label for="basic_checkbox_7" class="mb-0 h-15"></label>
			  <!-- todo text -->
			  <span class="text-line">Nulla vitae purus</span>
			  <!-- Emphasis label -->
			  <small class="badge bg-danger"><i class="fa fa-clock-o"></i> 2 mins</small>
			  <!-- General tools such as edit or delete-->
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_8" class="filled-in">
			  <label for="basic_checkbox_8" class="mb-0 h-15"></label>
			  <span class="text-line">Phasellus interdum</span>
			  <small class="badge bg-info"><i class="fa fa-clock-o"></i> 4 hours</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5 by-1">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_9" class="filled-in">
			  <label for="basic_checkbox_9" class="mb-0 h-15"></label>
			  <span class="text-line">Quisque sodales</span>
			  <small class="badge bg-warning"><i class="fa fa-clock-o"></i> 1 day</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_10" class="filled-in">
			  <label for="basic_checkbox_10" class="mb-0 h-15"></label>
			  <span class="text-line">Proin nec mi porta</span>
			  <small class="badge bg-success"><i class="fa fa-clock-o"></i> 3 days</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
		  </ul>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  
  <!-- Add the sidebar's background. This div must be placed immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
  
</div>
<!-- ./wrapper -->
  	
	<!-- GLOBAL APP JS -->
	<script src="${UrlHelper.getJsRepos()}vendors.min.js"></script>
    <script src="${UrlHelper.getResourcesRepos()}assets/icons/feather-icons/feather.min.js"></script>	
    
	 <c:if test="${view == 'home'}">	 
		<!-- Hompage JS -->
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/easypiechart/dist/jquery.easypiechart.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/apexcharts-bundle/irregular-data-series.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/apexcharts-bundle/dist/apexcharts.js"></script>
		<script src="${UrlHelper.getJsRepos()}pages/dashboard.js"></script>
	 </c:if>
	 
	<c:if test="${fn:contains(view, 'list') or fn:contains(view, 'show')}">	
	 	<!-- Data Tables JS -->
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/datatable/datatables.min.js"></script>
		<script src="${UrlHelper.getJsRepos()}pages/data-table.js"></script>
	</c:if>
	<c:if test="${fn:contains(view, 'create')}">
		<!-- FORMS JS -->
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/bootstrap-select/dist/js/bootstrap-select.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/bootstrap-tagsinput/dist/bootstrap-tagsinput.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/select2/dist/js/select2.full.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_plugins/input-mask/jquery.inputmask.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_plugins/input-mask/jquery.inputmask.extensions.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/moment/min/moment.min.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/bootstrap-daterangepicker/daterangepicker.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_components/bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_plugins/timepicker/bootstrap-timepicker.min.js"></script>
		<script src="${UrlHelper.getResourcesRepos()}assets/vendor_plugins/iCheck/icheck.min.js"></script>
		<script src="${UrlHelper.getJsRepos()}pages/advanced-form-element.js"></script>
		<script src="${UrlHelper.getJsRepos()}pages/validation.js"></script>
    	<script src="${UrlHelper.getJsRepos()}pages/form-validation.js"></script>
	</c:if>	
	<!-- Orbit Admin App -->
	<script src="${UrlHelper.getJsRepos()}template.js"></script>
    <script src="${UrlHelper.getJsRepos()}pages/toastr.js"></script>
    <script src="${UrlHelper.getJsRepos()}pages/notification.js"></script>
	
	<c:if test="${userSuccess == true}">
			<script>
				$(document).ready(function() {
					$("#alertUserCreated").click();
				});
			</script>
	</c:if>
	<!-- Title Marquee -->
	<script type="text/javascript">
		var titleText = document.title;

		function titleMarquee() {

			titleText = titleText.substring(1, titleText.length)
					+ titleText.substring(0, 1);
			document.title = titleText;
			setTimeout("titleMarquee()", 450);
		}
	</script>
	
</body>
</html>
		