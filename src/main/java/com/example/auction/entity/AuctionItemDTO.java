package com.example.auction.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemDTO {
    Long id;
    String description;
    String type;
    @Builder.Default
    List<BidDTO> bids = new ArrayList<>();
    BidDTO successfulBid;
}
