package example.formdata;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FormDataController {


    @PostMapping(value = "/files",produces = "application/json")
    @ResponseBody
    public FileMeta files(@RequestParam("file") MultipartFile multipartFile, @RequestParam("name") String name) {

        FileMeta fileMeta = new FileMeta();
        fileMeta.setName(name);
        fileMeta.setPath(multipartFile.getOriginalFilename());
        fileMeta.setSize(multipartFile.getSize());
        fileMeta.setContentType(multipartFile.getContentType());
        return fileMeta;
    }
}
