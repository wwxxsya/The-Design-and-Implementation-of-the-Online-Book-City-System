/**
 * 校验用户性别是否已选
 */
function checkGender(){
    //获得所有名称为gender的input标签
    var genderNum=document.getElementsByName("gender");
    var gender="";
    //遍历这些标签
    for(var i=0;i<genderNum.length;++i){
        //如果某个gender被选中，则记录
        if(genderNum[i].checked)
            gender=genderNum[i].value;
    }
    if(gender==""){
    	document.getElementById("tips_gender").innerHTML
    	="<em style='color:ff0000'>至少选其中一项</em>";
        return false;
    }
    else{
        document.getElementById("tips_gender").innerHTML="OK!";
        return true;
    }
}


function checkUsername(){
    /*使用document.getElementById获取id为textuser的输入域的值，判断其长度是否合法*/
    if(document.getElementById("textUser").value.length<1 || document.getElementById("textUser").value.length>10){
        //设置id为tips_username的span的html，显示错误信息
        document.getElementById("tips_username").innerHTML
        ="<em style='color:#ff0000'>请输入正确的用户名</em>";       
        return false;
    }
    else{
        document.getElementById("tips_username").innerHTML="OK!";
        return true;
    }
}
function checkPassword(){
    //正则表达式，由字母、数字和下划线组成
    var reg=/^\w{6,16}$/;
    var regs=/^[a-zA-Z0-9_\u4e00-\u9fa5]+$/;
    //判断密码长度是否符合规则
    if(!reg.test(document.getElementById("passWord").value)){
        //设置span的html，显示错误信息
        document.getElementById("tips_password").innerHTML
        ="<em style='color:#ff0000'>请输入正确的密码</em>";        
        return false;
    }
    else{
        document.getElementById("tips_password").innerHTML="OK!";
        return true;
    }
}
function checkPwdrepeat(){
    //校验两次密码输入是否一致
    if(document.getElementById("passWord").value != document.getElementById("pwdRepeat").value){
        document.getElementById("tips_pwdrepeat").innerHTML
        ="<em style='color:#ff0000'>两次输入的密码不一致</em>";       
        return false;
    }
    else{
        document.getElementById("tips_pwdrepeat").innerHTML="OK!";
        return true;
    }
}
function checkEmail(){
    //校验email
    var email=document.getElementById("textMail").value;
    //电子邮件的正则表达式
    var pattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if(email.length==0){
        document.getElementById("tips_email").innerHTML
        ="<em style='color:#ff0000'>电子邮箱不能为空</em>";       
        return false;
    }
    else if(!pattern.test(email)){
        document.getElementById("tips_email").innerHTML
        ="<em style='color:#ff0000'>Email不合法</em>";        
        return false;
    }
   
    else{
        document.getElementById("tips_email").innerHTML="OK!";
        return true;
    }

}   

function checkPhone(){
    //正则表达式，由字母、数字和下划线组成
    var reg2=/^1[356789]\d{9}$/;    
    if(!reg2.test(document.getElementById("telePhone").value)){
        //设置span的html，显示错误信息
        document.getElementById("tips_phone").innerHTML
        ="<em style='color:#ff0000'>请输入正确的手机号</em>";        
        return false;
    }
    else{
        document.getElementById("tips_phone").innerHTML="OK!";
        return true;
    }
}

var wrapper = function(){
	   return (checkEmail() && checkUsername() && checkPhone() && checkPwdrepeat() && checkPassword() && checkGender());
	}
