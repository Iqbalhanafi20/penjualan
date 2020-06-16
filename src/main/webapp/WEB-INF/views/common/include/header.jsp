<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="${pageContext.request.contextPath}/home" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>E</b>SL</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>E-Sell</b></span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          

   
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="/penjualan/resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">${sessionScope.sesikaryawan.getNamaKaryawan()}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="/penjualan/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  ${sessionScope.sesikaryawan.getNamaKaryawan()} 
                 
                </p>
              </li>
              <!-- Menu Body -->
              
              <!-- Menu Footer-->
              <li class="user-footer">
                
                <div class="pull-right">
                  <a href="${pageContext.request.contextPath}/logout" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          
        </ul>
      </div>
    </nav>
  </header>
