$(function(){
// 	var user=JSON.parse(getUser());
// 	$("#userName").html(user.username);
// 	console.log(user.username);
// 	$("#jifen").html("积分："+user.integration);
	getProductType();
	getBanner();
})

function getBanner(){
	var currentPage=-1;
	var pageSize=-1;
	$.ajax({
		type: "post",
		url: "http://localhost:8080/pmsBanner/listPmsBannerByPage",
		data: {
			"currentPage": currentPage,
			"pageSize":pageSize
		},
		dataType: 'json',
		async: true,
		success: function(data) {
			var msg=data.code;
			if(msg!=200) {
				console.log(msg);
			} else {
				var a=data.data.content;
				var s='';
				for(var i=0;i<a.length;i++){
					s+='<div class="swiper-slide"><a href="item_show.html">'
					+'<img src="'+a[i].imgUrl+'" class="cover"></a></div>'
				}
				$("#banner").html(s+' </div>');
				// 顶部banner轮播,动态数据时初始化swiper
				var banner_swiper = new Swiper('.banner-box', {
				autoplayDisableOnInteraction : false,
				pagination: '.banner-box .swiper-pagination',
				paginationClickable: true,
				autoplay : 2000,
			});

			}
		}
	})
}

/**
 * 获取商品分类
 */
function getProductType(){
	var level=0;
	var currrntPage=-1;
	var pageSize=-1;
	$.ajax({
		type: "post",
		url: "http://localhost:8080/pmsProductCategory/listPmsProductCategoryByPage",
		data: {
			"level": level
		},
		dataType: 'json',
		async: true,
		success: function(data) {
			console.log(data);
			var msg=data.code;
			if(msg!=200) {
				console.log(msg);
			} else {
				var a=data.data.content;
				var s='';
				for(var i=0;i<a.length;i++){
					s+=' <div class="cat-box"> <div class="title"> <i class="iconfont icon-skirt ce"></i>'+a[i].name+' </div><ul class="cat-list clearfix"> <li>下装</li><li>上装</li><li>裙装</li><li>内衣</li></ul> <div class="cat-list__deploy"> <div class="deploy-box"> ';
					var b=a[i].children;
					for(var j=0;j<b.length;j++){
						s+='<div class="genre-box clearfix"> <span class="title">'+b[j].name+'：</span> '
						var c=b[j].children;
						if(c.length >0){
							s+='<div class="genre-list">'
							for(var k=0;k<c.length;k++){
								s+='<a href="">'+c[k].name+'</a>';
							}
							s+='</div>'
						}
						s+='</div>'
					}
					s+='</div></div></div>';
				}
				$(".cat-list__box").html(s);
			}
		}
	})
}