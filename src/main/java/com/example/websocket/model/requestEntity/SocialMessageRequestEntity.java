package com.example.websocket.model.requestEntity;



import java.io.Serializable;
import java.util.List;

public class SocialMessageRequestEntity implements Serializable {

	private String team;
	private String messageId;
	private String fromUsername;
	private String roomId;
	private String body;
	private String photoId;
	private String mediaId;
	private String mediaFilename;
	private String mediaURL;
	private String photoURL;
	private String photoThumbnail;
	private String photoWidth;
	private String photoHeight;
	private int type;
	private String messageUUID;
	private String messageExtension;
	private String timeStamp;
	private String socialMessageId;
	private String tag;
	private List<String> carbonMessageReceiverList;
	private int messageDeliveryMethod;
	private String toUsername;
	private String messageStatus;

	/** for LINE only **/
	private String replyToken;

	private Object extraData;
	private boolean withTransactionLinks = false;

	public SocialMessageRequestEntity() {

	}



	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getFromUsername() {
		return fromUsername;
	}
	public void setFromUsername(String fromUsername) {
		this.fromUsername = fromUsername;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public String getPhotoThumbnail() {
		return photoThumbnail;
	}
	public void setPhotoThumbnail(String photoThumbnail) {
		this.photoThumbnail = photoThumbnail;
	}
	public String getPhotoWidth() {
		return photoWidth;
	}
	public void setPhotoWidth(String photoWidth) {
		this.photoWidth = photoWidth;
	}
	public String getPhotoHeight() {
		return photoHeight;
	}
	public void setPhotoHeight(String photoHeight) {
		this.photoHeight = photoHeight;
	}	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMessageUUID() {
		return messageUUID;
	}
	public void setMessageUUID(String messageUUID) {
		this.messageUUID = messageUUID;
	}
	public String getMessageExtension() {
		return messageExtension;
	}
	public void setMessageExtension(String messageExtension) {
		this.messageExtension = messageExtension;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getSocialMessageId() {
		return socialMessageId;
	}
	public void setSocialMessageId(String socialMessageId) {
		this.socialMessageId = socialMessageId;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public List<String> getCarbonMessageReceiverList() {
		return carbonMessageReceiverList;
	}
	public void setCarbonMessageReceiverList(List<String> carbonMessageReceiverList) {
		this.carbonMessageReceiverList = carbonMessageReceiverList;
	}


	public int getMessageDeliveryMethod() {
		return messageDeliveryMethod;
	}

	public void setMessageDeliveryMethod(int messageDeliveryMethod) {
		this.messageDeliveryMethod = messageDeliveryMethod;
	}

	public String getToUsername() {
		return toUsername;
	}

	public void setToUsername(String toUsername) {
		this.toUsername = toUsername;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaFilename() {
		return mediaFilename;
	}

	public void setMediaFilename(String mediaFilename) {
		this.mediaFilename = mediaFilename;
	}

	public String getMediaURL() {
		return mediaURL;
	}

	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}

	public Object getExtraData() {
		return extraData;
	}

	public void setExtraData(Object extraData) {
		this.extraData = extraData;
	}

	public String getReplyToken() {
		return replyToken;
	}

	public void setReplyToken(String replyToken) {
		this.replyToken = replyToken;
	}

	public boolean isWithTransactionLinks() {
		return withTransactionLinks;
	}

	public void setWithTransactionLinks(boolean withTransactionLinks) {
		this.withTransactionLinks = withTransactionLinks;
	}


}
