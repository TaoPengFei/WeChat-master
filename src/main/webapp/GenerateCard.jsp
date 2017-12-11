<%--
  Created by IntelliJ IDEA.
  User: tpf
  Date: 11/16/17
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会员卡</title>
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
<script type="application/javascript">
//var url =location.href.split('?')[0]+'?'+encodeURIComponent(location.href.split('?')[1]);
var url = location.href.split('#')[0];
    $(function() {
        console.log('会员卡');
        alert("查看地址");
        alert(location.href.split('#')[0]);
        $.ajax({
            url : "./Signature/getSignature.do?param="+url,
            dataType : 'json',
            async: false,
            type : 'post',
            success : function(data) {
                console.log(data);
                var signature = data.signature;
                var timestamp = data.timestamp;
                var nonceStr = data.nonceStr;
                var jsapiticket = data.jsapiticket;
                var GAddCardSign = data.GAddCardSign;
                var openid = data.openid;
                // 通过config接口注入权限验证配置
                wx.config({
                    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    appId: 'wx7ae52acace660eb5', // 必填，公众号的唯一标识
                    timestamp: timestamp, // 必填，生成签名的时间戳
                    nonceStr: nonceStr+'', // 必填，生成签名的随机串
                    signature: signature+'',// 必填，签名，见附录1
                    jsApiList: [
                        'addCard'
                    ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                });
                // 通过ready接口处理成功验证
                var cardExlist = {
                		code:'310028280558',
                		openid:openid,
                		timestamp:timestamp	,
                		nonce_str:nonceStr,
                		signature:GAddCardSign
                };
                var cardExtlistjson = JSON.stringify(cardExlist).toString(); 
                alert(cardExtlistjson);
                wx.ready(function(){
                	wx.addCard({
                        cardList: [{
                            cardId: 'pAf4H04LCSEqkbUHq64Z05MRgtvw',
                            cardExt: cardExtlistjson
                        }], // 需要添加的卡券列表
                        success: function (res) {
                            var cardList = res.cardList; // 添加的卡券列表信息
                            alert('领取卡券success' + JSON.stringify(res.cardList));
                            console.log('------------- success ---------');
                            console.log(cardList);
                        },
                        fail: function (res) {
                            //var cardList = res.cardList; // 添加的卡券列表信息
                            console.log('------------- fail ---------');
                            console.log(res);
                        }
                    });
                });
                wx.error(function(res){
                    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
                    console.log(res);
                    alert(res);
                });
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log('------------- $.ajax()调用失败 ---------');
                console.log(XMLHttpRequest.status);
                console.log(XMLHttpRequest.readyState);
                console.log(textStatus);
            }
        });
    });
</script>
</html>
