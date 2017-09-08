package com.aaa.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String toU=request.getParameter("uto");//收件人
		String uTopic=request.getParameter("utopic");//标题
		String uContent=request.getParameter("ucontent");//内容
		String uname="tanzhoujiaoyu";//发件人名称
		String password="tzjava";//发件人密码
		Properties pro=new Properties();
		pro.put("mail.transport.protocol", "smtp");//邮件传送协议
		pro.put("mail.host", "smtp.163.com");//邮件主机服务器
		pro.put("mail.smtp.auth", "true");//邮件传送协议安全认证
		Session session=Session.getInstance(pro);//定义一个基本邮件会话
		MimeMessage msg=new MimeMessage(session);//组织邮件
		try {
			Address toAddress=new InternetAddress("tanzhoujiaoyu@163.com");//发件人
//			Address[] ccAddress={new InternetAddress("tanzhoujiaoyu@163.com"),
//					new InternetAddress("tanzhoujiaoyu@163.com")
//				};
			msg.addRecipient(Message.RecipientType.TO, toAddress);
			
			
			msg.setFrom(toAddress);//识别发送者
			
			
			msg.addRecipients(Message.RecipientType.CC, toU);//发送跟谁
			msg.setSubject(uTopic);//发送标题
			msg.setText(uContent);//发送内容
			msg.saveChanges();//保存邮件
			Transport ts=session.getTransport();//取得发送器
			ts.connect(uname,password);
			ts.sendMessage(msg, msg.getAllRecipients());
			ts.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
