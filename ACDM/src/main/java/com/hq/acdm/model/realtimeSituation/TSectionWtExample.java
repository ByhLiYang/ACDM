package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.List;

public class TSectionWtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSectionWtExample() {
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

        public Criteria andSectionIsNull() {
            addCriterion("SECTION is null");
            return (Criteria) this;
        }

        public Criteria andSectionIsNotNull() {
            addCriterion("SECTION is not null");
            return (Criteria) this;
        }

        public Criteria andSectionEqualTo(String value) {
            addCriterion("SECTION =", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotEqualTo(String value) {
            addCriterion("SECTION <>", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThan(String value) {
            addCriterion("SECTION >", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThanOrEqualTo(String value) {
            addCriterion("SECTION >=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThan(String value) {
            addCriterion("SECTION <", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThanOrEqualTo(String value) {
            addCriterion("SECTION <=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLike(String value) {
            addCriterion("SECTION like", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotLike(String value) {
            addCriterion("SECTION not like", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionIn(List<String> values) {
            addCriterion("SECTION in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotIn(List<String> values) {
            addCriterion("SECTION not in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionBetween(String value1, String value2) {
            addCriterion("SECTION between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotBetween(String value1, String value2) {
            addCriterion("SECTION not between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andVisbIsNull() {
            addCriterion("VISB is null");
            return (Criteria) this;
        }

        public Criteria andVisbIsNotNull() {
            addCriterion("VISB is not null");
            return (Criteria) this;
        }

        public Criteria andVisbEqualTo(String value) {
            addCriterion("VISB =", value, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbNotEqualTo(String value) {
            addCriterion("VISB <>", value, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbGreaterThan(String value) {
            addCriterion("VISB >", value, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbGreaterThanOrEqualTo(String value) {
            addCriterion("VISB >=", value, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbLessThan(String value) {
            addCriterion("VISB <", value, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbLessThanOrEqualTo(String value) {
            addCriterion("VISB <=", value, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbLike(String value) {
            addCriterion("VISB like", value, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbNotLike(String value) {
            addCriterion("VISB not like", value, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbIn(List<String> values) {
            addCriterion("VISB in", values, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbNotIn(List<String> values) {
            addCriterion("VISB not in", values, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbBetween(String value1, String value2) {
            addCriterion("VISB between", value1, value2, "visb");
            return (Criteria) this;
        }

        public Criteria andVisbNotBetween(String value1, String value2) {
            addCriterion("VISB not between", value1, value2, "visb");
            return (Criteria) this;
        }

        public Criteria andWspdIsNull() {
            addCriterion("WSPD is null");
            return (Criteria) this;
        }

        public Criteria andWspdIsNotNull() {
            addCriterion("WSPD is not null");
            return (Criteria) this;
        }

        public Criteria andWspdEqualTo(String value) {
            addCriterion("WSPD =", value, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdNotEqualTo(String value) {
            addCriterion("WSPD <>", value, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdGreaterThan(String value) {
            addCriterion("WSPD >", value, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdGreaterThanOrEqualTo(String value) {
            addCriterion("WSPD >=", value, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdLessThan(String value) {
            addCriterion("WSPD <", value, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdLessThanOrEqualTo(String value) {
            addCriterion("WSPD <=", value, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdLike(String value) {
            addCriterion("WSPD like", value, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdNotLike(String value) {
            addCriterion("WSPD not like", value, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdIn(List<String> values) {
            addCriterion("WSPD in", values, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdNotIn(List<String> values) {
            addCriterion("WSPD not in", values, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdBetween(String value1, String value2) {
            addCriterion("WSPD between", value1, value2, "wspd");
            return (Criteria) this;
        }

        public Criteria andWspdNotBetween(String value1, String value2) {
            addCriterion("WSPD not between", value1, value2, "wspd");
            return (Criteria) this;
        }

        public Criteria andWdrtIsNull() {
            addCriterion("WDRT is null");
            return (Criteria) this;
        }

        public Criteria andWdrtIsNotNull() {
            addCriterion("WDRT is not null");
            return (Criteria) this;
        }

        public Criteria andWdrtEqualTo(String value) {
            addCriterion("WDRT =", value, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtNotEqualTo(String value) {
            addCriterion("WDRT <>", value, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtGreaterThan(String value) {
            addCriterion("WDRT >", value, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtGreaterThanOrEqualTo(String value) {
            addCriterion("WDRT >=", value, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtLessThan(String value) {
            addCriterion("WDRT <", value, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtLessThanOrEqualTo(String value) {
            addCriterion("WDRT <=", value, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtLike(String value) {
            addCriterion("WDRT like", value, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtNotLike(String value) {
            addCriterion("WDRT not like", value, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtIn(List<String> values) {
            addCriterion("WDRT in", values, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtNotIn(List<String> values) {
            addCriterion("WDRT not in", values, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtBetween(String value1, String value2) {
            addCriterion("WDRT between", value1, value2, "wdrt");
            return (Criteria) this;
        }

        public Criteria andWdrtNotBetween(String value1, String value2) {
            addCriterion("WDRT not between", value1, value2, "wdrt");
            return (Criteria) this;
        }

        public Criteria andCbhtIsNull() {
            addCriterion("CBHT is null");
            return (Criteria) this;
        }

        public Criteria andCbhtIsNotNull() {
            addCriterion("CBHT is not null");
            return (Criteria) this;
        }

        public Criteria andCbhtEqualTo(String value) {
            addCriterion("CBHT =", value, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtNotEqualTo(String value) {
            addCriterion("CBHT <>", value, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtGreaterThan(String value) {
            addCriterion("CBHT >", value, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtGreaterThanOrEqualTo(String value) {
            addCriterion("CBHT >=", value, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtLessThan(String value) {
            addCriterion("CBHT <", value, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtLessThanOrEqualTo(String value) {
            addCriterion("CBHT <=", value, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtLike(String value) {
            addCriterion("CBHT like", value, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtNotLike(String value) {
            addCriterion("CBHT not like", value, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtIn(List<String> values) {
            addCriterion("CBHT in", values, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtNotIn(List<String> values) {
            addCriterion("CBHT not in", values, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtBetween(String value1, String value2) {
            addCriterion("CBHT between", value1, value2, "cbht");
            return (Criteria) this;
        }

        public Criteria andCbhtNotBetween(String value1, String value2) {
            addCriterion("CBHT not between", value1, value2, "cbht");
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