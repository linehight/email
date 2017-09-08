<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>邮件群发</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		body{background: url("images/3.jpg");background-size:cover; }
		.re_box{width:400px;margin:0px auto;border:0px solid blue;}
		.re_box h1{font-size: 30px;text-align: center;text-shadow: 2px 5px 5px rgba(0,0,0,1);color: #000;}
		.re_box p{width:398px;line-height: 40px; height: 40px;background: #2c2c29;border-radius:6px;border: 1px solid #222220;}
		.re_box span{display: block;width:80px;height: 40px;float: left;background: #373733;color: #fff;}
		.re_box .input_box{float: left;width: 260px;height: 29px;background: #2c2c29;color: #fff;border: 0px;}
		.input_btn{width: 400px;height: 40px;margin-top: 10px;background: #3c9;font-size: 18px;color: #fff;cursor: pointer;}
		textarea{border-radius:6px;background: #2c2c29;border: 1px solid #222220;color: #fff;}
	</style>
  </head>
  
  <body>
    <div class="re_box">
    	<h1>邮件发送系统</h1>
    	<form action="MailServlet" method="post">
    		<p><span>收件人:</span><input class="input_box" name="uto"/></p>
    		<p><span>标题:</span><input class="input_box" name="utopic"/></p>
    		<p style="height:150px;">
    			<textarea rows="9" cols="50" name="ucontent"></textarea>
    		</p>
    		<input class="input_btn" type="submit" value="发送邮件"/>
    	</form>
    </div>
    
  </body>
</html>
