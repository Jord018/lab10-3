package com.example.auction.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.auction.entity.AuctionItem;
import com.example.auction.entity.AuctionItemDTO;
import com.example.auction.entity.Bid;
import com.example.auction.entity.BidDTO;

@Mapper
public interface AuctionMapper {
    AuctionMapper INSTANCE = Mappers.getMapper(AuctionMapper.class);

    AuctionItemDTO getAuctionItemDto(AuctionItem auctionItem);
    List<AuctionItemDTO> getAuctionItemDto(List<AuctionItem> auctionItems);

    BidDTO getBidDto(Bid bid);
    List<BidDTO> getBidDto(List<Bid> bids);
}
