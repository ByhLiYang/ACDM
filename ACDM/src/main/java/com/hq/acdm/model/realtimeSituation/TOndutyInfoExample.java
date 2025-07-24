package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TOndutyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOndutyInfoExample() {
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

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("ORG_ID like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("ORG_ID not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("ORG_NAME =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("ORG_NAME <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("ORG_NAME >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_NAME >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("ORG_NAME <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("ORG_NAME <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("ORG_NAME like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("ORG_NAME not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("ORG_NAME in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("ORG_NAME not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("ORG_NAME between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("ORG_NAME not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdIsNull() {
            addCriterion("ONDUTY_EMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdIsNotNull() {
            addCriterion("ONDUTY_EMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdEqualTo(String value) {
            addCriterion("ONDUTY_EMP_ID =", value, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdNotEqualTo(String value) {
            addCriterion("ONDUTY_EMP_ID <>", value, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdGreaterThan(String value) {
            addCriterion("ONDUTY_EMP_ID >", value, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("ONDUTY_EMP_ID >=", value, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdLessThan(String value) {
            addCriterion("ONDUTY_EMP_ID <", value, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdLessThanOrEqualTo(String value) {
            addCriterion("ONDUTY_EMP_ID <=", value, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdLike(String value) {
            addCriterion("ONDUTY_EMP_ID like", value, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdNotLike(String value) {
            addCriterion("ONDUTY_EMP_ID not like", value, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdIn(List<String> values) {
            addCriterion("ONDUTY_EMP_ID in", values, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdNotIn(List<String> values) {
            addCriterion("ONDUTY_EMP_ID not in", values, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdBetween(String value1, String value2) {
            addCriterion("ONDUTY_EMP_ID between", value1, value2, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIdNotBetween(String value1, String value2) {
            addCriterion("ONDUTY_EMP_ID not between", value1, value2, "ondutyEmpId");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIsNull() {
            addCriterion("ONDUTY_EMP is null");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIsNotNull() {
            addCriterion("ONDUTY_EMP is not null");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpEqualTo(String value) {
            addCriterion("ONDUTY_EMP =", value, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpNotEqualTo(String value) {
            addCriterion("ONDUTY_EMP <>", value, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpGreaterThan(String value) {
            addCriterion("ONDUTY_EMP >", value, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpGreaterThanOrEqualTo(String value) {
            addCriterion("ONDUTY_EMP >=", value, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpLessThan(String value) {
            addCriterion("ONDUTY_EMP <", value, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpLessThanOrEqualTo(String value) {
            addCriterion("ONDUTY_EMP <=", value, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpLike(String value) {
            addCriterion("ONDUTY_EMP like", value, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpNotLike(String value) {
            addCriterion("ONDUTY_EMP not like", value, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpIn(List<String> values) {
            addCriterion("ONDUTY_EMP in", values, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpNotIn(List<String> values) {
            addCriterion("ONDUTY_EMP not in", values, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpBetween(String value1, String value2) {
            addCriterion("ONDUTY_EMP between", value1, value2, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andOndutyEmpNotBetween(String value1, String value2) {
            addCriterion("ONDUTY_EMP not between", value1, value2, "ondutyEmp");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("TEL is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("TEL is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("TEL =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("TEL <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("TEL >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("TEL >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("TEL <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("TEL <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("TEL like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("TEL not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("TEL in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("TEL not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("TEL between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("TEL not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("MOBILE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("MOBILE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("MOBILE_PHONE =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("MOBILE_PHONE <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("MOBILE_PHONE >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE_PHONE >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("MOBILE_PHONE <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("MOBILE_PHONE <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("MOBILE_PHONE like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("MOBILE_PHONE not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("MOBILE_PHONE in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("MOBILE_PHONE not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("MOBILE_PHONE between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("MOBILE_PHONE not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeIsNull() {
            addCriterion("ONDUTY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeIsNotNull() {
            addCriterion("ONDUTY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ONDUTY_TIME =", value, "ondutyTime");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ONDUTY_TIME <>", value, "ondutyTime");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ONDUTY_TIME >", value, "ondutyTime");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ONDUTY_TIME >=", value, "ondutyTime");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeLessThan(Date value) {
            addCriterionForJDBCDate("ONDUTY_TIME <", value, "ondutyTime");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ONDUTY_TIME <=", value, "ondutyTime");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ONDUTY_TIME in", values, "ondutyTime");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ONDUTY_TIME not in", values, "ondutyTime");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ONDUTY_TIME between", value1, value2, "ondutyTime");
            return (Criteria) this;
        }

        public Criteria andOndutyTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ONDUTY_TIME not between", value1, value2, "ondutyTime");
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