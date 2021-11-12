// P8-06-服务拆分-服务远程调用
// P13-11-Eureka-服务发现
// http://localhost:8081/user/1
// http://localhost:8080/order/101
// http://localhost:8080/order/102

package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2. 利用RestTemplate发起http请求，查询用户
        String url = "http://userservice/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        // 3. 封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
