package com.csmtech.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.csmtech.dbutil.DbUtil;

public class FirstController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		//pw.println(DbUtil.getSessionFactory().openSession());
		//pw.print("hello ajax");
		Session session=DbUtil.getSessionFactory().openSession();
		req.setAttribute("countryList", session.createQuery("from Countries").list());
		
		//req.setAttribute("stateList", session.createQuery("from States ").list());
		//req.setAttribute("citiesList", session.createQuery("from Cities").list());
	
		req.getRequestDispatcher("myAddress.jsp").forward(req, resp);
	}

}
