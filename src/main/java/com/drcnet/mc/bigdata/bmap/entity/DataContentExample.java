package com.drcnet.mc.bigdata.bmap.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DataContentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataContentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUrlIdIsNull() {
            addCriterion("url_id is null");
            return (Criteria) this;
        }

        public Criteria andUrlIdIsNotNull() {
            addCriterion("url_id is not null");
            return (Criteria) this;
        }

        public Criteria andUrlIdEqualTo(Integer value) {
            addCriterion("url_id =", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdNotEqualTo(Integer value) {
            addCriterion("url_id <>", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdGreaterThan(Integer value) {
            addCriterion("url_id >", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("url_id >=", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdLessThan(Integer value) {
            addCriterion("url_id <", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdLessThanOrEqualTo(Integer value) {
            addCriterion("url_id <=", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdIn(List<Integer> values) {
            addCriterion("url_id in", values, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdNotIn(List<Integer> values) {
            addCriterion("url_id not in", values, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdBetween(Integer value1, Integer value2) {
            addCriterion("url_id between", value1, value2, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("url_id not between", value1, value2, "urlId");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNull() {
            addCriterion("classify is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNotNull() {
            addCriterion("classify is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyEqualTo(String value) {
            addCriterion("classify =", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotEqualTo(String value) {
            addCriterion("classify <>", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThan(String value) {
            addCriterion("classify >", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThanOrEqualTo(String value) {
            addCriterion("classify >=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThan(String value) {
            addCriterion("classify <", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThanOrEqualTo(String value) {
            addCriterion("classify <=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLike(String value) {
            addCriterion("classify like", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotLike(String value) {
            addCriterion("classify not like", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyIn(List<String> values) {
            addCriterion("classify in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotIn(List<String> values) {
            addCriterion("classify not in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyBetween(String value1, String value2) {
            addCriterion("classify between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotBetween(String value1, String value2) {
            addCriterion("classify not between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTimeshowIsNull() {
            addCriterion("timeShow is null");
            return (Criteria) this;
        }

        public Criteria andTimeshowIsNotNull() {
            addCriterion("timeShow is not null");
            return (Criteria) this;
        }

        public Criteria andTimeshowEqualTo(Date value) {
            addCriterionForJDBCDate("timeShow =", value, "timeshow");
            return (Criteria) this;
        }

        public Criteria andTimeshowNotEqualTo(Date value) {
            addCriterionForJDBCDate("timeShow <>", value, "timeshow");
            return (Criteria) this;
        }

        public Criteria andTimeshowGreaterThan(Date value) {
            addCriterionForJDBCDate("timeShow >", value, "timeshow");
            return (Criteria) this;
        }

        public Criteria andTimeshowGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("timeShow >=", value, "timeshow");
            return (Criteria) this;
        }

        public Criteria andTimeshowLessThan(Date value) {
            addCriterionForJDBCDate("timeShow <", value, "timeshow");
            return (Criteria) this;
        }

        public Criteria andTimeshowLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("timeShow <=", value, "timeshow");
            return (Criteria) this;
        }

        public Criteria andTimeshowIn(List<Date> values) {
            addCriterionForJDBCDate("timeShow in", values, "timeshow");
            return (Criteria) this;
        }

        public Criteria andTimeshowNotIn(List<Date> values) {
            addCriterionForJDBCDate("timeShow not in", values, "timeshow");
            return (Criteria) this;
        }

        public Criteria andTimeshowBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("timeShow between", value1, value2, "timeshow");
            return (Criteria) this;
        }

        public Criteria andTimeshowNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("timeShow not between", value1, value2, "timeshow");
            return (Criteria) this;
        }

        public Criteria andStagenameIsNull() {
            addCriterion("stageName is null");
            return (Criteria) this;
        }

        public Criteria andStagenameIsNotNull() {
            addCriterion("stageName is not null");
            return (Criteria) this;
        }

        public Criteria andStagenameEqualTo(String value) {
            addCriterion("stageName =", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameNotEqualTo(String value) {
            addCriterion("stageName <>", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameGreaterThan(String value) {
            addCriterion("stageName >", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameGreaterThanOrEqualTo(String value) {
            addCriterion("stageName >=", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameLessThan(String value) {
            addCriterion("stageName <", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameLessThanOrEqualTo(String value) {
            addCriterion("stageName <=", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameLike(String value) {
            addCriterion("stageName like", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameNotLike(String value) {
            addCriterion("stageName not like", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameIn(List<String> values) {
            addCriterion("stageName in", values, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameNotIn(List<String> values) {
            addCriterion("stageName not in", values, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameBetween(String value1, String value2) {
            addCriterion("stageName between", value1, value2, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameNotBetween(String value1, String value2) {
            addCriterion("stageName not between", value1, value2, "stagename");
            return (Criteria) this;
        }

        public Criteria andPlatformnamIsNull() {
            addCriterion("platformNam is null");
            return (Criteria) this;
        }

        public Criteria andPlatformnamIsNotNull() {
            addCriterion("platformNam is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformnamEqualTo(String value) {
            addCriterion("platformNam =", value, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamNotEqualTo(String value) {
            addCriterion("platformNam <>", value, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamGreaterThan(String value) {
            addCriterion("platformNam >", value, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamGreaterThanOrEqualTo(String value) {
            addCriterion("platformNam >=", value, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamLessThan(String value) {
            addCriterion("platformNam <", value, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamLessThanOrEqualTo(String value) {
            addCriterion("platformNam <=", value, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamLike(String value) {
            addCriterion("platformNam like", value, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamNotLike(String value) {
            addCriterion("platformNam not like", value, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamIn(List<String> values) {
            addCriterion("platformNam in", values, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamNotIn(List<String> values) {
            addCriterion("platformNam not in", values, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamBetween(String value1, String value2) {
            addCriterion("platformNam between", value1, value2, "platformnam");
            return (Criteria) this;
        }

        public Criteria andPlatformnamNotBetween(String value1, String value2) {
            addCriterion("platformNam not between", value1, value2, "platformnam");
            return (Criteria) this;
        }

        public Criteria andClassifyshoIsNull() {
            addCriterion("classifySho is null");
            return (Criteria) this;
        }

        public Criteria andClassifyshoIsNotNull() {
            addCriterion("classifySho is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyshoEqualTo(String value) {
            addCriterion("classifySho =", value, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoNotEqualTo(String value) {
            addCriterion("classifySho <>", value, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoGreaterThan(String value) {
            addCriterion("classifySho >", value, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoGreaterThanOrEqualTo(String value) {
            addCriterion("classifySho >=", value, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoLessThan(String value) {
            addCriterion("classifySho <", value, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoLessThanOrEqualTo(String value) {
            addCriterion("classifySho <=", value, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoLike(String value) {
            addCriterion("classifySho like", value, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoNotLike(String value) {
            addCriterion("classifySho not like", value, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoIn(List<String> values) {
            addCriterion("classifySho in", values, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoNotIn(List<String> values) {
            addCriterion("classifySho not in", values, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoBetween(String value1, String value2) {
            addCriterion("classifySho between", value1, value2, "classifysho");
            return (Criteria) this;
        }

        public Criteria andClassifyshoNotBetween(String value1, String value2) {
            addCriterion("classifySho not between", value1, value2, "classifysho");
            return (Criteria) this;
        }

        public Criteria andTradeshowIsNull() {
            addCriterion("tradeShow is null");
            return (Criteria) this;
        }

        public Criteria andTradeshowIsNotNull() {
            addCriterion("tradeShow is not null");
            return (Criteria) this;
        }

        public Criteria andTradeshowEqualTo(String value) {
            addCriterion("tradeShow =", value, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowNotEqualTo(String value) {
            addCriterion("tradeShow <>", value, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowGreaterThan(String value) {
            addCriterion("tradeShow >", value, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowGreaterThanOrEqualTo(String value) {
            addCriterion("tradeShow >=", value, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowLessThan(String value) {
            addCriterion("tradeShow <", value, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowLessThanOrEqualTo(String value) {
            addCriterion("tradeShow <=", value, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowLike(String value) {
            addCriterion("tradeShow like", value, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowNotLike(String value) {
            addCriterion("tradeShow not like", value, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowIn(List<String> values) {
            addCriterion("tradeShow in", values, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowNotIn(List<String> values) {
            addCriterion("tradeShow not in", values, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowBetween(String value1, String value2) {
            addCriterion("tradeShow between", value1, value2, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andTradeshowNotBetween(String value1, String value2) {
            addCriterion("tradeShow not between", value1, value2, "tradeshow");
            return (Criteria) this;
        }

        public Criteria andDistrictshoIsNull() {
            addCriterion("districtSho is null");
            return (Criteria) this;
        }

        public Criteria andDistrictshoIsNotNull() {
            addCriterion("districtSho is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictshoEqualTo(String value) {
            addCriterion("districtSho =", value, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoNotEqualTo(String value) {
            addCriterion("districtSho <>", value, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoGreaterThan(String value) {
            addCriterion("districtSho >", value, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoGreaterThanOrEqualTo(String value) {
            addCriterion("districtSho >=", value, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoLessThan(String value) {
            addCriterion("districtSho <", value, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoLessThanOrEqualTo(String value) {
            addCriterion("districtSho <=", value, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoLike(String value) {
            addCriterion("districtSho like", value, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoNotLike(String value) {
            addCriterion("districtSho not like", value, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoIn(List<String> values) {
            addCriterion("districtSho in", values, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoNotIn(List<String> values) {
            addCriterion("districtSho not in", values, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoBetween(String value1, String value2) {
            addCriterion("districtSho between", value1, value2, "districtsho");
            return (Criteria) this;
        }

        public Criteria andDistrictshoNotBetween(String value1, String value2) {
            addCriterion("districtSho not between", value1, value2, "districtsho");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andStageshowIsNull() {
            addCriterion("stageShow is null");
            return (Criteria) this;
        }

        public Criteria andStageshowIsNotNull() {
            addCriterion("stageShow is not null");
            return (Criteria) this;
        }

        public Criteria andStageshowEqualTo(String value) {
            addCriterion("stageShow =", value, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowNotEqualTo(String value) {
            addCriterion("stageShow <>", value, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowGreaterThan(String value) {
            addCriterion("stageShow >", value, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowGreaterThanOrEqualTo(String value) {
            addCriterion("stageShow >=", value, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowLessThan(String value) {
            addCriterion("stageShow <", value, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowLessThanOrEqualTo(String value) {
            addCriterion("stageShow <=", value, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowLike(String value) {
            addCriterion("stageShow like", value, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowNotLike(String value) {
            addCriterion("stageShow not like", value, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowIn(List<String> values) {
            addCriterion("stageShow in", values, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowNotIn(List<String> values) {
            addCriterion("stageShow not in", values, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowBetween(String value1, String value2) {
            addCriterion("stageShow between", value1, value2, "stageshow");
            return (Criteria) this;
        }

        public Criteria andStageshowNotBetween(String value1, String value2) {
            addCriterion("stageShow not between", value1, value2, "stageshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowIsNull() {
            addCriterion("titleShow is null");
            return (Criteria) this;
        }

        public Criteria andTitleshowIsNotNull() {
            addCriterion("titleShow is not null");
            return (Criteria) this;
        }

        public Criteria andTitleshowEqualTo(String value) {
            addCriterion("titleShow =", value, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowNotEqualTo(String value) {
            addCriterion("titleShow <>", value, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowGreaterThan(String value) {
            addCriterion("titleShow >", value, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowGreaterThanOrEqualTo(String value) {
            addCriterion("titleShow >=", value, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowLessThan(String value) {
            addCriterion("titleShow <", value, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowLessThanOrEqualTo(String value) {
            addCriterion("titleShow <=", value, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowLike(String value) {
            addCriterion("titleShow like", value, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowNotLike(String value) {
            addCriterion("titleShow not like", value, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowIn(List<String> values) {
            addCriterion("titleShow in", values, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowNotIn(List<String> values) {
            addCriterion("titleShow not in", values, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowBetween(String value1, String value2) {
            addCriterion("titleShow between", value1, value2, "titleshow");
            return (Criteria) this;
        }

        public Criteria andTitleshowNotBetween(String value1, String value2) {
            addCriterion("titleShow not between", value1, value2, "titleshow");
            return (Criteria) this;
        }

        public Criteria andHashcodeIsNull() {
            addCriterion("hashcode is null");
            return (Criteria) this;
        }

        public Criteria andHashcodeIsNotNull() {
            addCriterion("hashcode is not null");
            return (Criteria) this;
        }

        public Criteria andHashcodeEqualTo(String value) {
            addCriterion("hashcode =", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeNotEqualTo(String value) {
            addCriterion("hashcode <>", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeGreaterThan(String value) {
            addCriterion("hashcode >", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeGreaterThanOrEqualTo(String value) {
            addCriterion("hashcode >=", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeLessThan(String value) {
            addCriterion("hashcode <", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeLessThanOrEqualTo(String value) {
            addCriterion("hashcode <=", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeLike(String value) {
            addCriterion("hashcode like", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeNotLike(String value) {
            addCriterion("hashcode not like", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeIn(List<String> values) {
            addCriterion("hashcode in", values, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeNotIn(List<String> values) {
            addCriterion("hashcode not in", values, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeBetween(String value1, String value2) {
            addCriterion("hashcode between", value1, value2, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeNotBetween(String value1, String value2) {
            addCriterion("hashcode not between", value1, value2, "hashcode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}