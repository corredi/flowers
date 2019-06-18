package com.accenture.flowershop.be.access.repositories;

import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FlowerRepository extends PagingAndSortingRepository<Flower,String> {
    public List<Flower> findAll();
    public Flower findByName(String name);
    public List<Flower> findAll(Sort sort);
    public List<Flower> findByStockBetween(int a, int b);
    public List<Flower> findByNameLike(String name);
}
