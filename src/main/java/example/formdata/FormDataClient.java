package example.formdata;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(url = "http://127.0.0.1:10080", name = "formDataClient")
public interface FormDataClient {

    @PostMapping(value = "files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    FileMeta files(@RequestPart("file") MultipartFile multipartFile, @RequestParam("name") String name);

    @Configuration
    class MultipartSupportConfig {

        @Bean
        @Scope("prototype") // others say, may be confuse inputStream
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
