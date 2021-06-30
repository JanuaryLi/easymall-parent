package cn.tedu;

import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.pojo.User;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private AppTest appTest;
    public AppTest(int a) {
        System.out.println("add1");
    }
    public static void main(String[] args){
        AppTest a=new AppTest(1);
        System.out.println(a.appTest);
        a.appTest=new AppTest(1);
        System.out.println(a.appTest);
        System.out.println(a.appTest.appTest);
    }
}
