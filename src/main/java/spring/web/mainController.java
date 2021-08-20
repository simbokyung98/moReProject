package spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.service.MaterialService;
import spring.web.dto.MaterialDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class mainController {

    private final MaterialService materialService;

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/meterialMain")
    public String meterrialMain(Model model){

        List<MaterialDto> materialDtoList = materialService.getAllMaterial();

        model.addAttribute("materialList", materialDtoList);

        return "meterialMain";
    }

    //재료 목록 종류별 띄우기
    @GetMapping("/meterialMain/{materialMainCate}")
    public String materialMainCate(@PathVariable("materialMainCate") String materialMainCate, Model model){
        List<MaterialDto> materialDtoList =materialService.getCateMaterial(materialMainCate);

        model.addAttribute("materialList", materialDtoList);

        return "meterialMain";
    }
}
