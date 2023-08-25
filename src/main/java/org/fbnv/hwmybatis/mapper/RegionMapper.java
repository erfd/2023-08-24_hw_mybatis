package org.fbnv.hwmybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.fbnv.hwmybatis.entity.Region;

import java.util.List;

@Mapper
public interface RegionMapper {

	@Select("SELECT * FROM regions WHERE id = #{id}")
	Region getRegion(@Param("id") Long id);

	@Select("SELECT * FROM regions")
	List<Region> getAllRegions();

	@Insert("INSERT INTO regions (id, name, slug) values (#{id}, #{name}, #{slug})")
	int addRegion(Region region);

	@Update("UPDATE regions SET name = #{name}, slug=#{slug} WHERE id = #{id}")
	int updateRegion(@Param("id") Long id, @Param("name") String name, @Param("slug") String slug);
}
