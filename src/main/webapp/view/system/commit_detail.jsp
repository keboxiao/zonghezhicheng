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
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="90">
					<table width="100%" height="60" border="1" align="center"
						cellpadding="0" cellspacing="1">
						<tr>
							<td colspan="3" height="30" bgcolor="#FFFF00" align="center"
								style="font-weight: bold">新建主题</td>
						</tr>
						<tr>
							<td width="31%" height="30"><label>主题 </label> <input id="title" name="title" /></td>
							<td width="30%"><label>备注</label><input id="remark" name="remark" /></td>
							<td></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="35">
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