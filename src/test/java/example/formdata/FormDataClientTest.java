package example.formdata;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FormDataClientTest {

    @Autowired
    private FormDataClient formDataClient;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testFiles() throws Exception {
        URL url = this.getClass().getClassLoader().getResource("1e97b70.jpg");
        String path = URLDecoder.decode(url.getFile());
        File file = new File(path);

        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "image/jpeg",
                FileUtils.openInputStream(file));
        FileMeta fileMeta = formDataClient.files(multipartFile, "cat.jpg");
        System.out.println("");

    }
}