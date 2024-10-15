package com.ohgiraffers.section01.xmlmapper;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ElementService elementService = new ElementService();

        do {
            System.out.println("=============== Mapper Element 테스트 메뉴 ===============");
            System.out.println("  1. <cache> 테스트");
            System.out.println("  2. <resultMap> 서브 메뉴");
            System.out.println("  3. <sql> 테스트");
            System.out.println("  4. <insert> 서브 메뉴");
            System.out.print("\n원하시는 메뉴를 골라주세요. : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: elementService.selectCacheTest();
                    break;
            }

        } while (true);

    }

}
