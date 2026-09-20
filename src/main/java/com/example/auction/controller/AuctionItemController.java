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
            @RequestParam(value = "description", required = false) String description) {
        List<AuctionItem> items;
        if (description == null) {
            items = auctionItemService.getAuctionItems();
        } else {
            items = auctionItemService.getAuctionItemsByDescription(description);
        }
        return ResponseEntity.ok(AuctionMapper.INSTANCE.getAuctionItemDto(items));
    }
}
