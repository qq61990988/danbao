<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%><%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <link rel="stylesheet" href="../css/weui.min.css"/>
        <link rel="stylesheet" href="../css/user.css"/>
        <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>   
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
		
     
    </head>
<body ontouchstart>

    <div class="page">

    <div class="bd">
		
		<h1 class="page_title">Login</h1>


        <form id="myForm" action="../user/login.do" id="subform" method="POST">
        <input name="openid" type="hidden" value="${param.openid }"/>
        <div class="weui_cells_title">用户登录</div>
        <div class="weui_cells weui_cells_form">
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">账户：</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input id="tel" name="tel" class="weui_input" type="number" placeholder="请输入手机号"/>
                </div>               
            </div>  
             <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">密码：</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input id="password" name="password" class="weui_input" type="password" placeholder="请输账户密码"/>
                </div>         
                <div class="bodyContent"> 
                <a href="#">忘记密码?</a>
                </div>     
            </div>           
        </div>
        <div class="weui_cells_tips">
        <c:if test="${requestScope.error != null }">
        	<span style="color:red">${requestScope.error }</span>
		</c:if>
        </div>
        <div class="weui_btn_area">
            <a class="weui_btn weui_btn_primary" href="javascript:" id="showTooltips" onclick="submit1();">下一步</a>
            <a class="weui_btn weui_btn_default" href="../page/weixin_register.do?openid=${param.openid }" id="showTooltips">新用户注册</a>
        </div>
        </form>
    </div>
</div>
	<div id="loadingToast" class="weui_loading_toast" style="display:none;">
	   <div class="weui_mask_transparent"></div>
	   <div class="weui_toast">
	       <div class="weui_loading">
	           <!-- :) -->
	           <div class="weui_loading_leaf weui_loading_leaf_0"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_1"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_2"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_3"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_4"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_5"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_6"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_7"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_8"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_9"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_10"></div>
	           <div class="weui_loading_leaf weui_loading_leaf_11"></div>
	       </div>
	       <p class="weui_toast_content">数据加载中</p>
	   </div>
	</div>
	<!--BEGIN dialog2-->
	<div class="weui_dialog_alert" id="dialog2" style="display: none;">
	    <div class="weui_mask"></div>
	    <div class="weui_dialog">
	        <div class="weui_dialog_hd"><strong class="weui_dialog_title">失败提示</strong></div>
	        <div class="weui_dialog_bd">账户或密码有误，请重试！</div>
	        <div class="weui_dialog_ft">
	            <a href="javascript:;" class="weui_btn_dialog primary">确定</a>
	        </div>
	    </div>
	</div>
	<!--END dialog2-->
    </body ontouchstart>
    <script type="text/javascript">
	
		function submit1(){
			
      		$('#loadingToast').show();	
      						
			$.get("../user/login.do", { tel: $("input[id='tel']").val(), password: $("input[id='password']").val() },
			function(data){
			    //alert("Data Loaded: " + data);
			    var jsonObj = eval('(' + data + ')');
				if(jsonObj.result=="00"){
      				$('#loadingToast').hide();	
					alert("登录成功");
					//window.location.href="../page/weixin_success.do";
				}else{
      				$('#loadingToast').hide();	
      				$('#dialog2').show().on('click', '.weui_btn_dialog', function () {
			            $('#dialog2').off('click').hide();
			        });
				}
			});
		}

    </script>
</html>