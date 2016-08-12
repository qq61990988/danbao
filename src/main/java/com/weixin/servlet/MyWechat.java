package com.weixin.servlet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.sword.wechat4j.WechatSupport;

import com.danbao.service.UserService;

import config.PropertyPlaceholderConfigurerExt;


public class MyWechat extends WechatSupport {

	Logger log=Logger.getLogger(this.getClass());
	
	private static Logger logger = Logger.getLogger(MyWechat.class);

	@Resource
	private UserService userService;
	
	public MyWechat(HttpServletRequest request) {
		super(request);		
	}

	/**
	 * 文本消息
	 */
	@Override
	protected void onText() {
		String content = super.wechatRequest.getContent().trim();
//		String msgId = wechatRequest.getMsgId();
		logger.info(content);

		String openid=super.wechatRequest.getFromUserName();
		String type="";
	
	}
	/**
	 * 图片消息
	 */
	@Override
	protected void onImage() {
		
		String picUrl = wechatRequest.getPicUrl();
		String MediaId = wechatRequest.getMediaId();
		String MsgId = wechatRequest.getMsgId();
		
		String openid=super.wechatRequest.getFromUserName();
		String type="";
				
		//String result = "图片消息picUrl:" + picUrl + "    其它MediaId:" + MediaId + ", MsgId:" + MsgId;
		//logger.info(result);
		
		
		
		//responseImage(mediaId);
	}

	/**
	 * 语音消息
	 */
	@Override
	protected void onVoice() {
		String Format = wechatRequest.getFormat();
		String MediaId = wechatRequest.getMediaId();//视频消息媒体id，可以调用多媒体文件下载接口拉取数据
		String MsgId = wechatRequest.getMsgId();
		
		String result = "语音消息Format:" + Format + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
		logger.info(result);
		responseText(result);	
		//responseVoice(mediaId);
		
		//回复音乐消息
//		MusicResponse music = new MusicResponse();
//		music.setTitle(title);
//		music.setDescription(description);
//		music.setMusicURL(musicURL);
//		music.setHQMusicUrl(hQMusicUrl);
//		music.setThumbMediaId(thumbMediaId);
//		responseMusic(music);
//		
//		responseMusic(title, description, musicURL, hQMusicUrl, thumbMediaId);
	}

	/**
	 * 视频消息
	 */
	@Override
	protected void onVideo() {
		String ThumbMediaId = wechatRequest.getThumbMediaId();
		String MediaId = wechatRequest.getMediaId();//语音消息媒体id，可以调用多媒体文件下载接口拉取数据
		String MsgId = wechatRequest.getMsgId();
		
		String result = "视频消息ThumbMediaId:" + ThumbMediaId + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
		logger.info(result);
		responseText(result);
		
		//回复视频消息
//		VideoResponse video = new VideoResponse();
//		video.setTitle(title);
//		video.setDescription(description);
//		video.setMediaId(mediaId);
//		responseVideo(video);
//		
//		responseVideo(mediaId, title, description);
	}
	
	/**
	 * 地理位置消息
	 */
	@Override
	protected void onLocation() {
		String Location_X = wechatRequest.getLocation_X();
		String Location_Y = wechatRequest.getLocation_Y();
		String Scale = wechatRequest.getScale();
		String Label = wechatRequest.getLabel();
		String MsgId = wechatRequest.getMsgId();
		
		String result = "地理位置消息Location_X:" + Location_X + ", Location_Y:" + Location_Y + 
				", Scale:" + Scale + ", Label:" + Label + 
				", MsgId:" + MsgId;
		logger.info(result);
		responseText(result);	
	}
	/**
	 * 链接消息
	 */
	@Override
	protected void onLink() {
		String Title = wechatRequest.getTitle();
		String Description = wechatRequest.getDescription();
		String Url = wechatRequest.getUrl();
		String MsgId = wechatRequest.getMsgId();
		
		String result = "链接消息Title:" + Title + ", Description:" + Description + 
				", Url:" + Url + 
				", MsgId:" + MsgId;
		logger.info(result);
		responseText(result);	
	}
	
	
	/**
	 * 未知消息类型，错误处理
	 */
	@Override
	protected void onUnknown() {
		String msgType = wechatRequest.getMsgType();
		
		String result = "未知消息msgType:" + msgType;
		logger.info(result);
		responseText(result);

	}

	/**
	 * 扫描二维码事件
	 */
	@Override
	protected void scan() {
		String FromUserName = wechatRequest.getFromUserName();
		String Ticket = wechatRequest.getTicket();
		
		String result = "扫描二维码事件FromUserName:" + FromUserName + ", Ticket:" + Ticket;
		logger.info(result);
		responseText(result);
	}

	/**
	 * 订阅事件
	 */
	@Override
	protected void subscribe() {
		String FromUserName = wechatRequest.getFromUserName();
		//用户未关注时扫描二维码事件,会多一个EventKey和Ticket节点
		String Ticket = wechatRequest.getTicket();

		String result = "感谢您关注"+PropertyPlaceholderConfigurerExt.NAME+"，功能不变，服务升级，如有疑问或建议请点击联系客服。菜单：帮助 > 联系客服";
		if(StringUtils.isNotBlank(Ticket)){
			result = "扫描带场景值二维码事件FromUserName:" + FromUserName + ", Ticket:" + Ticket;
		}
		logger.info(result);
		responseText(result);
	}
	
	/**
	 * 取消订阅事件
	 */
	@Override
	protected void unSubscribe() {
		String FromUserName = wechatRequest.getFromUserName();
		String result = "取消订阅事件FromUserName:" + FromUserName;
		logger.info(result);
		responseText(result);
	}
	
	/**
	 * 点击菜单跳转链接时的事件推送
	 */
	@Override
	protected void view() {
		String link = super.wechatRequest.getEventKey();
		logger.info("点击菜单跳转链接时的事件推送link:" + link);
		responseText("点击菜单跳转链接时的事件推送link:" + link);
	}

	/**
	 * 自定义菜单事件
	 */
	@Override
	protected void click() {
		String key = super.wechatRequest.getEventKey();
		logger.info("自定义菜单事件eventKey:" + key);
		
		String openid=super.wechatRequest.getFromUserName();

		
	}
	
	/**
	 * 上报地理位置事件
	 */
	@Override
	protected void location() {
		String Latitude = wechatRequest.getLatitude();
		String Longitude = wechatRequest.getLongitude();
		String Precision = wechatRequest.getPrecision();
		String result = "上报地理位置事件Latitude:" + Latitude + ", Longitude:" + Longitude + ", Precision:" + Precision;
		logger.info(result);
		responseText(result);
	}
	
	/**
	 * 模板消息发送成功推送事件
	 */
	@Override
	protected void templateMsgCallback() {
		String MsgID = wechatRequest.getMsgId();
		String Status = wechatRequest.getStatus();
		String result = "模板消息发送成功推送事件MsgID:" + MsgID + ", Status:" + Status;
		logger.info(result);
	}
	/**
	 * 弹出地理位置选择器的事件
	 */
	@Override
	protected void locationSelect() {
		String Location_X = wechatRequest.getSendLocationInfo().getLocation_X();
		String Location_Y = wechatRequest.getSendLocationInfo().getLocation_Y();
		String Scale = wechatRequest.getSendLocationInfo().getScale();
		String Label = wechatRequest.getSendLocationInfo().getLabel();
		String Poiname = wechatRequest.getSendLocationInfo().getPoiname();
		String result = "弹出地理位置选择器的事件Location_X:" + Location_X + 
				", Location_Y:" + Location_Y+ 
				", Scale:" + Scale+ 
				", Label:" + Label+ 
				", Poiname:" + Poiname;
		logger.info(result);
		responseText(result);
	}
	/**
	 * 弹出拍照或者相册发图的事件
	 */
	@Override
	protected void picPhotoOrAlbum() {
		String Count = wechatRequest.getSendPicsInfo().getCount();
		String PicMd5Sum = "";
		if(StringUtils.isNotBlank(Count) && !Count.equals("0")){
			PicMd5Sum = wechatRequest.getSendPicsInfo().getItem().get(0).getPicMd5Sum();
		}
		String result = "弹出系统拍照发图的事件Count:" + Count + ", PicMd5Sum:" + PicMd5Sum;
		logger.info(result);
		responseText(result);
	}
	/**
	 * 弹出系统拍照发图的事件
	 */
	@Override
	protected void picSysPhoto() {
		//String Count = wechatRequest.getSendPicsInfo().getCount();
		//String result = "弹出系统拍照发图的事件Count:" + Count ;
		//logger.info(result);
		//responseText(result);

		String openid=super.wechatRequest.getFromUserName();
	}
	/**
	 * 弹出微信相册发图器的事件推送
	 */
	@Override
	protected void picWeixin() {
		String Count = wechatRequest.getSendPicsInfo().getCount();
		String result = "弹出系统拍照发图的事件Count:" + Count ;
		logger.info(result);
		responseText(result);
	}
	/**
	 * 扫码推事件
	 * 
	 */
	@Override
	protected void scanCodePush() {
		String ScanType = wechatRequest.getScanCodeInfo().getScanType();
		String ScanResult = wechatRequest.getScanCodeInfo().getScanResult();
		String result = "扫码推事件ScanType:" + ScanType + ", ScanResult:" + ScanResult;
		logger.info(result);
		responseText(result);
	}
	/**
	 * 扫码推事件且弹出“消息接收中”提示框的事件
	 */
	@Override
	protected void scanCodeWaitMsg() {
		String ScanType = wechatRequest.getScanCodeInfo().getScanType();
		String ScanResult = wechatRequest.getScanCodeInfo().getScanResult();
		String result = "扫码推事件ScanType:" + ScanType + ", ScanResult:" + ScanResult;
		logger.info(result);
		responseText(result);
	}

	protected void onShortVideo(){}
	protected void kfCreateSession(){}
	protected void kfCloseSession(){}
	protected void kfSwitchSession(){}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
