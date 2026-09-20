package com.example.auction.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.auction.entity.AuctionItem;
import com.example.auction.repository.AuctionItemRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuctionItemDaoDbImpl implements AuctionItemDao {
    final AuctionItemRepository auctionItemRepository;

    @Override
    public List<AuctionItem> getAuctionItems() {
        return auctionItemRepository.findAll();
    }

    @Override
    public List<AuctionItem> getAuctionItemsByDescription(String description) {
        return auctionItemRepository.findByDescriptionContainingIgnoreCase(description);
    }
}
