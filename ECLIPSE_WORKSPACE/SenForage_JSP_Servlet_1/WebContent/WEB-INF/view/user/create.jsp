<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Main content -->
<section class="content">
<div class="row">
	<div class="box">
		<!-- box-header -->
		<div class="box-header with-border text-center text-uppercase">
		  <h4 class="box-title">Create a New User</h4>
		  <span class="text-danger"><c:if test="${form.resultat != null}"><br/>▶STATUS: ${form.resultat}</c:if></span>
		</div>
		<!-- /.box-header -->
		
		<!-- box-body -->
		<form class="form" action="<c:url value="/users/new" />" method="post">
			<div class="box-body">
				<h4 class="box-title text-info"><i class="ti-user mr-15"></i> Personal Info</h4>
				<hr class="my-15">
				<div class="row">
				  <div class="col-md-6">
					<div class="form-group">
					  <label><c:out value="${form.erreurs['prenom']}" default="First Name"/></label>
					  <input type="text" name="prenom" class="form-control" value="<c:out value="${user.prenom}"/>" placeholder="First Name" required data-validation-required-message="This field is required">
					</div>
				  </div>
				  <div class="col-md-6">
					<div class="form-group">
					  <label><c:out value="${form.erreurs['nom']}" default="Last Name"/></label>
					  <input type="text" name="nom" class="form-control" value="<c:out value="${user.nom}"/>" placeholder="Last Name" required data-validation-required-message="This field is required">
					</div>
				  </div>
				</div>
				<div class="row">
				  <div class="col-md-6">
					<div class="form-group">
					  <label ><c:out value="${form.erreurs['email']}" default="E-mail"/></label>
					  <input type="text" name="email" class="form-control" value="<c:out value="${user.email}"/>" placeholder="E-mail" required data-validation-required-message="This field is required">
					</div>
				  </div>
				  <div class="col-md-6">
					<div class="form-group">
						<label ><c:out value="${form.erreurs['username']}" default="Username"/></label>
						<div class="input-group">
							<span class="input-group-addon">@</span>
							<input type="text" name="username" class="form-control" value="<c:out value="${user.username}"/>" placeholder="Username" required>
					  	</div>
					</div>
				  </div>
				</div>
				<h4 class="box-title text-info"><i class="ti-save mr-15"></i> Requirements</h4>
				<hr class="my-15">
				
				
				
				<div class="row">
				  <div class="col-md-6">
					<div class="form-group">
						<h5><c:out value="${form.erreurs['password']}" default="Password Input Field"/> <span class="text-danger">*</span></h5>
						<div class="controls">
							<input type="password" name="password" class="form-control" required data-validation-required-message="This field is required"> 
						</div>
					</div>
				  </div>
				  <div class="col-md-6">
					<div class="form-group">
						<h5><c:out value="${form.erreurs['confirmpass']}" default="Repeat Password Input Field"/> <span class="text-danger">*</span></h5>
						<div class="controls">
							<input type="password" name="confirmpass" data-validation-match-match="password" class="form-control" required> 
						</div>
					</div>
				  </div>
				</div>
				<div class="row">
				  <div class="col-md-6">
					  <div class="form-group">
						<label><c:out value="${form.erreurs['role']}" default="Role"/></label>
						<select class="form-control select2" name="role" style="width: 100%;" required>
						  	<c:forEach items="${ sessionScope.rolesList }" var="role" varStatus="theCount">
								<c:choose>
								  <c:when test="${theCount.index == 0}">
									<option value="${ role.id }" selected="selected">${ role.libelle }</option>
								   </c:when>
								  
								  <c:otherwise>
									<option value="${ role.id }">${ role.libelle }</option>
								  </c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					  </div>
					  <!-- /.form-group -->
				  </div>
				  <div class="col-md-6">
					 <div class="form-group">
						<label><c:out value="${form.erreurs['status']}" default="State of The Account"/></label>
						<select class="selectpicker mb-20 mr-10" name="status" data-style="btn-warning ">
							<option value="1" data-tokens="1">Activated</option>
							<option value="0" data-tokens="0">Disabled</option>
						</select>
					  </div>
				  </div>
				</div>
			</div>
			<!-- /.box-body -->
			<div class="box-footer text-center">
				<button type="reset" class="btn btn-rounded btn-warning btn-outline mr-1">
				  <i class="ti-trash"></i> Cancel
				</button>
				<button type="submit" class="btn btn-rounded btn-primary btn-outline">
				  <i class="ti-save-alt"></i> Save
				</button>
			</div>  
		</form>
	</div>
	<!-- /.box -->
</div>
<!-- /.row -->					
</section>
<!-- /.content -->
    