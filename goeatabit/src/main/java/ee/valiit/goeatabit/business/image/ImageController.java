package ee.valiit.goeatabit.business.image;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Resource
    private ImagesService imagesService;

    @GetMapping("/image")
    @Operation(summary = "Tagastab kasutajaga seotud pildi.")
    public String getImage(@RequestParam Integer userId) {
        return imagesService.getImage(userId);
    }


}
