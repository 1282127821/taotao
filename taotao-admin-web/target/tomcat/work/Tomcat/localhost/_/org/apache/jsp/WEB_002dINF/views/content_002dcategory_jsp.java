/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-15 10:12:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class content_002dcategory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t/** 获取该页面对应的div容器 */\r\n");
      out.write("\t\tvar contentCategoryDiv = $(\"#content-category\"); \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/** 初始化tree树 */\r\n");
      out.write("\t\tcontentCategoryDiv.find(\"#content_category_tree\").tree({\r\n");
      out.write("\t\t\turl : '/contentcategory', // 请求URL\r\n");
      out.write("\t\t\tmethod : \"get\", // 请求方式\r\n");
      out.write("\t\t\tanimate : true, // 是否有动画效果\r\n");
      out.write("\t\t\tonContextMenu : function(e,node){// 监听上下文菜单事件\r\n");
      out.write("\t\t\t\t/** 取消事件的默认行为 */\r\n");
      out.write("\t            e.preventDefault();\r\n");
      out.write("\t\t\t\t/** 选中当前树节点 */\r\n");
      out.write("\t            $(this).tree('select',node.target);\r\n");
      out.write("\t\t\t\t/** 显示右键菜单 */\r\n");
      out.write("\t            $('#content_category_menu').menu('show',{\r\n");
      out.write("\t                left : e.pageX, // 离左边的距离\r\n");
      out.write("\t                top : e.pageY // 离上边的距离\r\n");
      out.write("\t            });\r\n");
      out.write("\t        },\r\n");
      out.write("\t        onAfterEdit : function(node){ // 监听编辑完事件\r\n");
      out.write("\t        \t/** 判断树节点id */\r\n");
      out.write("\t        \tif(node.id == 0){\r\n");
      out.write("\t        \t\t/** 异步新增树节点 */\r\n");
      out.write("\t        \t\t$.post(\"/contentcategory/save\", {parentId : node.parentId, name : node.text}, function(id){ // 返回响应数据为 id\r\n");
      out.write("\t        \t\t\tcontentCategoryDiv.find(\"#content_category_tree\").tree(\"update\",{\r\n");
      out.write("        \t\t\t\t\ttarget : node.target,\r\n");
      out.write("        \t\t\t\t\tid : id\r\n");
      out.write("        \t\t\t\t});\r\n");
      out.write("\t        \t\t});\r\n");
      out.write("\t        \t}else{\r\n");
      out.write("\t        \t\t/** 异步修改树节点 */\r\n");
      out.write("\t        \t\t$.ajax({\r\n");
      out.write("\t        \t\t\ttype : \"post\", // 请求方式\r\n");
      out.write("\t        \t\t\turl : \"/contentcategory/update\", // 请求url\r\n");
      out.write("\t        \t\t\tdata: {id : node.id, name : node.text}, // 请求参数\r\n");
      out.write("\t        \t\t\tsuccess: function(){ // 请求成功\r\n");
      out.write("\t        \t\t\t},\r\n");
      out.write("\t        \t\t\terror: function(){ // 请求失败\r\n");
      out.write("\t        \t\t\t\t$.messager.alert('提示','重命名失败!');\r\n");
      out.write("\t        \t\t\t}\r\n");
      out.write("\t        \t\t});\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/** 初始化右键菜单 */\r\n");
      out.write("\t\tcontentCategoryDiv.find(\"#content_category_menu\").menu({\r\n");
      out.write("\t\t\tonClick : function(item){ // 监听菜单点击事件\r\n");
      out.write("\t\t\t\t/** 获取树容器对象 */\r\n");
      out.write("\t\t\t\tvar treeObj = contentCategoryDiv.find(\"#content_category_tree\");\r\n");
      out.write("\t\t\t\t/** 获取选中的树节点 */\r\n");
      out.write("\t\t\t\tvar node = treeObj.tree(\"getSelected\");\r\n");
      out.write("\t\t\t\t/** 新增树节点 */\r\n");
      out.write("\t\t\t\tif(item.name === \"add\"){\r\n");
      out.write("\t\t\t\t\ttreeObj.tree('append', {\r\n");
      out.write("\t\t\t            parent: (node ? node.target : null), // 指定父级\r\n");
      out.write("\t\t\t            data: [{ // 设置新节点数据\r\n");
      out.write("\t\t\t                text: '新建分类',\r\n");
      out.write("\t\t\t                id : 0,\r\n");
      out.write("\t\t\t                parentId : node.id\r\n");
      out.write("\t\t\t            }]\r\n");
      out.write("\t\t\t        }); \r\n");
      out.write("\t\t\t\t\t/** 查找id为零的树节点 */\r\n");
      out.write("\t\t\t\t\tvar new_node = treeObj.tree('find',0);\r\n");
      out.write("\t\t\t\t\t/** 设置该节点选中，并开启编辑 */\r\n");
      out.write("\t\t\t\t\ttreeObj.tree(\"select\",new_node.target).tree('beginEdit',new_node.target);\r\n");
      out.write("\t\t\t\t}else if(item.name === \"rename\"){ // 重命名\r\n");
      out.write("\t\t\t\t\ttreeObj.tree('beginEdit',node.target);\r\n");
      out.write("\t\t\t\t}else if(item.name === \"delete\"){ // 删除\r\n");
      out.write("\t\t\t\t\t/** 确认信息 */\r\n");
      out.write("\t\t\t\t\t$.messager.confirm('确认','确定删除名为 '+ node.text +' 的分类吗？',function(r){\r\n");
      out.write("\t\t\t\t\t\tif(r){\r\n");
      out.write("\t\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t     \t\t\t   type: \"post\",\r\n");
      out.write("\t\t\t     \t\t\t   url: \"/contentcategory/delete\",\r\n");
      out.write("\t\t\t     \t\t\t   data : {parentId : node.parentId, id : node.id},\r\n");
      out.write("\t\t\t     \t\t\t   success: function(msg){\r\n");
      out.write("\t\t\t     \t\t\t\t  treeObj.tree(\"remove\", node.target);\r\n");
      out.write("\t\t\t     \t\t\t   },\r\n");
      out.write("\t\t\t     \t\t\t   error: function(){\r\n");
      out.write("\t\t\t     \t\t\t\t   $.messager.alert('提示','删除失败!');\r\n");
      out.write("\t\t\t     \t\t\t   }\r\n");
      out.write("\t\t\t     \t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div id=\"content-category\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 定义树容器 -->\r\n");
      out.write("\t<ul id=\"content_category_tree\"></ul>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 定义右键菜单容器 -->\r\n");
      out.write("\t<div id=\"content_category_menu\" style=\"width:120px;\">\r\n");
      out.write("\t    <div data-options=\"iconCls:'icon-add',name:'add'\">添加</div>\r\n");
      out.write("\t    <div data-options=\"iconCls:'icon-remove',name:'rename'\">重命名</div>\r\n");
      out.write("\t    <div class=\"menu-sep\"></div>\r\n");
      out.write("\t    <div data-options=\"iconCls:'icon-remove',name:'delete'\">删除</div>\r\n");
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