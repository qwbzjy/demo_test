package com.example.demo_test.template;

import com.example.demo_test.strategy.House;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.Map;

/**
 * @author qiwenbo
 * @date 2022/8/12 14:07
 * @Description
 */
@Component("applicationContextUtil")
public class ApplicationContextUtil /*implements ApplicationContextAware, InitializingBean*/ {

    //    public static Map<String, HouseTemplate> templateMap;
//
//    private ApplicationContext applicationContext;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        if (!CollectionUtils.isEmpty(templateMap)) {
//            templateMap.clear();
//        }
//        templateMap = applicationContext.getBeansOfType(HouseTemplate.class);
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
    @Autowired
    private final Map<String, HouseTemplate> templateMap = new ConcurrentReferenceHashMap<>(3);
    @Autowired
    private final Map<String, House> houseMap = new ConcurrentReferenceHashMap<>(3);

    //    private HouseTemplate houseTemplate;
    public HouseTemplate getHouse(String beanName) {
        return templateMap.get(beanName);
    }

    public House getHs(String beanName) {
        return houseMap.get(beanName);
    }

}
