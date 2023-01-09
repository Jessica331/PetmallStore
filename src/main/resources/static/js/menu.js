//修改这个变量为实际控制器的地址，如../showGoods.do
var reqpath = "search.html"
/*ajax获得的json对象*/
var typelist = [{
    "id": 1,
    "parentId": 0,
    "name": "宠物主粮"
},
    {
        "id": 2,
        "parentId": 0,
        "name": "宠物零食"
    },
    {
        "id": 3,
        "parentId": 0,
        "name": "宠物玩具"
    },
    {
        "id": 4,
        "parentId": 0,
        "name": "宠物清洁"
    },
    {
        "id": 5,
        "parentId": 0,
        "name": "宠物保健"
    },
    {
        "id": 6,
        "parentId": 0,
        "name": "宠物护理"
    },
    {
        "id": 7,
        "parentId": 0,
        "name": "宠物生活"
    },
    {
        "id": 8,
        "parentId": 0,
        "name": "宠物牵引"
    },
    {
        "id": 9,
        "parentId": 0,
        "name": "宠物洗浴"
    },
    {
        "id": 10,
        "parentId": 0,
        "name": "宠物美容"
    },
    {
        "id": 11,
        "parentId": 0,
        "name": "宠物窝垫"
    },
    {
        "id": 12,
        "parentId": 0,
        "name": "宠物服饰"
    },
    {
        "id": 13,
        "parentId": 1,
        "name": "进口主粮"
    },
    {
        "id": 14,
        "parentId": 1,
        "name": "国产主粮"
    },
    {
        "id": 15,
        "parentId": 1,
        "name": "冻干主粮"
    },
    {
        "id": 16,
        "parentId": 2,
        "name": "磨牙洁齿"
    },
    {
        "id": 17,
        "parentId": 2,
        "name": "肉制零食"
    },
    {
        "id": 18,
        "parentId": 2,
        "name": "点心饮料"
    },
    {
        "id": 19,
        "parentId": 2,
        "name": "罐头湿粮"
    },
    {
        "id": 20,
        "parentId": 3,
        "name": "磨牙玩具"
    },
    {
        "id": 21,
        "parentId": 3,
        "name": "益智玩具"
    },
    {
        "id": 22,
        "parentId": 3,
        "name": "巡回玩具"
    },
    {
        "id": 23,
        "parentId": 4,
        "name": "清洁除臭"
    },
    {
        "id": 24,
        "parentId": 4,
        "name": "尿片湿巾"
    },
    {
        "id": 25,
        "parentId": 4,
        "name": "宠物厕所"
    },
    {
        "id": 26,
        "parentId": 5,
        "name": "强化免疫"
    },
    {
        "id": 27,
        "parentId": 5,
        "name": "美毛增毛"
    },
    {
        "id": 28,
        "parentId": 5,
        "name": "肠胃调理"
    },
    {
        "id": 29,
        "parentId": 5,
        "name": "补钙强骨"
    },
    {
        "id": 30,
        "parentId": 5,
        "name": "微量元素"
    },
    {
        "id": 31,
        "parentId": 6,
        "name": "体外驱虫"
    },
    {
        "id": 32,
        "parentId": 6,
        "name": "体内驱虫"
    },
    {
        "id": 33,
        "parentId": 6,
        "name": "皮肤护理"
    },
    {
        "id": 34,
        "parentId": 6,
        "name": "五官护理"
    },
    {
        "id": 35,
        "parentId": 6,
        "name": "家庭常备"
    },
    {
        "id": 36,
        "parentId": 7,
        "name": "宠物餐具"
    },
    {
        "id": 37,
        "parentId": 7,
        "name": "宠物外出"
    },
    {
        "id": 38,
        "parentId": 7,
        "name": "宠物住所"
    },
    {
        "id": 39,
        "parentId": 7,
        "name": "宠物训练"
    },
    {
        "id": 40,
        "parentId": 7,
        "name": "主人专享"
    },
    {
        "id": 41,
        "parentId": 8,
        "name": "伸缩牵引"
    },
    {
        "id": 42,
        "parentId": 8,
        "name": "日常项圈"
    },
    {
        "id": 43,
        "parentId": 8,
        "name": "日常拉带"
    },
    {
        "id": 44,
        "parentId": 8,
        "name": "日常胸背"
    },
    {
        "id": 45,
        "parentId": 8,
        "name": "牵引套装"
    },
    {
        "id": 46,
        "parentId": 9,
        "name": "日常洗护"
    },
    {
        "id": 47,
        "parentId": 9,
        "name": "洗澡配套"
    },
    {
        "id": 48,
        "parentId": 10,
        "name": "梳剪工具"
    },
    {
        "id": 49,
        "parentId": 11,
        "name": "睡床窝垫"
    },
    {
        "id": 50,
        "parentId": 12,
        "name": "潮流服饰"
    },
    {
        "id": 51,
        "parentId": 12,
        "name": "精美配饰"
    }]
//加载json数据的到一级分类的方法
function initMenu() {
    for (var i = 0; i < typelist.length; i++) {

        if (typelist[i].parentId == "0") {

            $(".index-menu").append($("<li data='" + typelist[i].id + "'>" + typelist[i].name + "</li>"))
        }
    }
}

window.addEventListener("load", function() {
    initMenu();
    //根据轮播图片的高，导航的高
    //获得轮播图高
    var lunh = $("#myCarousel").height();
    var lih = (lunh - 10) / 12;
    //确定导航高度
    $(".index-menu li").css("height", lih + "px")
    //确定按钮位置
    var btnt = Math.floor($("#myCarousel").height() / 2 - 30);
    $(".left").css("margin-top", btnt + "px");
    $(".right").css("margin-top", btnt + "px");
    /*左侧分类一级菜单控制二级菜单显示和隐藏*/
    $(".index-menu").hover(function() {
        $("#showIndex").show();
    }, function() {
        $("#showIndex").hide();
    })
    /*左侧分类二级菜单控制三级菜单显示和隐藏*/
    // $(".second-menu").hover(function() {
    //     $("#showSecond").show();
    // }, function() {
    //     $("#showSecond").hide();
    // })
    /*二级菜单自己控制显示和隐藏*/
    $("#showIndex").hover(function() {
        $("#showIndex").show();
    }, function() {
        $("#showIndex").hide();
    })
    /*三级菜单自己控制显示和隐藏*/
    // $("#showSecond").hover(function() {
    //     $("#showIndex").show();
    //     $("#showSecond").show();
    // }, function() {
    //     $("#showIndex").hide();
    //     $("#showSecond").hide();
    // })
    /*一级分类项li鼠标移入移出*/
    var offTop = -100;
    var offLeft = 0;
    $(".index-menu li").hover(function() {
        $(".second-menu").empty();
        /*加载json数据*/
        for (var i = 0; i < typelist.length; i++) {
            if ($(this).attr("data") == typelist[i].parentId) {
                $(".second-menu").append($("<li class='second-menu-li' data='" + typelist[i].id +
                    "' >" + typelist[i].name + "</li>"))
            }
        }
        offLeft = $(this).width() + $(this).offset().left;
        offTop = $(this).offset().top;
        $("#showIndex").css("top", offTop - 2 + "px")
        $("#showIndex").css("left", offLeft - 1 + "px")
        $(this).css("background-color", "#f5f5f5");
        $(this).css("color", "#4288c3");
    }, function() {
        $(this).css("background-color", "");
        $(this).css("color", "");
    })
    /*二级分类项li鼠标移入移出*/
    $(".second-menu-li").live("mouseover", function() {
        $(".third-menu").empty();
        /*加载数据*/
        for (var i = 0; i < typelist.length; i++) {
            if ($(this).attr("data") == typelist[i].parentId) {}
            //alert($(document).scrollTop() +":"+$(this).offset().top)
            var ot = $(document).scrollTop() == $(this).offset().top ? offTop : $(this).offset().top;
            var ol = $(this).width() + $(this).offset().left;
            $("#showSecond").css("top", ot - 2 + "px");
            $("#showSecond").css("left", ol + "px")
            $(this).css("background-color", "#4288c3");
            $(this).css("color", "#f5f5f5");
        }
        $(".second-menu-li").live("mouseout", function() {
            $(this).css("background-color", "");
            $(this).css("color", "");
        })
        /*三级分类项li鼠标移入移出*/
        // $(".third-menu-li").live("mouseover", function() {
        //     $(this).css("background-color", "#dddddd");
        //     $(this).css("color", "#000000");
        // })
        // $(".third-menu-li").live("mouseout", function() {
        //     $(this).css("background-color", "");
        //     $(this).css("color", "");
        // })
    })
})
