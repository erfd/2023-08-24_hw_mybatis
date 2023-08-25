package org.fbnv.hwmybatis;

import lombok.RequiredArgsConstructor;
import org.fbnv.hwmybatis.dto.RegionDto;
import org.fbnv.hwmybatis.entity.Region;
import org.fbnv.hwmybatis.mapper.RegionMapper;
import org.modelmapper.ModelMapper;
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
	private final RegionMapper regionMapper;
	private final ModelMapper modelMapper;

	@GetMapping("{id}")
	public ResponseEntity<RegionDto> getRegion(@PathVariable("id") Long id) {
		Region region = regionMapper.getRegion(id);
		RegionDto regionDto = modelMapper.map(region, RegionDto.class);
		return new ResponseEntity<>(regionDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<RegionDto>> getAllRegions() {
		List<RegionDto> regionDtos = regionMapper.getAllRegions().stream()
				.map(r -> modelMapper.map(r, RegionDto.class))
				.toList();
		return new ResponseEntity<>(regionDtos, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> addRegion(@RequestBody RegionDto regionDto) {
		Region region = modelMapper.map(regionDto, Region.class);
		int updatedRows = regionMapper.addRegion(region);
		String result = updatedRows > 0 ? SUCCESS : FAIL;
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<String> patchRegion(@PathVariable("id") Long id, @RequestBody RegionDto regionDto) {
		int updatedRows = regionMapper.updateRegion(id, regionDto.getName(), regionDto.getSlug());
		String result = updatedRows > 0 ? SUCCESS : FAIL;
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
