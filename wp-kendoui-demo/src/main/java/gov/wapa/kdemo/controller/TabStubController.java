package gov.wapa.kdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This controller is used to display a string on a page that has not been
 * implemented
 * 
 * @author romulus
 *
 */
@Controller
public class TabStubController {

	//
	/////////////////////////////////// RESOURCES
	//
	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/two-day-ahead-checklist")
	public String twoDayAheadChecklist(Model model) {

		model.addAttribute("message", "Two-Day-Ahead Checklist");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/summary")
	public String summary(Model model) {

		model.addAttribute("message", "Summary");
		return "home/tagtest";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/sba-position")
	public String sbaPosition(Model model) {

		model.addAttribute("message", "SBA Position");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/doe-position")
	public String doePosition(Model model) {

		model.addAttribute("message", "DOE Position");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/wfls-position")
	public String wflsPosition(Model model) {

		model.addAttribute("message", "WFLS Position");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/line-monitor")
	public String lineMonitor(Model model) {

		model.addAttribute("message", "Line Monitor");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/transmission-usage-tracker")
	public String transmissionUsageTracker(Model model) {

		model.addAttribute("message", "Transmission Usage Tracker");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/merchant-requests")
	public String merchantRequests(Model model) {

		model.addAttribute("message", "Merchant Requests");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/day-ahead-deals")
	public String dayAheadDeals(Model model) {

		model.addAttribute("message", "Day-Ahead Deals");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/activity-log")
	public String activityLog(Model model) {

		model.addAttribute("message", "Activity Log");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/term-purchases")
	public String termPurchases(Model model) {

		model.addAttribute("message", "Term Purchases");
		return "stubs/tabStubDisplay";
	}

	//
	/////////////////////////////////// TRADING
	//

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/day-ahead-checklist")
	public String dayAheadChecklist(Model model) {

		model.addAttribute("message", "Day-Ahead Checklist");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/day-ahead-trader")
	public String dayAheadTrader(Model model) {

		model.addAttribute("message", "Day-Ahead Trader");
		return "stubs/tabStubDisplay";
	}

	//
	/////////////////////////////////// REALTIME
	//
	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/realtime-deals")
	public String realtimeDeals(Model model) {

		model.addAttribute("message", "Merchant Requests");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/web-trader-schedules")
	public String webTraderSchedules(Model model) {

		model.addAttribute("message", "Web Trader Schedules");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/wamptd-checkout-usage")
	public String wamptdCheckoutUsage(Model model) {

		model.addAttribute("message", "WAMPTD Checkout Usage");
		return "stubs/tabStubDisplay";
	}

	//
	/////////////////////////////////// AGC
	// a subset of realtime
	//

	//
	/////////////////////////////////// SETTLEMENTS
	// a subset
	//

	//
	/////////////////////////////////// REPORTS / ARCHIVES
	//
	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/two-day-ahead-summary")
	public String twoDayAheadSummary(Model model) {

		model.addAttribute("message", "Two-Day-Ahead Summary");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/schedule-day-activity-log")
	public String scheduleDayActivityLog(Model model) {

		model.addAttribute("message", "Schedule Day Activity Log");
		return "stubs/tabStubDisplay";
	}

	//
	/////////////////////////////////// ADMINISTRATOR
	//
	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/mailing-lists")
	public String mailingList(Model model) {

		model.addAttribute("message", "Mailing Lists");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/nerc-holidays")
	public String nercHolidays(Model model) {

		model.addAttribute("message", "NERC Holidays");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/gtmax-nodes")
	public String gtmaxNodes(Model model) {

		model.addAttribute("message", "GTMAX Nodes");
		return "stubs/tabStubDisplay";
	}

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/contract-rights")
	public String contractRights(Model model) {

		model.addAttribute("message", "Contract Rights");
		return "stubs/tabStubDisplay";
	}

	//
	/////////////////////////////////// ADMINISTRATION
	//

	/**
	 * stub
	 * 
	 * @return
	 */
	@RequestMapping("/marketing-tools")
	public String marketingTools(Model model) {

		model.addAttribute("message", "Marketing Tools");
		return "stubs/tabStubDisplay";
	}

	/**
	 * display access error message
	 * @param model
	 * @return
	 */
	@RequestMapping("error-access")
	public String errorAccess(Model model) {
		
		model.addAttribute("message", "acess error. Please, contact your IT administrator");
		return "stubs/tabStubDisplay";
	}
}
