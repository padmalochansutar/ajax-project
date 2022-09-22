package com.csmtech.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.csmtech.dbutil.DbUtil;
import com.csmtech.entity.Cities;
import com.csmtech.entity.States;

public class GetCitiesByStateId extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		Integer sId=Integer.parseInt(req.getParameter("stateId"));
		Session session=DbUtil.getSessionFactory().openSession();
		List<Cities> citiesList=session.createQuery("from Cities where stateId="+sId).list();
		String t="";
		for(Cities ct:citiesList) {
			t+="<option value='"+ct.getCityId()+"'>"+ct.getName()+"</option>";
		}
		pw.println(t);
	}
	}


