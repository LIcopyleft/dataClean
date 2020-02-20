package com.drcnet.mc.bigdata.bmap.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.slice.SliceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import io.searchbox.action.AbstractAction;
import io.searchbox.action.BulkableAction;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.BulkResult;
import io.searchbox.core.ClearScroll;
import io.searchbox.core.Count;
import io.searchbox.core.CountResult;
import io.searchbox.core.Delete;
import io.searchbox.core.DeleteByQuery;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import io.searchbox.core.SearchScroll;
import io.searchbox.core.Update;
import io.searchbox.core.UpdateByQuery;
import io.searchbox.core.UpdateByQueryResult;
import io.searchbox.params.Parameters;

/**
 * ElasticSearch工具
 * 
 * @author qi.sun
 * @time 2019-7-9 17:49:17
 */
public class ElasticSearchUtils {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(ElasticSearchUtils.class);

    /**
     * 新增/覆盖数据
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param t          数据
     * @return 是否成功
     */
    public static <T> boolean index(JestClient jestClient, String indexName,
        String typeName, T t) {
        Index data = new Index.Builder(t).index(indexName).type(typeName)
            .refresh(true).build();
        try {
            DocumentResult documentResult = jestClient.execute(data);
            return documentResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("新增失败");
            return false;
        }
    }

    /**
     * 删除数据
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param id         主键
     * @return 是否成功
     */
    public static boolean delete(JestClient jestClient, String indexName,
        String typeName, String id) {
        Delete delete = new Delete.Builder(id).index(indexName).type(typeName)
            .refresh(true).build();
        try {
            DocumentResult documentResult = jestClient.execute(delete);
            return documentResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("删除失败");
            return false;
        }
    }

    /**
     * 修改数据
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param t          数据
     * @param id         主键
     * @return 是否成功
     */
    public static <T> boolean update(JestClient jestClient, String indexName,
        String typeName, T t, String id) {
        if (id == null) {
            return false;
        }
        Map<String, Object> doc = new HashMap<>();
        doc.put("doc", t);
        Gson gson = new Gson();
        String json = gson.toJson(doc);
        Update update = new Update.Builder(json).id(id).index(indexName)
            .type(typeName).refresh(true).build();
        try {
            DocumentResult documentResult = jestClient.execute(update);
            return documentResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("修改失败");
            return false;
        }
    }

    /**
     * 修改数据
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param t          数据
     * @return 是否成功
     */
    public static <T> boolean update(JestClient jestClient, String indexName,
        String typeName, T t) {
        String id = AbstractAction.getIdFromSource(t);
        return update(jestClient, indexName, typeName, t, id);
    }

    /**
     * 批量处理
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param actions    处理动作
     * @return 是否成功
     */
    public static boolean bulk(JestClient jestClient, String indexName,
        String typeName,
        Collection<? extends BulkableAction<DocumentResult>> actions) {
        Bulk.Builder builder = new Bulk.Builder().defaultIndex(indexName)
            .defaultType(typeName).refresh(true);
        builder.addAction(actions);
        try {
            BulkResult bulkResult = jestClient.execute(builder.build());
            return bulkResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("批量处理失败");
            return false;
        }
    }

    /**
     * 批量处理
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param loop       处理函数
     * @return 是否成功
     */
    public static boolean bulk(JestClient jestClient, String indexName,
        String typeName, Predicate<Bulk.Builder> loop) {
        Bulk.Builder builder = new Bulk.Builder().defaultIndex(indexName)
            .defaultType(typeName).refresh(true);
        boolean test = loop.test(builder);
        if (test) {
            try {
                BulkResult bulkResult = jestClient.execute(builder.build());
                return bulkResult.isSucceeded();
            } catch (IOException e) {
                LOGGER.error("批量处理失败");
                return false;
            }
        } else {
            LOGGER.error("批量处理失败");
            return false;
        }
    }

    /**
     * 批量新增/覆盖
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param list       数据集合
     * @return 是否成功
     */
    public static <T> boolean index(JestClient jestClient, String indexName,
        String typeName, List<T> list) {
        Predicate<Bulk.Builder> loop = builder -> {
            for (T t : list) {
                Index data = new Index.Builder(t).build();
                builder.addAction(Arrays.asList(data));
            }
            return true;
        };
        return bulk(jestClient, indexName, typeName, loop);
    }

    /**
     * 批量删除
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param ids        主键集合
     * @return 是否成功
     */
    public static boolean delete(JestClient jestClient, String indexName,
        String typeName, List<String> ids) {
        Predicate<Bulk.Builder> loop = builder -> {
            for (String id : ids) {
                Delete delete = new Delete.Builder(id).build();
                builder.addAction(delete);
            }
            return true;
        };
        return bulk(jestClient, indexName, typeName, loop);
    }

    /**
     * 批量修改
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param map        主键数据映射
     * @return 是否成功
     */
    public static <T> boolean update(JestClient jestClient, String indexName,
        String typeName, Map<String, T> map) {
        Predicate<Bulk.Builder> loop = builder -> {
            Set<Entry<String, T>> entrySet = map.entrySet();
            for (Entry<String, T> entry : entrySet) {
                String id = entry.getKey();
                if (id == null) {
                    return false;
                }
                T t = entry.getValue();
                Map<String, Object> doc = new HashMap<>();
                doc.put("doc", t);
                Gson gson = new Gson();
                String json = gson.toJson(doc);
                Update update = new Update.Builder(json).id(id).build();
                builder.addAction(update);
            }
            return true;
        };
        return bulk(jestClient, indexName, typeName, loop);
    }

    /**
     * 批量修改
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param list       数据集合
     * @return 是否成功
     */
    public static <T> boolean update(JestClient jestClient, String indexName,
        String typeName, List<T> list) {
        Predicate<Bulk.Builder> loop = builder -> {
            for (T t : list) {
                String id = AbstractAction.getIdFromSource(t);
                if (id == null) {
                    return false;
                }
                Map<String, Object> doc = new HashMap<>();
                doc.put("doc", t);
                Gson gson = new Gson();
                String json = gson.toJson(doc);
                Update update = new Update.Builder(json).id(id).build();
                builder.addAction(update);
            }
            return true;
        };
        return bulk(jestClient, indexName, typeName, loop);
    }

    /**
     * 条件删除
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @return 是否成功
     */
    public static <T> boolean deleteByQuery(JestClient jestClient,
        String indexName, String typeName, String script) {
        DeleteByQuery deleteByQuery = new DeleteByQuery.Builder(script)
            .addIndex(indexName).addType(typeName).refresh(true).build();
        try {
            JestResult jestResult = jestClient.execute(deleteByQuery);
            return jestResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("删除失败");
            return false;
        }
    }

    /**
     * 条件修改
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @return 是否成功
     */
    public static <T> boolean updateByQuery(JestClient jestClient,
        String indexName, String typeName, String script) {
        UpdateByQuery updateByQuery = new UpdateByQuery.Builder(script)
            .addIndex(indexName).addType(typeName).refresh(true).build();
        try {
            UpdateByQueryResult updateByQueryResult = jestClient
                .execute(updateByQuery);
            return updateByQueryResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("修改失败");
            return false;
        }
    }

    /**
     * 检索
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param clazz      数据类型
     * @return 数据集合
     */
    public static <T> List<T> search(JestClient jestClient, String indexName,
        String typeName, String script, Class<T> clazz) throws IOException {
        Search search = new Search.Builder(script).addIndex(indexName)
            .addType(typeName).build();
        SearchResult searchResult = jestClient.execute(search);
        List<T> list = searchResult.getSourceAsObjectList(clazz, false);
        return list;
    }
    
    /**
     * 检索
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @return 数据集合
     */
    public static SearchResult search(JestClient jestClient, String indexName,
        String typeName, String script) throws IOException {
        Search search = new Search.Builder(script).addIndex(indexName)
            .addType(typeName).build();
        SearchResult searchResult = jestClient.execute(search);
        return searchResult;
    }

    /**
     * 检索
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param scrollId   游标ID
     * @param clazz      数据类型
     * @return 游标ID及数据集合的映射：{"scrollId":游标ID,"list":数据集合}
     */
    public static <T> Map<String, Object> search(JestClient jestClient,
        String indexName, String typeName, String script, String scrollId,
        Class<T> clazz) throws IOException {
        JestResult jestResult = null;
        if (scrollId == null) {
            jestResult = scrollSearch(jestClient, indexName, typeName, script);
            scrollId = jestResult.getJsonObject().get("_scroll_id")
                .getAsString();
        } else {
            jestResult = scrollResult(jestClient, indexName, typeName,
                scrollId);
            scrollId = jestResult.getJsonObject().get("_scroll_id")
                .getAsString();
        }
        List<T> list = jestResult.getSourceAsObjectList(clazz, false);
        Map<String, Object> map = new HashMap<>();
        map.put("scrollId", scrollId);
        map.put("list", list);
        return map;
    }

    public static JestResult searchAfter(JestClient jestClient, String indexName,
        String typeName, SearchSourceBuilder searchSource, Object[] sorts)
        throws IOException {
        if (sorts != null) {
            searchSource.searchAfter(sorts);
        }
        JestResult jestResult = scrollSearch(jestClient, indexName, typeName,
            searchSource.toString());
        return jestResult;
    }

    /**
     * 并行分片滚动查询，相当于把scroll查询结果分割成max个部分，这些部分各自生成一个scrollId进行scroll查询。
     * 
     * @param jestClient   Jest客户端
     * @param indexName    索引
     * @param typeName     类型
     * @param searchSource SearchSourceBuilder对象
     * @param id           分片下标，最小为0，最大为max-1。
     * @param max          分片数量
     * @return JestResult
     */
    public static JestResult slice(JestClient jestClient, String indexName,
        String typeName, SearchSourceBuilder searchSource, int id, int max)
        throws IOException {
        SliceBuilder sliceBuilder = new SliceBuilder(id, max);
        searchSource.slice(sliceBuilder);
        JestResult jestResult = scrollSearch(jestClient, indexName, typeName,
            searchSource.toString());
        return jestResult;
    }

    /**
     * 滚动查询
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @return JestResult
     */
    public static JestResult scrollSearch(JestClient jestClient,
        String indexName, String typeName, String script) throws IOException {
        Search search = new Search.Builder(script).addIndex(indexName)
            .addType(typeName).setParameter(Parameters.SIZE, 1000)
            .setParameter(Parameters.SCROLL, "10m").build();
        JestResult jestResult = jestClient.execute(search);
        return jestResult;
    }

    /**
     * 滚动查询
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param scrollId   游标ID
     * @return JestResult
     */
    public static JestResult scrollResult(JestClient jestClient,
        String indexName, String typeName, String scrollId) throws IOException {
        SearchScroll searchScroll = new SearchScroll.Builder(scrollId, "10m")
            .build();
        JestResult jestResult = jestClient.execute(searchScroll);
        return jestResult;
    }

    /**
     * 遍历检索结果，并处理。
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param function   集合处理函数
     * @param clazz      数据类型
     * @return
     */
    public static <T> int single(JestClient jestClient, String indexName,
        String typeName, String script, Consumer<List<T>> function,
        Class<T> clazz) throws IOException {
        // 获取search语句
        String searchQuery = String.format(script, "");
        // 设置search属性
        Search search = new Search.Builder(searchQuery).addIndex(indexName)
            .addType(typeName).build();
        // 发起请求
        JestResult jestResult = jestClient.execute(search);
        // 获取检索结果
        List<T> hits = jestResult.getSourceAsObjectList(clazz);
        // 处理结果
        function.accept(hits);
        return hits.size();
    }

    /**
     * 遍历检索结果，并处理。
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param function   集合处理函数
     * @param clazz      数据类型
     */
    public static <T, L> boolean after(JestClient jestClient, String indexName,
        String typeName, String script, Predicate<List<T>> function,
        Class<T> clazz) throws IOException {
        // 每次遍历数量
        final long size = 1000L;
        String sizeQuery = "\"size\":" + size + ",";
        String searchAfterQuery = "";
        LOGGER.info("遍历开始");
        while (true) {
            // 获取search语句
            String searchQuery = String.format(script,
                sizeQuery + searchAfterQuery);
            // 设置search属性
            Search search = new Search.Builder(searchQuery).addIndex(indexName)
                .addType(typeName).build();
            // 发起请求
            SearchResult searchResult = jestClient.execute(search);
            // 获取检索结果
            List<T> hits = searchResult.getSourceAsObjectList(clazz, false);
            if (hits.isEmpty()) {
                break;
            }
            List<Hit<T, Void>> list4sort = searchResult.getHits(clazz);
            List<String> sorts = list4sort.get(list4sort.size() - 1).sort;
            searchAfterQuery = "\"search_after\":[\""
                + String.join("\",\"", sorts) + "\"],";
            LOGGER.info("遍历结果 " + hits.size() + " 条");
            boolean test = function.test(hits);
            if (!test) {
                LOGGER.error("处理失败");
                return false;
            }
            // 当起始条数超过总数时跳出循环
        }
        LOGGER.info("遍历结束");
        return true;
    }

    /**
     * 遍历检索结果，并处理。
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param function   集合处理函数
     * @param clazz      数据类型
     */
    public static <T> boolean scroll(JestClient jestClient, String indexName,
        String typeName, String script, Predicate<List<T>> function,
        Class<T> clazz) throws IOException {
        // 每次遍历数量
        final long size = 1000L;
        // elasticsearch遍历查询scrollId
        String scrollId = null;
        LOGGER.info("遍历开始");
        while (true) {
            // 检索结果
            JestResult jestResult = null;
            if (scrollId == null) {
                // 当scrollId不存在时，即第一次遍历。
                // 获取search语句
                String searchQuery = String.format(script, "");
                // 设置search属性
                Search search = new Search.Builder(searchQuery)
                    .addIndex(indexName).addType(typeName)
                    .setParameter(Parameters.SIZE, size)
                    .setParameter(Parameters.SCROLL, "10m").build();
                // 发起请求
                jestResult = jestClient.execute(search);
                // 获得scrollId
                scrollId = jestResult.getJsonObject().get("_scroll_id")
                    .getAsString();
            } else {
                // 设置scroll属性
                SearchScroll searchScroll = new SearchScroll.Builder(scrollId,
                    "10m").build();
                // 发起请求
                jestResult = jestClient.execute(searchScroll);
                // 获得scrollId
                scrollId = jestResult.getJsonObject().get("_scroll_id")
                    .getAsString();
            }
            // 获取检索结果
            List<T> hits = jestResult.getSourceAsObjectList(clazz);
            if (hits.isEmpty()) {
                break;
            }
            LOGGER.info("遍历结果 " + hits.size() + " 条");
            boolean test = function.test(hits);
            if (!test) {
                LOGGER.error("处理失败");
                return false;
            }
            // 当起始条数超过总数时跳出循环
        }
        ClearScroll clearScroll = new ClearScroll.Builder()
            .addScrollId(scrollId).build();
        JestResult jestResult = jestClient.execute(clearScroll);
        // 获取成功状态
        boolean succeeded = jestResult.isSucceeded();
        LOGGER.info("清除scrollId " + (succeeded ? "成功" : "失败"));
        LOGGER.info("遍历结束");
        return true;
    }

    /**
     * 遍历检索结果，并处理。
     * 
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param function   集合处理函数
     * @param clazz      数据类型
     */
    @Deprecated
    public static <T, L> boolean page(JestClient jestClient, String indexName,
        String typeName, String script, Predicate<List<T>> function,
        Class<T> clazz) throws IOException {
        // 获取count语句
        String countQuery = String.format(script, "");
        // 设置count属性
        Count count = new Count.Builder().addIndex(indexName).addType(typeName)
            .query(countQuery).build();
        // 发起请求
        CountResult results = jestClient.execute(count);
        // 总数
        final long total = results.getCount().intValue();
        // 从第几条开始
        long from = 0;
        // 每次遍历数量
        final long size = 1000L;
        LOGGER.info("遍历开始");
        while (from < total) {
            // 获取search语句
            String searchQuery = String.format(script,
                "\"from\":" + from + ",\"size\":" + size
                    + ",\"sort\":[{\"_id\":{\"order\":\"asc\"}}],");
            // 设置search属性
            Search search = new Search.Builder(searchQuery).addIndex(indexName)
                .addType(typeName).build();
            // 发起请求
            JestResult jestResult = jestClient.execute(search);
            // 获取检索结果
            List<T> hits = jestResult.getSourceAsObjectList(clazz);
            LOGGER.info("遍历结果 " + hits.size() + " 条");
            boolean test = function.test(hits);
            if (!test) {
                LOGGER.error("处理失败");
                return false;
            }
            // 修改起始条数
            from += size;
        }
        LOGGER.info("遍历结束");
        return true;
    }

    /**
     * 遍历集合，并处理。
     * 
     * @param list     数据集合
     * @param function 处理函数
     */
    public static <T> boolean iterator(List<T> list,
        Predicate<List<T>> function) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        // 若集合不为空
        // 获取遍历器
        Iterator<T> iterator = list.iterator();
        // 待处理数量
        long count = list.size();
        LOGGER.info("处理开始，待处理 " + count + " 条");
        // 每次导入数量
        final long size = 1000L;
        do {
            // 获取循环次数
            long forSize = count < size ? count : size;
            // 添加处理数据
            List<T> group = new ArrayList<>();
            for (long i = 0; i < forSize; i++) {
                T next = iterator.next();
                group.add(next);
            }
            // 业务处理
            boolean test = function.test(group);
            if (!test) {
                LOGGER.info("处理失败");
                return false;
            }
            // 剩余数量减少
            count -= forSize;
            // 当待导入数量为0时跳出循环
        } while (count > 0);
        list.clear();
        LOGGER.info("处理结束");
        return true;
    }

}
