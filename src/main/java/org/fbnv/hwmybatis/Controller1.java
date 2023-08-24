package org.fbnv.hwmybatis;

import lombok.RequiredArgsConstructor;
import org.fbnv.hwmybatis.entity.Entity1;
import org.fbnv.hwmybatis.mapper.Mapper1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class Controller1 {

	private final Mapper1 mapper1;

	@GetMapping("do")
	public void doSomething() {
		List<Entity1> allEntities = mapper1.getAllEntities();
	}
}
