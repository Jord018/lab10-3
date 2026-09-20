package com.example.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.entity.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
