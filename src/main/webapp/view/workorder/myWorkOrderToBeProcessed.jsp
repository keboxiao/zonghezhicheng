<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
	<head>
		<title>我的待办</title>
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
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/dlgtable.css" type="text/css"></link>

		<script type="text/javascript">

$(function() {
	$('#grid').datagrid( {
		url : '../../app/listMyWorkOrderToBeProcessed',
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
			field: 'affectScope', 
			title: '影响范围', 
			align: 'center', 
			width : 100,
			align : 'center'
		}, {
			field : 'serviceType',
			title : '业务类型',
			width : 100,
			align : 'center'
		} , {
			field : 'contacts',
			title : '联系人',
			width : 100,
			align : 'center'
		}, {
			field : 'tel',
			title : '联系电话',
			width : 100,
			align : 'center'
		}, {
			field : 'firstSystem',
			title : '首要系统',
			width : 100,
			align : 'center'
		}, {
			field : 'appearance',
			title : '现象',
			width : 100,
			align : 'center'
		}, {
			field : 'influence',
			title : '影响',
			width : 100,
			align : 'center'
		}] ]
	});
});

function processbatch() {
	var objRows = $('#nextHandler').datagrid('getRows');
	//var rows = $('#grid').datagrid('getSelected');
	//var rows = $('#grid').datagrid('getSelections');
	var ids = [];
	$.messager.confirm('确认', '您确定要处理吗？', function(r) {
		for ( var i = 0; i < objRows.length; i++) {
			ids.push(objRows[i].userId);
		}
		$.ajax( {
			type : 'POST',
			url : '../../app/transmitWorkOrderToOthers',
			data : {
				targetUserIds : ids.join(','),
				id : document.getElementById("id").value,
				remark : document.getElementById("remark").value,
				chulifangshi : document.getElementById("chulifangshi").value
			},
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

function createWorkOrder() {
	$.messager.confirm('确认', '你确定要保存吗?', function(r) {
		if (r) {
		$.ajax( {
			type : 'POST',
			url : '../../app/createWorkOrder',
			data : $('#createOrderForm').serialize(),
			dataType : 'json',
			success : function(r) {
				$.messager.show( {
					title : '提示',
					msg : r.msg
				});
				$("#dlgAdd").dialog("close");
				$("#grid").datagrid("load");
				processWorkOrderByRow(r.obj);
			}
		});
		}
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

function editBatchById(row) {
	if (row) {
		$("#dlgDetails").dialog("open").dialog('setTitle', '修改');
		$("#batchForm").form("load", row);
		$("#batch_no").attr('value',row.id);
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

function processWorkOrderByRow(row) {
	if (row) {
		$("#dlgDetails").dialog("open").dialog('setTitle', '处理工单');
		$("#orderForm").form("load", row);
		$("#batch_no").attr('value',row.id);
		$('#workOrderDetails').datagrid( {
			url : '../../app/listOrderDetails?workOrderId='+row.id,
			striped : true,
			rownumbers : true,
			singleSelect:true,
			fitColumns: false,
			columns : [ [ {
				field : 'sysUser',
				title : '处理人',
				width : 100,
				align : 'center',
				formatter: function (value) { 
					return value.name;
				}
			}, {
				field : 'a',
				title : '处理人电话',
				width : 160,
				align : 'center',
				formatter: function (value,row,index) { 
					return row.sysUser.phone;
				}
			}, {
				field : 'reachTime',
				title : '到达时间',
				width : 120,
				align : 'center'
			}, {
				field:'remark',
				title:'处理意见',
				align:'center',
				width : 200
			}, {
				field:'state',
				title:'状态',
				align:'center',
				width : 80
			} ] ]
		});
		$("#batch_no").attr('value',row.id);
		$('#filegrid').datagrid( {
			url : '../../app/listFileByBatchId?id='+row.id+'&file_class=2',
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
	$('#nextHandler').datagrid({
		url : '',
		loadMsg : '数据加载中,请稍候...',
		rownumbers : true,
		singleSelect : false,//单选还是多选
		striped : true,
		fit : true,//自适应大小
		nowrap : false,//数据长度超出列宽时将会自动截取。
		columns : [ [
			{
				title : '对象ID',
				field : 'id',
				checkbox:true
			},{
				title : '姓名',
				field : 'name',
				width : 100
			},{
				title : '部门',
				field : 'groupName',
				width : 200
			},{
				title : '联系电话',
				field : 'phone',
				width : 300
			}
			] ],
			toolbar:[ {
				id : 'objectBtnAdd',
				text : '人员选择',
				iconCls : 'icon-add',
				handler : function() {
					$("#dlgrenyuan").dialog("open").dialog('setTitle', '选择');
						//数据表格
					$('#gridrenyuan').datagrid({
						url : '<%=request.getContextPath() %>/app/sys/user/findByName',
						loadMsg : '数据加载中,请稍候...',
						rownumbers : true,
						pagination : true, //分页控件
						pageList : [ 10, 15, 20, 30, 40, 50, 100 ],
						pageSize : 20,
						singleSelect : false,//单选还是多选
						striped : true,
						fit : true,//自适应大小
						fitColumns:true,
						nowrap : false,//数据长度超出列宽时将会自动截取。
						columns : [ [
							{
								title : '对象ID',
								field : 'id',
								checkbox:true
							},{
								title : '姓名',
								field : 'name'
							},{
								title : '部门',
								field : 'groupName'
							},{
								title : '联系电话',
								field : 'phone'
							}  ] ]
					});
				}
			},{
				id : 'objectBtnDel',
				text : '删除',
				iconCls : 'icon-cancel',
				handler : function() {
					var rows = $('#nextHandler').datagrid('getSelections');
					if(rows == null || rows.length<1) {
						$.messager.alert("提示", "请选择要删除的数据");
						return false;
					}
					for(var i=0;i<rows.length;i++) {
						var row = rows[i];
						var rowIndex = $('#nextHandler').datagrid('getRowIndex',row);
						delDataGridRow("nextHandler",rowIndex);
					}
				}
			} ]
	});
}
function processWorkOrder() {
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
		$("#dlgDetails").dialog("open").dialog('setTitle', '处理工单');
		$("#orderForm").form("load", row);
		$("#batch_no").attr('value',row.id);
		$('#workOrderDetails').datagrid( {
			url : '../../app/listOrderDetails?workOrderId='+row.id,
			striped : true,
			rownumbers : true,
			singleSelect:true,
			fitColumns: false,
			columns : [ [ {
				field : 'sysUser',
				title : '处理人',
				width : 100,
				align : 'center',
				formatter: function (value) { 
					return value.name;
				}
			}, {
				field : 'a',
				title : '处理人电话',
				width : 160,
				align : 'center',
				formatter: function (value,row,index) { 
					return row.sysUser.phone;
				}
			}, {
				field : 'reachTime',
				title : '到达时间',
				width : 120,
				align : 'center'
			}, {
				field:'remark',
				title:'处理意见',
				align:'center',
				width : 200
			}, {
				field:'state',
				title:'状态',
				align:'center',
				width : 80
			} ] ]
		});
		$("#batch_no").attr('value',row.id);
		$('#filegrid').datagrid( {
			url : '../../app/listFileByBatchId?id='+row.id+'&file_class=2',
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
	$('#nextHandler').datagrid({
		url : '',
		loadMsg : '数据加载中,请稍候...',
		rownumbers : true,
		singleSelect : false,//单选还是多选
		striped : true,
		fit : true,//自适应大小
		nowrap : false,//数据长度超出列宽时将会自动截取。
		columns : [ [
			{
				title : '对象ID',
				field : 'id',
				checkbox:true
			},{
				title : '姓名',
				field : 'name',
				width : 100
			},{
				title : '部门',
				field : 'groupName',
				width : 200
			},{
				title : '联系电话',
				field : 'phone',
				width : 300
			}
			] ],
			toolbar:[ {
				id : 'objectBtnAdd',
				text : '人员选择',
				iconCls : 'icon-add',
				handler : function() {
					$("#dlgrenyuan").dialog("open").dialog('setTitle', '选择');
						//数据表格
					$('#gridrenyuan').datagrid({
						url : '<%=request.getContextPath() %>/app/sys/user/findByName',
						loadMsg : '数据加载中,请稍候...',
						rownumbers : true,
						pagination : true, //分页控件
						pageList : [ 10, 15, 20, 30, 40, 50, 100 ],
						pageSize : 20,
						singleSelect : false,//单选还是多选
						striped : true,
						fit : true,//自适应大小
						fitColumns:true,
						nowrap : false,//数据长度超出列宽时将会自动截取。
						columns : [ [
							{
								title : '对象ID',
								field : 'id',
								checkbox:true
							},{
								title : '姓名',
								field : 'name'
							},{
								title : '部门',
								field : 'groupName'
							},{
								title : '联系电话',
								field : 'phone'
							}  ] ]
					});
				}
			},{
				id : 'objectBtnDel',
				text : '删除',
				iconCls : 'icon-cancel',
				handler : function() {
					var rows = $('#nextHandler').datagrid('getSelections');
					if(rows == null || rows.length<1) {
						$.messager.alert("提示", "请选择要删除的数据");
						return false;
					}
					for(var i=0;i<rows.length;i++) {
						var row = rows[i];
						var rowIndex = $('#nextHandler').datagrid('getRowIndex',row);
						delDataGridRow("nextHandler",rowIndex);
					}
				}
			} ]
	});
}

function loadFile(){
	var batch_id = $("#id").val();
    $("#uploadForm").form('submit', {
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
	$('#gridrenyuan').datagrid('load', serializeObject($('#renyuanForm')));
}

function clearFun() {
	$('#name').textbox('setValue', '');
	$('#gridrenyuan').datagrid('load', {});
}

function delDataGridRow(gridId,index){
	$('#'+gridId).datagrid('deleteRow',index); 
}

function saveOnlyFunc(){
	var objRows = $('#nextHandler').datagrid('getRows');
	var rows = $('#gridrenyuan').datagrid('getSelections');
	var flag = true;
	if(rows == null || rows.length<1){
		$.messager.alert("提示", "请选择数据");
		return false;
	}
	//snc
	for(var i=0;i<rows.length;i++){
		for(var j=0;j<objRows.length;j++){
			if(objRows[j].userId==rows[i].userId){
				flag = false;
				break;
			}
		}
		if(flag){
			$('#nextHandler').datagrid('appendRow',{
				userId:rows[i].userId,
				name: rows[i].name,
				groupName : rows[i].groupName,
				phone: rows[i].phone		
			});
		}
		flag=true;
	}
}
</script>

	</head>
	<body align="center">
	<%@ include file="createWorkOrder.jsp" %>
	<%@ include file="workOrderDetails.jsp" %>
		<div id="tb" style="padding: 3px"
			data-options="region:'north',title:'查询条件',border:false">
			<form id="admin_yhgl_searchForm">
				主题：
				<input id="title" class="easyui-textbox" name="title" />
				<a href="javascript:void(0);" id="add"
					class="easyui-linkbutton" iconCls="icon-add" onclick="addBatch()">添加</a>
				<a href="javascript:void(0);" id="edit"
					class="easyui-linkbutton" iconCls="icon-edit" onclick="processWorkOrder()">处理</a>
				<a href="javascript:void(0);" id="edit"
					class="easyui-linkbutton" iconCls="icon-cancel" onclick="deleteById()">删除</a>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="searchFun();">查询</a>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-redo'" onclick="clearFun();">重置</a>
			</form>
		</div>
		<div>
			<table id="grid" toolbar="#tb" title="待办工单" iconCls="icon-search"
				data-options="singleSelect:true,rownumbers:true,pagination:true,striped:true"></table>
		</div>
	</body>

</html>