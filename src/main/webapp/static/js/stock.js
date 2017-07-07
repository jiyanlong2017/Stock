/**
 * Created by jiyanlong on 2017/3/14.
 */

function searchStock(){
    var stockcode = $("#searchStock").val();
    var url = ctx + "/stock/searchStock";

    var myChart = echarts.init(document.getElementById('main'));


    // 使用刚指定的配置项和数据显示图表。


   $.post(url, {key: stockcode}, function(value){
        var myChart = echarts.init(document.getElementById('main'));


        var list = value.data;
        var xAxisdatalist = new Array();
        var openpricelist = new Array();
        var closepricelist = new Array();
        var heightpricelist = new Array();
        var lowpricelist = new Array();
        var tradeNumlist = new Array();
        var stockname;
        for(var i = 0; i < list.length; i++){
            var time = new Date(list[i].date).Format("MM-dd");
            stockname = list[i].stockName;
            var openprice = list[i].openPrice;
            var closePrice = list[i].closePrice;
            var maxPrice = list[i].maxPrice;
            var minPrice = list[i].minPrice;
            xAxisdatalist.push(time);
            openpricelist.push(openprice);
            closepricelist.push(closePrice);
            heightpricelist.push(maxPrice);
            lowpricelist.push(minPrice);
            tradeNumlist.push(list[i].tradeNum)
        }

       // 指定图表的配置项和数据
       var option = {
           title: {
               text: stockname
           },
           tooltip: {},
           legend: {
               data:['开盘价', "收盘价", "最高价", "最低价", "成交量"]
           },
           grid: [
               {
                   left: '10%',
                   right: '8%',
                   height: '50%'
               },
               {
                   left: '10%',
                   right: '8%',
                   top: '63%',
                   height: '16%'
               }
           ],
           xAxis: [{
               scale:true,
               data:xAxisdatalist
           },{
               type:'category',
               gridIndex:1,
               data:xAxisdatalist
           }],
           yAxis: [{
               scale: true

           },{
               scale: true,
               gridIndex: 1,
               boundaryGap : false,
               axisLine: {onZero: false},
               axisTick: {show: false},
               splitLine: {show: false},
               axisLabel: {show: false},
           }],
           series: [{
               name: '开盘价',
               type: 'line',
               data: openpricelist
           },{
               name: '收盘价',
               type: 'line',
               data: closepricelist
           },{
               name: '最高价',
               type: 'line',
               data: heightpricelist
           },{
               name: '最低价',
               type: 'line',
               data: lowpricelist
           },{
               name: '成交量',
               type: 'bar',
               xAxisIndex: 1,
               yAxisIndex: 1,
               data: tradeNumlist
           }],
           dataZoom: [
               {
                   type: 'slider',
                   xAxisIndex: [0, 1],
                   start: 80,
                   end: 100
               },
               {
                   type: 'inside',
                   xAxisIndex: [0, 1],
                   start: 10,
                   end: 60
               },
               {
                   type: 'slider',
                   yAxisIndex: 0,
                   start: 0,
                   end: 100
               }/*,
               {
                   type: 'inside',
                   yAxisIndex: 0,
                   start: 30,
                   end: 80
               }*/
           ]
       };
       myChart.setOption(option);
    });

}