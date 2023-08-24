package org.fbnv.hwmybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fbnv.hwmybatis.entity.Entity1;

import java.util.List;

@Mapper
public interface Mapper1 {

	@Select("SELECT * FROM table1 WHERE id = #{id}")
	Entity1 getEntity(@Param("id") Long id);

	@Select("SELECT * FROM table1")
	List<Entity1> getAllEntities();
}
