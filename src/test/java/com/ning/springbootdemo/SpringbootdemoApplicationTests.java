//package com.ning.springbootdemo;
//
//import com.ning.springbootdemo.activemq.Producer;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.jms.Destination;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringbootdemoApplicationTests {
//
////    private MockMvc mockMvc;
////
////    @Before
////    public void setMockMvc(){
////        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
////    }
////
////    @Test
////    public void test() throws Exception {
////        mockMvc.perform(MockMvcRequestBuilders.get("/searchById?id=123").accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(content().string(equalTo("123")));
////    }
//
//    @Autowired
//    private Producer producer;
//    @Test
//    public void contextLoads() {
//        Destination destination = new ActiveMQQueue("mytest.queue");
//        for(int i=0; i<100; i++){
//            producer.sendMessage(destination, "myname is zhangsan!!!");
//        }
//    }
//
//}
