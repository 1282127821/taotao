/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-15 09:32:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class item_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<link href=\"/js/kindeditor/themes/default/default.css\" type=\"text/css\" rel=\"stylesheet\"/>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/js/kindeditor/kindeditor-all-min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/js/kindeditor/lang/zh_CN.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t/** 定义编辑器全局参数 */\r\n");
      out.write("\tvar kingEditorParams = {\r\n");
      out.write("\t\tfilePostName  : \"pic\",   // 文件上传请求参数name名称  \r\n");
      out.write("\t\tuploadJson : '/pic/upload',// 请求地址\r\n");
      out.write("\t\tdir : \"image\" // 指定为图片\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t/** 获取该页面对应的div容器 */\r\n");
      out.write("\t\tvar itemAddDiv = $(\"#item-add\"); \r\n");
      out.write("\t\t/** 创建富文本编辑器 */\r\n");
      out.write("\t\twindow.itemAddEditor = KindEditor.create(itemAddDiv.find(\"textarea[name=desc]\"),\r\n");
      out.write("\t\t\t\tkingEditorParams);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/** 为选择物品类目按钮绑定点击事件 */\r\n");
      out.write("\t\titemAddDiv.find(\".selectItemCat\").click(function(){\r\n");
      out.write("\t\t\t/** 创建div作为弹出窗口  <div style='padding:5px'><ul></ul></div>*/\r\n");
      out.write("   \t\t\tvar div = $(\"<div/>\").css({padding:\"5px\"}).append(\"<ul/>\");\r\n");
      out.write("\t\t\t/** 把div转化成window */\r\n");
      out.write("   \t\t\tdiv.window({\r\n");
      out.write("   \t\t\t\twidth : 500, // 宽度\r\n");
      out.write("   \t\t\t    height : 450, // 高度\r\n");
      out.write("   \t\t\t    modal : true, // 模态窗口\r\n");
      out.write("   \t\t\t    closed : true, // 是否可以关闭\r\n");
      out.write("   \t\t\t    iconCls : 'icon-save', // 图标\r\n");
      out.write("   \t\t\t    title : '选择物品类目', // 标题\r\n");
      out.write("   \t\t\t    onOpen : function(){ // 监听打开窗口事件\r\n");
      out.write("   \t\t\t    \t/** 从div中找ul，再把ul转化成树容器  */\r\n");
      out.write("   \t\t\t    \tdiv.find(\"ul\").tree({\r\n");
      out.write("   \t\t\t    \t\turl : '/itemcat', // 请求URL\r\n");
      out.write("   \t\t\t    \t\tmethod :'get', // 请求方式\r\n");
      out.write("   \t\t\t    \t\tanimate : true, // 动画效果\r\n");
      out.write("   \t\t\t    \t\tonClick : function(node){ // 为点击树节点绑定事件\r\n");
      out.write("   \t\t\t    \t\t\t/** 判断树节点是不是叶节点 */\r\n");
      out.write("   \t\t\t    \t\t\tif($(this).tree(\"isLeaf\", node.target)){\r\n");
      out.write("   \t\t\t    \t\t\t\t/** 设置id到隐藏表单中 */\r\n");
      out.write("   \t\t\t    \t\t\t\titemAddDiv.find(\"input[name=cid]\").val(node.id);\r\n");
      out.write("   \t\t\t    \t\t\t\t/** 设置显示文体 */\r\n");
      out.write("   \t\t\t    \t\t\t\titemAddDiv.find(\"#cid_span\").text(node.text);\r\n");
      out.write("   \t\t\t    \t\t\t\t/** 关闭窗口 */\r\n");
      out.write("   \t\t\t    \t\t\t\tdiv.window('close');\r\n");
      out.write("   \t\t\t    \t\t\t}\r\n");
      out.write("   \t\t\t    \t\t}\r\n");
      out.write("   \t\t\t    \t});\r\n");
      out.write("   \t\t\t    },\r\n");
      out.write("   \t\t\t    onClose : function(){ // 监听关闭窗口事件\r\n");
      out.write("   \t\t\t    \t$(this).window(\"destroy\"); // 消毁窗口\r\n");
      out.write("   \t\t\t    }\r\n");
      out.write("   \t\t\t}).window('open'); // 打开窗口\r\n");
      out.write("   \t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/** 为提交按钮绑定点击事件 */\r\n");
      out.write("\t\titemAddDiv.find(\"#submitBtn\").click(function(){\r\n");
      out.write("\t\t\t/** 校验表单 */\r\n");
      out.write("\t\t\tif(!itemAddDiv.find('#itemAddForm').form('validate')){\r\n");
      out.write("\t\t\t\t$.messager.alert('提示','表单还未填写完成!',\"warning\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t/** 计算出价格，存入隐藏的表单中 */\r\n");
      out.write("\t\t\t\titemAddDiv.find(\"input[name=price]\")\r\n");
      out.write("\t\t\t\t\t\t.val(eval(itemAddDiv.find(\"input[name=priceView]\").val()) * 100);\r\n");
      out.write("\t\t\t\t/** 同步富文本编辑器中的数据到textarea中 */\r\n");
      out.write("\t\t\t\titemAddEditor.sync();\r\n");
      out.write("\t\t\t\t/** 异步添加商品 */\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t   type : \"post\",\r\n");
      out.write("\t\t\t\t   url : \"/item/save\",\r\n");
      out.write("\t\t\t\t   data : itemAddDiv.find(\"#itemAddForm\").serialize(),\r\n");
      out.write("\t\t\t\t   success : function(){\r\n");
      out.write("\t\t\t\t\t   $.messager.alert('提示','新增商品成功!',\"warning\");\r\n");
      out.write("\t\t\t\t   },\r\n");
      out.write("\t\t\t\t   error: function(){\r\n");
      out.write("\t\t\t\t\t   $.messager.alert('提示','新增商品失败!',\"warning\");\r\n");
      out.write("\t\t\t\t   }\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/** 为重置按钮绑定点击事件 */\r\n");
      out.write("\t\titemAddDiv.find(\"#resetBtn\").click(function(){\r\n");
      out.write("\t\t\t/** 重置表单 */\r\n");
      out.write("\t\t\titemAddDiv.find(\"#itemAddForm\").form('reset');\r\n");
      out.write("\t\t\t/** 设置富文本编辑器中的内容为空 */\r\n");
      out.write("\t\t\titemAddEditor.html('');\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 初始化图片上传\r\n");
      out.write("\t\titemAddDiv.find(\".picFileUpload\").click(function(){\r\n");
      out.write("\t\t\t/** 获取表单 */\r\n");
      out.write("       \t\tvar form = itemAddDiv.find(\"#itemAddForm\");\r\n");
      out.write("\t\t\t/** 加载文件上传插件,监听文件上传 */\r\n");
      out.write("       \t\tKindEditor.editor(kingEditorParams).loadPlugin('multiimage',function(){\r\n");
      out.write("       \t\t\t/** 富文本编辑器对象 */\r\n");
      out.write("       \t\t\tvar editor = this;\r\n");
      out.write("       \t\t\t/** 文件上传插件 */\r\n");
      out.write("       \t\t\teditor.plugin.multiImageDialog({\r\n");
      out.write("       \t\t\t\t/** 为全部插件按钮绑定事件 */\r\n");
      out.write("\t\t\t\t\tclickFn : function(urlList) {\r\n");
      out.write("\t\t\t\t\t\titemAddDiv.find(\".pics li\").remove();\r\n");
      out.write("\t\t\t\t\t\tvar imgArr = new Array();\r\n");
      out.write("\t\t\t\t\t\t$.each(urlList, function(i, data) {\r\n");
      out.write("\t\t\t\t\t\t\timgArr.push(data.url);\r\n");
      out.write("\t\t\t\t\t\t\titemAddDiv.find(\".pics ul\").append(\"<li><a href='\"+ data.url +\"' target='_blank'><img src='\"+data.url+\"' width='80' height='50' /></a></li>\");\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t/** 把上传的文件地址存入input元素，为保存做准备 */\r\n");
      out.write("\t\t\t\t\t\tform.find(\"input[name=image]\").val(imgArr.join(\",\"));\r\n");
      out.write("\t\t\t\t\t\t/** 隐藏文件上传对话框 */\r\n");
      out.write("\t\t\t\t\t\teditor.hideDialog();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("       \t\t});\r\n");
      out.write("       \t});\r\n");
      out.write("\t});\t\r\n");
      out.write("</script>\r\n");
      out.write("<div style=\"padding:5px 5px 5px 5px\" id=\"item-add\">\r\n");
      out.write("\t<form id=\"itemAddForm\" class=\"itemForm\" method=\"post\">\r\n");
      out.write("\t    <table cellpadding=\"3\">\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>商品类目:</td>\r\n");
      out.write("\t            <td>\r\n");
      out.write("\t            \t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton selectItemCat\">选择类目</a>\r\n");
      out.write("\t            \t<span id=\"cid_span\"></span>\r\n");
      out.write("\t            \t<input type=\"hidden\" name=\"cid\" style=\"width: 280px;\"></input>\r\n");
      out.write("\t            </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>商品标题:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\" type=\"text\" name=\"title\" \r\n");
      out.write("\t            \t\tdata-options=\"required:true\" style=\"width: 280px;\"></input></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>商品卖点:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\" name=\"sellPoint\" \r\n");
      out.write("\t            \t\tdata-options=\"multiline:true,validType:'length[0,150]'\" \r\n");
      out.write("\t            \t\tstyle=\"height:60px;width: 280px;\"></input></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>商品价格:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-numberbox\" type=\"text\" name=\"priceView\" \r\n");
      out.write("\t            \t\tdata-options=\"min:1,max:99999999,precision:2,required:true\" \r\n");
      out.write("\t            \t\tstyle=\"width: 280px;\"/>\r\n");
      out.write("\t            \t<input type=\"hidden\" name=\"price\"/>\r\n");
      out.write("\t            </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>库存数量:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-numberbox\" type=\"text\" name=\"num\" \r\n");
      out.write("\t            \t\tdata-options=\"min:1,max:99999999,precision:0,required:true\" \r\n");
      out.write("\t            \t\tstyle=\"width: 280px;\"/></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>条形码:</td>\r\n");
      out.write("\t            <td>\r\n");
      out.write("\t                <input class=\"easyui-textbox\" type=\"text\" name=\"barcode\" \r\n");
      out.write("\t                \tdata-options=\"validType:'length[1,30]'\" \r\n");
      out.write("\t                \tstyle=\"width: 280px;\"/>\r\n");
      out.write("\t            </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>商品图片:</td>\r\n");
      out.write("\t            <td>\r\n");
      out.write("\t            \t <a href=\"javascript:void(0)\" class=\"easyui-linkbutton picFileUpload\">上传图片</a>\r\n");
      out.write("\t            \t <div class=\"pics\"><ul></ul></div>\r\n");
      out.write("\t                 <input type=\"hidden\" name=\"image\"/>\r\n");
      out.write("\t            </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>商品描述:</td>\r\n");
      out.write("\t            <td>\r\n");
      out.write("\t                <textarea style=\"width:800px;height:300px;visibility:hidden;\" name=\"desc\"></textarea>\r\n");
      out.write("\t            </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t    </table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<div style=\"padding:5px\">\r\n");
      out.write("\t    <a class=\"easyui-linkbutton\" \r\n");
      out.write("\t    \t\tdata-options=\"iconCls:'icon-ok'\" id=\"submitBtn\">提交</a>\r\n");
      out.write("\t    <a class=\"easyui-linkbutton\" \r\n");
      out.write("\t    \t\tdata-options=\"iconCls:'icon-no'\" id=\"resetBtn\">重置</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
