$(function () {
    selectgzwd()
})
function selectgzwd() {
    $.ajax({
        url:"http://127.0.0.1:8768/isseu/findIsseu",
        type:"post",
        success:function (data) {
            var   html="";
            for (var i=0; i<data.length;i++){
                html='            <li  ><div class="qa-con"  id=""><p class="qa-t">'+data[i].issue+'<i></i> </p>\n' +
                    '<p class="qa-txt">'+data[i].answer+'</p> </div></li>'
                $("#gzwd").append(html)
            }

        }
    })
}
function jumpcarShow() {
    location.href="../PageController/PageOrderShow";
}


