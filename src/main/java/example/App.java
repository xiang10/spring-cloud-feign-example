package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebMvc
@Controller
@EnableFeignClients
public class App {


    @Autowired
    private GitHubClient gitHub;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/{owner}/{repo}")
    @ResponseBody
    public List<Contributor> contributors(@PathVariable String owner, @PathVariable String repo) {
        List<Contributor> list = new ArrayList<>();
        Contributor contributor = new Contributor();
        contributor.setLogin(owner + "-" + repo);
        contributor.setContributions(1);
        list.add(contributor);
        return list;
    }


    @PostMapping("/files/{name:.+}")
    @ResponseBody
    public FileMeta files(@RequestParam("file") MultipartFile multipartFile, @PathVariable("name") String name) {

        FileMeta fileMeta = new FileMeta();
        fileMeta.setName(name);
        fileMeta.setPath(multipartFile.getOriginalFilename());
        fileMeta.setSize(multipartFile.getSize());
        fileMeta.setContentType(multipartFile.getContentType());
        return fileMeta;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}

