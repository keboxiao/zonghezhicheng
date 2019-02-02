<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:useBean id="jb" scope="page" class="com.connectdb.Mydbbean" />
<head>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*,java.lang.*,javax.sql.*,javax.naming.*,java.util.Date"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>

<body>
	<script type="text/javascript" src="domtab.js"></script>
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
	<script language="JavaScript">
 

 function changelocation(no)
    {
    var i;
    document.all.next_man.length = 0; 

    for (i=0;i<onecount; i++) //从数组的第1行算起查找id ,这里的id是你大类的id(下面有我的数组例子)
        {
            if (subcat[i][2] == no) //第一次循环从第1行,第3列,那1列是大类ID
            { 
            document.all.next_man.options[document.all.next_man.length] = new Option(subcat[i][0], subcat[i][1]);
            }        
        }
        
    }
    
</script>
	<form name="userForm" method="post" action="../../app/addFileBatch">
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
			<tr>
				<td height="35" colspan="4">
					<center>
						<input type="submit" value="创建"/>
						<input type="button" value="取消" onclick="" /> 
					</center>
				</td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
   
	  


  //document.all.if_use.value="test";
  //document.all.area.value="test"; 
 
  function firm()
 {
	if (!confirm("确定要保存吗？")) 
     {return false;}
	else {
	  document.userForm.saveflag.value = "Y";}
  }
  
 function Update()
 {
     document.userForm.updateflag.value = "Y";
  }
  
 function change(){
   var w=document.userForm.next_type.value;

}
</script>

</body>
</html>