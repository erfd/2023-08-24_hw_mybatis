package org.fbnv.hwmybatis;

import lombok.RequiredArgsConstructor;
import org.fbnv.hwmybatis.dto.RegionDto;
import org.fbnv.hwmybatis.entity.Region;
import org.fbnv.hwmybatis.mapper.RegionMapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("regions")
public class RegionController {
	private final RegionMapper regionMapper;
	private final ModelMapper modelMapper;

	@GetMapping("/{id}")
	public ResponseEntity<RegionDto> getRegion(@PathVariable("id") Long id) {
		Region region = regionMapper.getRegion(id);
		RegionDto regionDto = modelMapper.map(region, RegionDto.class);
		return new ResponseEntity<>(regionDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<RegionDto>> getAllRegions() {
		List<Region> allRegions = regionMapper.getAllRegions();
		List<RegionDto> regionDtos = allRegions.stream()
				.map(r -> modelMapper.map(r, RegionDto.class))
				.toList();
		return new ResponseEntity<>(regionDtos, HttpStatus.OK);
	}
}
