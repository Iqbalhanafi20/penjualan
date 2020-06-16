<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/common/include/meta.jsp"%>
<title>Master Barang | List</title>
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
					Data Barang <small>Master</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Data Barang</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header">
								<h4 style="float: left">List</h4>
								<a href="${pageContext.request.contextPath}/barang/tambah"
									class="btn btn-sm btn-success" style="float: right">tambah</a>
							</div>
							<div class="box-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="tblListBarang">
										<thead>
											<tr>
												<th>Kode Barang</th>
												<th>Nama Barang</th>
												<th>Stock Barang</th>
												<th>Kode Suplier</th>
												<th>#</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${data}" var="p">
												<tr>
													<td>${p.getKodeBarang()}</td>
													<td>${p.getNamaBarang()}</td>
													<td>${p.getStokBarang()}</td>
													<td>${p.getKodeSupplier()}</td>
													<td><a class="btn btn-sm btn-warning"
														href="${pageContext.request.contextPath}/barang/ubah/${p.getKodeBarang()}">edit</a>
														| <a class="btn btn-sm btn-danger btDelete"
														href="${pageContext.request.contextPath}/barang/hapus/${p.getKodeBarang()}">delete</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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
			load();
			function load() {
				$('#tblListBarang').DataTable();
			}

			$(document).on("click", ".btDelete", function(e) {
				e.preventDefault();
				var target = $(this).attr("href");

				if (confirm("apakah anda yakin ingin menghapus data ini?")) {
					window.location.href = target;
				} else {
					//nothing
				}
			})

		})
	</script>

</body>
</html>