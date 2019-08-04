var discount_json_url = 'https://show.metinfo.cn/muban/M1156012/359/shop/discount.php?lang=cn&a=domydiscount',
        discount_listjson_url = 'https://show.metinfo.cn/muban/M1156012/359/shop/discount.php?lang=cn&a=dodiscount_list',
        discount_receive_url = 'https://show.metinfo.cn/muban/M1156012/359/shop/discount.php?lang=cn&a=doreceive';
window.is_login=$('.product-favorite').length?$('.product-favorite').attr('href').indexOf('favorite')>=0:false,
	$topcart=$("#topcart-body,#topcart-body2");
$(function(){
	// 右上角购物车
	if($topcart.length){
        loadTopcart();
        // 删除商品
        $topcart.on('click','.topcart-remove',function(e){
            e.preventDefault();
            $(this).parents('.list-group-item').append('<div class="padding-vertical-15 vertical-align text-center cart-loader"><div class="loader vertical-align-middle loader-default"></div></div>').find('.media').hide();
            $.ajax({
                url:$(this).attr('href'),
                type:'POST',
                dataType:'json',
                success:function(data){
                    if(data.error){
                        $topcart.find('.cart-loader').remove();
                        $topcart.find('.media').show();
                        alertify.error(data.error);
                    }else if(data.success){
                        setTimeout(function(){
                            alertify.success(data.success);
                            var $topcart_dropdown=$topcart.parents('.scrollable');
                            if($topcart.find('.list-group-item').length>1) $topcart.find('.cart-loader').parents('.list-group-item').remove();
                            loadTopcart('new');
                            $topcart_dropdown.asScrollable('update');
                            $topcart_dropdown.asScrollable('unStyle');
                        },300)
                    }
                }
            });
        });
        $('.shopcart').click(function() {
            if(!$topcart.is(':visible')) $topcart.parent('.scrollable-container').height('');
        });
    }
});
// 右上角购物车function
function loadTopcart(d){
	if(!d) $topcart.html('<div class="height-100 vertical-align text-center cart-loader"><div class="loader vertical-align-middle loader-default"></div></div>');
	loadCartJson(function(json){
		var html = '',num=0;
		$.each(json, function(i, item){
			item.shopmax = item.purchase>0?item.purchase:item.stock;
			item.img=item.img.replace(M['weburl'],'');
			item.img=M['weburl']+'include/thumb.php?dir='+item.img+'&x=40&y=40';
			html += '<div class="list-group-item" role="menuitem">'+
						'<div class="media">'+
							'<div class="media-left padding-right-10">'+
								'<a class="avatar text-middle" target="_blank" href="'+item.url+'">'+
									'<img class="img-responsive" src="'+item.img+'" alt="">'+
								'</a>'+
							'</div>'+
							'<div class="media-body">'+
								'<div class="pull-right text-right">'+
									'<span>'+item.price_str+' x '+item.amount+'</span>'+
									'<p><a href="'+delurl+'&id='+item.id+'" class="topcart-remove"><i class="icon wb-trash" aria-hidden="true"></i></a></p>'+
								'</div>'+
								'<h6 class="media-heading font-weight-unset">'+
									'<a target="_blank" href="'+item.url+'">'+
										item.name+
									'</a>'+
								'</h6>'+
								'<p>'+item.para_str+'</p>'+
							'</div>'+
						'</div>'+
					'</div>';
			num++;
		})
		if(html==''){
			html='<div class="height-100 text-center vertical-align"><div class="vertical-align-middle">'+SHOPLANG.app_shop_emptycart+'</div></div>';
			$('.dropdown-menu-footer').hide();
		}else{
			$('.dropdown-menu-footer').show();
			topcartTotal(json);
		}
		$('.topcart-goodnum').html(num).removeClass('hide');
		if(d&&!num || !d) $topcart.html(html);
	},d);
}
// 购物车价格
function topcartTotal(json){
	$.ajax({
		url: totalurl,
		type: "GET",
		cache: false,
		dataType: "jsonp",
		success: function(data) {
			if(data.message == 'ok'){
				$('.topcarttotal').html(data.price.goods.total_str);
			}
		}
	});
}
// 购物车数据
function loadCartJson(func,d){
	$.ajax({
		url: jsonurl,
		type: 'POST',
		dataType:'json',
		success: function(json) {
			func(json);
		}
	});
}
$(function(){
	// 产品详情页
	if($(".shop-product-intro").length){
		$('[data-plugin="touchSpin"]').TouchSpin();// 数量
		// 立即购买 && 加入购物车
		$(document).on('click', '.product-buynow,.product-tocart', function(e) {
			e.preventDefault();
			var f = true;
			$(".selectpara-body").each(function(){
				if($('.selectpara.btn-danger',this).length==0) f=false;
			});
			if(f){
				var paraval_str = encodeURIComponent(shopParaVal()).replace('*','u002A'),
                    url = $(this).attr('href')+'|'+paraval_str+'&num='+$("#buynum").val();
				location = url;
			}else{
				alertify.error(SHOPLANG.app_shop_choosepara);
			}
		});
		// 选择选项
		$('.selectpara').click(function(){
			if(!$(this).attr('disabled')){
				$(this).toggleClass('btn-danger').siblings().removeClass('btn-danger');
				stockPrice();
			}
		});
		stockPrice();
		// 商品收藏
		var $shop_collect=$('.product-favorite');
		$shop_collect.click(function(e){
			e.preventDefault();
			if(is_login){
				$.ajax({
					url: $(this).attr('href'),
					type: 'POST',
					dataType:'json',
					data:{pid:$(this).data('pid')},
					success: function(result) {
						if(result.status){
							if(result.msg==SHOPLANG.app_shop_favorite_ok){
								$shop_collect.removeClass('btn-warning').addClass('btn-success').find('span').html(SHOPLANG.app_shop_favorited);
				            	$shop_collect.find('i').removeClass('fa-heart-o').addClass('fa-heart');
							}else{
								$shop_collect.removeClass('btn-success').addClass('btn-warning').find('span').html(SHOPLANG.app_shop_favorite_add);
				                $shop_collect.find('i').removeClass('fa-heart').addClass('fa-heart-o');
							}
						}else{
							alertify.error(result.error);
						}
					}
				});
			}else{
				alertify.theme('bootstrap').okBtn(SHOPLANG.app_shop_ok).cancelBtn(SHOPLANG.app_shop_cancel).confirm(SHOPLANG.app_shop_needlogin, function (ev) {
					location=$shop_collect.attr('href');
				});
			}
		});
        // 展示图片点击复原
        var metimgsRecover=function(delay){
            var $img_current=$('#met-imgs-carousel .slick-current img').length?$('#met-imgs-carousel .slick-current img'):$('#met-imgs-carousel .slick-slide img'),
                delay=delay||0;
            setTimeout(function(){
                if($img_current.attr('src')!=$img_current.data('src')) $img_current.attr({src:$img_current.data('src')});
                if($('#met-imgs-carousel .slick-img-cover').length) $('#met-imgs-carousel .slick-img-cover').remove();
            },delay)
        };
		$('#met-imgs-carousel .slick-dots li').click(function() {
            if($(this).attr('aria-hidden')=='false') $(this).addClass('slick-active');
            metimgsRecover();
        });
        $('#met-imgs-carousel').on('beforeChange', function(){
            metimgsRecover(500);
        })
	}
});
// 获取选项
function shopParaVal(){
	var str='';
	$('.selectpara.btn-danger').each(function(index){
		if(index>0) str+=',';
		str+=$(this).data('val');
	});
	return str;
}
// 计算价格、规格图片切换、库存不足时禁止加入购物车
function stockPrice(){
	var str=shopParaVal(),
		$stock_num=$('#stock-num'),
		$touchspin=$('[data-plugin="touchSpin"]');
	$('.product-tocart').removeClass('disabled btn-dark');
	$('.stock-no').hide();
	$.each(stockjson,function(i,item){
		if(item.valuelist==str){
			var stock_max=item.stock;
			// 计算价格
			$("#price").html(item.price_str);
			$stock_num.html(item.stock);
			if(item.stock>$touchspin.data('max')) stock_max=$touchspin.data('max');
			$touchspin.trigger("touchspin.updatesettings",{min:1,max:stock_max});
			// 库存不足时禁止加入购物车
			if(item.stock==0){
				$touchspin.val(0);
				$touchspin.trigger("touchspin.updatesettings",{min:0});
				$('.product-tocart').addClass('disabled btn-dark');
				var $stock_no='<span class="red-600 stock-no">'+SHOPLANG.app_shop_lowstocks_min+'</span>';
				if($('.stock-no').length){
					$('.stock-no').show();
				}else{
					$('#buynum').parents('.form-group').append($stock_no);
				}
			}
			// 规格图片切换
			var $img_current=$('#met-imgs-carousel .slick-current img').length?$('#met-imgs-carousel .slick-current img'):$('#met-imgs-carousel .slick-slide img'),
				img_x=$img_current.width(),
				img_y=$img_current.height(),
				para_img=item.para_img?M['weburl']+'include/thumb.php?dir='+item.para_img+'&x='+img_x+'&y='+img_y:'',
				img_current_src=$img_current.attr('src'),
				img_current_datasrc=$img_current.data('src');
			if(para_img && para_img!=img_current_datasrc){
                $img_current.attr({src:para_img});
				if($('.met-showproduct.pagetype1').length) $img_current.parents('.slick-slide').after('<div class="slick-img-cover"></div>');
				$('#met-imgs-carousel .slick-dots .slick-active').removeClass('slick-active');
			}else{
				if(img_current_src!=img_current_datasrc) $img_current.attr({src:img_current_datasrc});
				if($('.slick-img-cover').length) $('.slick-img-cover').remove();
				$('#met-imgs-carousel .slick-dots li:eq(0)').click();
			}
		}
	});
}
$(function(){
    if($('.shoppro-discount').length){// 商品详情页、购物车页面
        discountListD();// 优惠券加载
        // 领取优惠券弹窗
        var $discount_receive_modal=$('#discount-received-modal'),
            $discount_modal=$discount_receive_modal.find('.pricing-list');
        $(document).on('click', '.shoppro-discount-list .btn', function() {
            var self_json=$(this).data('content-json'),
                $discount_modal_btn=$discount_modal.find('.btn');
            $discount_modal.find('.pricing-title').html($('span',this).html());
            $discount_modal.find('.pricing-amount').html(self_json.par);
            $discount_modal.find('.pricing-par strong').html(self_json.r_price);
            $discount_modal.find('.pricing-time span').html(self_json.s_time_str+' '+SHOPLANG.app_shop_to+' '+self_json.e_time_str);
            // $discount_modal.find('.pricing-range span').html(self_json.one_user_have);
            if(self_json.instructions){
                $discount_modal.find('.pricing-inst span').html(self_json.instructions).show();
            }else{
                $discount_modal.find('.pricing-inst').html('').hide();
            }
            if(self_json.state){
                $discount_modal.find('.pricing-header').addClass('bg-orange-600').removeClass('bg-red-600');
                $discount_modal_btn.addClass('btn-warning btn-receive').removeClass('btn-danger').find('.btn-text').html(SHOPLANG.app_shop_immediate_receive);
            }else{
                $discount_modal.find('.pricing-header').addClass('bg-red-600').removeClass('bg-orange-600');
                $discount_modal_btn.removeClass('btn-warning btn-receive').addClass('btn-danger').find('.btn-text').html(SHOPLANG.app_shop_immediate_use);
            }
            $discount_modal_btn.attr({'data-id':$(this).data('id')});
            $discount_modal.show();

            $('.discount-received-success').hide().find('.media-heading').html($('span',this).html());

            $discount_receive_modal.modal();
        });
        // 优惠券弹窗立即使用
        $(document).on('click', '#discount-received-modal .pricing-list .btn:not(.btn-receive),#discount-received-modal .btn-use', function() {
            $('#discount-received-modal').modal('hide');
        });
    }
    //优惠券领取
    $(document).on('click', '.btn-receive', function() {
        if(is_login){
            var $self=$(this);
            $.ajax({
                url: discount_receive_url,
                data:{id:$(this).attr('data-id')},
                type: 'POST',
                dataType:'json',
                success: function(result) {
                    result.status=parseInt(result.status);
                    if(result.status){
                        if($('.shop-discount-state').length){
                            // 待领取列表页
                            discountList();
                            alertify.success(SHOPLANG.app_shop_receiveok);
                            setTimeout(function(){
                                location.reload();
                            },500)
                        }else{
                            discountListD(true);// 产品详情页
                        }
                    }else{
                        alertify.error(result.info);
                    }
                }
            });
        }else{
            alertify.theme('bootstrap').okBtn(SHOPLANG.app_shop_ok).cancelBtn(SHOPLANG.app_shop_cancel).confirm(SHOPLANG.app_shop_needlogin, function (ev) {
                location=$('.product-favorite').attr('href');
            });
        }
    });
});
// 详情页优惠券加载
function discountListD(is_receive){
    for (var i = 0; i < 2; i++) {
        var discount_url=i?discount_listjson_url:discount_json_url,
            discount_data={pid:$('.product-favorite').data('pid')};
        if(!i) discount_data.state=i;
        discountJsonD(discount_url,discount_data,i);
    }
    if(is_receive) $('#discount-received-modal .pricing-list').hide().next('.discount-received-success').fadeIn();
}
// 详情页渲染优惠券数据
function discountJsonD(url,data,state){
    $.ajax({
        url: url,
        data: data,
        type: 'POST',
        dataType:'json',
        success: function(json) {
            if(json.length){
                var html = '',
                    price_str_prefix=$('#discount-received-modal .pricing-list .pricing-currency').html();
                if(state==0) var idnum=new Array();
                $.each(json,function(i,item){
                    if(idnum){
                        if(!idnum[item.id]) idnum[item.id]=0;
                        idnum[item.id]++;
                        if(idnum[item.id]>1) return true;
                    }
                    switch(state){
                        case 0:
                            item.btn='danger';
                            item.btn_txt='';
                            break;
                        case 1:
                            item.btn='warning';
                            item.btn_txt=' &nbsp;'+SHOPLANG.app_shop_receive;
                            break;
                    }
                    item.content_json={
                        state:state,
                        r_price:item.r_price,
                        par:item.par,
                        s_time_str:item.s_time_str,
                        e_time_str:item.e_time_str,
                        one_user_have:item.one_user_have,
                        instructions:item.instructions
                    };
                    item.content_json=JSON.stringify(item.content_json);
                    if((typeof device_type!='undefined' && device_type=='d') || (typeof deviceType!='undefined' && deviceType=='p')){
                        item.content="<div class='padding-10 blue-grey-500'>"+SHOPLANG.app_shop_discountvalue+"：<strong class='red-600 font-size-18'><span class='font-size-12'>"+price_str_prefix+"</span>"+item.par+"</strong><br />"+SHOPLANG.app_shop_order+SHOPLANG.app_shop_order_achieve+" <strong>"+item.r_price+"</strong> "+SHOPLANG.app_shop_canuser+"<br />"+SHOPLANG.app_shop_period_validity+"："+item.s_time_str+" "+SHOPLANG.app_shop_to+"<br />"+item.e_time_str+"<br />"+SHOPLANG.app_shop_receivelimit+" "+item.one_user_have+" "+SHOPLANG.app_shop_sheet;
                        if(item.instructions) item.content+="<br />"+SHOPLANG.app_shop_instructions+"："+item.instructions;
                        item.content+="</div>";
                    }else{
                        item.content='';
                    }
                    html+='<a href="javascript:;" class="btn btn-'+item.btn+' btn-outline btn-xs margin-top-5 margin-right-5" data-id="'+item.id+'" data-trigger="hover" data-animation="pop" data-placement="bottom" data-animation="fade" data-content="'+item.content+'" data-content-json=\''+item.content_json+'\'><span class="inline-block pull-left text-truncate">'+item.name+'</span>'+item.btn_txt+'</a>';
                });
                $('.shoppro-discount-list[data-state='+state+']').html(html);
                if((typeof device_type!='undefined' && device_type=='d') || (typeof deviceType!='undefined' && deviceType=='p')) $('.shoppro-discount-list[data-state='+state+'] .btn').webuiPopover({padding:0});
                if(idnum){
                    $.each(idnum,function(i,item){
                        if(item>1) $('.shoppro-discount-list .btn-danger[data-id='+i+']').append(' &nbsp; '+item+SHOPLANG.app_shop_sheet);
                    })
                }
                $('.shoppro-discount').removeAttr('hidden');
            }else{
                $('.shoppro-discount-list[data-state='+state+']').html('');
            }
        }
    });
}