package gov.wapa.kdemo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This loadforecast class is for demo purpose. A record type will indicate
 * whether this is a load forecast record. The persistence model that we would
 * like to promote is that is no update only add is supported. If a record
 * already exists, a new one is create where the version number is incremented.
 * The primary constraint is id and version number. The first record is id and
 * version 0; When retrieve records, we need to always get the latest version
 * number.
 * 
 * @author eromu
 *
 */
public class LoadForecast {
	private long id;
	private long recordType;
	private long unitOfMeasure;
	private int minuteInterval;

	private String title;
	private String description;
	private String comment;

	private Date startDate;
	private Date endDate;

	private Date updateDateTime;
	private String updatedBy;


	public LoadForecast() {
	}

	public LoadForecast(long id, long recordType, long unitOfMeasure, int minuteInterval, String title,
			String description, String comment, Date startDate, Date endDate) {

		this.id = id;
		this.recordType = recordType;
		this.unitOfMeasure = unitOfMeasure;
		this.minuteInterval = minuteInterval;

		this.title = title;
		this.description = description;
		this.comment = comment;

	}

	/********************************
	 * properties
	 ********************************/

	/**
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public long getRecordType() {
		return recordType;
	}

	public void setRecordType(long recordType) {
		this.recordType = recordType;
	}

	/**
	 * 
	 * @return
	 */
	public long getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(long unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	/**
	 * 
	 * @return
	 */
	public int getMinuteInterval() {
		return minuteInterval;
	}

	public void setMinuteInterval(int minuteInterval) {
		this.minuteInterval = minuteInterval;
	}

	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 
	 * @return
	 */
	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	/**
	 * 
	 * @return
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	

}
