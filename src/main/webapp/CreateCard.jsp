<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <meta name="format-detection" content="telephone=no" />
    <meta name="viewport" content="width=device-width, initial-scale=0.35,  user-scalable=no">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <script src="plugins/jQuery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>
<body>

</body>
<script type="text/javascript">
	var createcard = {
		    "card": {
		        "card_type": "MEMBER_CARD",
		        "member_card": {
		            "background_pic_url": "https://mmbiz.qlogo.cn/mmbiz/",
		            "base_info": {
		                "logo_url": "http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZ/0",
		                "brand_name": "hidilao",
		                "code_type": "CODE_TYPE_TEXT",
		                "title": "haidilao",
		                "color": "Color010",
		                "notice": "haidilao",
		                "service_phone": "020-88888888",
		                "description": "haidilao",
		                "bind_openid":true,
		                
		                "date_info": {
		                    "type": "DATE_TYPE_PERMANENT"
		                },
		                "sku": {
		                    "quantity": 100000000
		                },
		                "get_limit": 1,
		                "use_custom_code": true,
		                "can_give_friend": true,
		                "custom_url_name": "haidilao",
		                "custom_url": "http://weixin.qq.com",
		                "custom_url_sub_title": "haidilao",
		                "promotion_url_name": "haidilao",
		                "promotion_url": "http://www.qq.com",
		                "need_push_on_view": true
		            },
		             "advanced_info": {
		               "use_condition": {
		                   "accept_category": "haidilao",
		                   "reject_category": "haidilao",
		                   "can_use_with_other_discount": true
		               },
		             "abstract": {
		                   "abstract": "haidilao",
		                   "icon_url_list": [
		                       "http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj  piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0"
		                   ]   
		               },
		               "text_image_list": [
		                   {
		                       "image_url": "http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0",
		                       "text": "haidilao"
		                   },
		                   {
		                       "image_url": "http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0",
		                       "text": "haidilao"
		                   }
		               ],
		               "time_limit": [
		                   {
		                       "type": "MONDAY",
		                       "begin_hour":0,
		                       "end_hour":10,
		                       "begin_minute":10,
		                       "end_minute":59
		                   },
		                   {
		                       "type": "HOLIDAY"
		                   }
		               ],
		               "business_service": [
		                   "BIZ_SERVICE_FREE_WIFI",
		                   "BIZ_SERVICE_WITH_PET",
		                   "BIZ_SERVICE_FREE_PARK",
		                   "BIZ_SERVICE_DELIVER"
		               ]
		           },
		            "supply_bonus": true,
		            "supply_balance": false,
		            "prerogative": "test_prerogative",
		            "auto_activate": true,
		            "custom_field1": {
		                "name_type": "FIELD_NAME_TYPE_LEVEL",
		                "url": "http://www.qq.com"
		            },
		            "activate_url": "http://www.qq.com",
		            "custom_cell1": {
		                "name": "haidilao",
		                "tips": "haidilao",
		                "url": "http://www.xxx.com"
		            },
		            "bonus_rule": {
		                "cost_money_unit": 100,
		                "increase_bonus": 1,
		                "max_increase_bonus": 200,
		                "init_increase_bonus": 10,
		                "cost_bonus_unit": 5,
		                "reduce_money": 100,
		                "least_money_to_use_bonus": 1000,
		                "max_reduce_bonus": 50
		            },
		            "discount": 10
		        }
		    }
		}

	 $(function() {
		 var cardExtlistjson = JSON.stringify(createcard).toString(); 
		 console.log(createcard);
		 console.log(cardExtlistjson);
		  $.ajax({
	            url : "./Signature/CreateCard.do?param="+cardExtlistjson,
	            dataType : 'json',
	            async: false,
	            type : 'post',
	            success : function(data) {
	            	 console.log(data);
	        		 alert(data.haidilao);
	            }
		  });
		 
	 });






</script>
</html>