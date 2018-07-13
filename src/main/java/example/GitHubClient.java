package example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "http://localhost:10080", name = "gitHubClient")
public interface GitHubClient {

    //e.g. http://localhost:10080/andrefaria/spring-cloud-feign-example

    @RequestMapping(method = RequestMethod.GET, value = "/{owner}/{repo}")
    List<Contributor> contributors(@RequestParam("owner") String owner, @RequestParam("repo") String repo);


}