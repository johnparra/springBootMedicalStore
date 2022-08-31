package com.pruebajp.johnparra.repository;

import com.pruebajp.johnparra.entity.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("Select p.name from Order o left join ProductOrder po on o.ProductOrderList = po.id left join Product p on p.id=po.productOrder group by p.name")
    static List<Order> findMostAndMinusSeller(Sort sort);

    @Query("Select sum(p.price) from Order o left join ProductOrder po on o.ProductOrderList = po.id left join Product p on p.id=po.productOrder")
    static List<Order> showTotalSells();
}
