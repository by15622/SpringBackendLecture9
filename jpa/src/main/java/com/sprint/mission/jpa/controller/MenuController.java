package com.sprint.mission.jpa.controller;

import com.sprint.mission.jpa.service.MenuService;
import com.sprint.mission.jpa.dto.MenuResponse;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menus")
public class MenuController {

  private final MenuService service;

  public MenuController(MenuService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public MenuResponse get(@PathVariable Long id) {
    return service.findById(id);
  }

  @GetMapping("/filter2")
  public List<MenuResponse> filter2(
      @RequestParam String categoryName,
      @RequestParam int minPrice
  ) {
    return service.findExpensiveMenusInCategory2(categoryName, minPrice);
  }

  @GetMapping("/pages")
  public Page<MenuResponse> pages(
      @RequestParam String categoryName,
      @RequestParam int minPrice,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(defaultValue = "price") String sortBy,
      @RequestParam(defaultValue = "desc") String direction
  ) {
    return service.findMenusPageByCategoryAndMinPrice(categoryName, minPrice, page, size, sortBy, direction);
  }

  // GET /menus/pages2?categoryName=찌개류&minPrice=8000&page=0&size=10&sort=price,desc
  @GetMapping("/pages2")
  public Page<MenuResponse> pages2(
      @RequestParam String categoryName,
      @RequestParam int minPrice,
      @PageableDefault(size = 10, sort = "price", direction = Sort.Direction.DESC) Pageable pageable
  ) {
    return service.findMenusPageByCategoryAndMinPrice(categoryName, minPrice, pageable);
  }

  // GET /menus/slice?categoryName=찌개류&minPrice=8000&page=0&size=10&sort=id,asc
  @GetMapping("/slice")
  public Slice<MenuResponse> slice(
      @RequestParam String categoryName,
      @RequestParam int minPrice,
      @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
  ) {
    return service.findMenusSliceByCategoryAndMinPrice(categoryName, minPrice, pageable);
  }

  @GetMapping("/page-search")
  public Page<MenuResponse> pageSearch(
      @RequestParam int minPrice,
      @RequestParam(required = false) String categoryName,
      @PageableDefault(size = 10, sort = "price", direction = Sort.Direction.DESC)
      Pageable pageable
  ) {
    return service.searchMenus(minPrice, categoryName, pageable);
  }

  //신규 추가
  // 1) 커밋 확인
  // POST /menus/tx/increase?categoryName=찌개류&delta=1000
  @PostMapping("/tx/increase")
  public void txIncrease(
      @RequestParam String categoryName,
      @RequestParam int delta
  ) {
    service.txIncrease(categoryName, delta);
  }

  //신규 추가
  // 2) 롤백 확인
  // POST /menus/tx/rollback?categoryName=찌개류&newMenuName=롤백메뉴&newMenuPrice=9999&delta=1000
  @PostMapping("/tx/rollback")
  public void txRollback(
      @RequestParam String categoryName,
      @RequestParam String newMenuName,
      @RequestParam int newMenuPrice,
      @RequestParam int delta
  ) {
    service.txCreateAndIncreaseWithRollback(categoryName, newMenuName, newMenuPrice, delta);
  }

  @GetMapping("/tx/isolation/read-twice")
  public String readTwice(@RequestParam Long menuId) throws Exception {
    int diff = service.readTwicePrice(menuId);
    return "diff=" + diff;
  }

  @PostMapping("/tx/isolation/update")
  public String updatePrice(@RequestParam Long menuId, @RequestParam int price) {
    // 단순 업데이트: 기본 @Transactional 없어도 save/update는 커밋됨(요청 단위)
    service.updatePrice(menuId, price); // 아래 updatePrice 메서드 하나 만들어두면 됨
    return "updated";
  }


}
