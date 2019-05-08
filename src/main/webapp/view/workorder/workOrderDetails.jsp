<%@ page contentType="text/html;charset=utf-8"%>

<div id="dlgDetails" class="easyui-dialog"
	style="width: 900px; height: 600px; padding: 10px 20px;" closed="true"
	buttons="#editdlg-buttons">
		<form id="orderForm" name="orderForm" method="post" >
		<table class="editTable" height="100px">
			<tr height="35px">
				<td colspan="4" bgcolor="#D2E9FF" align="center" style="font-weight: bold">处理工单</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">工单标题 ：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="title" name="title" />
				</td>
				<td class="oddTd" width="20%">拟稿部门：</td>
				<td align="center">
				</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">影响范围 ：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="affectScope" name="affectScope" />
				</td>
				<td class="oddTd" width="20%">业务类型：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="serviceType" name="serviceType" />
				</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">联系人 ：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="contacts" name="contacts" />
				</td>
				<td class="oddTd" width="20%">联系电话：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="tel" name="tel" />
				</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">首要系统 ：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="firstSystem" name="firstSystem" />
				</td>
				<td class="oddTd" width="20%">事件发生时间：</td>
				<td align="center">
				</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">申告现象 ：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="appearance" name="appearance" />
				</td>
				<td class="oddTd" width="20%">优先级：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="priority" name="priority" />
				</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">事件影响度 ：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="influence" name="influence" />
					<input type="hidden" id="id" name="id" />
				</td>
				<td class="oddTd" width="20%">处理方式：</td>
				<td align="center">
				<select id="chulifangshi" name="chulifangshi">
					<option value="all" selected>
						请选择
					</option>
					<option value="1">
						转他人处理
					</option>
					<option value="2">
						办结
					</option>
				</select>
				</td>
			</tr>
			<tr height="35px">
				<td width="25%" align="left" class="oddTd" colspan="4">下一个处理人 ：</td>
				
			</tr>
			<tr>
				<td align="center" colspan="4">
				<div style="height: 200px;">
					<table id="nextHandler"></table>
					</div>
				</td>
			</tr>
			<tr>
				<td width="25%" class="oddTd">处理意见 ：</td>
				<td align="center" colspan="3">
					<input class="easyui-textbox" id="remark" name="remark" style="width:600px;height:80px" data-options="multiline:true">
				</td>
			</tr>
			<tr>
				<td height="35" colspan="4">
				</td>
			</tr>
		</table>
	</form>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" frame="box">
		<tr height='35px'>
			<td  style="font-size:16px" class="oddTd" colspan="2" >
				 流程跟踪：
			</td>
		</tr>
		<tr>
			<td>
				<table id="workOrderDetails" style="width: 100%; height: 150px;"></table>
			</td>
		</tr>
	</table>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" frame="box">
		<tr height='35px'>
			<td  style="font-size:16px" class="oddTd" colspan="2" >
				 附件 
			</td>
		</tr>
		<tr height='35px'>
			<form id="uploadForm" name="uploadForm" enctype="multipart/form-data"
				method="post">
			<td align="left" style="width: 90px">
				<div id="newUpload2">
					<input id="file" type="file" name="file" multiple="true">
				</div>
			</td>
			<td>
				<input type="button" onclick="javascript:loadFile();" value="上传文件"/>
				<input type="hidden" id="batch_no" name="batch_no" />
				<input type="hidden" value="2" id="file_class" name="file_class" />
				<input type="button" onclick="javascript:deleteFile();" value="删除文件"/>
			</td>
			</form>
		</tr>
		<tr>
			<td colspan="2" align="left">
				<div id="filegrid" style="width: 100%; height: 150px;"></div>
			</td>
		</tr>
	</table>
</div>
<div id="editdlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="processbatch()" iconcls="icon-save">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:$('#dlgDetails').dialog('close')"
		iconcls="icon-cancel">取消</a>
</div>


<div id="dlgrenyuan" class="easyui-dialog" toolbar="#tb" buttons="#renyuan-buttons"
	style="width: 500px; height: 300px; padding: 10px 20px;" closed="true">
	<div id="gridrenyuan"></div>
</div>
	
<div id="renyuan-buttons">
 <a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:$('#dlgrenyuan').dialog('close')"
		iconcls="icon-cancel">关闭</a>
</div>	

<div id="tb" style="padding: 3px"
			data-options="region:'north',title:'查询条件',border:false">
			<form id="renyuanForm">
				姓名：
				<input id="name" class="easyui-textbox" name="name" />
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="searchFun();">查询</a>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-redo'" onclick="clearFun();">清空</a>
					<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'" onclick="saveOnlyFunc();">保存</a>
			</form>
		</div>