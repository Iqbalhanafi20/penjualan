<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/common/include/meta.jsp"%>
<title>Transaksi | Detail</title>
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
					Data Transaksi <small>Detail</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Tambah Transaksi Header</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header">
								<h4 style="float: left">Tambah Transaksi Header</h4>
							</div>
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
								<div class="row" style="margin-bottom: 20px;">
								<form:form modelAttribute="data" action="${pageContext.request.contextPath}/transaksi/simpanheader/proses" method="post">
				              <div class="box-body">
				                <div class="form-group">
				                  <label for="nonota">No Nota</label>
				                  <form:input path="noNota" type="text" class="form-control" />
				                </div>
				                <div class="form-group">
												<label>Tanggal Transaksi : </label>
												<%-- <form:formatDate path="tanggalTransaksi"
													pattern="dd/MM/yyyy" var="theFormattedDate" />
												<input id="datepicker" type="text" class="form-control datepicker"
													value="${theFormattedDate}" /> --%>
												<form:input path="tanggalTransaksi"
													class="form-control datepicker" />
											</div>
				                <div class="form-group">
				                  <label for="globaldiskon">Global Diskon</label>
				                  <form:input path="globalDiskon" type="text" class="form-control" onkeypress="return hanyaAngka(event)" />
				                </div>
				                
				                  <form:input path="hargaTotal" type="hidden" class="form-control" />
				               
				                <div class="form-group">
				                  <label for="pelanggan">Pelanggan</label>
				                  <form:select path="kodeCustomer" class="form-control">
										<option value="">-Pilih Pelanggan</option>
										<c:forEach items="${pelanggan}" var="p">
										<option value="${p.getKodeCustomer()}">${p.getNamaCustomer()}</option>
										</c:forEach>
								  </form:select>
				                </div>
				                <div class="form-group">
				                  <label for="karyawan">Karyawan</label>
				                  <form:select path="kodeKaryawan" class="form-control">
										<option value="">-Pilih Pelanggan</option>
										<c:forEach items="${karyawan}" var="k">
										<option value="${k.getKodeKaryawan()}">${k.getNamaKaryawan()}</option>
										</c:forEach>
								  </form:select>
				                </div>
				                <div class="box-footer">
					                <button type="submit" class="btn btn-primary">Submit</button>
					                <a href="${pageContext.request.contextPath}/transaksi/list" class="btn btn-sm btn-warning">kembali</a>
					             </div>
				            </form:form>
								</div>	
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

<script type="text/javascript">
		$(document).ready(function() {
			var options = {
				format : 'dd/mm/yyyy',
				todayHighlight : true,
				autoclose : true,
			};

			$('.datepicker').datepicker(options);
		})
	</script>
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