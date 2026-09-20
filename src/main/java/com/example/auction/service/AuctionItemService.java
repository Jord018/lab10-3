package com.example.auction.service;

import java.util.List;

import com.example.auction.entity.AuctionItem;

public interface AuctionItemService {
    List<AuctionItem> getAuctionItems();
    List<AuctionItem> getAuctionItemsByDescription(String description);
    List<AuctionItem> getAuctionItemsBySuccessfulBidLessThan(Double amount);
}
