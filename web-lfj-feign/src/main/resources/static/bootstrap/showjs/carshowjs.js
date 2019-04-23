$(function () {
    /*查询地区*/
    initdiqu()
    /*查询汽车品牌*/
    initCarType()
    /*查询汽车猜你喜欢*/
    initcnxh()
    /*瓜子问答*/
    initgzwd()
    /**/
    initUser
})

/*查询瓜子问答*/
function initgzwd() {
    $.ajax({
        url:"http://192.168.1.127:8767/isseu/findIsseu",
        type:"post",
        success:function (data) {
            for (var i=0; i<data.length;i++){
                var   html="";
                html='<li class="problem-item"><div class="problem-item-tit">'+data[i].issue+'</div><div class="problem-item-con">'+data[i].answer+'</div></li>'
                $("#gzwd").append(html)
            }

        }
    })
}
/*查询地区*/
function initdiqu() {
   $.ajax({
       url:"http://192.168.1.110:9999/Area/queryArea",
       type:"post",
       success:function (data) {
           for (var i=0; i<data.length;i++){
               var   html="";
               html='<a style="color: black" href="javascript:selectCarBydq('+data[i].id+')">'+data[i].area+'</a>  &nbsp;&nbsp;'
               $("#div").append(html)
           }

       }
   })
}
/*汽车猜你喜欢*/
function initcnxh() {
    $.ajax({
        url:"http://192.168.1.110:9999/Car/queryCarRandom",
        type:"post",
        success:function (data) {
            for (var i=0; i<data.length;i++){
                var   html="";
                html=' <li data-scroll-track="74269993@0@0@0&amp;92102665">'+
                    '<a href="#"'+
                'target="_blank" class="car-a"'+
                'data-gzlog="tracking_type=click&amp;eventid=0080310000000030&amp;carid=74269993&amp;position=0&amp;is_baomai=0">'+
                   ' <img src="'+data[i].imgUrl+'"'+
                'alt="'+data[i].brandName+'&nbsp;'+data[i].seriesName+'">'+
                   ' <div class="car-info">'+
                  '  <h2 class="t">'+data[i].brandName+'&nbsp;'+data[i].seriesName+'</h2>'+
                '<div class="t-i">2018年<span class="icon-pad">|</span>'+data[i].mileageName+'</div>'+
                '<div class="t-price">'+
                  '  <!-- 价格 -->'+
                '   <p>'+data[i].price+'<span>万</span></p>'+
               '<!-- 标签 -->'+
               '<i class="i-green">准新车</i><em class="line-through">19.80万</em></div>'+
               '</div>'+
               ' </a>'+
                ' </li>'+
                '<input type="hidden" value="'+data[i].id+'" class="data-js-rec" show-log="1010000000000024" data-carshow="1" id="car-show">'
                $("#cnxh").append(html)
            }

        }
    })
}
/*查询汽车品牌*/
function initCarType() {
    $.ajax({
        url:"http://192.168.1.110:9999/Brand/queryBrand",
        type:"post",
        success:function (data) {
            for (var i=0; i<data.length;i++){
                var   html="";
                html='<a href="javascript:selectCarBydq('+data[i].id+')" data-gzlog="tracking_type=click&amp;eventid=0050080000000024&amp;brand=dazhong">'+data[i].brandName+'</a> &nbsp;&nbsp; '
                $("#buycar-brand").append(html)
            }

        }
    })
}
/*跳转我要卖车*/
function jumpsellcar() {
    location.href="../PageController/jumpsellcar";
}
/*点击地区跳转到汽车展示页面   传入地区id*/
function  selectCarBydq(id){
    location.href="../PageController/jumpcarlist?dqid="+id;
}
/*点击汽车品牌跳转到汽车展示页面   传入地区id*/
function  selectCarBypp(id){
    alert(id)
}
/*跳转首页*/
function jumpcarShow() {
    location.href="../PageController/PageOrderShow";
}
/*登陆  引入登陆页面*/
function login() {
    location.href="../PageController/jumplogin";
}
