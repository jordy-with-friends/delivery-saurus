package com.deliverysaurus.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import com.deliverysaurus.member.domain.Gender;

@RestController
public class EnumController {
    @RequestMapping("/test/gender-enums")
    public Map<String, String> domainEnums() {
        return Arrays.stream(Gender.values())
                .collect(Collectors.toMap(Gender::name, Gender::name));
    }
}
