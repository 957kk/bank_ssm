<%--
  @author: xkZhao
  @Create: 2021-09-18 22:33
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

<div id="all" align="center">

    <h1>dd</h1>

</div>


</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script>


    $(function () {
        $("#btn3").click(function () {
            $("#all").html("   <input type=\"hidden\" id=\"acc\" value=\"${accountId}\">\n" +
                "    姓名：<input type=\"date\" name=\"tradeTime1\" id=\"t1\" required><br>\n" +
                "    密码：<input type=\"date\" name=\"tradeTime2\" id=\"t2\" required><br>\n" +
                "    <input type=\"button\" id=\"ss\" value=\"查询\">\n" +
                "    <table id=\"tb\" border=\"1px\" hidden>\n" +
                "    </table>")
        })
        $("#ss").click(function () {
            alert("aa")
            //$("#all")
            var accountId = $("#acc").val();
            var t1 = $("#t1").val();
            var t2 = $("#t2").val();
            var month = 30 * 24 * 1000 * 60 * 60;
            var day = 24 * 1000 * 60 * 60;
            var a = t1.split("-");
            var b = t2.split("-");
            var bt = (b[1] - 1) * month + (b[2] * day);
            var at = (a[1] - 1) * month + (a[2] * day);
            if (bt >= at) {
                alert(bt - at)
                if (b[0] == a[0]) {
                    if ((bt - at) < month) {
                        var str = {"accountId": accountId, "tradeTime1": t1, "tradeTime2": t2};
                        alert(str)
                        //发送异步调用
                        $.ajax({
                            //请求方式：POST请求
                            type: "POST",
                            //请求的地址
                            url: "STBAT",
                            //请求参数（也就是请求内容）
                            data: JSON.stringify(str),
                            //响应正文类型
                            dataType: "json",
                            //请求正文的MIME类型
                            contentType: "application/json",
                            success: function (data) {
                                let titles = " <tr>\n" +
                                    "            <th>转账状态</th>\n" +
                                    "            <th>转账金额</th>\n" +
                                    "            <th>转账时间</th>\n" +
                                    "            <th>所转账户</th>\n" +
                                    "        </tr>";
                                for (let i = 0; i < data.length; i++) {
                                    titles += "<tr>\n" +
                                        "    <td>" + data[i].tradeType + "</td>\n" +
                                        "    <td>" + data[i].tradeMoney + "</td>\n" +
                                        "    <td>" + data[i].tradeTimeStr + "</td>\n" +
                                        "    <td>" + data[i].digest + "</td>\n" +
                                        "</tr>";
                                }
                                //添加到页面
                                $("#tb").html(titles);
                                $("#tb").show();
                            },
                        });
                    }
                }
            } else {
                alert("错误的时间范围，请重输！")
            }
        });
    });


</script>
</html>
