package com.example.ecommerce.repositories.Repository;

import com.example.ecommerce.models.Product;
import com.example.ecommerce.repositories.Interface.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    EntityManager entityManager;

    @Autowired
    public ProductRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public Product findById(Integer id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> theQuery = entityManager.createQuery("FROM product order by name",Product.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return entityManager.merge(product);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Product product = entityManager.find(Product.class,id);
        entityManager.remove(product);
    }
}
