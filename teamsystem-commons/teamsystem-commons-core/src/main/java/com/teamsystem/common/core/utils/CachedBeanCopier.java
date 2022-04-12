package com.teamsystem.common.core.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象复制器缓存
 * @author Moment
 */
public class CachedBeanCopier {
    //创建过的BeanCopier实例放到缓存中，下次可以直接获取，提升性能
    private static final Map<String, BeanCopier> BEAN_COPIERS = new HashMap<>();

    public static void copy(Object srcObj, Object destObj) {
        String key = genKey(srcObj.getClass(), destObj.getClass());
        BeanCopier copier;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        copier.copy(srcObj, destObj, null);
    }

    public static Object copy(Object srcObj,Class<?> destClazz) {
        String key = genKey(srcObj.getClass(), destClazz);
        BeanCopier copier;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destClazz, false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        Object destObj = null;
        try {
            destObj = destClazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        copier.copy(srcObj, destObj, null);
        return destObj;
    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }
}