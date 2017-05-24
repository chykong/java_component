<%--
  Created by IntelliJ IDEA.
  User: chykong
  Date: 2017/5/24
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery.js"></script>
</head>
<body>
<input type="text" class="form-control" name="verifyCode" placeholder="验证码"
       id="verifyCode" style="width: 180px;"/>
<img id="verifyCodeImg"
     style="cursor: pointer;" src="" width="80" height="30" title=" 点击刷新" onclick="javascript:changeCode()">
<script type="text/javascript">

    // 点击验证码图片
		function changeCode() {
				$('#verifyCodeImg').attr('src', "generateVerifyCode.htm?random=" + Math.random());
				$("#verifyCode").val("")
		}
		$(function(){
		changeCode();
		})

</script>
</body>

</html>
