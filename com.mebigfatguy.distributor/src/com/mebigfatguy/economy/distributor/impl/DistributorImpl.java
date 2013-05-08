package com.mebigfatguy.economy.distributor.impl;

import java.util.Random;

import com.mebigfatguy.economy.marketplace.MarketPlace;

public class DistributorImpl implements Runnable {

	private static final int CHAIRS_PER_SET = 6;
	private static final int TABLES_PER_SET = 1;
	private MarketPlace marketPlace;

	public void init() {
		System.out.println("Distributor starts selling dining room sets.");
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
				
				for (int i = 0; i < CHAIRS_PER_SET;) {
					if (marketPlace.getProduct(MarketPlace.Part.Chair) == MarketPlace.Part.Chair) {
						System.out.println("Distributor buys a Chair");
						i++;
					}
				}
				for (int i = 0; i < TABLES_PER_SET;) {
					if (marketPlace.getProduct(MarketPlace.Part.Table) == MarketPlace.Part.Table) {
						System.out.println("Distributor buys a Table");
						i++;
					}
				}
				System.out.println("****** Distributor sells a Dining Room Set ******");
			}
		} catch (InterruptedException ie) {
		}
	}
}
