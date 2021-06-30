package cn.tedu;

import static org.junit.Assert.assertTrue;

import com.rabbitmq.tools.json.JSONUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws UnsupportedEncodingException {
        String str = "你好";
        byte[] bytes=str.getBytes("iso8859-1");
        String str1 = new String(bytes, "utf8");
        System.out.println(str1);
        String str2 = new String(str1.getBytes("utf8"), "iso8859-1");
        System.out.println(str2);

    }
}
