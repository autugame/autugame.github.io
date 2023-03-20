function doValidate(){
	//1,校验用户名
	var username = document.getElementById("userNameInput").value;
	var label1 = document.getElementById("userNameTipsLabel");
	//a,不能为空
	if (username == null || username == ""){
		//通过innerHtml属性修改标签对象里面的值
		label1.innerHTML = "请输入用户名!";
		label1.style.color = "red";
		return false;
	} else if(username.length < 8 || username.length > 20){
		label1.innerHTML="用户名长度必须为8-20个字符";
		label1.style.color = "red";
		return false;
	} else if(!new RegExp("^[0-9a-zA-Z]*$").test(username)) {
		label1.innerHTML = "用户名只允许包含数字和字母";
		label1.style.color = "red";
		return false;
	} else {
		//用户名合法
		label1.innerHTML = "用户名输入正确！";
		label1.style.color = "green";
	}
	
	var userPwd = document.getElementById("userPwdInput").value;
	var label2 = document.getElementById("userPwdTipsLabel");
	if (userPwd == null || userPwd == ""){
		label2.innerHTML = "请输入密码!";
		label2.style.color = "red";
		return false;
	} else if (userPwd.length < 8 || userPwd.length > 16){
		label2.innerHTML = "密码长度必须为8-16个字符";
		label2.style.color = "red";
		return false;
	} else {
		//密码正确
		label2.innerHTML = "密码输入正确！";
		label2.style.color = "green";
	}
	//校验确认密码
	var rePwd = document.getElementById("rePwdInput").value;
	var label3 = document.getElementById("rePwdTipsLabel");
	if (rePwd == null || rePwd == ""){
		label3.innerHTML = "请再次输入密码!";
		label3.style.color = "red";
		return false;
	} else if (userPwd != rePwd){
		label3.innerHTML = "两次密码输入不一致!";
		label3.style.color = "red";
		return false;
	} else {
		label3.innerHTML = "重复密码输入正确!";
		label3.style.color = "green";
	}
	//验证手机
	
	//验证邮箱
	return false;
}