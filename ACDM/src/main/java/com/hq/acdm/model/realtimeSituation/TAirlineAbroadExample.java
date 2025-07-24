package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.List;

public class TAirlineAbroadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAirlineAbroadExample() {
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

        public Criteria andTwoCharCdIsNull() {
            addCriterion("TWO_CHAR_CD is null");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdIsNotNull() {
            addCriterion("TWO_CHAR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdEqualTo(String value) {
            addCriterion("TWO_CHAR_CD =", value, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdNotEqualTo(String value) {
            addCriterion("TWO_CHAR_CD <>", value, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdGreaterThan(String value) {
            addCriterion("TWO_CHAR_CD >", value, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdGreaterThanOrEqualTo(String value) {
            addCriterion("TWO_CHAR_CD >=", value, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdLessThan(String value) {
            addCriterion("TWO_CHAR_CD <", value, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdLessThanOrEqualTo(String value) {
            addCriterion("TWO_CHAR_CD <=", value, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdLike(String value) {
            addCriterion("TWO_CHAR_CD like", value, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdNotLike(String value) {
            addCriterion("TWO_CHAR_CD not like", value, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdIn(List<String> values) {
            addCriterion("TWO_CHAR_CD in", values, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdNotIn(List<String> values) {
            addCriterion("TWO_CHAR_CD not in", values, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdBetween(String value1, String value2) {
            addCriterion("TWO_CHAR_CD between", value1, value2, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andTwoCharCdNotBetween(String value1, String value2) {
            addCriterion("TWO_CHAR_CD not between", value1, value2, "twoCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdIsNull() {
            addCriterion("THREE_CHAR_CD is null");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdIsNotNull() {
            addCriterion("THREE_CHAR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdEqualTo(String value) {
            addCriterion("THREE_CHAR_CD =", value, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdNotEqualTo(String value) {
            addCriterion("THREE_CHAR_CD <>", value, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdGreaterThan(String value) {
            addCriterion("THREE_CHAR_CD >", value, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdGreaterThanOrEqualTo(String value) {
            addCriterion("THREE_CHAR_CD >=", value, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdLessThan(String value) {
            addCriterion("THREE_CHAR_CD <", value, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdLessThanOrEqualTo(String value) {
            addCriterion("THREE_CHAR_CD <=", value, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdLike(String value) {
            addCriterion("THREE_CHAR_CD like", value, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdNotLike(String value) {
            addCriterion("THREE_CHAR_CD not like", value, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdIn(List<String> values) {
            addCriterion("THREE_CHAR_CD in", values, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdNotIn(List<String> values) {
            addCriterion("THREE_CHAR_CD not in", values, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdBetween(String value1, String value2) {
            addCriterion("THREE_CHAR_CD between", value1, value2, "threeCharCd");
            return (Criteria) this;
        }

        public Criteria andThreeCharCdNotBetween(String value1, String value2) {
            addCriterion("THREE_CHAR_CD not between", value1, value2, "threeCharCd");
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