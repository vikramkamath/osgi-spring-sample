package com.mebigfatguy.economy.marketplace;

public interface MarketPlace {
	enum Part {Timber, Lumber, Chair, Table, DiningRoomSet};
	void addProduct(Part productName);
	Part getProduct(Part productName);
}
