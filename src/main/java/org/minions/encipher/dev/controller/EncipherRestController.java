package org.minions.encipher.dev.controller;

import org.minions.encipher.base.model.AjaxJson;
import org.minions.encipher.dev.service.EncipherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "cipher")
public class EncipherRestController {

    @Resource
    private EncipherService encipherService;

    @PostMapping(value = "")
    public AjaxJson encipher(@RequestParam String username,
                             @RequestParam(required = false) String password,
                             @RequestParam String identity,
                             @RequestParam(defaultValue = "0") short format,
                             @RequestParam(defaultValue = "8") int minLength,
                             @RequestParam(defaultValue = "16") int maxLength) {
        String data = this.encipherService.encipher(username, password, identity, format, minLength, maxLength);
        return AjaxJson.success("success", data);
    }
}
