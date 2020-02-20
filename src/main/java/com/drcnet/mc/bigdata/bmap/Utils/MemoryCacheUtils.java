package com.drcnet.mc.bigdata.bmap.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemoryCacheUtils {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(MemoryCacheUtils.class);
    /**
     * 缓存最大个数
     */
    private static final Integer CACHE_MAX_NUMBER = 100;
    /**
     * 当前缓存个数
     */
    private static Integer CURRENT_SIZE = 0;
    /**
     * 缓存对象
     */
    private static final Map<String, Cache> CACHE_OBJECT_MAP = new ConcurrentHashMap<>();
    /**
     * 这个记录了缓存使用的最后一次的记录，最近使用的在最前面
     */
    private static final List<String> CACHE_USE_LOG_LIST = new LinkedList<>();
    /**
     * 清理过期缓存是否在运行
     */
    private static volatile Boolean CLEAN_THREAD_IS_RUN = false;
    /**
     * 清理线程的单线程池
     */
    private static ExecutorService executor = Executors
        .newSingleThreadExecutor();

    /**
     * 设置缓存
     */
    public static void setCache(String cacheKey, Object cacheValue,
        long cacheTime) {
        startCleanThread();
        checkSize();
        saveCacheUseLog(cacheKey);
        CURRENT_SIZE = CURRENT_SIZE + 1;
        Long time;
        if (cacheTime < 0L) {
            time = -1L;
        } else {
            time = System.currentTimeMillis() + cacheTime;
        }
        Cache cache = new Cache(cacheValue, time);
        CACHE_OBJECT_MAP.put(cacheKey, cache);
        LOGGER.info("存储成功，键为：" + cacheKey);
    }

    /**
     * 设置缓存
     */
    public static void setCache(String cacheKey, Object cacheValue) {
        setCache(cacheKey, cacheValue, -1L);
    }

    /**
     * 获取缓存
     */
    public static Object getCache(String cacheKey) {
        if (checkCache(cacheKey)) {
            saveCacheUseLog(cacheKey);
            return CACHE_OBJECT_MAP.get(cacheKey).getCacheValue();
        }
        return null;
    }

    /**
     * 检验是否存在
     */
    public static boolean isExist(String cacheKey) {
        return checkCache(cacheKey);
    }

    /**
     * 删除所有缓存
     */
    public static void clear() {
        LOGGER.info("删除所有缓存！");
        CACHE_OBJECT_MAP.clear();
        CURRENT_SIZE = 0;
    }

    /**
     * 删除某个缓存
     */
    public static void deleteCache(String cacheKey) {
        Object cacheValue = CACHE_OBJECT_MAP.remove(cacheKey);
        if (cacheValue != null) {
            LOGGER.info("删除缓存成功，键为：" + cacheKey);
            CURRENT_SIZE = CURRENT_SIZE - 1;
        }
    }

    /**
     * 判断缓存是否存在，是否过期。
     */
    private static boolean checkCache(String cacheKey) {
        Cache cache = CACHE_OBJECT_MAP.get(cacheKey);
        if (cache == null) {
            return false;
        }
        if (cache.getTime() == -1L) {
            return true;
        }
        if (cache.getTime() < System.currentTimeMillis()) {
            deleteCache(cacheKey);
            return false;
        }
        return true;
    }

    /**
     * 删除最久未使用的缓存
     */
    private static void deleteLRU() {
        LOGGER.info("删除最久未使用缓存！");
        String cacheKey = CACHE_USE_LOG_LIST
            .remove(CACHE_USE_LOG_LIST.size() - 1);
        deleteCache(cacheKey);
    }

    /**
     * 删除过期的缓存
     */
    private static void deleteTimeOut() {
        LOGGER.info("删除所有过期缓存！");
        List<String> deleteKeyList = new LinkedList<>();
        for (Map.Entry<String, Cache> entry : CACHE_OBJECT_MAP.entrySet()) {
            if (entry.getValue().getTime() < System.currentTimeMillis()
                && entry.getValue().getTime() != -1L) {
                deleteKeyList.add(entry.getKey());
            }
        }
        for (String deleteKey : deleteKeyList) {
            deleteCache(deleteKey);
        }
        LOGGER.info("共删除" + deleteKeyList.size() + "条缓存！");
    }

    /**
     * 检查大小，<br/>
     * 若当前数量已经达到最大数量，<br/>
     * 首先删除过期缓存，<br/>
     * 如果过期缓存删除过后还是达到最大数量，<br/>
     * 删除最久未使用缓存。
     */
    private static void checkSize() {
        if (CURRENT_SIZE >= CACHE_MAX_NUMBER) {
            deleteTimeOut();
        }
        if (CURRENT_SIZE >= CACHE_MAX_NUMBER) {
            deleteLRU();
        }
    }

    /**
     * 保存缓存的使用记录
     */
    private static synchronized void saveCacheUseLog(String cacheKey) {
        CACHE_USE_LOG_LIST.remove(cacheKey);
        CACHE_USE_LOG_LIST.add(0, cacheKey);
    }

    /**
     * 设置清理线程的运行状态为正在运行
     */
    private static void setCleanThreadRun() {
        CLEAN_THREAD_IS_RUN = true;
    }

    /**
     * 开启清理过期缓存的线程
     */
    private static void startCleanThread() {
        if (!CLEAN_THREAD_IS_RUN) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    MemoryCacheUtils.setCleanThreadRun();
                    while (true) {
                        LOGGER.info("清理过期缓存正在进行！");
                        MemoryCacheUtils.deleteTimeOut();
                        try {
                            TimeUnit.MINUTES.sleep(10);
                        } catch (InterruptedException e) {
                            LOGGER.error(e.getMessage());
                        }
                    }
                }
            });
        }
    }

    private static class Cache {

        /**
         * 缓存对象
         */
        private Object cacheValue;
        /**
         * 缓存过期时间
         */
        private Long time;

        Cache(Object cacheValue, Long time) {
            this.cacheValue = cacheValue;
            this.time = time;
        }

        Object getCacheValue() {
            return cacheValue;
        }

        Long getTime() {
            return time;
        }

    }

}
