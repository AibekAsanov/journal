package kg.itacademy.hakaton.journal.repository;

import kg.itacademy.hakaton.journal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    Optional<Product> findByName(String name);

    Optional<Product> findById(Long id);

    @Override
    void deleteById(Long id);
}
