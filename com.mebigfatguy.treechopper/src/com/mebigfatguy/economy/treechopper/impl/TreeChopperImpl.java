package com.mebigfatguy.economy.treechopper.impl;

import java.util.Random;

import com.mebigfatguy.economy.marketplace.MarketPlace;


public class TreeChopperImpl implements Runnable {

	private MarketPlace marketPlace;

	public void init() {
		System.out.println("TreeChopper starts chopping trees.");
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
				Thread.sleep(r.nextInt(r.nextInt(30*1000)));
				System.out.println("TreeChopper sells a Timber");
				marketPlace.addProduct(MarketPlace.Part.Timber);
			}
		} catch (InterruptedException ie) {
		}
	}
}
