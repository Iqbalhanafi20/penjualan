<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/common/include/meta.jsp"%>
<title>Tambah Supplier</title>
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
					Form Tambah Supplier <small>Master</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Form Tambah Supplier</li>
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
            <form:form modelAttribute="data" action="${pageContext.request.contextPath}/supplier
            /simpan/proses" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="kodesupplier">Kode Supplier</label>
                  <form:input path="kodeSupplier" type="text" class="form-control" />
                </div>
                <div class="form-group">
                  <label for="namasupplier">Nama Supplier</label>
                  <form:input path="namaSupplier" type="text" class="form-control" />
                </div>
                <div class="form-group">
                  <label for="alamatsupplier">Alamat</label>
                  <form:input path="alamatSupplier" type="text" class="form-control" />
                </div>
                <div class="form-group">
                  <label for="telpsupplier">No Telepon</label>
                  <form:input path="telpSupplier" type="text" class="form-control" maxlength="13" onkeypress="return hanyaAngka(event)" />
                </div>
                <div class="form-group">
                  <label for="telpsupplier">Email</label>
                  <form:input path="emailSupplier" type="text" class="form-control" />
                </div>
                <div class="form-group">
                  <label for="telpsupplier">Kota</label>
                  <form:select path="kodeKota" class="form-control">
											<option value="">-Pilih Kota</option>
											<c:forEach items="${datakota}" var="k">
											<option value="${k.getKodeKota()}">${k.getNamaKota()}</option>
											</c:forEach>
										</form:select>
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="${pageContext.request.contextPath}/supplier/list" class="btn btn-sm btn-warning">kembali</a>
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
	

<script>
function hanyaAngka(evt) {
	  var charCode = (evt.which) ? evt.which : event.keyCode
	   if (charCode > 31 && (charCode < 48 || charCode > 57))

	    return false;
	  return true;
	}
</script>
</body>
</html>