<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/common/include/meta.jsp"%>
<title>Transaksi Detail | Tambah</title>
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
					Form Tambah Transaksi Detail <small>Master</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Form Tambah Transaksi Detail</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<!-- general form elements -->
						<div class="box box-primary">
							<div class="box-header with-border"></div>
							<!-- /.box-header -->
							<!-- form start -->
							<form:form modelAttribute="detail"
								action="${pageContext.request.contextPath}/transaksi/detail
            /tambah/proses/${noNota}"
								method="post">
								<div class="box-body">
									<div class="form-group">
										<label for="kodeDetail">Kode Detail</label>
										<form:input path="kodeDetail" type="text" class="form-control" />
									</div>
									<div class="form-group">
										<label for="kodeBarang">Barang</label>
										<form:select path="kodeBarang" class="form-control">
											<option value="">-Pilih Barang</option>
											<c:forEach items="${barangData}" var="k">
												<option value="${k.getKodeBarang()}">${k.getNamaBarang()}</option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group">
										<label for="hargaSatuan">Harga Satuan</label>
										<form:input path="hargaSatuan" type="text"
											class="form-control" onkeypress="return hanyaAngka(event)" />
									</div>
									<div class="form-group">
										<label for="qty">Qty</label>
										<form:input path="qty" name="qty" type="text" class="form-control" onkeypress="return hanyaAngka(event)" />
									</div>
									<div class="form-group">
										<label for="diskon">Diskon (%)</label>
										<form:input path="diskon" name="diskon" type="text" class="form-control" onkeypress="return hanyaAngka(event)" maxlength="3" />
									</div>
									<div class="form-group">
										<label for="subtotal">Subtotal</label>
										<form:input path="subtotal" type="text" class="form-control" onkeypress="return hanyaAngka(event)" readonly="true" />
									</div>
								</div>
								<!-- /.box-body -->

								<div class="box-footer">
									<button type="submit" class="btn btn-sm btn-primary">submit</button>
									<a href="${pageContext.request.contextPath}/transaksi/detail/${noNota}" class="btn btn-sm btn-warning">kembali</a>
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
		$('#qty').keyup(function(e){
			var hargaSatuan = $('#hargaSatuan').val();
			var diskon = $('#diskon').val();
			var qty = $(this).val();
			
			var hasil1 = (hargaSatuan * qty);
			var diskonRP = (hasil1 * diskon) / 100;
			
			var total = hasil1 - diskonRP;
			
			$('#subtotal').val(total);
		})
		
		$('#diskon').keyup(function(e){
			var hargaSatuan = $('#hargaSatuan').val();
			var qty = $('#qty').val();
			var diskon = $(this).val();
			
			var hasil1 = (hargaSatuan * qty);
			var diskonRP = (hasil1 * diskon) / 100;
			
			var total = hasil1 - diskonRP;
			
			$('#subtotal').val(total);
		})
	});
	
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