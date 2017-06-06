<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->

    <script src="${pageContext.request.contextPath}/assets/echarts/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/echarts/shine.js"></script>
    <script src="${pageContext.request.contextPath}/assets/echarts/vintage.js"></script>

</head>

<body>

<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
       // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'),'vintage');

       // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

</script>


</body>
</html>