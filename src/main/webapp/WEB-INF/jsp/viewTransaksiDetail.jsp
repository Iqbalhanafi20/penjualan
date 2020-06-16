<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
					<li class="active">Detail Transaksi</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header">
								<h4 style="float: left">Detail Transaksi</h4>
								<a style="float: right"
									href="${pageContext.request.contextPath}/transaksi/detail/tambah/${data.getNoNota()}"
									class="btn btn-sm btn-success">tambah barang</a>
							</div>
							<div class="box-body">
								<form:form modelAttribute="headerDto"
									action="${pageContext.request.contextPath}/transaksi/header/ubah/proses/${noNota}"
									method="post">
									<div class="row" style="margin-bottom: 20px;">
										<div class="col-md-12">
											<div class="form-group">
												<label>No. Nota : </label>
												<%-- <input type="text"
													class="form-control" value="${data.getNoNota()}" /> --%>
												<form:input path="noNota" class="form-control" />
											</div>
											<div class="form-group">
												<label>Tanggal Transaksi : </label>
												<%-- <f:formatDate value="${data.getTanggalTransaksi()}"
													pattern="dd/MM/yyyy" var="theFormattedDate" />
												<input id="datepicker" type="text" class="form-control datepicker"
													value="${theFormattedDate}" /> --%>
												<form:input path="tanggalTransaksi"
													class="form-control datepicker" />
											</div>
											<div class="form-group">
												<label>Pilih Pelanggan : </label>
												<%-- <select
													class="form-control">
													<option value="">-Pilih Customer-</option>
													<c:forEach items="${pelanggan}" var="k">
														<option
															${data.getKodeCustomer() == k.getKodeCustomer() ? "selected" : ""}
															value="${k.getKodeCustomer()}">${k.getNamaCustomer()}</option>
													</c:forEach>
												</select> --%>
												<form:select path="kodeCustomer" class="form-control">
													<option value="">-Pilih Customer-</option>
													<c:forEach items="${pelanggan}" var="k">
														<option
															${data.getKodeCustomer() == k.getKodeCustomer() ? "selected" : ""}
															value="${k.getKodeCustomer()}">${k.getNamaCustomer()}</option>
													</c:forEach>
												</form:select>
											</div>
											<div class="form-group">
												<label>Karyawan</label>
												<input class="form-control" value="${sessionScope.sesikaryawan.getNamaKaryawan()}" readonly="true" />
												<form:input path="kodeKaryawan" type="hidden"
													class="form-control"
													value="${sessionScope.sesikaryawan.getKodeKaryawan()}"
													readonly="true" />
											</div>
										</div>
									</div>
									<div class="table-responsive">
										<table class="table table-bordered" id="tblDetailTransaksi">
											<thead>
												<tr>
													<th>Kode Detail</th>
													<th>Barang</th>
													<th>Qty</th>
													<th>Harga Satuan</th>
													<th>Diskon</th>
													<th>Subtotal</th>
													<th class="text-right">#</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${data.getDetail()}" var="p">
													<tr>
														<td>${p.getKodeDetail()}</td>
														<td>${p.getNamaBarang()}</td>
														<td>${p.getQty()}</td>
														<td>${p.getHargaSatuan()}</td>
														<td>${p.getDiskon()}</td>
														<td class="subtotal">${p.getSubtotal()}</td>
														<td class="text-right"><a
															class="btn btn-sm btn-danger btDelete"
															href="${pageContext.request.contextPath}/transaksi/detail/hapus/${p.getKodeDetail()}">delete</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="row">
										<div class="col-md-12 text-right">
											<p>
												Global diskon :
												<%-- <input type="text" id="globalDiskon"
													value="${data.getGlobalDiskon()}" /> --%>
												<form:input path="globalDiskon" />
											</p>
											<p>
												Total Harga : <input type="text"
													value="${data.getDisplayHargaTotal()}" />
												<form:input type="hidden" path="hargaTotal" />
											</p>
										</div>
										<div class="col-md-12 text-center">
											<button type="submit" class="btn btn-sm btn-success">submit</button>
											<a href="${pageContext.request.contextPath}/transaksi/list" class="btn btn-sm btn-warning">kembali</a>
										</div>
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

	<script type="text/javascript">
		$(document).ready(function() {
			//load();
			function load() {
				$('#tblDetailTransaksi').DataTable();
			}
			
			$(document).on("click", ".btDelete", function(e){
				e.preventDefault();
				var href = $(this).attr("href");
				
				if (confirm("apa anda yakin ingin menghapus")) {
					window.location.href = href;
				}
			});

			var options = {
				format : 'dd/mm/yyyy',
				todayHighlight : true,
				autoclose : true,
			};

			$('.datepicker').datepicker(options);
		})
	</script>
</body>
</html>