<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/common/include/meta.jsp"%>
<title>Master Pelanggan | Ubah</title>
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
					Ubah Data Pelanggan <small>Master Input Form</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Ubah Data Pelanggan</li>
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
									action="${pageContext.request.contextPath}/pelanggan/ubah/proses/${kodeCustomer}"
									modelAttribute="pelangganDto">
									<div class="form-group">
										<form:label path="kodeCustomer">Kode Pelanggan</form:label>
										<form:input path="kodeCustomer" type="text"
											class="form-control" readonly="true" />
									</div>
									<div class="form-group">
										<form:label path="namaCustomer">Nama Pelanggan</form:label>
										<form:input path="namaCustomer" type="text"
											class="form-control" />
									</div>
									<div class="form-group">
										<form:label path="emailCustomer">Email Pelanggan</form:label>
										<form:input path="emailCustomer" type="email"
											class="form-control" />
									</div>
									<div class="form-group">
										<form:label path="alamatCustomer">Alamat Pelanggan</form:label>
										<form:input path="alamatCustomer" type="text"
											class="form-control" />
									</div>
									<div class="form-group">
										<form:label path="jenisKelamin">Jenis Kelamin Pelanggan</form:label>
										<form:select path="jenisKelamin" class="form-control">
											<option value="">-Pilih Kota-</option>
											<option
												${pelangganDto.getJenisKelamin() == "PRIA" ? "selected" : ""}
												value="PRIA">PRIA</option>
											<option
												${pelangganDto.getJenisKelamin() == "WANITA" ? "selected" : ""}
												value="WANITA">WANITA</option>
										</form:select>
									</div>
									<div class="form-group">
										<form:label path="kodeKota">Kode Kota</form:label>
										<form:select path="kodeKota" class="form-control">
											<option value="">-Pilih Kota-</option>
											<c:forEach items="${dataKota}" var="p">
												<option
													${p.getKodeKota() == pelangganDto.getKodeKota() ? "selected" : ""}
													value="${p.getKodeKota()}">${p.getNamaKota()}</option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group">
										<form:button type="submit" class="btn btn-sm btn-primary">submit</form:button>
										<a class="btn btn-sm btn-warning"
											href="${pageContext.request.contextPath}/pelanggan/list">kembali</a>
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