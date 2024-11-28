
package com.example.springboot_jpa.entity.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springboot_jpa.entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, OffsetDateTime> {
  @Query(value = "select date_trunc('second',sp.time) as time_sec, symbol, count(1) as cnt " +
      "from stock_prices sp " +
      "where date_trunc('second',time)= date_trunc('second', cast(:collectTime as timestamp)) " +
      "group by time_sec, symbol", nativeQuery = true)
  List<Object> findDuplicateTimes(@Param("collectTime") String collectTime);

  @Query(value = "select date_trunc('second',sp.time) as time_sec, symbol, count(1) as cnt " +
      "from stock_prices sp " +
      "where date_trunc('second',time)= date_trunc('second', cast(:collectTime as timestamp with time zone)) " +
      "group by time_sec, symbol", nativeQuery = true)
  List<Object> findDuplicateTimes(@Param("collectTime") OffsetDateTime collectTime);
}
