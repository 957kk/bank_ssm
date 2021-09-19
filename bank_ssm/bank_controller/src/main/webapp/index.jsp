<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  @author: xkZhao
  @Create: 2021-09-16 20:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>start</h1>
<form autocomplete="off">
    姓名：<input type="text" value="1234" name="accountId" id="accountId" required><br>
    密码：<input type="password" value="1234" name="password" id="password" required><br>
    <input type="button" id="ss" value="登录">
    <input type="reset" id="reset" value="重置">
</form>

</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        //为id="testAjax"的组件绑定点击事件
        $("#ss").click(function () {
            var accountId = $("#accountId").val();
            var password = $("#password").val();
            var str = {"accountId": accountId, "password": password};
            //发送异步调用
            $.ajax({
                //请求方式：POST请求
                type: "POST",
                //请求的地址
                url: "login",
                //请求参数（也就是请求内容）
                data: JSON.stringify(str),
                //响应正文类型
                dataType: "json",
                //请求正文的MIME类型
                contentType: "application/json",
                success: function (data) {
                    //alert(accountId)
                    //location = data.message;
                    if (data.code == 10001) {
                        window.location.href = "toTrade?accountId="+accountId;
                    }
                    alert(data.message)
                    $("#reset").click();
                    /* window.location.href = "index.jsp?message=" + data.message;*/
                    //打印返回结果
                },
            });
        });
    });
</script>
</html>
