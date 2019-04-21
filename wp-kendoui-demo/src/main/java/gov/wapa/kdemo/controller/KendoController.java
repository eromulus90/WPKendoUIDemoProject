package gov.wapa.kdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gov.wapa.kdemo.viewmodel.KendouiViewModel;

@Controller
public class KendoController {

	/**
	 * the home page for kendo ui
	 * @return
	 */
	@RequestMapping("/kendo")
	public String index(Model model) {
		
		//model.addAttribute("viewModel", new KendouiViewModel());
		return "kendo-ui/index";
	}
}
