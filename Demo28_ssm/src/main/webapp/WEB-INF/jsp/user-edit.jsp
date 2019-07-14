<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="padding:10px 10px 10px 10px">
	<form id="editContent" method="post">
		<input type="hidden" name="id"/>
	    <table cellpadding="5">
	        <tr>
	            <td>用户名:</td>
	            <td><input class="easyui-textbox" type="text" name="userName" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>密码:</td>
	            <td><input class="easyui-textbox" type="password" name="password" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>姓名:</td>
	            <td><input class="easyui-textbox" name="name" data-options="validType:'length[0,150]',required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>年龄:</td>
	            <td><input class="easyui-numberbox" type="text" name="age" data-options="min:1,max:100,precision:0,required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>性别:</td>
	            <td>
	            	<input class="easyui-radio" type="radio" name="sex" value="1" checked="checked"/> 男
	            	<input class="easyui-radio" type="radio" name="sex" value="2"/> 女
	            </td>
	        </tr>
	        <tr>
	            <td>出生日期:</td>
	            <td>
	                <input class="easyui-datebox" type="text" name="birthday" data-options="required:true" />
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitFormEdit()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearFormEdit()">重置</a>
	</div>
</div>
<script type="text/javascript">
	function submitFormEdit(){
		if(!$('#editContent').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("/user/edit",$("#editContent").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改会员成功!');
				$('#userEdit').window('close');
				$("#userList").datagrid("reload");
                clearFormEdit();
			}else{
				$.messager.alert('提示','修改会员失败!');
			}
		});
	}
	function clearFormEdit(){
		$('#editContent').form('reset');
	}
</script>