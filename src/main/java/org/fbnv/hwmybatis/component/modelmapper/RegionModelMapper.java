package org.fbnv.hwmybatis.component.modelmapper;

import lombok.RequiredArgsConstructor;
import org.fbnv.hwmybatis.dto.RegionDto;
import org.fbnv.hwmybatis.entity.Region;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RegionModelMapper {
	private final ModelMapper modelMapper;

	public RegionDto getRegionDto(Region region) {
		return modelMapper.map(region, RegionDto.class);
	}

	public Region getRegion(RegionDto regionDto) {
		return modelMapper.map(regionDto, Region.class);
	}
}
