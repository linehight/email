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
		String toU=request.getParameter("uto");//�ռ���
		String uTopic=request.getParameter("utopic");//����
		String uContent=request.getParameter("ucontent");//����
		String uname="tanzhoujiaoyu";//����������
		String password="tzjava";//����������
		Properties pro=new Properties();
		pro.put("mail.transport.protocol", "smtp");//�ʼ�����Э��
		pro.put("mail.host", "smtp.163.com");//�ʼ�����������
		pro.put("mail.smtp.auth", "true");//�ʼ�����Э�鰲ȫ��֤
		Session session=Session.getInstance(pro);//����һ�������ʼ��Ự
		MimeMessage msg=new MimeMessage(session);//��֯�ʼ�
		try {
			Address toAddress=new InternetAddress("tanzhoujiaoyu@163.com");//������
//			Address[] ccAddress={new InternetAddress("tanzhoujiaoyu@163.com"),
//					new InternetAddress("tanzhoujiaoyu@163.com")
//				};
			msg.addRecipient(Message.RecipientType.TO, toAddress);
			
			
			msg.setFrom(toAddress);//ʶ������
			
			
			msg.addRecipients(Message.RecipientType.CC, toU);//���͸�˭
			msg.setSubject(uTopic);//���ͱ���
			msg.setText(uContent);//��������
			msg.saveChanges();//�����ʼ�
			Transport ts=session.getTransport();//ȡ�÷�����
			ts.connect(uname,password);
			ts.sendMessage(msg, msg.getAllRecipients());
			ts.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
