<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>综合支撑系统</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5.1/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5.1/themes/default/easyui.css" type="text/css"></link>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5.1/themes/icon.css" type="text/css"></link>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/style/main.css">
<script type="text/javascript">
var treeData = <%=request.getAttribute("treeJson") %>;

function createFrame(url) {
    var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
    return s;
}
function tabClose() {
    /*双击关闭TAB选项卡*/
    $(".tabs-inner").dblclick(function () {
        var subtitle = $(this).children("span").text();
        $('#tabs').tabs('close', subtitle);
    })

    $(".tabs-inner").bind('contextmenu', function (e) {
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY,
        });

        var subtitle = $(this).children("span").text();
        $('#mm').data("currtab", subtitle);

        return false;
    });
}
function addTab(subtitle, url) {
    if (!$('#tabs').tabs('exists', subtitle)) {
        $('#tabs').tabs('add', {
            title: subtitle,
            content: createFrame(url),
            closable: true,
            width: $('#mainPanle').width()-10 ,
            height: $('#mainPanle').height()-26
        });
    } else {
        $('#tabs').tabs('select', subtitle);
    }
    tabClose();
}

$(function(){
	$('#help_tree').tree({
		checkbox: false,
		animate:true,
		lines:true,
		data: treeData,
		onClick:function(node) {
			if (node.attributes && node.attributes.menuUrl) {
				addTab(node.text, '<%=request.getContextPath() %>' +  node.attributes.menuUrl);
			} 
		},
		formatter: function(node) {
			return node.text + "-";
		}
	});
	$('#show_win').panel({
				fit:true,
				border:false,
				noheader:false
	});
});
</script>
</head>
<body class="easyui-layout">

<div data-options="region:'north'" style="height:70px;overflow:hidden;">
	<div class="top-bg">
		<table width=100% height="80">
				<tr>
					<td align="left">
						<h1>
							<p align="left"
									style="filter: shadow (   color =     #111000, direction =     135, strength :     3 ); font-size: 20px; color: #0000C6; font-weight: bold; padding-right: 100px; font-style: italic">
									&nbsp; &nbsp;综合支撑系统
							</p>
						</h1>
					</td>
					<td width="281" valign="bottom">
						<div id="login_user_info">欢迎你：${currentUser.name}. <a href="<%=request.getContextPath() %>/app/logout">退出</a></div>
					</td>
				</tr>
		</table>
	</div>
</div>


<div data-options="region:'west',split:true,title:'导航窗口',iconCls:'icon-help'" style="width:248px;padding:5px; text-align:left;">
	<ul id="help_tree" class="easyui-tree"></ul>
</div>
<div data-options="region:'center'" style="overflow: hidden; ">
  <div id="tabs" class="easyui-tabs" fit="true" border="false">
		<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">
			<h1>
				欢迎您登录系统。
			</h1>
		</div>
	</div>
</div>

<script>
setInterval(function() {
	var url = '<%=request.getContextPath() %>/app/checkSession';
	$.get(url, function(result) {
		if (! result.successful) {
			window.location.href="<%=request.getContextPath() %>";
		}
	}, 'json');
}, 60000);
</script>
</body>
</html>
