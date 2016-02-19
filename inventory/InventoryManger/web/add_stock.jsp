<%-- 
    Document   : register
    Created on : Feb 10, 2016, 10:42:38 PM
    Author     : nuzly
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>Inventory Control System</title>

        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="assets/js/bootstrap-datepicker/css/datepicker.css" />
        <link rel="stylesheet" type="text/css" href="assets/js/bootstrap-daterangepicker/daterangepicker.css" />

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
            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <h3><i class="fa fa-angle-right"></i> Add Stock</h3>

                    <!-- BASIC FORM ELELEMNTS -->


                    <div class="row mt" >
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <h4 class="mb"><i class="fa fa-angle-right"></i> Item Detail</h4>
                                <form class="form-horizontal style-form" method="post" action="UpdateStocksServlet">



                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Item Name</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sinamel">${searchItem.itemName}</label>
                                            <input type="hidden" value="${searchItem.itemName}" name="siname">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Item Description</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sidesc">${searchItem.itemDescription}</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Unit Price</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="siup">${searchItem.unitPrice}</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Available Stock</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sias">${searchItem.unitsInStock}</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Threshold</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sit">${searchItem.reorderThreshold}</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Supplier</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sisup">${searchItem.supId.compName}</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Category</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sic">${searchItem.catId.catName}</label>
                                        </div>
                                    </div>
                                        
                                         <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">New Stock</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="control-label" name="newstock">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-theme" >Update</button>
                                </form>
                            </div>
                        </div><!-- col-lg-12-->      	
                    </div><!-- /row -->




                </section><! --/wrapper -->
            </section><!-- /MAIN CONTENT -->

            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    2014 - Alvarez.is
                    <a href="form_component.html#" class="go-top">
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
        <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>

        <!--custom switch-->
        <script src="assets/js/bootstrap-switch.js"></script>

        <!--custom tagsinput-->
        <script src="assets/js/jquery.tagsinput.js"></script>

        <!--custom checkbox & radio-->

        <script type="text/javascript" src="assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap-daterangepicker/date.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>

        <script type="text/javascript" src="assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>


        <script src="assets/js/form-component.js"></script>    


        <script>
            //custom select box

            $(function () {
                $('select.styled').customSelect();
            });

        </script>

    </body>
</html>

