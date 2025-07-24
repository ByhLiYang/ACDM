package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAirportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAirportExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAirportIataIsNull() {
            addCriterion("AIRPORT_IATA is null");
            return (Criteria) this;
        }

        public Criteria andAirportIataIsNotNull() {
            addCriterion("AIRPORT_IATA is not null");
            return (Criteria) this;
        }

        public Criteria andAirportIataEqualTo(String value) {
            addCriterion("AIRPORT_IATA =", value, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataNotEqualTo(String value) {
            addCriterion("AIRPORT_IATA <>", value, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataGreaterThan(String value) {
            addCriterion("AIRPORT_IATA >", value, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataGreaterThanOrEqualTo(String value) {
            addCriterion("AIRPORT_IATA >=", value, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataLessThan(String value) {
            addCriterion("AIRPORT_IATA <", value, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataLessThanOrEqualTo(String value) {
            addCriterion("AIRPORT_IATA <=", value, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataLike(String value) {
            addCriterion("AIRPORT_IATA like", value, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataNotLike(String value) {
            addCriterion("AIRPORT_IATA not like", value, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataIn(List<String> values) {
            addCriterion("AIRPORT_IATA in", values, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataNotIn(List<String> values) {
            addCriterion("AIRPORT_IATA not in", values, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataBetween(String value1, String value2) {
            addCriterion("AIRPORT_IATA between", value1, value2, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIataNotBetween(String value1, String value2) {
            addCriterion("AIRPORT_IATA not between", value1, value2, "airportIata");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoIsNull() {
            addCriterion("AIRPORT_ICAO is null");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoIsNotNull() {
            addCriterion("AIRPORT_ICAO is not null");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoEqualTo(String value) {
            addCriterion("AIRPORT_ICAO =", value, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoNotEqualTo(String value) {
            addCriterion("AIRPORT_ICAO <>", value, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoGreaterThan(String value) {
            addCriterion("AIRPORT_ICAO >", value, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoGreaterThanOrEqualTo(String value) {
            addCriterion("AIRPORT_ICAO >=", value, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoLessThan(String value) {
            addCriterion("AIRPORT_ICAO <", value, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoLessThanOrEqualTo(String value) {
            addCriterion("AIRPORT_ICAO <=", value, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoLike(String value) {
            addCriterion("AIRPORT_ICAO like", value, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoNotLike(String value) {
            addCriterion("AIRPORT_ICAO not like", value, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoIn(List<String> values) {
            addCriterion("AIRPORT_ICAO in", values, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoNotIn(List<String> values) {
            addCriterion("AIRPORT_ICAO not in", values, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoBetween(String value1, String value2) {
            addCriterion("AIRPORT_ICAO between", value1, value2, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAirportIcaoNotBetween(String value1, String value2) {
            addCriterion("AIRPORT_ICAO not between", value1, value2, "airportIcao");
            return (Criteria) this;
        }

        public Criteria andAttributeIsNull() {
            addCriterion("ATTRIBUTE is null");
            return (Criteria) this;
        }

        public Criteria andAttributeIsNotNull() {
            addCriterion("ATTRIBUTE is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeEqualTo(String value) {
            addCriterion("ATTRIBUTE =", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotEqualTo(String value) {
            addCriterion("ATTRIBUTE <>", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeGreaterThan(String value) {
            addCriterion("ATTRIBUTE >", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeGreaterThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE >=", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLessThan(String value) {
            addCriterion("ATTRIBUTE <", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLessThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE <=", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLike(String value) {
            addCriterion("ATTRIBUTE like", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotLike(String value) {
            addCriterion("ATTRIBUTE not like", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeIn(List<String> values) {
            addCriterion("ATTRIBUTE in", values, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotIn(List<String> values) {
            addCriterion("ATTRIBUTE not in", values, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE between", value1, value2, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE not between", value1, value2, "attribute");
            return (Criteria) this;
        }

        public Criteria andChineseNameIsNull() {
            addCriterion("CHINESE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andChineseNameIsNotNull() {
            addCriterion("CHINESE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andChineseNameEqualTo(String value) {
            addCriterion("CHINESE_NAME =", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotEqualTo(String value) {
            addCriterion("CHINESE_NAME <>", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameGreaterThan(String value) {
            addCriterion("CHINESE_NAME >", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHINESE_NAME >=", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLessThan(String value) {
            addCriterion("CHINESE_NAME <", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLessThanOrEqualTo(String value) {
            addCriterion("CHINESE_NAME <=", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLike(String value) {
            addCriterion("CHINESE_NAME like", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotLike(String value) {
            addCriterion("CHINESE_NAME not like", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameIn(List<String> values) {
            addCriterion("CHINESE_NAME in", values, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotIn(List<String> values) {
            addCriterion("CHINESE_NAME not in", values, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameBetween(String value1, String value2) {
            addCriterion("CHINESE_NAME between", value1, value2, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotBetween(String value1, String value2) {
            addCriterion("CHINESE_NAME not between", value1, value2, "chineseName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNull() {
            addCriterion("ENGLISH_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNotNull() {
            addCriterion("ENGLISH_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameEqualTo(String value) {
            addCriterion("ENGLISH_NAME =", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotEqualTo(String value) {
            addCriterion("ENGLISH_NAME <>", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThan(String value) {
            addCriterion("ENGLISH_NAME >", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENGLISH_NAME >=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThan(String value) {
            addCriterion("ENGLISH_NAME <", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("ENGLISH_NAME <=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLike(String value) {
            addCriterion("ENGLISH_NAME like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotLike(String value) {
            addCriterion("ENGLISH_NAME not like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIn(List<String> values) {
            addCriterion("ENGLISH_NAME in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotIn(List<String> values) {
            addCriterion("ENGLISH_NAME not in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameBetween(String value1, String value2) {
            addCriterion("ENGLISH_NAME between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotBetween(String value1, String value2) {
            addCriterion("ENGLISH_NAME not between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNull() {
            addCriterion("IS_OPEN is null");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNotNull() {
            addCriterion("IS_OPEN is not null");
            return (Criteria) this;
        }

        public Criteria andIsOpenEqualTo(String value) {
            addCriterion("IS_OPEN =", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotEqualTo(String value) {
            addCriterion("IS_OPEN <>", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThan(String value) {
            addCriterion("IS_OPEN >", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThanOrEqualTo(String value) {
            addCriterion("IS_OPEN >=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThan(String value) {
            addCriterion("IS_OPEN <", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThanOrEqualTo(String value) {
            addCriterion("IS_OPEN <=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLike(String value) {
            addCriterion("IS_OPEN like", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotLike(String value) {
            addCriterion("IS_OPEN not like", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenIn(List<String> values) {
            addCriterion("IS_OPEN in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotIn(List<String> values) {
            addCriterion("IS_OPEN not in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenBetween(String value1, String value2) {
            addCriterion("IS_OPEN between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotBetween(String value1, String value2) {
            addCriterion("IS_OPEN not between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("SHORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("SHORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("SHORT_NAME =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("SHORT_NAME <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("SHORT_NAME >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("SHORT_NAME >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("SHORT_NAME <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("SHORT_NAME <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("SHORT_NAME like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("SHORT_NAME not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("SHORT_NAME in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("SHORT_NAME not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("SHORT_NAME between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("SHORT_NAME not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("IS_DELETE is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("IS_DELETE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("IS_DELETE =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("IS_DELETE <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("IS_DELETE >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_DELETE >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("IS_DELETE <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("IS_DELETE <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("IS_DELETE in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("IS_DELETE not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("IS_DELETE between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_DELETE not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andInCityIsNull() {
            addCriterion("IN_CITY is null");
            return (Criteria) this;
        }

        public Criteria andInCityIsNotNull() {
            addCriterion("IN_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andInCityEqualTo(String value) {
            addCriterion("IN_CITY =", value, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityNotEqualTo(String value) {
            addCriterion("IN_CITY <>", value, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityGreaterThan(String value) {
            addCriterion("IN_CITY >", value, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityGreaterThanOrEqualTo(String value) {
            addCriterion("IN_CITY >=", value, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityLessThan(String value) {
            addCriterion("IN_CITY <", value, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityLessThanOrEqualTo(String value) {
            addCriterion("IN_CITY <=", value, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityLike(String value) {
            addCriterion("IN_CITY like", value, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityNotLike(String value) {
            addCriterion("IN_CITY not like", value, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityIn(List<String> values) {
            addCriterion("IN_CITY in", values, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityNotIn(List<String> values) {
            addCriterion("IN_CITY not in", values, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityBetween(String value1, String value2) {
            addCriterion("IN_CITY between", value1, value2, "inCity");
            return (Criteria) this;
        }

        public Criteria andInCityNotBetween(String value1, String value2) {
            addCriterion("IN_CITY not between", value1, value2, "inCity");
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