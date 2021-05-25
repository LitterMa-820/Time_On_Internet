<%@ page import="dao.UseTimeInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>how many time are use in Internet</title>
    <script src="https://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <style>
        body{
            background-image: linear-gradient(to top, #fff1eb 0%, #ace0f9 100%);
            background-size:cover;
            background-attachment:fixed;
        }
    </style>
    <script src="echarts/echarts.min.js"></script>

</head>
<body>
<div  id="main1" style="width: 1450px;height: 700px;">
</div>
<script type="text/javascript">
    window.onload=function () {
        var myChart = echarts.init(document.getElementById('main1'));
        option = {
            title: {
                text: '用户使用网络时长统计',
                subtext: '基于MapReduce和hbase的大数据统计',
                left: 'center',
                top:30
            },
            tooltip: {
                trigger: 'item',
                formatter: '{a} <br/>{b}: {c}人 ({d}%)'
            },
            legend: {
                bottom:150,
                left:1000,
                orient: 'vertical',
            },
            series: [
                {
                    name: '使用时长以及统计人数',
                    type: 'pie',
                    radius: '50%',
                    data: [
                        {value: ${Time["0-2"]}, name: '0-2小时'},
                        {value: ${Time["2-5"]}, name: '2-5小时'},
                        {value: ${Time["5-8"]}, name: '5-8小时'},
                        {value: ${Time["8--"]}, name: '8--小时'},
                    ],
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myChart.setOption(option);
    }
</script>
</body>
</html>
