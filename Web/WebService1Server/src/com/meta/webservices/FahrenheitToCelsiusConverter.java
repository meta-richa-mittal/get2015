package com.meta.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class FahrenheitToCelsiusConverter {
	
	
	@WebMethod
	public double fahrenheitToCelsiusConverter(double fahrenheitTemperature) {
		double celsiusTemperature = ( fahrenheitTemperature - 32 ) / 1.8;
				
				return celsiusTemperature;
	}

}
