package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.service.MenuService;
import com.ohgiraffers.section01.xmlconfig.view.PrintResult;

import java.util.List;
import java.util.Map;

public class MenuController {

    /* 필기.
    *   Controller 의 역할
    *   view 에서 사용자가 입력한 정보를 파라미터 형태로 전달 받으면 전달 받은 값들을 검증하거나,
    *   ★ 추가적인 정보가 필요하면 가공한 뒤 service 쪽으로 전달하기 위한 인스턴스를 생성하여 담고
    *   service 의 비즈니스 로직을 담당하는 메소드를 호출한다. ★
    *   또한 호출한 수행 결과를 반환받아 어떤 view 를 보여줄지 결정하는 역할을 수행하게 된다.
    * */

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }

    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null) {
            printResult.printMenuList(menuList);
        } else {
//            System.out.println("조회 결과가 없습니다.");
            printResult.printErrorMessage("selectList");
        }

    }

    public void selectMenuByCode(Map<String, String> parameter) {

        // 나중에 나올 개념이지만, 나중에 화면에서 입력 받은 값을 컨트롤러가 전달 받게 되면 String 타입으로 넘어오게 된다.
        // 사용자가 입력한 String 타입의 값을 우리가 설계한 자료형에 맞게 parsing
        int code = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.selectMenuByMenuCode(code);  // 1행

        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("selectOne");
        }

    }

    public void insertNewMenu(Map<String, String> parameter) {
        String newMenuName = parameter.get("NewMenuName");
        int newMenuPrice = Integer.parseInt(parameter.get("NewMenuPrice"));
        int NewMenuCategory = Integer.parseInt(parameter.get("NewMenuCategory"));

        // 서로 다른 자료형을 가진 연고나있는 값을 클래스로 뭉쳐서 전달
        // MenuDTO 클래스 사용
        MenuDTO newMenu = new MenuDTO();
        newMenu.setMenuName(newMenuName);
        newMenu.setMenuPrice(newMenuPrice);
        newMenu.setCategoryCode(NewMenuCategory);

        if(menuService.insertNewMenu(newMenu)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }

    }

    public void modifyMenu(Map<String, String> parameter) {
        int modifyMenuCode = Integer.parseInt(parameter.get("modifyMenuCode"));
        String modifyMenuName = parameter.get("modifyMenuName");
        int modifyMenuPrice = Integer.parseInt(parameter.get("modifyMenuPrice"));
        int modifyMenuCategoryCode = Integer.parseInt(parameter.get("modifyMenuCategoryCode"));

        MenuDTO modifyMenu = new MenuDTO();
        modifyMenu.setMenuCode(modifyMenuCode);
        modifyMenu.setMenuName(modifyMenuName);
        modifyMenu.setMenuPrice(modifyMenuPrice);
        modifyMenu.setCategoryCode(modifyMenuCategoryCode);

        if(menuService.modifyMenu(modifyMenu)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> parameter) {
        int deleteCode = Integer.parseInt(parameter.get("deleteMenuCode"));



        if (menuService.deleteMenuByMenuCode(deleteCode)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
