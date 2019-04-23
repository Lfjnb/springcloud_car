$(function () {

    /*查询地区*/
    initdiqu()
    /*查询汽车品牌*/
    initCarType()

    huoquId()
})

function huoquId() {

}
/*查询地区*/
function initdiqu() {
    $.ajax({
        url:"http://192.168.1.110:9999/Area/queryArea",
        type:"post",
        success:function (data) {
            for (var i=0; i<data.length;i++){
                var   html="";
                html='<a style="color: black" href="javascript:selectCarAllbyid('+data[i].id+')">'+data[i].area+'</a>  &nbsp;&nbsp;'
                $("#div").append(html)
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
                html='<a   href="javascript:selectCarAll('+data[i].id+')"  data-gzlog="tracking_type=click&amp;eventid=92458035&ampfilter=brand&ampbrand=dazhong&amp;type=hot"href="https://www.guazi.com/bj/dazhong/#bread">'+data[i].brandName+'</a> &nbsp;&nbsp; '
                $("#a-box").append(html)
            }

        }
    })
}
/*查询车系*/
function selectCarAll(id) {
    $.ajax({
        url:"http://192.168.1.110:9999/Series/querySeries",
        type:"post",
        data:{
            id:id
        },
        success:function (data) {
            var   html="";
            for (var i=0; i<data.length;i++){
                html+='<a   href="javascript:selectCarAllbyid('+data[i].id+')"  data-gzlog="tracking_type=click&amp;eventid=92458035&ampfilter=brand&ampbrand=dazhong&amp;type=hot">'+data[i].seriesName+'</a>'
            }
            $("#chexi").html(html)
        }

    })
    selectCarAllbyid(id)
}
/* 提交form  #myForm   走调差 查询汽车信息 list*/
function selectCarAllbyid(id){
          alert(id)
}
/*走es*/
function selectCarAllbyes(carName){
alert(id)
}
/*跳转首页*/
function jumpcarShow() {
    location.href="../PageController/PageOrderShow";
}

