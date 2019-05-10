package com.jarod.demo.controller;

import com.jarod.demo.dao.EmergencyNodeDao;
import com.jarod.demo.domain.EmergencyNode;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@SpringBootApplication
@RequestMapping(value = "/demo")
public class MainController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private EmergencyNodeDao emergencyNodeDao;

    private final static String QUEUE_NAME = "rabbitMQ_test";

    @RequestMapping(value = "/")
    public String mainMethod() {
        return "hello, spring Boot!";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        String msg = "abc...";
        System.out.println(msg);
        return "need role!";
    }

    @RequestMapping(value = "/test")
    public String test() {

        EmergencyNode node = new EmergencyNode();
        node.setEmergencyId("0bdb143488ab44c3aba2e55d704ab8f5");
        node.setNodeId("hello_000");
        node.setNodeName("complet，springboot!");
        node.setNodeOrder((byte) 1);

//        Pageable pageable = new PageRequest(1, 5, null);
//        Page<EmergencyNode> page = emergencyNodeDao.findAll(pageable);
//        return page.toString();
        return null;
    }

    @RequestMapping(value = "/redis")
    public String testRedis() throws Exception {

        System.out.println("1");

        List<EmergencyNode> nodeList = emergencyNodeDao.findAll();
        redisTemplate.opsForValue().set("nick2", "jarod222");

        long i1 = 1;

        for (EmergencyNode node : nodeList) {
            System.out.println(node.getNodeName());
            redisTemplate.opsForList().leftPush("nodeList", node);
        }

        redisTemplate.opsForValue().set("nodeList2", nodeList);

        //Thread.sleep(10000);
        System.out.println("2");

        return null;
    }

    @RequestMapping(value = "/read")
    public List<EmergencyNode> readRedis() throws Exception {
        List<EmergencyNode> nodeList = redisTemplate.opsForList().range("nodeList", 1L, (long) redisTemplate.opsForList().size("nodeList"));
        System.out.println(redisTemplate.opsForList().size("nodeList") + "... nodeList.size()");
        return nodeList;
    }

    @RequestMapping(value = "/read2")
    public List<EmergencyNode> readRedis2() throws Exception {
        List<EmergencyNode> nodes = (List<EmergencyNode>) redisTemplate.opsForValue().get("nodeList2");
        return nodes;
    }

    @RequestMapping(value = "/sessionTest")
    public String st(HttpSession session) {
        session.setAttribute("nick", "jarod");
        return (String) session.getAttribute("nick");
    }


    @RequestMapping("rabbitMqTest")
    public String listTest() throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "Hello RabbitMQ";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        channel.close();
        connection.close();

        List<String> list = new ArrayList<>();
        return list.size() + "";
    }


}
