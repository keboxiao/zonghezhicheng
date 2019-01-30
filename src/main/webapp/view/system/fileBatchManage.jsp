<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
	<head>
		<title>共享文件管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5.1/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5.1/themes/default/easyui.css" type="text/css"></link>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5.1/themes/icon.css" type="text/css"></link>
		<script type="text/javascript">

$(function() {
	$('#grid').datagrid( {
		url : '../../app/listFileBatch',
		pageSize : 15,
		pageList : [ 15, 20, 30 ],
		columns : [ [ {
			field : 'id',
			title : '唯一标识',
			width : 70,
			align : 'center'
		}, {
			field : 'title',
			title : '主题',
			width : 200,
			align : 'center'
		}, {
			field: 'user', 
			title: '创建人', 
			align: 'center', 
			sortable: true ,
			width : 100,
	        formatter: function (value) {
	               return value.name  //班级名称
	        }
		}, {
			field : 'remark',
			title : '备注',
			width : 300,
			align : 'center'
		} ] ]
	});
});



function savebatch() {
	$.messager.confirm('确认', '您确定要保存？', function(r) {
		$.ajax( {
			type : 'POST',
			url : '../../app/updateFileBatch',
			data : $('#batchForm').serialize(),
			dataType : 'json',
			success : function(r) {
				$.messager.show( {
					title : '提示',
					msg : r.msg
				});
				$("#dlgDetails").dialog("close");
				$("#grid").datagrid("load");
			}
		});
	});
}

serializeObject = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};

function searchFun() {
	$('#grid').datagrid('load', serializeObject($('#admin_yhgl_searchForm')));
}
function clearFun() {
	$('#title').textbox('setValue', '');
	$('#grid').datagrid('load', {});
}


function addBatch() {
	url = "commit_detail.jsp";		
    var content = '<iframe src="' + url + '" width="100%" height="99%" frameborder="0" scrolling="no"></iframe>';  
    var boarddiv = '<div id="msgwindow" ></div>'//style="overflow:hidden;"可以去掉滚动条  	    
    $(document.body).append(boarddiv);  
    var win = $('#msgwindow').dialog({  
        content: content,  
        width: 900,  
        height: 500,  
        modal: true, 
        title: "新增共享资料",  
        onClose: function () {  
            $(this).dialog('destroy');//后面可以关闭后的事件  
        }  
    });  
    win.dialog('open');
}

function editBatch() {
	var rowsData = $('#grid').datagrid('getSelections');
	if (!rowsData || rowsData.length==0) {
		tip('请选择一行数据');
		return;
	}		
	if (rowsData.length>1) {
		tip('请选择一行数据');
		return;
	}	
	var row = rowsData[0];
	if (row) {
		$("#dlgDetails").dialog("open").dialog('setTitle', '修改');
		$("#batchForm").form("load", row);
		$("#batch_no").attr('value',row.id);
		$('#filegrid').datagrid( {
			url : '../../app/listFileByBatchId?id='+row.id,
			striped : true,
			rownumbers : true,
			singleSelect:true,
			fitColumns: false,
			columns : [ [ {
				field : 'filename',
				title : '文件名',
				width : 200,
				align : 'center'
			}, {
				field : 'batchNo',
				title : '主题号',
				width : 200,
				align : 'center'
			}, {
				field : 'uploadTime',
				title : '上传时间',
				width : 200,
				align : 'center'
			}, {
				field:'no',
				title:'下载',
				align:'center',
				width : 100,
				formatter : function(value) {
					return "<a href='../../app/downloadById?id=" + value + "'>下载</a>";
				}
			} ] ]
		});
	}
}

function loadFile(){
	var batch_id = $("#id").val();
    $("#userForm").form('submit', {
            type:"post",  //提交方式    
            url:"../../app/springUpload", //请求url
            dataType : 'json',
			success : function(r) {
				$.messager.show( {
					title : '提示',
					msg : r.msg
				});
				$("#filegrid").datagrid("load");
			}   
     });  
}
    
function deleteById(){
	var row = $("#grid").datagrid("getSelected");
	if (row != null) {
		$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
			if (r) {
				$.ajax({
					type: 'POST',
					url : '../../app/deleteById',
					data : {
						id : row.id
					},
					dataType : 'json',
					success : function(r) {
						$('#grid').datagrid('reload');
						$('#grid').datagrid('unselectAll');
						$.messager.show({
							title : '提示',
							msg : r.msg
						});
					}
				});
			}
		});
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要删除的记录！'
		});
	}
}
</script>

	</head>
	<%@ include file="batchDetails.jsp" %>
	<body align="center">

		<div id="tb" style="padding: 3px"
			data-options="region:'north',title:'查询条件',border:false">
			<form id="admin_yhgl_searchForm">
				主题：
				<input id="title" class="easyui-textbox" name="title" />
				<a href="javascript:void(0);" id="add"
					class="easyui-linkbutton" iconCls="icon-add" onclick="addBatch()">添加</a>
				<a href="javascript:void(0);" id="edit"
					class="easyui-linkbutton" iconCls="icon-edit" onclick="editBatch()">修改</a>
				<a href="javascript:void(0);" id="edit"
					class="easyui-linkbutton" iconCls="icon-cancel" onclick="deleteById()">删除</a>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="searchFun();">查询</a>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-redo'" onclick="clearFun();">清空</a>
			</form>
		</div>
		<div>
			<table id="grid" toolbar="#tb" title="主题查询" iconCls="icon-search"
				data-options="singleSelect:true,rownumbers:true,pagination:true,striped:true"></table>
		</div>
	</body>

</html>