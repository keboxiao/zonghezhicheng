<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page 
   contentType="text/html;charset=gb2312"
   import="java.sql.*,java.lang.*,javax.sql.*,javax.naming.*,java.util.Date"
%>
<jsp:useBean id="jb" scope="page" class="com.connectdb.Mydbbean"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<style type="text/css">
<!--
body {
	background-color: #CCCCCC;
}
-->
.STYLE1 {font-size:12px}
</style></head>
<body>
<%
  Connection sqlCon;  
  Statement sqlStmt; 
  ResultSet sqlRst;
  String strSQL; 
  String area_id="",bianhao,tablename;  
  String strDep;
  int intPageSize;  
  int intRowCount;  
  int intPageCount; 
  int intPage=1;  
  String strPage;  
  int i=0,b=0,type=0;
  String updatesuccess,id="";
  
//����һҳ��ʾ�ļ�¼��  

//request.setCharacterEncoding("gb2312");

String username=request.getParameter("username");
updatesuccess=request.getParameter("updatesuccess");
String batch_no=request.getParameter("batch_no");
String detail_no=request.getParameter("detail_no");

   java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   java.util.Date a1,a2;
  
   java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy");
   java.text.SimpleDateFormat formatter1 = new java.text.SimpleDateFormat("MM");
   java.text.SimpleDateFormat formatter2 = new java.text.SimpleDateFormat("dd");
   java.text.SimpleDateFormat formatter3 = new java.text.SimpleDateFormat("HH");
   java.text.SimpleDateFormat formatter4 = new java.text.SimpleDateFormat("mm");
   java.text.SimpleDateFormat formatter5 = new java.text.SimpleDateFormat("ss");

   java.util.Date currentTime = new java.util.Date();//�õ���ǰϵͳʱ�� 

   String str_date = formatter.format(currentTime); //������ʱ���ʽ��
   String str_date1 = formatter1.format(currentTime);
   String str_date2 = formatter2.format(currentTime);
   String str_date3 = formatter3.format(currentTime);
   String str_date4 = formatter4.format(currentTime);
   String str_date5 = formatter5.format(currentTime);
   String str_date6;
   int month = Integer.parseInt(str_date1);
   int year = Integer.parseInt(str_date);
   int day = Integer.parseInt(str_date2);
   int hour = Integer.parseInt(str_date3);
   int minut = Integer.parseInt(str_date4);
   int mi = Integer.parseInt(str_date5);
   
   if (month < 10) {
      str_date6 = year+"-0"+month;
	  } else {
      str_date6 = year+"-"+month;
	  }
   
   if (day < 10) {
      str_date6 = str_date6+"-0"+day;
	  }
   else {
      str_date6 = str_date6+"-"+day;
	  }
	
   if (hour < 10) {
      str_date6 = str_date6+" 0"+hour;
	  }
   else {
      str_date6 = str_date6+" "+hour;
	  }
	  
   if (minut < 10) {
      str_date6 = str_date6+":0"+minut;
	  } else {
      str_date6 = str_date6+":"+minut;
	  }
	  
		if (mi < 10) {
      str_date6 = str_date6+":0"+mi;
	  } else {
      	str_date6 = str_date6+":"+mi;
	  }
	  
	strSQL = "select user_id from user where user_account='"+username+"'";  
	sqlRst = jb.executeQuery(strSQL);
	while (sqlRst.next()) {
		id =sqlRst.getString("user_id");
	}

sqlRst.close();

if(updatesuccess==null) {
   updatesuccess = "0";  
}

if (updatesuccess.equals("1")) {
%>

<script type="text/javascript">
    alert("�����ɹ���");
    window.opener.location.replace("commit_detail.jsp?batch_no=<%= batch_no%>&detail_no=<%= detail_no%>&username=<%= username %>");
	window.close();	
</script>

<% } else if(updatesuccess.equals("2")) { %>

<script type="text/javascript">
    alert("����ʧ�ܣ�");
</script>
<% } %>
 
<form method="post" action="../springUpload" name="userForm" style="margin:0px;padding:0px" onsubmit="return Check_input();" enctype="multipart/form-data">

<table width="100%" height="15" background="picture/front.gif" border="0"  cellspacing="2" cellpadding="0" align="center">
<tbody>
	<tr>
   		<td height="15" align="left" style="font-size:14px;font:"����"">
   		<strong>�����ϴ�</strong>
   		</td> 
   </tr>
</tbody>
</table>

<table width="100%" height="35" bgcolor="#CCCCCC" align="center" border="1" cellspacing="0" cellpadding="0">
<tbody>
<tr>   
   <td width="50%" class="STYLE1">
��ѡ�񸽼���<input name="upfile" type="file">&nbsp;&nbsp;<input type="hidden" name="username" value="<%= username %>"/>
<input type="submit" value="�ϴ�" onClick="return firm()"/>&nbsp;
<input type="button"  onclick=window.close() value="�ر�"/>  
   </td>
</tr>
</tbody>
</table>

<center>
<input type="hidden" name="load_id" value="<%= id %>"/>
<input type="hidden" name="load_time" value="<%= str_date6 %>"/>
<input type="hidden" name="batch_no" value="<%= batch_no %>"/>
<input type="hidden" name="detail_no" value="<%= detail_no %>"/>
</center>
</form>
<script type="text/javascript">   

   function getSelectedText(name) {
    var obj=document.getElementById(name);
	for(i=0;i<obj.length;i++) {
    	if(obj[i].selected==true) {
			return obj[i].innerText;      //�ؼ���ͨ��option�����innerText���Ի�ȡ��ѡ���ı�
		}
     }
   }

  function getSelectedValue(name) {
    var obj=document.getElementById(name);
    return obj.value;      //ֱ����������value���Ա�ɻ�ȡ��
   }

  function Redirect1() {
    href = "ip_batch.jsp";
    location.replace(href);
  }
  //document.all.if_use.value="test";
  //document.all.area.value="test"; 
  
  function Check_input() {
	 var no,name;
	 
	 no=document.userForm.no.value;
	 name=document.userForm.name.value;	 

	 if (no=="") {
		  alert("��Ų���Ϊ�գ�");
    	  return false;
	 } else if (name=="") {
		  alert("��������Ϊ�գ�");
    	  return false;
	 } else {
		  return true;
	 } 
  }
  
  function firm() {
	if (!confirm("ȷ��Ҫ�ϴ���")) {
		return false;
	}
  }
  
  
</script>


</body>
</html>
