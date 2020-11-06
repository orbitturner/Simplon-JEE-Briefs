<%@page import="services.UrlHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Main content -->
<section class="content">
 <div class="box">
				<div class="box-header with-border">
				  <h3 class="box-title">List of All Users in the Databases</h3>
				  <h6 class="box-subtitle">You can Export data to Copy, CSV, Excel, PDF & Print</h6>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="table-responsive">
					  <table id="example" class="table table-bordered table-hover display nowrap margin-top-10 w-p100">
						<thead>
							<tr>
								<th>id</th>
								<th>Nom</th>
								<th>Prenom</th>
								<th>Username</th>
								<th>Email</th>
								<th>Role</th>
								<th>Created at:</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ sessionScope.usersList }" var="user">
								<tr>
									<td><c:out value="${ user.id }"></c:out></td>
									<td><c:out value="${ user.nom }"></c:out></td>
									<td><c:out value="${ user.prenom }"></c:out></td>
									<td><c:out value="${ user.username }"></c:out></td>
									<td><c:out value="${ user.email }"></c:out></td>
									<td><c:out value="${ user.role.libelle }"></c:out></td>
									<td><c:out value="${ user.created_at }"></c:out></td>
								</tr>
							</c:forEach>
							
						</tbody>				  
						<tfoot>
							<tr>
								<th>id</th>
								<th>Nom</th>
								<th>Prenom</th>
								<th>Username</th>
								<th>Email</th>
								<th>Role</th>
								<th>Created at:</th>
							</tr>
						</tfoot>
					</table>
					</div>              
				</div>
				<!-- /.box-body -->
			  </div>
			  <!-- /.box -->    
</section>
<!-- /.content -->
