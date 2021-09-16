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
<form autocomplete="off" action="${pageContext.request.contextPath}/login" method="post">
    <%--<input type="hidden" name="id" value="null">--%>
    姓名：<input type="text" name="accountId" id="accountId"><br>
    密码：<input type="password" name="password" id="password"><br>
    <input type="submit" id="ss" value="登录">
</form>

<a href="javascript:void(0);" id="testAjaxPojo">访问springmvc后台controller，传递Json格式POJO</a><br/>

</body>
<script type="text/javascript">
    $(function () {
        //为id="testAjax"的组件绑定点击事件
        /*$("#ss").submit(function () {
            //发送异步调用
            $.ajax({
                //请求方式：POST请求
                type: "POST",
                //请求的地址
                url: "login",
                //请求参数（也就是请求内容）
                data: '{"accountId":$("#a"),"password":"ss"}',
                //响应正文类型
                dataType: "text",
                //请求正文的MIME类型
                contentType: "application/json",
                success: function (data) {
                    //打印返回结果
                    alert(data);
                },
                error: function (data) {
                    alert(data);
                }
            });
        });*/
        //为id="testAjaxPojo"的组件绑定点击事件
        $("#testAjaxPojo").click(function () {
            $.ajax({
                type: "POST",
                url: "login",
                data: '{"accountId":"0370","password":0370}',
                dataType: "text",
                contentType: "application/json",
                success: function (data) {
                    //打印返回结果
                    alert(data);
                },
                error: function (data) {
                    alert(data);
                }
            });
        });
    });
</script>
</html>
