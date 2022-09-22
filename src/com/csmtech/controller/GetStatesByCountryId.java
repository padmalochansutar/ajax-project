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
import com.csmtech.entity.States;

public class GetStatesByCountryId extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		Integer cId=Integer.parseInt(req.getParameter("countryId"));
		System.out.println(cId);
		Session session=DbUtil.getSessionFactory().openSession();
		List<States> stateList=session.createQuery("from States where countryId="+cId).list();
		String t="";
		for(States st:stateList) {
			t+="<option value='"+st.getStateId()+"'>"+st.getName()+"</option>";
		}
		pw.println(t);
	}

}
