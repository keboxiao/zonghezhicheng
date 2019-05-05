<%@ page contentType="text/html;charset=utf-8"
	import="java.sql.*,java.lang.*"%>

<div id="dlgAdd" class="easyui-dialog" style="width: 900px; height: 500px; padding: 10px 20px;" closed="true"
	buttons="#adddlg-buttons">
	<form id="userForm1" name="userForm" method="post" >
		<table class="editTable" height="100px">
			<tr height="35px">
				<td colspan="4" bgcolor="#D2E9FF" align="center" style="font-weight: bold">新建主题</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">主题 ：</td>
				<td align="center">
				<input style="width:98%;height:100%" id="title" name="title" />
				</td>
				<td class="oddTd" width="20%">备注：</td>
				<td align="center">
				<input style="width:98%;height:100%" id="remark" name="remark" />
				<input type="hidden" id="id" name="id" />
				</td>
			</tr>
		</table>
	</form>
</div>

<div id="adddlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="addFileBatch()" iconcls="icon-save">保存</a> <a
		href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:$('#dlgAdd').dialog('close')"
		iconcls="icon-cancel">取消</a>
</div>