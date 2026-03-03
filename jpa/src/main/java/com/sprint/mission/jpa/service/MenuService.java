package com.sprint.mission.jpa.service;

import com.sprint.mission.jpa.domain.Category;
import com.sprint.mission.jpa.domain.Menu;
import com.sprint.mission.jpa.dto.MenuResponse;
import com.sprint.mission.jpa.repository.CategoryRepository;
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
  private final CategoryRepository categoryRepository;

  public MenuService(MenuRepository repository, CategoryRepository categoryRepository) {
    this.repository = repository;
    this.categoryRepository = categoryRepository;
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

  @Transactional
  public void txIncrease(String categoryName, int delta) {
    List<Menu> menus = repository.findByCategoryName(categoryName);
    menus.forEach(m -> m.increasePrice(delta));
    // save 호출 없어도 dirty checking으로 UPDATE 됨
  }

  //신규 추가
  // 실습 B: 중간에 예외 → 전체 롤백(신규 메뉴 insert + 가격 update 전부)
  @Transactional
  public void txCreateAndIncreaseWithRollback(
      String categoryName,
      String newMenuName,
      int newMenuPrice,
      int delta
  ) {
    Category category = categoryRepository.findByName(categoryName)
        .orElseThrow(() -> new IllegalArgumentException("카테고리 없음"));

    // 1) 신규 메뉴 insert
    repository.save(new Menu(newMenuName, newMenuPrice, category));

    // 2) 가격 일괄 인상(update)
    List<Menu> menus = repository.findByCategoryName(categoryName);
    menus.forEach(m -> m.increasePrice(delta));

    // 3) 강제 예외 → 롤백 확인
    throw new RuntimeException("강제 예외(롤백 확인)");
  }

}
