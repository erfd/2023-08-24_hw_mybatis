package org.fbnv.hwmybatis.component.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fbnv.hwmybatis.entity.Region;
import org.fbnv.hwmybatis.mapper.RegionMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegionService {
	private final RegionMapper regionMapper;

	@Cacheable(value = "region", key = "#id")
	public Region getRegion(Long id) {
		return regionMapper.getRegion(id);
	}

	@Cacheable(value = "regions")
	public List<Region> getAllRegions() {
		log.info("get all regions");
		return regionMapper.getAllRegions();
	}

	@Caching(evict = {
			@CacheEvict(value = "regions", allEntries = true),
			@CacheEvict(value = "region", key = "#region.id")
	})
	public boolean addRegion(Region region) {
		log.info("add region id={}", region.getId());
		return regionMapper.addRegion(region) > 0;
	}

	@Caching(evict = {
			@CacheEvict(value = "regions", allEntries = true),
			@CacheEvict(value = "region", key = "#region.id")
	})
	public boolean updateRegion(Region region) {
		log.info("update region id={}", region.getId());
		return regionMapper.updateRegion(region) > 0;
	}
}
