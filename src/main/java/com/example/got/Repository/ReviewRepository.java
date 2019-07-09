package com.example.got.Repository;
import com.example.got.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
    public List<Review> findByBookId(String bookId);
}

