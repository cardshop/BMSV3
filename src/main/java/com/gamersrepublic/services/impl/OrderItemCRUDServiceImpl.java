package com.gamersrepublic.services.impl;

import com.gamersrepublic.domain.OrderItem;
import com.gamersrepublic.repository.OrderItemRepository;
import com.gamersrepublic.services.OrderItemCRUDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonathan
 */

@Service
public class OrderItemCRUDServiceImpl implements OrderItemCRUDService{
    @Autowired
    private OrderItemRepository repo;
    private Long id;

    @Override
    public OrderItem find(Long id) {
       return repo.findOne(id);
    }

    @Override
    public OrderItem persist(OrderItem entity) {
        return repo.save(entity);
    }

    @Override
    public OrderItem merge(OrderItem entity) {
        if (entity.getId() != null) {
            return repo.save(entity);
        }
        return null;
        }
    
    @Override
    public void remove(OrderItem entity) {
       repo.delete(entity);
    }

    @Override
    public List<OrderItem> findAll() {
       return repo.findAll();
    }
}