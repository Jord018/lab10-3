package com.example.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.entity.AuctionItem;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    List<AuctionItem> findByDescriptionContainingIgnoreCase(String description);

    List<AuctionItem> findBySuccessfulBid_AmountLessThan(Double amount);

    List<AuctionItem> findByDescriptionContainingIgnoreCaseOrTypeContainingIgnoreCase(String description, String type);
}
