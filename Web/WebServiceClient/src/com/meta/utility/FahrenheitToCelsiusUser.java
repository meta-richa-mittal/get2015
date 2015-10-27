package com.meta.utility;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.meta.webservices.FahrenheitToCelsiusConverter;
import com.meta.webservices.FahrenheitToCelsiusConverterServiceLocator;

public class FahrenheitToCelsiusUser {
	
	public static void main(String[] args) {
		FahrenheitToCelsiusConverterServiceLocator fTocWebServiceImplServiceLocator = new FahrenheitToCelsiusConverterServiceLocator();
		fTocWebServiceImplServiceLocator.setFahrenheitToCelsiusConverterEndpointAddress("http://localhost:8080/WebService1Server/services/FahrenheitToCelsiusConverter");
		
		try {
			FahrenheitToCelsiusConverter fTocWebService = fTocWebServiceImplServiceLocator.getFahrenheitToCelsiusConverter();
			System.out.print("Enter temperature in °F to convert it to °C:\t");
			Scanner sc= new Scanner(System.in);
			double fahrenheitTemperature = sc.nextDouble();
			System.out.print("\nTemperature in °C is:\t");
			double celsiusTemperature = fTocWebService.fahrenheitToCelsiusConverter(fahrenheitTemperature);
			System.out.println(new DecimalFormat("##.####").format(celsiusTemperature)+" °C");
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}

}
