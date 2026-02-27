package com.sprint.mission.jpa.service;

import com.sprint.mission.jpa.dto.MenuResponse;
import com.sprint.mission.jpa.repository.MenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

  private final MenuRepository repository;

  public MenuService(MenuRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public List<MenuResponse> findExpensiveMenusInCategory2(String categoryName, int minPrice) {
    // 아까 MenuRepository에 추가한 그 긴 이름의 메서드를 호출하는 거예요!
    return repository.findByCategoryNameAndPriceGreaterThanEqualOrderByPriceDesc(categoryName,
            minPrice)
        .stream()
        .map(m -> new MenuResponse(
            m.getId(),
            m.getName(),
            m.getPrice(),
            m.getCategory().getName()
        ))
        .toList();
  }

  public MenuResponse findById(Long id) {
    return null;
  }

  @Transactional(readOnly = true)
  public Page<MenuResponse> findMenusPageByCategoryAndMinPrice(
      String categoryName,
      int minPrice,
      int page,
      int size,
      String sortBy,
      String direction
  ) {
    Sort.Direction dir = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
    Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortBy));

    return repository.findByCategoryNameAndPriceGreaterThanEqual(categoryName, minPrice, pageable)
        .map(m -> new MenuResponse(m.getId(), m.getName(), m.getPrice(), m.getCategory().getName()));
  }

  // [추가] Pageable 그대로 받는 예제  (Menu -> MenuResponse)
  @Transactional(readOnly = true)
  public Page<MenuResponse> findMenusPageByCategoryAndMinPrice(
      String categoryName,
      int minPrice,
      Pageable pageable
  ) {
    return repository.findByCategoryNameAndPriceGreaterThanEqual(categoryName, minPrice, pageable)
        .map(m -> new MenuResponse(m.getId(), m.getName(), m.getPrice(), m.getCategory().getName()));
  }

  // [추가] Slice 활용 예제(무한 스크롤)  (Menu -> MenuResponse)
  @Transactional(readOnly = true)
  public Slice<MenuResponse> findMenusSliceByCategoryAndMinPrice(
      String categoryName,
      int minPrice,
      Pageable pageable
  ) {
    return repository.findSliceByCategoryNameAndPriceGreaterThanEqual(categoryName, minPrice, pageable)
        .map(m -> new MenuResponse(m.getId(), m.getName(), m.getPrice(), m.getCategory().getName()));
  }

  @Transactional(readOnly = true)
  public Page<MenuResponse> searchMenus(
      Integer minPrice,
      String categoryName,
      Pageable pageable
  ) {
    return repository
        .findByMinPriceAndOptionalCategory(minPrice, categoryName, pageable)
        .map(m -> new MenuResponse(
            m.getId(),
            m.getName(),
            m.getPrice(),
            m.getCategory().getName() // ⚠️ LAZY → N+1 (다음 챕터에서 해결)
        ));
  }

  @Transactional(readOnly = true)
  public List<MenuResponse> search(String keyword) {
//        return repository.findByNameContaining(keyword).stream()
    return repository.findByNameContainingWithCategory(keyword).stream()
        .map(m -> new MenuResponse(m.getId(), m.getName(), m.getPrice(), m.getCategory().getName()))
        .toList();
  }

}
