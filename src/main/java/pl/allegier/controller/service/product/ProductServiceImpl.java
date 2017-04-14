package pl.allegier.controller.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegier.controller.repository.ProductRepository;
import pl.allegier.model.Product;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
@Service
public class ProductServiceImpl implements  ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public <S extends Product> S save(S Product ) {
        return productRepository.save( Product );
    }

    @Override
    public <S extends Product> Iterable<S> save(Iterable<S> productIterables) {
       return productRepository.save(productIterables);
    }

    @Override
    public Product findOne(Integer id) {
        return productRepository.findOne( id );
    }

    @Override
    public boolean exists(Integer id) {
        return productRepository.exists( id );
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Iterable<Product> findAll(Iterable<Integer> ids) {
        return productRepository.findAll( ids );
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete( id );
    }

    @Override
    public void delete(Iterable<? extends Product> Products) {
        productRepository.delete( Products );
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
