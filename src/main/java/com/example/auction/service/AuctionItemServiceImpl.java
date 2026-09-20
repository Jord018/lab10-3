package com.example.auction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.auction.dao.AuctionItemDao;
import com.example.auction.entity.AuctionItem;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuctionItemServiceImpl implements AuctionItemService {
    final AuctionItemDao auctionItemDao;

    @Override
    public List<AuctionItem> getAuctionItems() {
        return auctionItemDao.getAuctionItems();
    }

    @Override
    public List<AuctionItem> getAuctionItemsByDescription(String description) {
        return auctionItemDao.getAuctionItemsByDescription(description);
    }

    @Override
    public List<AuctionItem> getAuctionItemsBySuccessfulBidLessThan(Double amount) {
        return auctionItemDao.getAuctionItemsBySuccessfulBidLessThan(amount);
    }
}
