/**
 * Created by jiyanlong on 2016/4/10.
 */
//easyui grid全局设置
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