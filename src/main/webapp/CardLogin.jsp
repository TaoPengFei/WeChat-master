<%--
  Created by IntelliJ IDEA.
  User: tpf
  Date: 11/16/17
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>领取会员卡</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
    <link rel="stylesheet" href="plugins/weui/dist/style/weui.css"/>
    <link rel="stylesheet" href="plugins/weui/dist/example/example.css"/>
    <style type="text/css">
        .CardBtn {
            position: relative;
            display: block;
            margin-left: auto;
            margin-right: auto;
            padding-left: 14px;
            padding-right: 14px;
            box-sizing: border-box;
            font-size: 18px;
            text-align: center;
            text-decoration: none;
            color: #FFFFFF;
            line-height: 2.55555556;
            border-radius: 0px;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
            overflow: hidden;
        }
        .CardCells {
            margin-top: 0em;
            background-color: #FFFFFF;
            line-height: 1.47058824;
            font-size: 17px;
            overflow: hidden;
            position: relative;
            padding-top: 1.17647059em;
        }
        .page, body {
            background-color: #f8f8f8;
            overflow: hidden;
        }
    </style>
</head>
<body>
<div id="loadingToast" >
    <div class="weui-mask_transparent"></div>
    <div class="weui-toast">
        <i class="weui-loading weui-icon_toast"></i>
        <p class="weui-toast__content">数据加载中</p>
    </div>
</div>
<div class="page__hd">
    <h1 class="page__title"></h1>
    <%--<p class="page__desc"></p>--%>
</div>
<%-- <div class="weui-cells__title">领取会员卡</div> --%>
<div class="weui-cells weui-cells_form" id='cardMember'>
    <div class="weui-cell weui-cells_form">
        <div class="weui-cell__hd"><label class="weui-label">卡号</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="number" pattern="[0-9]*" id="id_securityCode_input"  placeholder="请输入会员卡帐号"/>
        </div>
        <div class="weui-cell__ft">
            <button class="weui-vcode-btn" id="scanQRCode" onclick="scanQRCode()">扫码</button>
        </div>

    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">密码</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="password" pattern="[0-9]*" placeholder="不少于6位"/>
        </div>
    </div>
</div>
<div class="weui-cells weui-cells_form" id="addCard">
    <a class="weui-btn weui-btn_primary CardBtn" href="javascript:" id="showTooltips" onclick="addcard()">领取会员卡</a>
</div>




</body>
<!-- 引入WeUI前端UI框架 -->
<script src="plugins/weui/dist/example/zepto.min.js"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
<script src="plugins/weui/dist/example/example.js"></script>
<script type="text/javascript">
    document.onreadystatechange = function(){
        //alert(document.readyState);
        //alert($);
        if(document.readyState == 'complete'){
            document.getElementById('loadingToast').style.setProperty('display','none');
            document.getElementById('cardMember').style.removeProperty('display');
            document.getElementById('addCard').style.removeProperty('display');

            //$('#loadingToast').fadeOut();
            //$('#loadingToast').css('display') == 'none';
            //$('#cardMember').css('display') == 'none';
        }else{
            //$('#cardMember').fadeOut();
            document.getElementById('loadingToast').style.removeProperty('display');
            document.getElementById('cardMember').style.setProperty('display','none');
            document.getElementById('addCard').style.setProperty('display','none');

        }
    }
</script>

<script type="application/javascript">

    var url = location.href.split('#')[0];


    function scanQRCode(){

        $.ajax({
            url : "./Signature/scanQRCode.do?param="+url,
            dataType : 'json',
            async: false,
            type : 'post',
            success : function(data) {
                console.log(data);
                // 通过config接口注入权限验证配置
                wx.config({
                    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    appId: data.appid, // 必填，公众号的唯一标识
                    timestamp: data.timestamp, // 必填，生成签名的时间戳
                    nonceStr: data.nonceStr+'', // 必填，生成签名的随机串
                    signature: data.signature+'',// 必填，签名，见附录1
                    jsApiList: [
                        'scanQRCode'
                    ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                });
                // 通过ready接口处理成功验证

                wx.ready(function(){
                    wx.scanQRCode({
                        // 默认为0，扫描结果由微信处理，1则直接返回扫描结果
                        needResult : 1,
                        desc : 'scanQRCode desc',
                        success : function(res) {
                            //扫码后获取结果参数赋值给Input
                            var url = res.resultStr;
                            //商品条形码，取","后面的
                            if(url.indexOf(",")>=0){
                                var tempArray = url.split(',');
                                var tempNum = tempArray[1];
                                $("#id_securityCode_input").val(tempNum);
                            }else{
                                $("#id_securityCode_input").val(url);
                            }
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
    }
    function addcard(){
        var cardcode = $(" input[ type='number' ] ").val();
        if(cardcode==null||cardcode==""){
            return;
        }
        $.ajax({
            url : "./Signature/getSignature.do?param="+url+"&cardcode="+cardcode,
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
                var appid = data.appid;
                var cardId = data.cardId;
                // 通过config接口注入权限验证配置
                wx.config({
                    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    appId: appid, // 必填，公众号的唯一标识
                    timestamp: timestamp, // 必填，生成签名的时间戳
                    nonceStr: nonceStr+'', // 必填，生成签名的随机串
                    signature: signature+'',// 必填，签名，见附录1
                    jsApiList: [
                        'addCard'
                    ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                });
                // 通过ready接口处理成功验证
                var cardExlist = {
                    code:cardcode,
                    openid:openid,
                    timestamp:timestamp	,
                    nonce_str:nonceStr,
                    signature:GAddCardSign
                };
                var cardExtlistjson = JSON.stringify(cardExlist).toString();

                wx.ready(function(){
                    wx.addCard({
                        cardList: [{
                            cardId: cardId,
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

    }

</script>
</html>
