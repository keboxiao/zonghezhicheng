<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请登录</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5.1/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5.1/themes/default/easyui.css" type="text/css"></link>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5.1/themes/icon.css" type="text/css"></link>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/style/main.css">
</head>
<body>

<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		buttons="#dlg-buttons" modal="true" title="请登录" closable="false">
    <div class="ftitle">请输入登陆信息</div>
    <form id="loginform" method="post" action="<%=request.getContextPath() %>/login">
        <div class="fitem">
            <label>登录名:</label>
            <input type="text" name="username" class="easyui-validatebox" required="true" />
        </div>
        <div class="fitem">
            <label>密码:</label>
            <input type="password" name="password" class="easyui-validatebox" required="true"  />
        </div>
        
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="login()">登陆</a>
</div>

<script type="text/javascript">
function login() {
	
	$('#loginform').form('submit', {
		url: '<%=request.getContextPath() %>/app/login',
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			result = eval('(' + result + ')');
			
			if (result.successful) {
				window.location.href="<%=request.getContextPath() %>";	
			} else {
				$.messager.show({title: '操作结果',msg: result.msg});
			}
		}
	});
}
</script>

</body>
</html>