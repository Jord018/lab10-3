package com.example.auction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.auction.entity.AuctionItem;
import com.example.auction.service.AuctionItemService;
import com.example.auction.util.AuctionMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuctionItemController {
    final AuctionItemService auctionItemService;

    @GetMapping("/auction-items")
    public ResponseEntity<?> getAuctionItems(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "successfulBidLessThan", required = false) Double successfulBidLessThan) {
        List<AuctionItem> items;
        if (keyword != null) {
            items = auctionItemService.getAuctionItemsByKeyword(keyword);
        } else if (description != null) {
            items = auctionItemService.getAuctionItemsByDescription(description);
        } else if (successfulBidLessThan != null) {
            items = auctionItemService.getAuctionItemsBySuccessfulBidLessThan(successfulBidLessThan);
        } else {
            items = auctionItemService.getAuctionItems();
        }
        return ResponseEntity.ok(AuctionMapper.INSTANCE.getAuctionItemDto(items));
    }
}
