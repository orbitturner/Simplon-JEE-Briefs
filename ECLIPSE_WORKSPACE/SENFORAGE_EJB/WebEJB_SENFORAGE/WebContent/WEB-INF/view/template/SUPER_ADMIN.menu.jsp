<%@page import="services.UrlHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<!-- start -->
		<li>
          <a href="<c:url value="home"/>">
            <i data-feather="pie-chart"></i>
			<span>Dashboard</span>
          </a>
        </li>  
		
		<li class="header nav-small-cap">App Management</li>
		
        <li class="treeview">
          <a href="#">
            <i data-feather="home"></i>
            <span>Villages</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="<c:url value="/villages"/>"><i class="ti-more"></i>List of Villages</a></li>
            <li><a href="<c:url value="villages/new"/>"><i class="ti-more"></i>Create a Village</a></li>
            <li><a href="<c:url value="villages/showblocked" />"><i class="ti-more"></i>Blocked Villages</a></li>
          </ul>
        </li> 
		  
        <li class="treeview">
          <a href="#">
            <i data-feather="users"></i> 
            <span>Customers</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
          	<li><a href="<c:url value="clients"/>"><i class="ti-more"></i>List of Customers</a></li>
            <li><a href="<c:url value="clients/new"/>"><i class="ti-more"></i>Create a Customer</a></li>
            <li><a href="<c:url value="clients/showblocked"/>"><i class="ti-more"></i>Show Blocked Customers</a></li>
          </ul>
        </li>
		        		 
        <li class="header nav-small-cap">System Management Interface</li>
		  
		<li class="treeview">
		      <a href="#">
		        <i data-feather="user-check"></i>
		        <span>Users</span>
		        <span class="pull-right-container">
		          <i class="fa fa-angle-right pull-right"></i>
		        </span>
		      </a>
		      <ul class="treeview-menu">
		        <%-- <li><a href="profile"><i class="ti-more"></i>Profile</a></li>--%>
		        <li><a href="<c:url value="users"/>"><i class="ti-more"></i>List of Users</a></li>
		        <li><a href="<c:url value="users/new"/>"><i class="ti-more"></i>Create a User</a></li>
		        <li><a href="<c:url value="users/showblocked"/>"><i class="ti-more"></i>Show Blocked Users</a></li>
		      </ul>
		</li> 		  
		  
        <li class="treeview">
          <a href="#">
            <i data-feather="grid"></i>
            <span>Roles</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
          	<li><a href="<c:url value="roles"/>"><i class="ti-more"></i>List of Users</a></li>
            <li><a href="<c:url value="roles/new"/>"><i class="ti-more"></i>Create a Role</a></li>
            <li><a href="<c:url value="roles/showblocked"/>"><i class="ti-more"></i>Show Blocked Roles</a></li>
          </ul>
        </li>
		
		
		  
<!-- 		<li>
          <a href="logout">
            <i data-feather="lock"></i>
			<span>Log Out</span>
          </a>
        </li>  -->
		<!-- end -->