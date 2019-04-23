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
            var   html="";
            for (var i=0; i<data.length;i++){

                html+='<a style="color: black" href="javascript:selectCarAllbyid('+data[i].id+')">'+data[i].area+'</a>  &nbsp;&nbsp;'


            }
            $("#div").html(html)

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
    $("#pinp").val(id);
/*这里添加汽车品牌id 到 form*/
    $.ajax({
        url:"http://192.168.1.110:9999/Series/querySeries",
        type:"post",
        data:{
            id:id
        },
        success:function (data) {
            var   html="";
            for (var i=0; i<data.length;i++){
                html+='<a   href="javascript:selectCarAllbycx('+data[i].id+')"  data-gzlog="tracking_type=click&amp;eventid=92458035&ampfilter=brand&ampbrand=dazhong&amp;type=hot">'+data[i].seriesName+'</a>'
            }
            $("#chexi").html(html)
        }

    })
    carChange();

}

function selectCarAllbycx(cxid){
    $("#cx").val(cxid)
    carChange();
/*这里添加 车系  到form*/
}

/* */
function selectCarAllbyid(id){
    $("#diqu").val(id)
    carChange();
          /*地区放入form*/
}
/*走es*/
function selectCarAllbyes(carName){
alert("走es"+id)

}
/*跳转首页*/
function jumpcarShow() {
    location.href="../PageController/PageOrderShow";
}

