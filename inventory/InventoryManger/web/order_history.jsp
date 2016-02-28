<%-- 
    Document   : adminHome
    Created on : Feb 10, 2016, 11:39:56 PM
    Author     : nuzly
--%>

<%@page import="entity.User"%>
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
            <jsp:include page="header.jsp" />

            <jsp:include page="side_bar.jsp" />

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <h3><i class="fa fa-angle-right"></i> View Orders</h3>
                    <div class="row">





                        <div class="row mt">
                            <div class="col-md-12">
                                <div class="content-panel">
                                    <ul class="sub">


                                    </ul>
                                    <table class="table table-striped table-advance table-hover">

                                        <hr>
                                        <thead>
                                            <tr>
                                                <th><i class="fa fa-bullhorn"></i>id</th>
                                                <th><i class="fa fa-bookmark"></i> Customer Name</th>
                                                <th><i class="fa fa-bookmark"></i> Officer in charge</th>
                                                <th><i class="fa fa-bookmark"></i> Order Date</th>
                                                <th><i class="fa fa-bookmark"></i> Total Value</th>


                                            </tr>
                                        </thead>
                                        <tbody>
                                        <form action="EditCategoryServlet" method="get" > 
                                            <input type="hidden" value="EDIT" name="fromList">
                                            <c:forEach var="order" items="${orderHistory}">
                                                <tr>
                                                    <td><a href="basic_table.html#"><c:out value="${order.id}" /></a></td>
                                                    <td class="hidden-phone"><c:out value="${order.customerId.firstName}" /></td>
                                                    <td class="hidden-phone"><c:out value="${order.staffId.username}" /></td>
                                                    <td class="hidden-phone"><c:out value="${order.orderDate}" /></td>
                                                    <td class="hidden-phone"><c:out value="${order.orderDate}" /></td>


                                                   
                                                </tr>
                                            </c:forEach>
                                        </form>
                                        </tbody>
                                    </table>
                                </div><!-- /content-panel -->
                            </div><!-- /col-md-12 -->
                        </div><!-- /row -->

                </section><! --/wrapper -->
            </section><!-- /MAIN CONTENT -->

            <!--main content end-->
            <!--footer start-->
            <jsp:include page="footer.jsp" />

        
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

