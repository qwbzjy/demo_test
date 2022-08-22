package com.example.demo_test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo_test.enums.SexEnum;
import com.example.demo_test.mapper.UserMapper;
import com.example.demo_test.po.ExtendInfo;
import com.example.demo_test.po.User;
import com.example.demo_test.reflect.Per;
import com.example.demo_test.service.impl.BusinessServiceImpl;
import com.example.demo_test.strategy.House;
import com.example.demo_test.template.ApplicationContextUtil;
import com.example.demo_test.template.HouseTemplate;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.HashAttributeSet;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@SpringBootTest
class DemoTestApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BusinessServiceImpl businessService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RestTemplate httpClientTemplate;

    @Autowired
    private CloseableHttpClient httpClient;

    @Test
    void test() throws IOException {

        String result = httpClientTemplate.getForObject("https://www.baidu.com/", String.class);
        System.out.println("httpClientTemplate===" + result);


        // 声明 http get 请求
        String url = "https://www.baidu.com/";
        HttpGet httpGet = new HttpGet(url);
        // 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpGet);
        System.out.println("httpClient===" + response);
    }

    @Test
    public void testAop() {
        businessService.executeBuss();
    }

    @Test
    public void testRedis() {
        //=====================string============
//        redisTemplate.opsForValue().set("t1", "测试数据");
//        System.out.println(redisTemplate.opsForValue().get("t1"));
        //=====================list============
//        redisTemplate.opsForList().leftPushAll("list1", "a", "b");
//        List<String> list1 = redisTemplate.opsForList().range("list1", 0, -1);
//        System.out.println(list1);
//        List<String> ls = new ArrayList<>();
//        ls.add("c");
//        ls.add("d");
//        redisTemplate.opsForList().leftPush("list1", ls);
//        List<String> list2 = redisTemplate.opsForList().range("list1", 0, -1);
//        System.out.println(list2);

        //=====================hash============
//        redisTemplate.opsForHash().put("key1","k1","v1");
//        System.out.println(redisTemplate.opsForHash().get("key1","k1"));
        //=====================set============
//        redisTemplate.opsForSet().add("set1","1","2");
//        System.out.println(redisTemplate.opsForSet().members("set1"));
        //=====================sorted set============
        redisTemplate.opsForZSet().add("zset1", "order", 1.0);
        redisTemplate.opsForZSet().add("zset1", "goods", 2.0);
        System.out.println(redisTemplate.opsForZSet().popMax("zset1"));
    }

    @Test
    public void getAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void insert() {
        List<String> features = Arrays.asList("u", "v", "w");
        ExtendInfo extendInfo = ExtendInfo.builder().address("hz").email("123@qq.com").age(10).build();
        User build = User.builder().deptId(1).name("alice10").remark("like baseball 9").sex(SexEnum.MAN).features(features).extendInfo(extendInfo).build();
        int insert = userMapper.insert(build);
        System.out.println(insert+"   插入后的主键id: "+build.getId());
    }

    @Test
    public void update_01() {
        User user = User.builder().id(7).deptId(1).name("alice2").remark("like soccer").build();
        userMapper.updateById(user);
    }

    @Test
    public void update_02() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "alice2").set("remark", "like basketball");
        userMapper.update(null, updateWrapper);
    }

    @Test
    public void update_03() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "alice2");
        User user = User.builder().remark("like table ball").build();
        userMapper.update(user, updateWrapper);
    }

    @Test
    public void delete_01() {
        userMapper.deleteById(1);
    }

    @Test
    public void delete_02() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "小菜");
        map.put("remark", "关注小菜不迷路！");
        userMapper.deleteByMap(map);
    }

    @Test
    public void delete_03() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("remark", "好好学习，天天向上！");
        userMapper.delete(updateWrapper);
    }

    @Test
    public void delete_04() {
        User user = User.builder().remark("like baseball").build();
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>(user);
        userMapper.delete(updateWrapper);
    }

    @Test
    public void deleteBatchIds() {
        List<Integer> idList = new ArrayList<>();
        idList.add(4);
        idList.add(7);
        userMapper.deleteBatchIds(idList);
    }

    @Test
    public void selectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void selectCount() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "ali");
        System.out.println(userMapper.selectCount(queryWrapper));

    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(13);
        System.out.println(user);
    }

    @Test
    public void selectBatchByIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(7, 9));
        users.forEach(System.out::println);
    }

    @Test
    public void selectOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getName, "alice");
//        queryWrapper.eq("name", "alice");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "alice");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void selectMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "ice");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void selectObjects() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "ice");
        List<Object> objects = userMapper.selectObjs(queryWrapper);
    }

    @Test
    public void selectPage() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", "ice");
        queryWrapper.lambda().like(User::getName, "ice");
//        Page<User> page = new Page<>(1, 2, false);
        Page<User> page = new Page<>(1, 2);
        Page<User> page1 = userMapper.selectPage(page, queryWrapper);
        System.out.println(page1.getTotal() + "   " + page1.getPages() + " " + page1.getCurrent() + " " + page1.getSize());
        page1.getRecords().forEach(System.out::println);
    }

    // 自定义分页方法
    @Test
    public void selectUserPage() {
        Page<User> page = new Page<>(1, 2);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(User::getName, "ice");
        IPage<User> userIPage = userMapper.selectUserPage(page, queryWrapper);
        System.out.println("=============");
    }

    @Test
    public void testAllEq() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "alice");
        map.put("remark", null);
        queryWrapper.allEq(map);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testAllEq_01() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "alice");
        map.put("remark", null);
        queryWrapper.allEq(map, false); ////不会调用 isNull 方法[ remark is null]
        userMapper.selectList(queryWrapper);
    }

    @Test
    public void testAllEq_02() {
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "alice");
        map.put("remark", null);
        // 不传入查询条件
        queryWrapper.allEq(false, map, false);
        userMapper.selectList(queryWrapper);
    }

    @Test
    public void testAllEq_03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "alice");
        map.put("remark", null);
        //只有 key 中包含 r 字母的才会过滤
        queryWrapper.allEq((k, v) -> (k.contains("r")), map);
        userMapper.selectList(queryWrapper);
    }

    @Test
    public void deleteLogic() {
        userMapper.deleteById(7);
    }


//    @Autowired
//    private ApplicationContextUtil applicationContextUtil;
//
////    @Test
////    void contextLoads() {
////    }
//
//    private static Class class1;
//
//    @BeforeTestClass
//    public static void beforeClass() throws ClassNotFoundException {
//        System.out.println("测试方法启动前先加载类");
//        class1 = Class.forName("com.example.demo_test.reflect.Per");
//    }
//
//    @Test
//    public void test1() throws Exception {
//        Constructor constructor = class1.getConstructor(null);
//        Per per = (Per) constructor.newInstance(null);
//        System.out.println(per.name);
//    }
//
//    @Test
//    public void test2() throws Exception {
//        Constructor constructor = class1.getConstructor(String.class, int.class);
//        Per alex = (Per) constructor.newInstance("alex", 1);
//    }
//
//    @Test
//    public void test3() throws Exception {
//        Constructor declaredConstructor = class1.getDeclaredConstructor(String.class);
//        declaredConstructor.setAccessible(true);
//        Per per = (Per) declaredConstructor.newInstance("alice");
//        System.out.printf(per.name);
//    }
//
//
//    @Test
//    public void testMap() {
////        HouseTemplate wooden = applicationContextUtil.getHouse("wooden");
////        wooden.buildHouse();
//        House glass = applicationContextUtil.getHs("glass");
//        System.out.printf(glass.firstStep("nice "));
//        System.out.println(glass.secondStep("真香 "));
//    }

}
