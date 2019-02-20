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
			<tr>
				<td width="25%" class="oddTd">处理意见 ：</td>
				<td align="center" colspan="3">
					<input class="easyui-textbox" name="remark" style="width:600px;height:80px" data-options="multiline:true">
				</td>
			</tr>
			<tr>
				<td height="35" colspan="4">
					
				</td>
			</tr>
		</table>
	</form>
	<table id="workOrderDetails"></table>
</div>
<div id="editdlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="savebatch()" iconcls="icon-save">保存</a> <a
		href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:$('#dlgDetails').dialog('close')"
		iconcls="icon-cancel">取消</a>
</div>