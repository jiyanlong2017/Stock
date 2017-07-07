/**
 * Created by jiyanlong on 2017/3/8.
 *
 */
//ajax全局变量设置
(function ($) {
    //ajax全局配置：调用不使用缓存；超时时间：20秒
    $.ajaxSetup({
        cache: false,
        timeout: 20000,
        beforeSend: function (XMLHttpRequest) {
            layer.load();
        },
        complete: function (XMLHttpRequest, textStatus) {
            layer.closeAll('loading');

        }
    });

   /* //easyui grid全局设置
    jQuery.extend(jQuery.fn.datagrid.defaults, {
        loadMsg: "",
        width: 'auto',
        height: 'auto',
        nowrap: false,
        fitColumns: true,    //适应列宽
        rownumbers: true,   //是否显示行号
        singleSelect: true,  //是否单选
        pagination: true,    //是否显示分页
        pageSize: 15,        //每页行数
        pageList: [10, 15, 20],   //是否显示一个每页行数的下拉选择框，“[]”中设置选择项
        onLoadSuccess: function (data) {
            if (data.rows.length == 0) {
                var body = $(this).data().datagrid.dc.body2;
                body.find('table tbody').append('<tr><td width="' + body.width() + '" style="height: 25px; text-align: center;" colspan="6">没有数据</td></tr>');
            }
        }
    });

    //easyui pager全局设置
    jQuery.extend(jQuery.fn.pagination.defaults, {
        layout: ['list', 'sep', 'first', 'prev', 'sep', 'links', 'sep', 'next', 'last', 'sep', 'refresh']
    });*/

})(jQuery);


// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}