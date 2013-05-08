package com.mebigfatguy.economy.tableassembler.impl;

import java.util.Random;

import com.mebigfatguy.economy.marketplace.MarketPlace;

public class TableAssemblerImpl implements Runnable {

	private static final int LUMBER_PER_TABLE = 12;
	private MarketPlace marketPlace;

	public void init() {
		System.out.println("TableAssembler starts assembling tables.");
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
				
				for (int i = 0; i < LUMBER_PER_TABLE;) {
					if (marketPlace.getProduct(MarketPlace.Part.Lumber) == MarketPlace.Part.Lumber) {
						System.out.println("ChairAssembler buys a Lumber");
						i++;
					}
				}
				System.out.println("TableAssembler sells a Table");
				marketPlace.addProduct(MarketPlace.Part.Table);
			}
		} catch (InterruptedException ie) {
		}
	}
}
