package com.ohgiraffers.section01.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface ElementMapper {

    List<String> selectCacheTest();

}
