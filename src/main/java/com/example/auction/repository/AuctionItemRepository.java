package com.example.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.entity.AuctionItem;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
}
