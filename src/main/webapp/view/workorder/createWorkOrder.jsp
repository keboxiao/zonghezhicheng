<%@ page contentType="text/html;charset=utf-8" %>

<div id="dlgAdd" class="easyui-dialog" style="width: 900px; height: 600px; padding: 10px 20px;" closed="true"
	buttons="#adddlg-buttons">
	<form id="createOrderForm" name="createOrderForm" method="post" >
		<table class="editTable" height="100px">
			<tr height="35px">
				<td colspan="4" bgcolor="#D2E9FF" align="center" style="font-weight: bold">新建工单</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">工单标题 ：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="title" name="title" />
				</td>
				<td class="oddTd" width="20%">拟稿部门：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="groupid" name="groupid" />
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
					<input id="begintime" style="width:98%;height:100%" class="easyui-datebox" name="happenTime" /> 
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
				</td>
				<td class="oddTd" width="20%"></td>
				<td align="center">
					
				</td>
			</tr>
		</table>
	</form>
</div>

<div id="adddlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="createWorkOrder()" iconcls="icon-save">保存</a> <a
		href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:$('#dlgDetails').dialog('close')"
		iconcls="icon-cancel">取消</a>
</div>