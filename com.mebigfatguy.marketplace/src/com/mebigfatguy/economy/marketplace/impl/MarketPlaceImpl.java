package com.mebigfatguy.economy.marketplace.impl;

import java.util.HashMap;
import java.util.Map;

import com.mebigfatguy.economy.marketplace.MarketPlace;

public class MarketPlaceImpl implements MarketPlace {
	private Map<Part, Integer> market = new HashMap<Part, Integer>();
	
	public void init() {
		System.out.println("Marketplace is open for business");
	}
	
	public void addProduct(Part product) {
		synchronized(market) {
			Integer cnt = market.get(product);
			if (cnt == null)
				market.put(product, Integer.valueOf(1));
			else
				market.put(product, Integer.valueOf(1 + cnt.intValue()));
			market.notifyAll();
		}
	}
	
	public Part getProduct(Part product) {
		try {
			synchronized(market) {
				Integer cnt = market.get(product);
				while ((cnt == null) || (cnt.intValue() == 0)) {
					market.wait();
					cnt = market.get(product);
				}
				market.put(product, Integer.valueOf(cnt.intValue() - 1));
			}
			
			return product;
		} catch (InterruptedException ie) {
			return null;
		}
	}
}
