<%-- 
    Document   : adminHome
    Created on : Feb 10, 2016, 11:39:56 PM
    Author     : nuzly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>Inventory Control System</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <section id="container" >
            <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a href="index.html" class="logo"><b>Inventory Control System</b></a>
                <!--logo end-->

                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li><a class="logout" href="${pageContext.request.contextPath}/logout">Logout</a></li>
                    </ul>
                </div>
            </header>
            <!--header end-->

            <!-- **********************************************************************************************************************************************************
            MAIN SIDEBAR MENU
            *********************************************************************************************************************************************************** -->
            <!--sidebar start-->
            <aside>
                <div id="sidebar"  class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">

                        <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
                        <h5 class="centered"><%= session.getAttribute("logFname")%> </h5>



                        <li class="sub-menu">
                            <a class="active" href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Admin Function</span>
                            </a>
                            <ul class="sub">
                                <li> <a href="${pageContext.request.contextPath}/admin">Approval Requests</a></li>

                                <li><a href="${pageContext.request.contextPath}/AddCategoryServlet">Categories</a></li>

                                <li><a href="${pageContext.request.contextPath}/CreateSupplierServlet">Suppliers</a></li>



                            </ul>
                        </li>

                        <li class="sub-menu">
                            <a class="active" href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Items</span>
                            </a>
                            <ul class="sub">

                                <li><a href="${pageContext.request.contextPath}/listitem">View Items</a></li>

                            </ul>
                        </li>

                        <li class="sub-menu">
                            <a class="active" href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Customers</span>
                            </a>
                            <ul class="sub">

                                <li><a href="create_customer.jsp">Create Customers</a></li>

                            </ul>
                        </li>





                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <form class="form-inline" role="form" action="CreateOrderServlet" method="post">
                        <h3><i class="fa fa-angle-right"></i>Create Order</h3>
                        <div class="row">





                            <div class="row mt">
                                <div class="col-md-12">

                                    <div class="col-lg-12">



                                        <div class="form-group">
                                            <label class="sr-only" for="itemName">Name</label>
                                            <input type="text" class="form-control" list="items" name="itemName" id="itemName" placeholder="Enter Item Name" autocomplete="off">

                                            <datalist  name="itemslist" id="items">
                                                <c:forEach items="${items}" var="isup" >
                                                    <option value="${isup.itemName}">${isup.id}</option>

                                                </c:forEach>
                                            </datalist>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="category">Category</label>
                                            <input type="text" class="form-control" list="categoryList" name="categoryList" id="catId" placeholder="Enter Category" autocomplete="off">

                                            <datalist  name="suppliersList" id="categoryList">
                                                <c:forEach items="${categories}" var="cat" >
                                                    <option value="${cat.catName}">${cat.id}</option>

                                                </c:forEach>
                                            </datalist>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="category">Supplier</label>
                                            <input type="text" class="form-control" list="suppliersList" id="supId" name="suppliersList" placeholder="Enter Suplier" autocomplete="off">

                                            <datalist  name="suppliersList" id="suppliersList">
                                                <c:forEach items="${suppliers}" var="sup" >
                                                    <option value="${sup.compName}">${sup.id}</option>

                                                </c:forEach>
                                            </datalist>
                                        </div>
                                        <button type="submit" class="btn btn-theme">Search</button>

                                    </div><!-- /form-panel -->
                                    <div class="content-panel">
                                        <table class="table table-striped table-advance table-hover">

                                            <hr>
                                            <thead>
                                                <tr>
                                                    <th><i class="numeric"></i>Item Name</th>
                                                    <th><i class="numeric"></i> Unit Price</th>
                                                    <th><i class="numeric"></i> Quantity per Unit</th>
                                                    <th><i class="numeric"></i> Units in Stock</th>
                                                    <th><i class="numeric"></i> Supplier</th>
                                                    <th><i class="numeric"></i> Category</th>

                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <form action="EditCategoryServlet" method="get" > 
                                                <input type="hidden" value="EDIT" name="fromList">
                                                <c:forEach var="pitem" items="${items}">
                                                    <tr>
                                                        <td><a href="basic_table.html#"><c:out value="${pitem.itemName}" /></a></td>
                                                        <td class="numeric"><c:out value="${pitem.unitPrice}" /></td>
                                                        <td class="numeric"><c:out value="${pitem.quanityPerUnit}" /></td>
                                                         <td class="numeric"><c:out value="${pitem.unitsInStock}" /></td>
                                                        <td class="numeric"><c:out value="${pitem.supId.compName}" /></td>
                                                        <td class="numeric"><c:out value="${pitem.catId.catName}" /></td>


                                                        <td>

                                                            <button name="orderItem"  class="btn btn-success btn-sm pull-left"  value="${pitem.id}">Order</button>

                                                        </td>
                                                    </tr>
                                                </c:forEach>

                                                </tbody>
                                        </table>
                                    </div>
                                </div><!-- /content-panel -->

                            </div><!-- /row -->
                    </form>
                </section><! --/wrapper -->
            </section><!-- /MAIN CONTENT -->

            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    2014 - Alvarez.is
                    <a href="basic_table.html#" class="go-top">
                        <i class="fa fa-angle-up"></i>
                    </a>
                </div>
            </footer>
            <!--footer end-->
        </section>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
        <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


        <!--common script for all pages-->
        <script src="assets/js/common-scripts.js"></script>

        <!--script for this page-->

        <script>
            //custom select box

            $(function () {
                $('select.styled').customSelect();
            });

        </script>

    </body>
</html>

