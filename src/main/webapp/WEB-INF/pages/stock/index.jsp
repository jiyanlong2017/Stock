<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/14
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/taglibs.jsp"%>
<html>
<head>
    <title>首页</title>
    <script src="${ctx}/js/echarts.min.js"></script>
</head>
<body>

<input id="searchStock" name="searchStock" placeholder="输入股票代码">
<button onclick="searchStock()">查询</button>
<a href="${ctx}/stock/grabtodaty" target="_blank">数据抓取</a>

<div id="main" style="width: 98%;height:600px;"></div>
<script type="text/javascript">

</script>
</body>
</html>
