package kg.mega.college.controller;

import kg.mega.college.model.dto.GrantDto;
import kg.mega.college.service.GrantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grant")
public class GrantController {

    private final GrantService grantService;

    public GrantController(GrantService grantService) {
        this.grantService = grantService;
    }

    @PostMapping("/save")
    public String save(@RequestBody GrantDto grantDto) {
        return grantService.save(grantDto);
    }

    @GetMapping("get/{grantsId}")
    public String get(@PathVariable Long grantsId) {
        return grantService.get(grantsId);
    }

    @PutMapping("/update")
    public String update(@RequestBody GrantDto grantDto) {
        return grantService.update(grantDto);
    }
}
