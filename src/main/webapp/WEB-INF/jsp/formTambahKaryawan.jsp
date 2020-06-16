<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/common/include/meta.jsp"%>
<title>Master Karyawan | Tambah</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- .wrapper -->
	<div class="wrapper">

		<%@include file="/WEB-INF/views/common/include/header.jsp"%>
		<%@include file="/WEB-INF/views/common/include/aside.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Form Tambah Karyawan <small>Master</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Form Tambah Karyawan</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
					<!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              					<c:choose>
									<c:when test="${not empty  errors}">
										<div class="alert alert-danger alert-dismissible">
											<button type="button" class="close" data-dismiss="alert"
												aria-hidden="true">×</button>
											<c:forEach items="${errors}" var="err">${err.defaultMessage}<br />
											</c:forEach>
										</div>
									</c:when>
									<c:when test="${not empty  anotherError}">
										<div class="alert alert-danger alert-dismissible">
											<button type="button" class="close" data-dismiss="alert"
												aria-hidden="true">×</button>
											${anotherError}
										</div>
									</c:when>
								</c:choose>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form:form modelAttribute="data" action="${pageContext.request.contextPath}/karyawan
            /simpan/proses" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="kodekaryawan">Kode Karyawan</label>
                  <form:input path="kodeKaryawan" type="text" class="form-control" />
                </div>
                <div class="form-group">
                  <label for="namakaryawan">Nama Karyawan</label>
                  <form:input path="namaKaryawan" type="text" class="form-control" />
                </div>
                <div class="form-group">
                  <label for="username">Username</label>
                  <form:input path="username" type="text" class="form-control" />
                </div>
                <div class="form-group">
                  <label for="password">Password</label>
                  <form:input path="password" type="text" class="form-control" />
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="${pageContext.request.contextPath}/karyawan/list" class="btn btn-sm btn-warning">kembali</a>
              </div>
            </form:form>
          </div>
          <!-- /.box -->
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<%@include file="/WEB-INF/views/common/include/footer.jsp"%>
		<%@include file="/WEB-INF/views/common/include/control-sidebar.jsp"%>

	</div>
	<!-- /.wrapper -->

	<%@include file="/WEB-INF/views/common/include/script.jsp"%>
	
	<script type="text/javascript">
		$(document).ready(function(){
			load();
			function load(){
				$('#tblListBarang').DataTable();
			}
		})
	</script>

</body>
</html>