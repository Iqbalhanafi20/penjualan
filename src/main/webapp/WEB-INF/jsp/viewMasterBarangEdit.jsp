<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/common/include/meta.jsp"%>
<title>Master Barang | Ubah</title>
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
					Tambah Data Barang <small>Master Input Form</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Ubah Data Barang</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-body">
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
								<form:form method="POST"
									action="${pageContext.request.contextPath}/barang/ubah/proses/${kodeBarang}"
									modelAttribute="barangDto">
									<div class="form-group">
										<form:label path="kodeBarang">Kode Barang</form:label>
										<form:input path="kodeBarang" type="text" class="form-control"
											readonly="true" />
									</div>
									<div class="form-group">
										<form:label path="namaBarang">Nama Barang</form:label>
										<form:input path="namaBarang" type="text" class="form-control" />
									</div>
									<div class="form-group">
										<form:label path="stokBarang">Stok Barang</form:label>
										<form:input path="stokBarang" type="number"
											class="form-control" />
									</div>
									<div class="form-group">
										<form:label path="kodeSupplier">Kode Supplier</form:label>
										<form:select path="kodeSupplier" class="form-control">
											<option value="">-Pilih Supplier</option>
											<c:forEach items="${dataSupplier}" var="p">
												<option
													${p.getKodeSupplier() == barangDto.getKodeSupplier() ? 'selected' : ''}
													value="${p.getKodeSupplier()}">${p.getNamaSupplier()}</option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group">
										<form:button type="submit" class="btn btn-sm btn-primary">submit</form:button>
										<a href="${pageContext.request.contextPath}/barang/list"
											class="btn btn-sm btn-warning">kembali</a>
									</div>
								</form:form>
							</div>
							<div class="box-footer clearfix"></div>
						</div>
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

</body>
</html>