package com.alojea;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alojea.model.CurrencyConverterForm;
import com.alojea.model.RateValues;

@Controller
public class MainController {
	
	CurrencyConverterController currencyConverterController = new CurrencyConverterController();
	
	/**
	 * 
	 * Redirection to home page
	 * 
	 * @param model
	 * @return main Screen
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@RequestMapping(value = "/" , method = RequestMethod.GET)
 	public String initialForm(Model model) throws IOException, InterruptedException {
	
		model.addAttribute("currencyConverterForm", new CurrencyConverterForm());
 		return "currencyConverter";
 	}
 	
	/**
	 * Return Rate Exchange results
	 * 
	 * @param CurrencyConverterForm
	 * @param model
	 * @return converter results in the same page
	 */
 	@RequestMapping(value = "/" , method = RequestMethod.POST)
 	public String processSubmit(@ModelAttribute CurrencyConverterForm currencyConverterForm, Model model) {
 		try {
 			String fromCurrency = currencyConverterForm.getFromCurrency();
 			String toCurrency = currencyConverterForm.getToCurrency();
 			Float amount = currencyConverterForm.getAmount();
 			RateValues rateValues = currencyConverterController.getCurrencyRate(fromCurrency,toCurrency);
 			rateValues.setFinalExchangeRate(currencyConverterController.calculateRate(amount,rateValues));
 			
 			currencyConverterForm.setRateValues(rateValues);
 			
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 		return "currencyConverter";
 	}
 	
 	/**
 	 * 
 	 * Redirection to Help Page
 	 * 
 	 * @param model
 	 * @return help page
 	 */
 	@RequestMapping(value = "/help" , method = RequestMethod.GET)
 	public String help(Model model) {
 		return "help";
 	}
 	
 	/**
 	 * 
 	 * Redirection to about page
 	 * 
 	 * @param model
 	 * @return Redirection to about page
 	 */
 	@RequestMapping(value = "/about" , method = RequestMethod.GET)
 	public String about(Model model) {
 		return "about";
 	}
 	

}
