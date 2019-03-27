<%@ page contentType="text/html;charset=utf-8"
	import="java.sql.*,java.lang.*"%>

<div id="dlgDetails" class="easyui-dialog"
	style="width: 900px; height: 500px; padding: 10px 20px;" closed="true"
	buttons="#editdlg-buttons">
	<form id="batchForm" name="batchForm" method="post"
		action="../../app/updateFileBatch">
		<table class="editTable" height="100px">
			<tr height="35px">
				<td colspan="4" bgcolor="#D2E9FF" align="center" style="font-weight: bold">修改主题</td>
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
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="1" frame="box">
		<tr height='35px'>
			<td  style="font-size:16px" class="oddTd" colspan="2" >
				 附件 
			</td>
		</tr>
		<% if(flag) { %>
		<tr height='35px'>
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
				<input type="hidden" value="1" id="file_class" name="file_class" />
				<input type="button" onclick="javascript:deleteFile();" value="删除文件"/>
			</td>
			</form>
		</tr>
		<% } %>
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
