package example;

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
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GitHubClientTest {

    @Autowired
    private GitHubClient client;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void contributors() {
        List<Contributor> list = client.contributors("C", "a");
        System.out.println("");
    }


    @Test
    public void testUploadFiles() throws Exception {
        URL url = this.getClass().getClassLoader().getResource("1e97b70.jpg");
        String path = URLDecoder.decode(url.getFile());
        File file = new File(path);

        MultipartFile multipartFile = new MockMultipartFile(file.getName(),FileUtils.openInputStream(file));
        client.files(multipartFile,"cat.jpg");

    }

}