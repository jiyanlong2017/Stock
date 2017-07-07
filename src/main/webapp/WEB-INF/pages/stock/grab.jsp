<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/8
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/taglibs.jsp"%>
<html>
<head>
    <title>股票名称</title>
</head>
<body>
<button onclick="grab()">股票代码抓取</button>
<button onclick="grabHistory()">股票当日交易数据抓取</button>
<button onclick="grabData()">抓取A股所以股票两年的数据</button>
</body>

<script type="text/javascript">
    function grab(){
        var url = "${ctx}/stock/grab";
        //console.log(url);
        $.get(url, function(value){

        });
    }

    function grabHistory(){
        var url = "${ctx}/stockHistory/grabToday";
        $.get(url);
    }

    function grabData(){
        var url = "${ctx}/stockHistory/history";
        $.get(url);
    }

</script>
</html>
