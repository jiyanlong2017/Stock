<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${ctx}/easyui/jquery.min.js" ></script>
<script type="text/javascript" src="${ctx}/lib/layer/layer.js" ></script>
<script type="text/javascript" src="${ctx}/js/app.js" ></script>
<script type="text/javascript" src="${ctx}/js/stock.js" ></script>
<script type="text/javascript">
    var ctx = "${ctx}";
</script>