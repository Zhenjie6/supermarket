package Mytest;

import com.hngd.web.supermarket.service.IUserService;
import com.hngd.web.supermarket.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MyShit {
@Test public void myLittleShit(){
    IUserService iUserService = new UserServiceImpl();
    List<HashMap<String,String>> theList = iUserService.getUserList();
    String string = theList.toString();
    System.out.println(string);
}
}
