<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->

    <script src="${pageContext.request.contextPath}/assets/echarts/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/echarts/vintage.js"></script>
    <script src="${pageContext.request.contextPath}/assets/jquery-1.7.1.min.js"></script>

</head>

<body>

<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
       // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'),'vintage');
// 显示标题，图例和空的坐标轴
myChart.setOption({
    title: {
        text: '异步数据加载示例'
    },
    tooltip: {},
    legend: {
        data:['销量']
    },
    xAxis: {
        data: []
    },
    yAxis: {},
    series: [{
        name: '销量',
        type: 'bar',
        data: []
    }]
});
myChart.showLoading();
// 异步加载数据
$.get('getData.htm').done(function (json) {
     myChart.hideLoading();
       var data = eval('('+json + ')');
    // 填入数据
    myChart.setOption({
        xAxis: {
            data: data.categories
        },
        series: [{
            // 根据名字对应到相应的系列
            name: '销量',
            data: data.data
        }]
    });

});

        // 使用刚指定的配置项和数据显示图表。
       myChart.setOption(option);



</script>


</body>
</html>