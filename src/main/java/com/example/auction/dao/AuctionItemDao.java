package com.example.auction.dao;

import java.util.List;

import com.example.auction.entity.AuctionItem;

public interface AuctionItemDao {
    List<AuctionItem> getAuctionItems();
    List<AuctionItem> getAuctionItemsByDescription(String description);
}
