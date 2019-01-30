<%@ page contentType="text/html;charset=utf-8"
	import="java.sql.*,java.lang.*"%>

<div id="dlgDetails" class="easyui-dialog"
	style="width: 900px; height: 500px; padding: 10px 20px;" closed="true"
	buttons="#editdlg-buttons">
	<form id="batchForm" name="batchForm" method="post"
		action="../../app/updateFileBatch">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="90">
					<table width="100%" height="60" border="1" align="center"
						cellpadding="0" cellspacing="1">
						<tr>
							<td colspan="3" height="30" bgcolor="#FFFF00" align="center"
								style="font-weight: bold">修改主题</td>
						</tr>
						<tr>
							<td width="31%" height="30"><label>主题 </label> <input
								id="title" name="title" /></td>
							<td width="30%"><label>备注</label><input id="remark"
								name="remark" /></td>
							<td><input type="hidden" id="id" name="id" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="1" frame="box">
		<tr>
			<td colspan="2">&nbsp;
				<h color="#CCCCCC" width="100%" size="5" />&nbsp;附件</h>
			</td>
		</tr>
		<tr>
			<form id="userForm" name="userForm2" enctype="multipart/form-data"
				method="post">
			<td align="left" style="width: 90px">
				<div id="newUpload2">
					<input id="file" type="file" name="file" multiple="true">
				</div>
			</td>
			<td>
				<input type="button" onclick="javascript:loadFile();" value="上传文件"/>
				<input type="hidden" id="batch_no" name="batch_no" />
			</td>
			</form>
		</tr>
		<tr>
			<td colspan="2" align="left">
				<div id="filegrid" />
			</td>
		</tr>
	</table>
</div>
<div id="editdlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="savebatch()" iconcls="icon-save">保存</a> <a
		href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:$('#dlgDetails').dialog('close')"
		iconcls="icon-cancel">取消</a>
</div>
