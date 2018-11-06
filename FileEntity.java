package br.com.yaman.jmeter.csv.entity;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FileEntity implements Serializable {

	private static final long serialVersionUID = -3196333826913603084L;

	private Date timeStamp;
	private float elapsed;
	private String label;
	private int responseCode;
	private String responseMessage;
	private String threadName;
	private String dataType;
	private Boolean success;
	private String failureMessage;
	private Long bytes;
	private Long sentBytes;
	private Integer grpThreads;
	private Integer allThreads;
	private Long latency;
	private Long idleTime;
	private Integer connect;
	private Double media;
	private Double pct90;

	public FileEntity() {
		// TODO Auto-generated constructor stub
	}

	public FileEntity(Date timeStamp, float elapsed, String label, int responseCode, String responseMessage,
			String threadName, String dataType, Boolean success, String failureMessage, Long bytes, Long sentBytes,
			Integer grpThreads, Integer allThreads, Long latency, Long idleTime, Integer connect, Double media,
			Double pct90) {
		super();
		this.timeStamp = timeStamp;
		this.elapsed = elapsed;
		this.label = label;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.threadName = threadName;
		this.dataType = dataType;
		this.success = success;
		this.failureMessage = failureMessage;
		this.bytes = bytes;
		this.sentBytes = sentBytes;
		this.grpThreads = grpThreads;
		this.allThreads = allThreads;
		this.latency = latency;
		this.idleTime = idleTime;
		this.connect = connect;
		this.media = media;
		this.pct90 = pct90;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public float getElapsed() {
		return elapsed;
	}

	public void setElapsed(float elapsed) {
		this.elapsed = elapsed;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	public Long getBytes() {
		return bytes;
	}

	public void setBytes(Long bytes) {
		this.bytes = bytes;
	}

	public Long getSentBytes() {
		return sentBytes;
	}

	public void setSentBytes(Long sentBytes) {
		this.sentBytes = sentBytes;
	}

	public Integer getGrpThreads() {
		return grpThreads;
	}

	public void setGrpThreads(Integer grpThreads) {
		this.grpThreads = grpThreads;
	}

	public Integer getAllThreads() {
		return allThreads;
	}

	public void setAllThreads(Integer allThreads) {
		this.allThreads = allThreads;
	}

	public Long getLatency() {
		return latency;
	}

	public void setLatency(Long latency) {
		this.latency = latency;
	}

	public Long getIdleTime() {
		return idleTime;
	}

	public void setIdleTime(Long idleTime) {
		this.idleTime = idleTime;
	}

	public Integer getConnect() {
		return connect;
	}

	public void setConnect(Integer connect) {
		this.connect = connect;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public Double getPct90() {
		return pct90;
	}

	public void setPct90(Double pct90) {
		this.pct90 = pct90;
	}

	@Override
	public String toString() {
		return "FileEntity [timeStamp=" + timeStamp + ", elapsed=" + elapsed + ", label=" + label + ", responseCode="
				+ responseCode + ", responseMessage=" + responseMessage + ", threadName=" + threadName + ", dataType="
				+ dataType + ", success=" + success + ", failureMessage=" + failureMessage + ", bytes=" + bytes
				+ ", sentBytes=" + sentBytes + ", grpThreads=" + grpThreads + ", allThreads=" + allThreads
				+ ", latency=" + latency + ", idleTime=" + idleTime + ", connect=" + connect + "]";
	}

}
