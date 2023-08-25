package org.fbnv.hwmybatis.component.controller;

import lombok.RequiredArgsConstructor;
import org.fbnv.hwmybatis.component.modelmapper.RegionModelMapper;
import org.fbnv.hwmybatis.dto.RegionDto;
import org.fbnv.hwmybatis.entity.Region;
import org.fbnv.hwmybatis.component.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("regions")
public class RegionController {
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	private final RegionModelMapper regionModelMapper;
	private final RegionService regionService;

	@GetMapping("{id}")
	public ResponseEntity<RegionDto> getRegion(@PathVariable("id") Long id) {
		Region region = regionService.getRegion(id);
		RegionDto regionDto = regionModelMapper.getRegionDto(region);
		return new ResponseEntity<>(regionDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<RegionDto>> getAllRegions() {
		List<RegionDto> regionDtos = regionService.getAllRegions().stream()
				.map(regionModelMapper::getRegionDto)
				.toList();
		return new ResponseEntity<>(regionDtos, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> addRegion(@RequestBody RegionDto regionDto) {
		Region region = regionModelMapper.getRegion(regionDto);
		boolean success = regionService.addRegion(region);
		return new ResponseEntity<>(getSuccessString(success), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<String> patchRegion(@PathVariable("id") Long id, @RequestBody RegionDto regionDto) {
		Region region = regionModelMapper.getRegion(regionDto);
		region.setId(id);
		boolean success = regionService.updateRegion(region);
		return new ResponseEntity<>(getSuccessString(success), HttpStatus.OK);
	}

	private static String getSuccessString(boolean success) {
		return success ? SUCCESS : FAIL;
	}
}
