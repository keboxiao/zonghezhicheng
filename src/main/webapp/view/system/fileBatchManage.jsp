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
		
			<style type="text/css">
		#mostSchemeListId,#perSchemeNumberId,#mostTimeId,#mostHopId,#delayTimeId{
			width:98%;
			height:30px;
		}
		#addDialogId{
			width:700px;height:425px;
			padding:20px 15px 15px 15px;
		}
		
		table.editTable{
		   border-collapse: collapse; 
		   width: 100%;
		   font-size: 16px;
		   /* color:#00bfff; */
		   color:#009999;
		   cellpadding : 3px;
		   text-align: right;
		   
		 }
		 
		  tr,td{
		 	border: solid 1px silver; 
		 }
		
		
		 td.oddTd{
		 	/* width:20%; */
		 	background: #eaeaea;
		 }
		
		#operatePerson,#userId,#ip_id,#port_id{
			width: 97%; height: 100%;
		}
		input#dataDomainId, input#serviceTypeIds{
			width:100%;height:30px;
		}
		#urlId{
			width: 99%; height: 100%;
		}
		textarea{
			margin-top:5px;
			resize:none;
		    height: 100%;
		    width: 100%;
		    font-size: 14px;
		    border:0;
		    overflow:hidden;
		}
		.combobox-item, .combobox-group, .combobox-stick{
			font-size:14px;
		}
		 div.save-reset{
			text-align:center;padding:5px 0;
		 }
		 button{
		 	font-size:16px;
		 }
		
	</style>
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

function test() {
	alert($('#userForm1').serialize());
}

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
	$("#dlgAdd").dialog("open").dialog('setTitle', '增加');
}

function addFileBatch() {
		$.messager.confirm('确认', '你确定要保存吗?', function(r) {
			if (r) {
				$.ajax({
					type: 'POST',
					url : '../../app/addFileBatch',
					data : $('#userForm1').serialize(),
					dataType : 'json',
					success : function(r) {
						$('#grid').datagrid('reload');
						$('#grid').datagrid('unselectAll');
						$("#dlgAdd").dialog("close");
						editBatchById(r.obj);
					}
				});
			}
		});
}

function editBatchById(row) {
	if (row) {
		$("#dlgDetails").dialog("open").dialog('setTitle', '修改');
		$("#batchForm").form("load", row);
		$("#batch_no").attr('value',row.id);
		//$("#file_class").attr('value',1);
		$('#filegrid').datagrid( {
			url : '../../app/listFileByBatchId?id='+id,
			striped : true,
			rownumbers : true,
			singleSelect:true,
			fitColumns: false,
			columns : [ [ {
				field : 'filename',
				title : '文件名',
				width : 300,
				align : 'center'
			}, {
				field : 'batchNo',
				title : '主题号',
				width : 80,
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
			url : '../../app/listFileByBatchId?id='+row.id+'&file_class=1',
			striped : true,
			rownumbers : true,
			singleSelect:true,
			fitColumns: false,
			columns : [ [ {
				field : 'filename',
				title : '文件名',
				width : 300,
				align : 'center'
			}, {
				field : 'batchNo',
				title : '主题号',
				width : 80,
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

function deleteFile(){
	var row = $("#filegrid").datagrid("getSelected");
	if (row != null) {
		$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
			if (r) {
				$.ajax({
					type: 'POST',
					url : '../../app/deleteUpFile',
					data : {
						id : row.no
					},
					dataType : 'json',
					success : function(r) {
						$('#filegrid').datagrid('reload');
						$('#filegrid').datagrid('unselectAll');
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
<% boolean flag = true; %>
	</head>
	<%@ include file="batchDetails.jsp" %>
	<%@ include file="commit_detail.jsp" %>
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
					data-options="iconCls:'icon-redo'" onclick="clearFun();">重置</a>
			</form>
		</div>
		<div>
			<table id="grid" toolbar="#tb" title="主题查询" iconCls="icon-search"
				data-options="singleSelect:true,rownumbers:true,pagination:true,striped:true"></table>
		</div>
	</body>

</html>