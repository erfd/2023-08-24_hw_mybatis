package org.fbnv.hwmybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fbnv.hwmybatis.entity.Region;

import java.util.List;

@Mapper
public interface RegionMapper {

	@Select("SELECT * FROM regions WHERE id = #{id}")
	Region getRegion(@Param("id") Long id);

	@Select("SELECT * FROM regions")
	List<Region> getAllRegions();
}
