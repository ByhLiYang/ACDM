package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMdrsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMdrsExample() {
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

        public Criteria andIdentificationIsNull() {
            addCriterion("IDENTIFICATION is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationIsNotNull() {
            addCriterion("IDENTIFICATION is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationEqualTo(String value) {
            addCriterion("IDENTIFICATION =", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotEqualTo(String value) {
            addCriterion("IDENTIFICATION <>", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationGreaterThan(String value) {
            addCriterion("IDENTIFICATION >", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationGreaterThanOrEqualTo(String value) {
            addCriterion("IDENTIFICATION >=", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLessThan(String value) {
            addCriterion("IDENTIFICATION <", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLessThanOrEqualTo(String value) {
            addCriterion("IDENTIFICATION <=", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLike(String value) {
            addCriterion("IDENTIFICATION like", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotLike(String value) {
            addCriterion("IDENTIFICATION not like", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationIn(List<String> values) {
            addCriterion("IDENTIFICATION in", values, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotIn(List<String> values) {
            addCriterion("IDENTIFICATION not in", values, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationBetween(String value1, String value2) {
            addCriterion("IDENTIFICATION between", value1, value2, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotBetween(String value1, String value2) {
            addCriterion("IDENTIFICATION not between", value1, value2, "identification");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("AREA is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("AREA is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("AREA =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("AREA <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("AREA >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("AREA >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("AREA <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("AREA <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("AREA like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("AREA not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("AREA in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("AREA not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("AREA between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("AREA not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("LEVEL =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("LEVEL <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("LEVEL >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("LEVEL >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("LEVEL <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("LEVEL <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("LEVEL like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("LEVEL not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("LEVEL in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("LEVEL not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("LEVEL between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("LEVEL not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIsNull() {
            addCriterion("PUBLISHTIME is null");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIsNotNull() {
            addCriterion("PUBLISHTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPublishtimeEqualTo(Date value) {
            addCriterion("PUBLISHTIME =", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotEqualTo(Date value) {
            addCriterion("PUBLISHTIME <>", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThan(Date value) {
            addCriterion("PUBLISHTIME >", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PUBLISHTIME >=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThan(Date value) {
            addCriterion("PUBLISHTIME <", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThanOrEqualTo(Date value) {
            addCriterion("PUBLISHTIME <=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIn(List<Date> values) {
            addCriterion("PUBLISHTIME in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotIn(List<Date> values) {
            addCriterion("PUBLISHTIME not in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeBetween(Date value1, Date value2) {
            addCriterion("PUBLISHTIME between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotBetween(Date value1, Date value2) {
            addCriterion("PUBLISHTIME not between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceIsNull() {
            addCriterion("EXPECTINFLUENCE is null");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceIsNotNull() {
            addCriterion("EXPECTINFLUENCE is not null");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceEqualTo(String value) {
            addCriterion("EXPECTINFLUENCE =", value, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceNotEqualTo(String value) {
            addCriterion("EXPECTINFLUENCE <>", value, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceGreaterThan(String value) {
            addCriterion("EXPECTINFLUENCE >", value, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceGreaterThanOrEqualTo(String value) {
            addCriterion("EXPECTINFLUENCE >=", value, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceLessThan(String value) {
            addCriterion("EXPECTINFLUENCE <", value, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceLessThanOrEqualTo(String value) {
            addCriterion("EXPECTINFLUENCE <=", value, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceLike(String value) {
            addCriterion("EXPECTINFLUENCE like", value, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceNotLike(String value) {
            addCriterion("EXPECTINFLUENCE not like", value, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceIn(List<String> values) {
            addCriterion("EXPECTINFLUENCE in", values, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceNotIn(List<String> values) {
            addCriterion("EXPECTINFLUENCE not in", values, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceBetween(String value1, String value2) {
            addCriterion("EXPECTINFLUENCE between", value1, value2, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andExpectinfluenceNotBetween(String value1, String value2) {
            addCriterion("EXPECTINFLUENCE not between", value1, value2, "expectinfluence");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andTimescopeIsNull() {
            addCriterion("TIMESCOPE is null");
            return (Criteria) this;
        }

        public Criteria andTimescopeIsNotNull() {
            addCriterion("TIMESCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andTimescopeEqualTo(String value) {
            addCriterion("TIMESCOPE =", value, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeNotEqualTo(String value) {
            addCriterion("TIMESCOPE <>", value, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeGreaterThan(String value) {
            addCriterion("TIMESCOPE >", value, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeGreaterThanOrEqualTo(String value) {
            addCriterion("TIMESCOPE >=", value, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeLessThan(String value) {
            addCriterion("TIMESCOPE <", value, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeLessThanOrEqualTo(String value) {
            addCriterion("TIMESCOPE <=", value, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeLike(String value) {
            addCriterion("TIMESCOPE like", value, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeNotLike(String value) {
            addCriterion("TIMESCOPE not like", value, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeIn(List<String> values) {
            addCriterion("TIMESCOPE in", values, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeNotIn(List<String> values) {
            addCriterion("TIMESCOPE not in", values, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeBetween(String value1, String value2) {
            addCriterion("TIMESCOPE between", value1, value2, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeNotBetween(String value1, String value2) {
            addCriterion("TIMESCOPE not between", value1, value2, "timescope");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartIsNull() {
            addCriterion("TIMESCOPE_START is null");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartIsNotNull() {
            addCriterion("TIMESCOPE_START is not null");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartEqualTo(Date value) {
            addCriterion("TIMESCOPE_START =", value, "timescopeStart");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartNotEqualTo(Date value) {
            addCriterion("TIMESCOPE_START <>", value, "timescopeStart");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartGreaterThan(Date value) {
            addCriterion("TIMESCOPE_START >", value, "timescopeStart");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartGreaterThanOrEqualTo(Date value) {
            addCriterion("TIMESCOPE_START >=", value, "timescopeStart");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartLessThan(Date value) {
            addCriterion("TIMESCOPE_START <", value, "timescopeStart");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartLessThanOrEqualTo(Date value) {
            addCriterion("TIMESCOPE_START <=", value, "timescopeStart");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartIn(List<Date> values) {
            addCriterion("TIMESCOPE_START in", values, "timescopeStart");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartNotIn(List<Date> values) {
            addCriterion("TIMESCOPE_START not in", values, "timescopeStart");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartBetween(Date value1, Date value2) {
            addCriterion("TIMESCOPE_START between", value1, value2, "timescopeStart");
            return (Criteria) this;
        }

        public Criteria andTimescopeStartNotBetween(Date value1, Date value2) {
            addCriterion("TIMESCOPE_START not between", value1, value2, "timescopeStart");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndIsNull() {
            addCriterion("TIMESCOPE_END is null");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndIsNotNull() {
            addCriterion("TIMESCOPE_END is not null");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndEqualTo(Date value) {
            addCriterion("TIMESCOPE_END =", value, "timescopeEnd");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndNotEqualTo(Date value) {
            addCriterion("TIMESCOPE_END <>", value, "timescopeEnd");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndGreaterThan(Date value) {
            addCriterion("TIMESCOPE_END >", value, "timescopeEnd");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("TIMESCOPE_END >=", value, "timescopeEnd");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndLessThan(Date value) {
            addCriterion("TIMESCOPE_END <", value, "timescopeEnd");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndLessThanOrEqualTo(Date value) {
            addCriterion("TIMESCOPE_END <=", value, "timescopeEnd");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndIn(List<Date> values) {
            addCriterion("TIMESCOPE_END in", values, "timescopeEnd");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndNotIn(List<Date> values) {
            addCriterion("TIMESCOPE_END not in", values, "timescopeEnd");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndBetween(Date value1, Date value2) {
            addCriterion("TIMESCOPE_END between", value1, value2, "timescopeEnd");
            return (Criteria) this;
        }

        public Criteria andTimescopeEndNotBetween(Date value1, Date value2) {
            addCriterion("TIMESCOPE_END not between", value1, value2, "timescopeEnd");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNull() {
            addCriterion("ISDEL is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("ISDEL is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(Integer value) {
            addCriterion("ISDEL =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Integer value) {
            addCriterion("ISDEL <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Integer value) {
            addCriterion("ISDEL >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISDEL >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Integer value) {
            addCriterion("ISDEL <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Integer value) {
            addCriterion("ISDEL <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Integer> values) {
            addCriterion("ISDEL in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Integer> values) {
            addCriterion("ISDEL not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Integer value1, Integer value2) {
            addCriterion("ISDEL between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("ISDEL not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andStatussIsNull() {
            addCriterion("STATUSS is null");
            return (Criteria) this;
        }

        public Criteria andStatussIsNotNull() {
            addCriterion("STATUSS is not null");
            return (Criteria) this;
        }

        public Criteria andStatussEqualTo(String value) {
            addCriterion("STATUSS =", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotEqualTo(String value) {
            addCriterion("STATUSS <>", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussGreaterThan(String value) {
            addCriterion("STATUSS >", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussGreaterThanOrEqualTo(String value) {
            addCriterion("STATUSS >=", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussLessThan(String value) {
            addCriterion("STATUSS <", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussLessThanOrEqualTo(String value) {
            addCriterion("STATUSS <=", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussLike(String value) {
            addCriterion("STATUSS like", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotLike(String value) {
            addCriterion("STATUSS not like", value, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussIn(List<String> values) {
            addCriterion("STATUSS in", values, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotIn(List<String> values) {
            addCriterion("STATUSS not in", values, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussBetween(String value1, String value2) {
            addCriterion("STATUSS between", value1, value2, "statuss");
            return (Criteria) this;
        }

        public Criteria andStatussNotBetween(String value1, String value2) {
            addCriterion("STATUSS not between", value1, value2, "statuss");
            return (Criteria) this;
        }

        public Criteria andCreateTmIsNull() {
            addCriterion("CREATE_TM is null");
            return (Criteria) this;
        }

        public Criteria andCreateTmIsNotNull() {
            addCriterion("CREATE_TM is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTmEqualTo(Date value) {
            addCriterion("CREATE_TM =", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmNotEqualTo(Date value) {
            addCriterion("CREATE_TM <>", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmGreaterThan(Date value) {
            addCriterion("CREATE_TM >", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TM >=", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmLessThan(Date value) {
            addCriterion("CREATE_TM <", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TM <=", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmIn(List<Date> values) {
            addCriterion("CREATE_TM in", values, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmNotIn(List<Date> values) {
            addCriterion("CREATE_TM not in", values, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmBetween(Date value1, Date value2) {
            addCriterion("CREATE_TM between", value1, value2, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TM not between", value1, value2, "createTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmIsNull() {
            addCriterion("UPDATE_TM is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTmIsNotNull() {
            addCriterion("UPDATE_TM is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTmEqualTo(Date value) {
            addCriterion("UPDATE_TM =", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmNotEqualTo(Date value) {
            addCriterion("UPDATE_TM <>", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmGreaterThan(Date value) {
            addCriterion("UPDATE_TM >", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TM >=", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmLessThan(Date value) {
            addCriterion("UPDATE_TM <", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TM <=", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmIn(List<Date> values) {
            addCriterion("UPDATE_TM in", values, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmNotIn(List<Date> values) {
            addCriterion("UPDATE_TM not in", values, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TM between", value1, value2, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TM not between", value1, value2, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrIsNull() {
            addCriterion("UPDATE_USR is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrIsNotNull() {
            addCriterion("UPDATE_USR is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrEqualTo(String value) {
            addCriterion("UPDATE_USR =", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrNotEqualTo(String value) {
            addCriterion("UPDATE_USR <>", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrGreaterThan(String value) {
            addCriterion("UPDATE_USR >", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USR >=", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrLessThan(String value) {
            addCriterion("UPDATE_USR <", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USR <=", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrLike(String value) {
            addCriterion("UPDATE_USR like", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrNotLike(String value) {
            addCriterion("UPDATE_USR not like", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrIn(List<String> values) {
            addCriterion("UPDATE_USR in", values, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrNotIn(List<String> values) {
            addCriterion("UPDATE_USR not in", values, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrBetween(String value1, String value2) {
            addCriterion("UPDATE_USR between", value1, value2, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USR not between", value1, value2, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrIsNull() {
            addCriterion("CREATE_USR is null");
            return (Criteria) this;
        }

        public Criteria andCreateUsrIsNotNull() {
            addCriterion("CREATE_USR is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUsrEqualTo(String value) {
            addCriterion("CREATE_USR =", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrNotEqualTo(String value) {
            addCriterion("CREATE_USR <>", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrGreaterThan(String value) {
            addCriterion("CREATE_USR >", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USR >=", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrLessThan(String value) {
            addCriterion("CREATE_USR <", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USR <=", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrLike(String value) {
            addCriterion("CREATE_USR like", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrNotLike(String value) {
            addCriterion("CREATE_USR not like", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrIn(List<String> values) {
            addCriterion("CREATE_USR in", values, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrNotIn(List<String> values) {
            addCriterion("CREATE_USR not in", values, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrBetween(String value1, String value2) {
            addCriterion("CREATE_USR between", value1, value2, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrNotBetween(String value1, String value2) {
            addCriterion("CREATE_USR not between", value1, value2, "createUsr");
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