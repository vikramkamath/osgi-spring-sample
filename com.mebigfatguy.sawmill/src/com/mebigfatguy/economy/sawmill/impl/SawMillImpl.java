package com.mebigfatguy.economy.sawmill.impl;

import java.util.Random;

import com.mebigfatguy.economy.marketplace.MarketPlace;

public class SawMillImpl  implements Runnable {
	
	private static final int LUMBER_PER_TIMBER = 10;
	private MarketPlace marketPlace;

	public void init() {
		System.out.println("SawMill starts milling lumber.");
		Thread t = new Thread(this);
		t.start();
	}
	
	public void setMarketPlace(MarketPlace mp) {
		marketPlace = mp;
	}
	
	public void run() {
		try {
			Random r = new Random(System.currentTimeMillis());
			while (!Thread.interrupted()) {
				Thread.sleep(r.nextInt(r.nextInt(10*1000)));
				System.out.println("SawMill buys a Timber");
				if (marketPlace.getProduct(MarketPlace.Part.Timber) == MarketPlace.Part.Timber) {
					for (int i = 0; i < LUMBER_PER_TIMBER; i++) {
						System.out.println("SawMill sells a Lumber");
						marketPlace.addProduct(MarketPlace.Part.Lumber);
					}
				}
			}
		} catch (InterruptedException ie) {
		}
	}
}
