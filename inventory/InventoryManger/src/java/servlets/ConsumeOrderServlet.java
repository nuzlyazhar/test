/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CategoryManagementBean;
import ejb.CreateOrderBean;
import ejb.ItemManagementBean;
import ejb.SupplierManagementBean;
import entity.Item;
import entity.Order;
import entity.OrderDetail;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nuzly
 */
@WebServlet(name = "ConsumeOrderServlet", urlPatterns = {"/ConsumeOrderServlet"})
public class ConsumeOrderServlet extends HttpServlet {

    @EJB
    CreateOrderBean createOrderBean;

    @EJB
    ItemManagementBean itemManagementBean;

    @EJB
    CategoryManagementBean categoryManagementBean;

    @EJB
    SupplierManagementBean supplierManagementBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderItem = request.getParameter("addToOrder");
        Item item = itemManagementBean.getItemById(orderItem);
        request.setAttribute("orderItem", item);
        
        String noOfUnits = request.getParameter("noOfUnits");
        HttpSession session = request.getSession(true);
        if (null == session.getAttribute("sessionOrder") && noOfUnits != null) {
            
            Order order = new Order();
            order.setOrderDate(Calendar.getInstance().getTime());
            order.setStaffId((User) session.getAttribute("user"));

            //create order detail
            OrderDetail od = new OrderDetail();
            od.setOrderDate(Calendar.getInstance().getTime());
            od.setItemId(item);
            od.setOrderId(order);
            od.setUnitPrice(item.getUnitPrice());
            od.setOrderQantity(Integer.parseInt(noOfUnits));
            od.setTotal(od.getUnitPrice().multiply(new BigDecimal(noOfUnits)));
            od.setBillId(1111);
            List<OrderDetail> odList = new ArrayList<>();
            odList.add(od);
            order.setOrderDetailCollection(odList);
            session.setAttribute("sessionOrder", order);
            RequestDispatcher rd = request.getRequestDispatcher("order_overview.jsp");
            rd.include(request, response);

        } else if (null != session.getAttribute("sessionOrder") && noOfUnits != null) {

            Order existingOrder = (Order) session.getAttribute("sessionOrder");
            //create order detail
            OrderDetail od = new OrderDetail();
            od.setOrderDate(Calendar.getInstance().getTime());
            od.setItemId(item);
            od.setOrderId(existingOrder);
            od.setUnitPrice(item.getUnitPrice());
            od.setOrderQantity(Integer.parseInt(noOfUnits));
            od.setTotal(od.getUnitPrice().multiply(new BigDecimal(noOfUnits)));
            od.setBillId(11411);
            existingOrder.getOrderDetailCollection().add(od);
            session.setAttribute("sessionOrder", existingOrder);
            RequestDispatcher rd = request.getRequestDispatcher("order_overview.jsp");
            rd.include(request, response);

        }

    }

}
