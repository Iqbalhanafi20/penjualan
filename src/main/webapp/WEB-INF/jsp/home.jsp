<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/common/include/meta.jsp"%>
<title>E-Sell | Home</title>
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
        Home
        <small>Control Panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Home</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Small boxes (Stat box) -->
      <div class="row">
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-aqua">
            <div class="inner">
              <h3>${jmlh }</h3>

              <p>Transaksi</p>
            </div>
            <div class="icon">
              <i class="fa fa-fw fa-cart-arrow-down"></i>
            </div>
            
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-green">
            <div class="inner">
              <h3>${jmlbar}<sup style="font-size: 20px"></sup></h3>

              <p>Barang</p>
            </div>
            <div class="icon">
              <i class="fa fa-fw fa-cubes"></i>
            </div>
            
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3>${jmlcus} </h3>

              <p>Pelanggan</p>
            </div>
            <div class="icon">
              <i class="ion ion-person"></i>
            </div>
            
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-red">
            <div class="inner">
              <h3>${jmlkar}</h3>

              <p>Karyawan </p>
            </div>
            <div class="icon">
              <i class="ion ion-person"></i>
            </div>
           
          </div>
        </div>
        <!-- ./col -->
      </div>
      <!-- /.row -->
      <div class="row">
      <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-purple">
            <div class="inner">
              <h3>${jmlpr }</h3>

              <p>Provinsi</p>
            </div>
            <div class="icon">
              <i class="fa fa-fw fa-map-o"></i>
            </div>
            
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-maroon">
            <div class="inner">
              <h3>${jmlko}<sup style="font-size: 20px"></sup></h3>

              <p>Kota</p>
            </div>
            <div class="icon">
              <i class="fa fa-fw fa-map-signs"></i>
            </div>
            
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
         
            
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          
           
          </div>
        </div>
        <!-- ./col -->
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