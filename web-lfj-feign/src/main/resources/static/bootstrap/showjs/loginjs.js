function inityzm() {
    var  phone=$("#phone").val();
    if (!(/^1[34578]\d{9}$/.test(phone))){
        alert("请输入正确的手机号")
        return
    }
    $.ajax({
        url:"http://127.0.0.1:8768/logina/findduanxin",
        type:"post",
        data:{
            phone:phone
        },
        success:function (data) {
            if (data=="距离上一次获取验证码不超过一分钟"){
                alert(data)
                $("#phone").val(phone);
                return
            }
            if (data=="次数已用完"){
                alert(data)
                $("#phone").val(phone);
                return
            }
            if (data=="验证码发送失败！"){
                alert(data)
                $("#phone").val(phone);
                return
            }
            if (data=="手机号不能为空"){
                alert(data)
                $("#phone").val(phone);
                return
            }
            if (data=="验证码发送失败！"){
                alert(data)
                $("#phone").val(phone);
                return
            }
            searchInfo()
        }
    })
}


var wait = 60;
function  searchInfo(){
    //按钮倒计时
    if (wait == 0) {
        $("#fsyzm").html('<button onclick="inityzm()" >获取验证码</button>');
        wait = 60
    } else {
        $("#fsyzm").html(wait + "秒后可以重新发送");
        wait--;
        setTimeout(function(){
            searchInfo();
        },1000)//1000是1秒
    }

}

