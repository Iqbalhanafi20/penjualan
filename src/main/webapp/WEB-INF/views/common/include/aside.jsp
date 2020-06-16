<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="/penjualan/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${sessionScope.sesikaryawan.getNamaKaryawan()}</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">MENU UTAMA</li>
        <!-- Optionally, you can add icons to the links -->
        <li><a href="/penjualan/home"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>
        <!-- <li><a href="#"><i class="fa fa-link"></i> <span>Another Link</span></a></li> -->
        <li class="treeview">
          <a href="#"><i class="fa fa-lock"></i> <span>Master</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/barang/list"><i class="fa fa-list"></i> Barang</a></li>
            <li><a href="${pageContext.request.contextPath}/karyawan/list"><i class="fa fa-list"></i> Karyawan</a></li>
            <li><a href="${pageContext.request.contextPath}/kota/list"><i class="fa fa-list"></i> Kota</a></li>
            <li><a href="${pageContext.request.contextPath}/pelanggan/list"><i class="fa fa-list"></i> Pelanggan</a></li>
            <li><a href="${pageContext.request.contextPath}/provinsi/list"><i class="fa fa-list"></i> Provinsi</a></li>
            <li><a href="${pageContext.request.contextPath}/supplier/list"><i class="fa fa-list"></i> Supplier</a></li>
          </ul>
        </li>
        <li><a href="${pageContext.request.contextPath}/transaksi/list"><i class="fa fa-dollar"></i> <span>Transaksi</span></a></li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>
