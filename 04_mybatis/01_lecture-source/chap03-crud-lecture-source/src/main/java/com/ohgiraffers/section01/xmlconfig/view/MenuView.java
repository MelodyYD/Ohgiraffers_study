package com.ohgiraffers.section01.xmlconfig.view;

import com.ohgiraffers.section01.xmlconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuView {

    /* 필기.
    *   우리는 아직 Server 에 대한 개념과 프론트엔드에 대한 개념을 배우지 않았다.
    *   따라서 실질적으로 사용자들이 볼 수 있는 화면을 만들 수는 없지만,
    *   콘솔창을 사용자들이 볼 수 있는 화면이라고 생각하고 진행해보자.
    * */

    /*
    *   시스템 요구사항
    *   1. 메뉴 전체 조회
    *   2. 메뉴 코드로 메뉴 조회
    *   3. 신규 메뉴 등록
    *   4. 메뉴 수정
    *   5. 메뉴 삭제
    * */
    public void display() {

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do {

            System.out.println("┌───────────────────────────────────────────────────────────┐");
            System.out.println("│                ★ Hi-Media 메뉴 관리 시스템 ★         　     │");
            System.out.println("│                                                           │");
            System.out.println("│  1. 메뉴 전체 조회하기                                       │");
            System.out.println("│  2. 메뉴 코드로 메뉴 조회하기                                 │");
            System.out.println("│  3. 신규 메뉴 등록하기                                       │");
            System.out.println("│  4. 메뉴 수정하기                                           │");
            System.out.println("│  5. 메뉴 삭제하기                                           │");
            System.out.println("│  9. 종료하기                                               │");
            System.out.println("│                                                           │");
            System.out.println("└───────────────────────────────────────────────────────────┘");
            System.out.println("");
            System.out.print("실행할 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            if (no == 9) {
                System.out.println();
                System.out.println("┌───────────────────────────────────────────────────────────┐");
                System.out.println("│                    프로그램을 종료합니다.                     │");
                System.out.println("└───────────────────────────────────────────────────────────┘");
                System.out.println();
                break;
            }

            switch (no) {
                case 1: menuController.selectAllMenu();
                    break;
                case 2: menuController.selectMenuByCode(inputMenuCode());
                    break;
                case 3: menuController.insertNewMenu(inputMenu());
                    break;
                case 4: menuController.modifyMenu(inputModifyMenu());
                    break;
                case 5: menuController.deleteMenu(inputDeleteMenuCode());
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                    break;
            }

        } while (true);

    }

    private static Map<String, String> inputDeleteMenuCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴 코드를 입력해주세요. : ");
        String deleteMenuCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("deleteMenuCode", deleteMenuCode);

        return parameter;

    }

    private static Map<String, String> inputModifyMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 메뉴 코드를 입력해주세요. : ");
        String modifyMenuCode = sc.nextLine();
        System.out.print("수정할 메뉴 이름을 입력해주세요. : ");
        String modifyMenuName = sc.nextLine();
        System.out.print(modifyMenuName + "의 수정할 가격을 입력해주세요. : ");
        String modifyMenuPrice = sc.nextLine();
        System.out.print(modifyMenuName + "의 수정할 카테고리 코드를 입력해주세요. : ");
        String modifyMenuCategoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("modifyMenuCode", modifyMenuCode);
        parameter.put("modifyMenuName", modifyMenuName);
        parameter.put("modifyMenuPrice", modifyMenuPrice);
        parameter.put("modifyMenuCategoryCode", modifyMenuCategoryCode);

        return parameter;

    }

    private static Map<String, String> inputMenuCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 메뉴 코드를 입력해주세요. : ");
        String menuCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);

        return parameter;

    }

    private static Map<String, String> inputMenu() {
        // 메뉴 이름, 가격, 카테고리 코드를 입력받아 넘겨주기
        Scanner sc = new Scanner(System.in);
        System.out.print("신규 메뉴 이름을 입력해주세요. : ");
        String NewMenuName = sc.nextLine();
        System.out.print(NewMenuName + "의 판매 가격을 입력해주세요. : ");
        String NewMenuPrice = sc.nextLine();
        System.out.print(NewMenuName + "의 카테고리 코드를 입력해주세요. : ");
        String NewMenuCategory = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("NewMenuName", NewMenuName);
        parameter.put("NewMenuPrice", NewMenuPrice);
        parameter.put("NewMenuCategory", NewMenuCategory);

        return parameter;

    }

}
