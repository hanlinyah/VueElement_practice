import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class VerifyCodeTest {
    @Test
    public  void verifyimgtest() throws Exception{
        OutputStream fos=new FileOutputStream("src/main/webapp/img/verify.jpg");
        String verifycode=util.verifyCode.outputVerifyImage(100,50,fos,4);
        fos.close();
        System.out.println(verifycode);
    }

}
