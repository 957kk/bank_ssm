<%--
  @author: xkZhao
  @Create: 2021-09-16 20:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>【${accountId}用户】，欢迎您登录个人网上银行系统</h3>
<div align="center">
    <h1>操作菜单</h1>
    <input type="hidden" id="in" value="${accountId}">
    <button type="button" id="btn1">个人首页</button>
    <button type="button" id="btn2">账户余额查询</button>
    <button type="button" id="btn3">交易记录查询</button>
    <button type="button" id="btn4">行内单笔转账</button>
</div>

<div id="remaining">

</div>

</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        $("#btn1").click(function () {
            var accountId = $("#in").val();
            alert(accountId)
            var str = {"accountId": accountId};
            $.ajax({
                //请求方式：POST请求
                type: "POST",
                //请求的地址
                url: "selectByAccountId",
                //请求参数（也就是请求内容）
                data: JSON.stringify(str),
                //响应正文类型
                dataType: "json",
                //请求正文的MIME类型
                contentType: "application/json",
                success: function (data) {
                    alert(data)
                    alert(data[0]
                    )
                    let titles = "";
                    for (let i = 0; i < data.length; i++) {
                        titles += " <h5>" + data[i] + "</h5>"
                    }
                    //添加到页面
                    $("#remaining").html(titles);

                },
            });

        })

    })
</script>
</html>
