package com.example.auction;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.auction.entity.AuctionItem;
import com.example.auction.entity.Bid;
import com.example.auction.repository.AuctionItemRepository;
import com.example.auction.repository.BidRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AuctionItemRepository auctionItemRepository;
    final BidRepository bidRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        AuctionItem watch = auctionItemRepository.save(AuctionItem.builder()
                .description("Vintage Pocket Watch")
                .type("Collectible")
                .build());
        Bid watchBid1 = bidRepository.save(Bid.builder().amount(50.0).datetime("2026-01-10 09:00").item(watch).build());
        Bid watchBid2 = bidRepository.save(Bid.builder().amount(75.0).datetime("2026-01-10 09:15").item(watch).build());
        Bid watchBid3 = bidRepository.save(Bid.builder().amount(120.0).datetime("2026-01-10 09:30").item(watch).build());
        watch.getBids().addAll(java.util.List.of(watchBid1, watchBid2, watchBid3));
        watch.setSuccessfulBid(watchBid3);
        auctionItemRepository.save(watch);

        AuctionItem painting = auctionItemRepository.save(AuctionItem.builder()
                .description("Sunset Oil Painting")
                .type("Art")
                .build());
        Bid paintingBid1 = bidRepository.save(Bid.builder().amount(200.0).datetime("2026-01-11 13:00").item(painting).build());
        Bid paintingBid2 = bidRepository.save(Bid.builder().amount(250.0).datetime("2026-01-11 13:20").item(painting).build());
        Bid paintingBid3 = bidRepository.save(Bid.builder().amount(300.0).datetime("2026-01-11 13:45").item(painting).build());
        painting.getBids().addAll(java.util.List.of(paintingBid1, paintingBid2, paintingBid3));
        painting.setSuccessfulBid(paintingBid3);
        auctionItemRepository.save(painting);

        AuctionItem vase = auctionItemRepository.save(AuctionItem.builder()
                .description("Antique Ming Vase")
                .type("Collectible")
                .build());
        Bid vaseBid1 = bidRepository.save(Bid.builder().amount(500.0).datetime("2026-01-12 10:00").item(vase).build());
        Bid vaseBid2 = bidRepository.save(Bid.builder().amount(650.0).datetime("2026-01-12 10:30").item(vase).build());
        Bid vaseBid3 = bidRepository.save(Bid.builder().amount(800.0).datetime("2026-01-12 11:00").item(vase).build());
        Bid vaseBid4 = bidRepository.save(Bid.builder().amount(900.0).datetime("2026-01-12 11:30").item(vase).build());
        vase.getBids().addAll(java.util.List.of(vaseBid1, vaseBid2, vaseBid3, vaseBid4));
        vase.setSuccessfulBid(vaseBid4);
        auctionItemRepository.save(vase);

        AuctionItem guitar = auctionItemRepository.save(AuctionItem.builder()
                .description("Fender Stratocaster Guitar")
                .type("Instrument")
                .build());
        Bid guitarBid1 = bidRepository.save(Bid.builder().amount(300.0).datetime("2026-01-13 15:00").item(guitar).build());
        Bid guitarBid2 = bidRepository.save(Bid.builder().amount(350.0).datetime("2026-01-13 15:20").item(guitar).build());
        Bid guitarBid3 = bidRepository.save(Bid.builder().amount(400.0).datetime("2026-01-13 15:40").item(guitar).build());
        guitar.getBids().addAll(java.util.List.of(guitarBid1, guitarBid2, guitarBid3));
        auctionItemRepository.save(guitar);

        AuctionItem coins = auctionItemRepository.save(AuctionItem.builder()
                .description("Rare Coin Set 1920")
                .type("Collectible")
                .build());
        Bid coinsBid1 = bidRepository.save(Bid.builder().amount(150.0).datetime("2026-01-14 12:00").item(coins).build());
        Bid coinsBid2 = bidRepository.save(Bid.builder().amount(180.0).datetime("2026-01-14 12:20").item(coins).build());
        Bid coinsBid3 = bidRepository.save(Bid.builder().amount(210.0).datetime("2026-01-14 12:40").item(coins).build());
        coins.getBids().addAll(java.util.List.of(coinsBid1, coinsBid2, coinsBid3));
        auctionItemRepository.save(coins);
    }
}
