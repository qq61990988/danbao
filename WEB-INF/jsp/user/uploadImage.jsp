<%@ page language="java" import="java.util.*,org.sword.wechat4j.token.TokenProxy,com.weixin.servlet.Sign,org.sword.wechat4j.common.Config" contentType="text/html; charset=UTF-8"%><%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>    
<html>    
<head>    
<meta charset="utf-8">    
<title>确认收款金额</title>    
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">    
<link rel="stylesheet" href="http://demo.open.weixin.qq.com/jssdk/css/style.css?ts=1420774989">
<link rel="stylesheet" href="../css/weui.min.css"/>   
</head>    
<body ontouchstart="">
<div class="wxapi_container">
    <div class="lbox_close wxapi_form">
     
      <h3 id="menu-image">图像接口</h3>
      <span class="desc">拍照或从手机相册中选图接口</span>
      <button class="btn btn_primary" id="chooseImage">chooseImage</button>
      <span class="desc">预览图片接口</span>
      <button class="btn btn_primary" id="previewImage">previewImage</button>
      <span class="desc">上传图片接口</span>
      <button class="btn btn_primary" id="uploadImage">uploadImage</button>
      <span class="desc">下载图片接口</span>
      <button class="btn btn_primary" id="downloadImage">downloadImage</button>

    </div>
</div>

	<div class="weui_cells weui_cells_form">
        <div class="weui_cell">
            <div class="weui_cell_bd weui_cell_primary">
                <div class="weui_uploader">
                    <div class="weui_uploader_hd weui_cell">
                        <div class="weui_cell_bd weui_cell_primary">图片上传</div>
                        <div class="weui_cell_ft">0/2</div>
                    </div>
                    
                    <div class="weui_uploader_bd">
                        <ul class="weui_uploader_files">
                            <li class="weui_uploader_file" id="style1id" style="background-image:url(http://shp.qpic.cn/weixinsrc_pic/pScBR7sbqjOBJomcuvVJ6iacVrbMJaoJZkFUIq4nzQZUIqzTKziam7ibg/); width:46%; height:100px;"></li>
                            <li class="weui_uploader_file" style="background-image:url(http://shp.qpic.cn/weixinsrc_pic/pScBR7sbqjOBJomcuvVJ6iacVrbMJaoJZkFUIq4nzQZUIqzTKziam7ibg/); width:46%; height:100px;"></li>
                            <li class="weui_uploader_file" style="background-image:url(http://shp.qpic.cn/weixinsrc_pic/pScBR7sbqjOBJomcuvVJ6iacVrbMJaoJZkFUIq4nzQZUIqzTKziam7ibg/); width:95%; height:160px;"></li>
                        </ul>                                       
                    </div>
                </div>
            </div>
        </div>
    </div>
  
  
</body>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>    
<script src="../js/jquery-1.9.1.min.js"></script>    

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+path;
System.out.println(basePath+"/page/uploadImage.do");
Map<String, String> map=Sign.sign(TokenProxy.jsApiTicket(), basePath+"/page/uploadImage.do");

%>
<script>    
/*    
* 注意：    
* 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。    
* 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。    
* 3. 完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html    
*    
* 如有问题请通过以下渠道反馈：    
* 邮箱地址：weixin-open@qq.com    
* 邮件主题：【微信JS-SDK反馈】具体问题    
* 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。    
*/    
wx.config({    
debug: true,    
appId: '<%=Config.instance().getAppid() %>',    
timestamp: <%=map.get("timestamp") %>,    
nonceStr: '<%=map.get("nonceStr") %>',    
signature: '<%=map.get("signature") %>',    
jsApiList: [      
		'chooseImage',
        'previewImage',
        'uploadImage',
        'downloadImage'
]    
});    

wx.ready(function () {
  
  // 5 图片接口
  // 5.1 拍照、本地选图
  var images = {
    localId: [],
    serverId: []
  };
  document.querySelector('#chooseImage').onclick = function () {
    wx.chooseImage({
      success: function (res) {
        images.localId = res.localIds;
        alert('已选择 ' + res.localIds.length + ' 张图片');
        if(res.localIds.length>0){
	       //$("#style1id").css({ background-image: "http://img3.douban.com/view/photo/photo/public/p2152117150.jpg", width:"160px", height:"100px" });
        	
        	$("#style1id").css("width","46%");
        	$("#style1id").css("hight","100px");
        	$("#style1id").css("background-image","url(http://test.saopay.net/danbao/images/123.png)");
        	alert($("#style1id").css("background-image"));
        }
      }
    });
  };

  // 5.2 图片预览
  document.querySelector('#previewImage').onclick = function () {
    wx.previewImage({
      current: 'http://img5.douban.com/view/photo/photo/public/p1353993776.jpg',
      urls: [
        'http://img3.douban.com/view/photo/photo/public/p2152117150.jpg',
        'http://img5.douban.com/view/photo/photo/public/p1353993776.jpg',
        'http://img3.douban.com/view/photo/photo/public/p2152134700.jpg'
      ]
    });
  };

  // 5.3 上传图片
  document.querySelector('#uploadImage').onclick = function () {
    if (images.localId.length == 0) {
      alert('请先使用 chooseImage 接口选择图片');
      return;
    }
    var i = 0, length = images.localId.length;
    images.serverId = [];
    function upload() {
      wx.uploadImage({
        localId: images.localId[i],
        success: function (res) {
          i++;
          //alert('已上传：' + i + '/' + length);
          images.serverId.push(res.serverId);
          if (i < length) {
            upload();
          }
        },
        fail: function (res) {
          alert(JSON.stringify(res));
        }
      });
    }
    upload();
  };

  // 5.4 下载图片
  document.querySelector('#downloadImage').onclick = function () {
    if (images.serverId.length === 0) {
      alert('请先使用 uploadImage 上传图片');
      return;
    }
    var i = 0, length = images.serverId.length;
    images.localId = [];
    function download() {
      wx.downloadImage({
        serverId: images.serverId[i],
        success: function (res) {
          i++;
          alert('已下载：' + i + '/' + length);
          images.localId.push(res.localId);
          if (i < length) {
            download();
          }
        }
      });
    }
    download();
  };
  
});

wx.error(function (res) {
  alert(res.errMsg);
});

</script>    
</html>
