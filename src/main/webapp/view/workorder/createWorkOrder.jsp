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
				</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">影响范围 ：</td>
				<td align="center">
				<select id="affectScope" name="affectScope">
					<option value="all">
						请选择
					</option>
					<option value="个别用户">
						个别用户
					</option>
					<option value="一类型用户">
						一类型用户
					</option>
				</select>
				</td>
				<td class="oddTd" width="20%">业务类型：</td>
				<td align="center">
				<select id="serviceType" name="serviceType">
					<option value="all" selected>
						请选择
					</option>
					<option value="宽带">
						宽带
					</option>
					<option value="ITV">
						ITV
					</option>
					<option value="固话">
						固话
					</option>
					<option value="手机">
						手机
					</option>
				</select>
				</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">受理人员 ：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="shoulirenyuan" name="shoulirenyuan" />
				</td>
				<td class="oddTd" width="20%">受理人员联系电话：</td>
				<td align="center">
					<input style="width:98%;height:100%" id="shoulirenyuandianhua" name="shoulirenyuandianhua" />
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
				<select id="priority" name="priority">
					<option value="all" selected>
						请选择
					</option>
					<option value="低">
						低
					</option>
					<option value="中">
						中
					</option>
					<option value="高">
						高
					</option>
				</select>
				</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">事件影响度 ：</td>
				<td align="center">
					<select id="influence" name="influence">
					<option value="all">
						请选择
					</option>
					<option value="一般">
						一般
					</option>
					<option value="中等">
						中等
					</option>
					<option value="严重">
						严重
					</option>
				</select>
				</td>
				<td class="oddTd" width="20%"></td>
				<td align="center">
					
				</td>
			</tr>
			<tr height="35px">
				<td width="25%" class="oddTd">事件描述 ：</td>
				<td align="center" colspan="3">
				<textarea id="event" name="event" style="width:100%;height:180px;overflow:auto" >【订单编号】
【接入号/业务号码】
【办理业务】
【操作工号】
【出错环节】
【错误提示】
【申告现象】
【可能原因】
【处理要求】
【影响范围】</textarea>
				</td>
			</tr>
		</table>
	</form>
</div>

<div id="adddlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		onclick="createWorkOrder()" iconcls="icon-save">保存</a> <a
		href="javascript:void(0)" class="easyui-linkbutton"
		onclick="javascript:$('#dlgAdd').dialog('close')"
		iconcls="icon-cancel">取消</a>
</div>