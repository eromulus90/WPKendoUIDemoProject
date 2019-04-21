package gov.wapa.kdemo.service;
/*********************************************************************************************
*
* @COPYRIGHT 					(c) 2018 WAPA, BILLINGS,MONTANA ALL RIGHTS RESERVED 
* 				THIS SOFTWARE IS FURNISHED UNDER A LICENSE AND MAY BE USED AND COPIED ONLY IN
*            	ACCORDANCE WITH THE TERMS OF SUCH LICENSE AND WITH THE INCLUSION OF THE ABOVE COPYRIGHT NOTICE. 
*            	THIS SOFTWARE OR ANY OTHER COPIES THEREOF MAY NOT BE PROVIDED OR OTHERWISE MADE AVAILABLE TO ANY OTHER PERSON. 
*            	NO TITLE TO AND OWNERSHIP OF THE SOFTWARE IS HEREBY TRANSFERRED.
* 
* @DESCRIPTION : 	Define tabs and their tab items used in the tab navigation.
 * 					Override initializeTabs and add tabs and tab items to the list.
* 
* 
* @PROGRAM : application template :  11/15/2018 FUNCTION :
* 
* @ENVIRONMENT : java
* 
* 
* @MODIFICATION HISTORY:
*
* 
* @author Emmanuel Romulus
*
***********************************************************************************************/

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import gov.wapa.core.NavigationServiceBase;
import gov.wapa.core.NavigationTab;
import gov.wapa.core.NavigationTabItem;

/**
 * Define tabs and their tab items used in the tab navigation. Override
 * initializeTabs and add tabs and tab items to the list.
 * 
 * @author romulus
 *
 */
@Service
public class NavigationServiceImpl extends NavigationServiceBase {
	/**
	 * TODO: REPLACE TABS AND TAB ITEMS WITH THOSE APPROPRIATE FOR YOUR APPLICATION.
	 * return the current tab list for the all the tabs
	 * 
	 * @return
	 */
	@Override
	protected void initializeTabs(List<NavigationTab> tabList) {
		
		/*
		 * define all the tabs and inner tabs used in this application
		 */
		NavigationTab KENDOUI_TAB = new NavigationTab(0, "KENDOUI_TAB", "Kendo UI");
		KENDOUI_TAB.setDescription("Trial version of kendo ui");

		/*
		 * define all the tabs and inner tabs used in this application
		 */
		NavigationTab RESOURCES_TAB = new NavigationTab(1, "RESOURCES_TAB", "Resources", "RESOURCE_TEAM_MEMBERS");
		RESOURCES_TAB.setDescription("Perform base resource energy calculations for two-day-ahead prescheduling.");

		NavigationTab TRADING_TAB = new NavigationTab(2, "TRADING_TAB", "Trading", "RESCALC_TRADERS");
		TRADING_TAB.setDescription("Manage day-ahead energy purchases and sales.");

		NavigationTab PRESCHEDULING_TAB = new NavigationTab(3, "PRESCHEDULING_TAB", "Prescheduling");// ,"PRESCHEDULING_TEAM_MEMBERS");
		PRESCHEDULING_TAB.setDescription("Perform daily prescheduling tasks.");

		NavigationTab REALTIME_TAB = new NavigationTab(4, "REALTIME_TAB", "Realtime", "REALTIME_TEAM_MEMBERS");
		REALTIME_TAB.setDescription("Perform realtime scheduling tasks.");

		NavigationTab AGC_TAB = new NavigationTab(5, "AGC_TAB", "AGC", "RESCALC_AGC_TEAM_MEMBERS");
		AGC_TAB.setDescription("View the SBA Position and/or submit purchase and sale requests to Realtime.");

		NavigationTab SETTLEMENTS_TAB = new NavigationTab(6, "SETTLEMENTS_TAB", "Settlements",
				"RESCALC_SETTLEMENTS_TEAM_MEMBERS");
		SETTLEMENTS_TAB.setDescription(
				"View information about the long-term, day-ahead, and realtime purchases and sales completed by SNR as well as the DOE position.");

		NavigationTab ARCHIVES_REPORTS_TAB = new NavigationTab(7, "ARCHIVES_REPORTS_TAB", "Archives / Reports");
		ARCHIVES_REPORTS_TAB
				.setDescription("View historical information about base resource calculations for days that are past.");

		NavigationTab ADMINISTRATION_TAB = new NavigationTab(8, "ADMINISTRATION_TAB", "Administration",
				"RESCALC_ADMINISTRATORS");
		ADMINISTRATION_TAB
				.setDescription("Configure the Resource Calculator application.&#13;&#13;Administrators only!");

		NavigationTab TOOLS_TAB = new NavigationTab(9, "TOOLS_TAB", "Tools");
		TOOLS_TAB.setDescription("Administrative tools for Rescalc");

		
		/* 
		 * tab for ABC Reports module
		 * 
		 * TODO: add appropriate ABC roles
		 */
		NavigationTab ABC_REPORTS_TAB = new NavigationTab(10, "ABC_REPORTS", "ABC Reports", "FAKE_ABC_ROLE_TO_HIDE_TAB");
		ABC_REPORTS_TAB.setDescription("Automatic Billing Cycle Report Module");
		
		tabList.addAll(Arrays.asList(
				KENDOUI_TAB,

				RESOURCES_TAB, TRADING_TAB, PRESCHEDULING_TAB, REALTIME_TAB, AGC_TAB, SETTLEMENTS_TAB,
				ARCHIVES_REPORTS_TAB, ADMINISTRATION_TAB));
		
		/*
		 * kendo ui
		 */
		KENDOUI_TAB.addItem(new NavigationTabItem("kendo","Kendo UI Demo","Demo of the capabilities of kendo ui component library"));
		
		
		
		/*
		 * RESOURCES_TAB
		 */
		RESOURCES_TAB.addItem(new NavigationTabItem("two-day-ahead-checklist", "Two-Day-Ahead Checklist",
				"Perform tasks that are part of the two-day-ahead resource process. This includes calculating and allocating base resource energy."));
		RESOURCES_TAB.addItem(new NavigationTabItem("summary", "Summary",
				"View a summary of all the two-day-ahead base resource information that has been gathered"));
		RESOURCES_TAB.addItem(new NavigationTabItem("sba-position", "SBA Position",
				"Track the WASN SBA position for a schedule day."));
		RESOURCES_TAB.addItem(new NavigationTabItem("doe-position", "DOE Position",
				"Track the DOE portfolio positions for a schedule day."));
		RESOURCES_TAB.addItem(
				new NavigationTabItem("wfls-position", "WFLS Position", "Track the WFLS position for a schedule day."));
		RESOURCES_TAB.addItem(new NavigationTabItem("line-monitor", "Line Monitor",
				"View projected capacities for transmission lines."));
		RESOURCES_TAB.addItem(new NavigationTabItem("transmission-usage-tracker", "Transmission Usage",
				"View current transmission ratings and available capacity."));
		RESOURCES_TAB.addItem(new NavigationTabItem("merchant-requests", "Merchant Requests",
				"View the merchant requests for a schedule day."));
		RESOURCES_TAB.addItem(new NavigationTabItem("day-ahead-deals", "Day-Ahead Deals",
				"View the day-ahead purchases and sales for a schedule day."));
		RESOURCES_TAB.addItem(new NavigationTabItem("activity-log", "Activity Log",
				"View a log of all activities that have occurred related to the schedule day"));
		RESOURCES_TAB.addItem(
				new NavigationTabItem("term-purchases", "Term Purchases", "Record long-term energy purchases."));

		/*
		 * TRADING_TAB
		 */
		TRADING_TAB.addItem(new NavigationTabItem("day-ahead-checklist", "Day-Ahead Checklist",
				"Perform tasks that are part of the day-ahead trading process."));
		TRADING_TAB.addItem(new NavigationTabItem("merchant-requests", "Merchant Requests",
				"View the merchant requests for a schedule day."));
		TRADING_TAB.addItem(new NavigationTabItem("day-ahead-deals", "Day-Ahead Deals",
				"View the day-ahead purchases and sales for a schedule day."));
		TRADING_TAB.addItem(new NavigationTabItem("sba-position", "SBA Position",
				"Track the WASN SBA position for a schedule day."));
		TRADING_TAB.addItem(new NavigationTabItem("line-monitor", "Line Monitor",
				"View projected capacities for transmission lines."));
		TRADING_TAB.addItem(new NavigationTabItem("transmission-usage-tracker", "Transmission Usage",
				"View current transmission ratings and available capacity."));
		TRADING_TAB.addItem(new NavigationTabItem("activity-log", "Activity Log",
				"View a log of all activities that have occurred related to the schedule day"));
		TRADING_TAB.addItem(
				new NavigationTabItem("term-purchases", "Term Purchases", "Record long-term energy purchases."));
		TRADING_TAB.addItem(new NavigationTabItem("day-ahead-trader", "Day-Ahead Trader",
				"Perform day-ahead energy trades for one or more schedule days."));
		/*
		 * PRESCHEDULING_TAB
		 */
		PRESCHEDULING_TAB.addItem(new NavigationTabItem("day-ahead-checklist", "Day-Ahead Checklist",
				"Perform day-ahead prescheduling tasks."));
		PRESCHEDULING_TAB.addItem(new NavigationTabItem("merchant-requests", "Merchant Requests",
				"View the merchant requests for a schedule day."));
		PRESCHEDULING_TAB.addItem(new NavigationTabItem("day-ahead-deals", "Day-Ahead Deals",
				"View the day-ahead purchases and sales for a schedule day."));
		PRESCHEDULING_TAB.addItem(new NavigationTabItem("sba-position", "SBA Position",
				"Track the WASN SBA position for a schedule day."));
		PRESCHEDULING_TAB.addItem(new NavigationTabItem("line-monitor", "Line Monitor",
				"View projected capacities for transmission lines."));
		PRESCHEDULING_TAB.addItem(new NavigationTabItem("transmission-usage-tracker", "Transmission Usage",
				"View current transmission ratings and available capacity."));
		PRESCHEDULING_TAB.addItem(new NavigationTabItem("activity-log", "Activity Log",
				"View a log of all activities that have occurred related to the schedule day"));
		PRESCHEDULING_TAB.addItem(
				new NavigationTabItem("term-purchases", "Term Purchases", "Record long-term energy purchases."));
		PRESCHEDULING_TAB.addItem(new NavigationTabItem("day-ahead-trader", "Day-Ahead Trader",
				"Perform day-ahead energy trades for one or more schedule days."));
		/*
		 * REALTIME_TAB
		 */
		REALTIME_TAB.addItem(new NavigationTabItem("sba-position", "SBA Position",
				"Track the WASN SBA position for a schedule day."));
		REALTIME_TAB.addItem(new NavigationTabItem("doe-position", "DOE Position",
				"Track the DOE portfolio positions for a schedule day."));
		REALTIME_TAB.addItem(
				new NavigationTabItem("wfls-position", "WFLS Position", "Track the WFLS position for a schedule day."));
		REALTIME_TAB.addItem(new NavigationTabItem("merchant-requests", "Merchant Requests",
				"View the merchant requests for a schedule day."));
		REALTIME_TAB.addItem(new NavigationTabItem("day-ahead-deals", "Day-Ahead Deals",
				"View the day-ahead purchases and sales for a schedule day."));
		REALTIME_TAB.addItem(new NavigationTabItem("realtime-deals", "Realtime Deals",
				"View the realtime purchases and sales for a schedule day."));
		REALTIME_TAB.addItem(new NavigationTabItem("web-trader-schedules", "Web Trader Schedules",
				"View schedules that Resource Calculator has prepared for OATI WebTrader."));
		REALTIME_TAB.addItem(new NavigationTabItem("line-monitor", "Line Monitor",
				"View projected capacities for transmission lines."));
		REALTIME_TAB.addItem(new NavigationTabItem("transmission-usage-tracker", "Transmission Usage",
				"View current transmission ratings and available capacity."));
		REALTIME_TAB.addItem(new NavigationTabItem("wamptd-checkout-usage", "WAMPTD Checkout Usage",
				"View / checkout hourly WAMPTD interchange values."));
		REALTIME_TAB.addItem(new NavigationTabItem("activity-log", "Activity Log",
				"View a log of all activities that have occurred related to the schedule day"));
		REALTIME_TAB.addItem(
				new NavigationTabItem("term-purchases", "Term Purchases", "Record long-term energy purchases."));

		/*
		 * AGC_TAB
		 */
		AGC_TAB.addItem(new NavigationTabItem("doe-position", "SBA Position",
				"Track the WASN SBA position for a schedule day."));
		AGC_TAB.addItem(new NavigationTabItem("wamptd-checkout-usage", "WAMPTD Checkout Usage",
				"View / checkout hourly WAMPTD interchange values."));
		AGC_TAB.addItem(new NavigationTabItem("activity-log", "Activity Log",
				"View a log of all activities that have occurred related to the schedule day"));

		/*
		 * SETTLEMENTS_TAB
		 */
		SETTLEMENTS_TAB.addItem(new NavigationTabItem("day-ahead-deals", "Day-Ahead Deals",
				"View the day-ahead purchases and sales for a schedule day."));
		SETTLEMENTS_TAB.addItem(new NavigationTabItem("realtime-deals", "Realtime Deals",
				"View the realtime purchases and sales for a schedule day."));
		SETTLEMENTS_TAB.addItem(new NavigationTabItem("doe-position", "DOE Position",
				"Track the DOE portfolio positions for a schedule day."));
		SETTLEMENTS_TAB.addItem(
				new NavigationTabItem("term-purchases", "Term Purchases", "Record long-term energy purchases."));
		SETTLEMENTS_TAB.addItem(new NavigationTabItem("line-monitor", "Line Monitor",
				"View projected capacities for transmission lines."));
		SETTLEMENTS_TAB.addItem(new NavigationTabItem("transmission-usage-tracker", "Transmission Usage",
				"View current transmission ratings and available capacity."));

		/*
		 * ARCHIVES_REPORTS_TAB
		 */
		ARCHIVES_REPORTS_TAB.addItem(new NavigationTabItem("two-day-ahead-summary", "Two-Day-Ahead Summary",
				"View a summary of base resource calculation, allocation, and prescheduling information that was gathered."));
		ARCHIVES_REPORTS_TAB.addItem(new NavigationTabItem("day-ahead-deals", "Day-Ahead Deals",
				"View the day-ahead purchases and sales for a schedule day."));
		ARCHIVES_REPORTS_TAB.addItem(new NavigationTabItem("realtime-deals", "Realtime Deals",
				"View the realtime purchases and sales for a schedule day."));
		ARCHIVES_REPORTS_TAB.addItem(new NavigationTabItem("schedule-day-activity-log", "Schedule Day Activity Log",
				"View a log of all activities that took place related to two-day-ahead base resource calculation, allocation, and prescheduling "));

		/*
		 * ADMINISTRATION_TAB
		 */

		ADMINISTRATION_TAB.addItem(new NavigationTabItem("mailing-lists", "Mailing Lists",
				"View and edit information about the mailing lists used by Resource Calculator."));
		ADMINISTRATION_TAB.addItem(new NavigationTabItem("nerc-holidays", "NERC Holidays",
				"Specify which dates should be treated as NERC holidays for scheduling purposes."));
		ADMINISTRATION_TAB.addItem(new NavigationTabItem("gtmax-nodes", "GTMAX Nodes",
				"Edit the list of GTMAX term purchase nodes that ResCalc should write term purchases to."));
		ADMINISTRATION_TAB.addItem(new NavigationTabItem("contract-rights", "Contract Rights",
				"Manage contract rights for contracts such as SMUD, REDD, etc."));
		
	}

}
