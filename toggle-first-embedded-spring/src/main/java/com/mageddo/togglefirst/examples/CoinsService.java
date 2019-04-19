package com.mageddo.togglefirst.examples;

import org.springframework.stereotype.Service;

@Service
public class CoinsService {

	public String buy(String userId, double price){
		if(Parameter.FREE_SHOP.isActive()){
			return "congrats, you earned a free shop";
		}
		if(Parameter.BALANCE.asInteger(userId, 5) > price){
			return "bought";
		}
		return "not enough balance";
	}

}
