<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jQuery 2.2.3 -->
<script src="/penjualan/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/penjualan/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- datatables -->
<script
	src="/penjualan/resources/vendor/datepicker/bootstrap-datepicker.min.js"></script>
<script
	src="/penjualan/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script
	src="/penjualan/resources/vendor/datatables/js/dataTables.bootstrap.min.js"></script>
<!-- sweetalert -->
<script src="/penjualan/resources/vendor/sweetalert/swal.min.js"></script>
<!-- SlimScroll -->
<script
	src="/penjualan/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/penjualan/resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/penjualan/resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/penjualan/resources/dist/js/demo.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var url = window.location;
		$('ul.sidebar-menu li a').filter(function() {
			return this.href == url;
		}).parent().addClass('active');

		$('ul.treeview-menu li a').filter(function() {

			return this.href == url;

		}).parentsUntil($("ul.level-1")).addClass('active');

		var title = '${swalMessage.getTitle()}';
		var text = '${swalMessage.getText()}';
		var icon = '${swalMessage.getIcon()}';

		if (title) {
			swal(title, text, icon);
		}

	})
</script>