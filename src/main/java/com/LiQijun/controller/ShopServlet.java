package com.LiQijun.controller;

import com.LiQijun.dao.IProductDao;
import com.LiQijun.dao.ProductDao;
import com.LiQijun.model.Category;
import com.LiQijun.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set all category into request
        Category category=new Category();
        List<Category> categoryList= null;
        try {
            categoryList = category.findAllCategory(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("categoryList",categoryList);
        //set all  product into request
        ProductDao productDao=new ProductDao();
        List<Product>productList= null;
        try {
            if(request.getParameter("categoryId")==null){
                //show all product
                productList = productDao.findAll(con);
            }else{
                //show only one type of product
                int categoryId=Integer.parseInt(request.getParameter("categoryId"));
                productList=productDao.findByCategoryId(categoryId,con);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("productList",productList);
        String path="/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
        //forward
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
