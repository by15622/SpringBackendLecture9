package com.sprint.mission.jpa.repository;


import com.sprint.mission.jpa.domain.Menu;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuRepository extends JpaRepository<Menu, Long> {

  @Query("""
        SELECT m
        FROM Menu m
        JOIN FETCH m.category
        WHERE m.name LIKE %:keyword%
    """)
  List<Menu> findByNameContainingWithCategory(@Param("keyword") String keyword);


  List<Menu> findByCategoryNameAndPriceGreaterThanEqualOrderByPriceDesc(
      String categoryName,
      int minPrice
  );

  Page<Menu> findByCategoryNameAndPriceGreaterThanEqual(
      String categoryName,
      int minPrice,
      Pageable pageable
  );

  // Slice 기반 (메서드명만 변경)
  Slice<Menu> findSliceByCategoryNameAndPriceGreaterThanEqual(
      String categoryName,
      int minPrice,
      Pageable pageable
  );

  @Query("""
        SELECT m
        FROM Menu m
        WHERE m.price >= :minPrice
          AND (:categoryName IS NULL OR m.category.name = :categoryName)
    """)
  Page<Menu> findByMinPriceAndOptionalCategory(
      @Param("minPrice") int minPrice,
      @Param("categoryName") String categoryName,
      Pageable pageable
  );

}
