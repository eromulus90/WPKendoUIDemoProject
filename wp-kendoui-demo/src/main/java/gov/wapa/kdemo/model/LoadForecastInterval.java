package gov.wapa.kdemo.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author eromu time series represent a list of values for a particular load
 *         forecast record. notice that this class does not specify any
 *         interval. The interval is dictate by the main record those values
 *         belong to. For example, if there are 96 time series and the main
 *         record dictates that the interval is 15 minutes We can display for 15
 *         minutes within an our. This is just a data display, it does not
 *         change the anything. The same list of series can also be display in 5
 *         minutes interval if the main records dictates that. For display
 *         purpose, use rank to group data by number of intervals within an
 *         hour. If the interval is 15 minutes, divide 60 minutes by 15 to get
 *         the number of records to group by. In this case, it would 4 15
 *         minutes for an hour. Do the same math for 10, 5 minute interval. If
 *         the interval is an 60 minutes, we are at the one hour interval.
 * 
 *         Here is an sql example using ranking to group every 4 records:
 *         https://stackoverflow.com/questions/7068235/group-by-every-n-records-in-t-sql
 * 
 *         WITH T AS ( SELECT RANK() OVER (ORDER BY sID) Rank, sID FROM docSVsys
 *         ) SELECT (Rank-1) / 1000 GroupID, count(sID) FROM T GROUP BY
 *         ((Rank-1) / 1000) order by GroupID
 *
 */
public class LoadForecastInterval {
	private long id;
	private long loadForecastId;
	private Date startDate;
	private Date endDate;
	private BigDecimal value;

	private Date updateDateTime;
	private String updatedBy;

	/********************************
	 * constructors
	 ********************************/
	public LoadForecastInterval() {
	}

	public LoadForecastInterval(long id, long loadForecastId, Date startDate, Date endDate, BigDecimal value) {

		this.id = id;
		this.loadForecastId = loadForecastId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.value = value;

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
	public long getLoadForecastId() {
		return loadForecastId;
	}

	public void setLoadForecastId(long loadForecastId) {
		this.loadForecastId = loadForecastId;
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
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
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
