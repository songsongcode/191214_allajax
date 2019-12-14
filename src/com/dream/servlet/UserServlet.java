package com.dream.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.dto.UsersDTO;
import com.dream.service.IUserBiz;
import com.dream.service.UserBizImpl;
import com.dream.vo.Page;
import com.dream.vo.User;
import com.google.gson.Gson;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String uage = request.getParameter("uage");
		String usex = request.getParameter("usex");
		String uphone = request.getParameter("uphone");
		String currentpage = request.getParameter("currentpage");
		IUserBiz iUserBiz=new UserBizImpl(); 
		if("register".equals(action)) {//注册
			User user = new User(uname,usex.charAt(0), Integer.parseInt(uage), uphone);
			iUserBiz.addUser(user);
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		if("showUsers".equals(action)) {//展示用户信息
			int count=10;
			int allpage = iUserBiz.allPage(count);
			Page page =new Page(Integer.parseInt(currentpage),count);
			List<User> users = iUserBiz.showUsers(page);
			UsersDTO usersDTO = new UsersDTO(allpage,users);
			Gson gson=new Gson();
			String usersDTO_str = gson.toJson(usersDTO);
			System.out.println("usersDTO_str:"+usersDTO_str);
			PrintWriter out = response.getWriter();
			out.write(usersDTO_str);
			out.flush(); 
			
			
		}
		if("delUser".equals(action)) {//删除用户
			iUserBiz.delUserByUid(Integer.parseInt(uid));
			response.sendRedirect("showusers.html");
		}
		if("Modify".equals(action)) {//修改信息
			User user = iUserBiz.showUserByUid(Integer.parseInt(uid));
			Gson gson=new Gson();
			String user_str = gson.toJson(user);
			System.out.println("Modify:"+user_str);
			PrintWriter out = response.getWriter();
			out.write(user_str);
			out.flush(); 
		}
		if("updateUser".equals(action)) {
			User user = new User(Integer.parseInt(uid), uname,usex.charAt(0), Integer.parseInt(uage), uphone);
			iUserBiz.updateUserByUid(user);
			response.sendRedirect("showusers.html");
		}
		
	}

}
