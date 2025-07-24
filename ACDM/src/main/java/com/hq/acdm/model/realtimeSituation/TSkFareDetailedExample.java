package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSkFareDetailedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSkFareDetailedExample() {
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

        public Criteria andFareTypeIsNull() {
            addCriterion("FARE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFareTypeIsNotNull() {
            addCriterion("FARE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFareTypeEqualTo(String value) {
            addCriterion("FARE_TYPE =", value, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeNotEqualTo(String value) {
            addCriterion("FARE_TYPE <>", value, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeGreaterThan(String value) {
            addCriterion("FARE_TYPE >", value, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FARE_TYPE >=", value, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeLessThan(String value) {
            addCriterion("FARE_TYPE <", value, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeLessThanOrEqualTo(String value) {
            addCriterion("FARE_TYPE <=", value, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeLike(String value) {
            addCriterion("FARE_TYPE like", value, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeNotLike(String value) {
            addCriterion("FARE_TYPE not like", value, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeIn(List<String> values) {
            addCriterion("FARE_TYPE in", values, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeNotIn(List<String> values) {
            addCriterion("FARE_TYPE not in", values, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeBetween(String value1, String value2) {
            addCriterion("FARE_TYPE between", value1, value2, "fareType");
            return (Criteria) this;
        }

        public Criteria andFareTypeNotBetween(String value1, String value2) {
            addCriterion("FARE_TYPE not between", value1, value2, "fareType");
            return (Criteria) this;
        }

        public Criteria andAdepIsNull() {
            addCriterion("ADEP is null");
            return (Criteria) this;
        }

        public Criteria andAdepIsNotNull() {
            addCriterion("ADEP is not null");
            return (Criteria) this;
        }

        public Criteria andAdepEqualTo(String value) {
            addCriterion("ADEP =", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepNotEqualTo(String value) {
            addCriterion("ADEP <>", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepGreaterThan(String value) {
            addCriterion("ADEP >", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepGreaterThanOrEqualTo(String value) {
            addCriterion("ADEP >=", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepLessThan(String value) {
            addCriterion("ADEP <", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepLessThanOrEqualTo(String value) {
            addCriterion("ADEP <=", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepLike(String value) {
            addCriterion("ADEP like", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepNotLike(String value) {
            addCriterion("ADEP not like", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepIn(List<String> values) {
            addCriterion("ADEP in", values, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepNotIn(List<String> values) {
            addCriterion("ADEP not in", values, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepBetween(String value1, String value2) {
            addCriterion("ADEP between", value1, value2, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepNotBetween(String value1, String value2) {
            addCriterion("ADEP not between", value1, value2, "adep");
            return (Criteria) this;
        }

        public Criteria andAdesIsNull() {
            addCriterion("ADES is null");
            return (Criteria) this;
        }

        public Criteria andAdesIsNotNull() {
            addCriterion("ADES is not null");
            return (Criteria) this;
        }

        public Criteria andAdesEqualTo(String value) {
            addCriterion("ADES =", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesNotEqualTo(String value) {
            addCriterion("ADES <>", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesGreaterThan(String value) {
            addCriterion("ADES >", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesGreaterThanOrEqualTo(String value) {
            addCriterion("ADES >=", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesLessThan(String value) {
            addCriterion("ADES <", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesLessThanOrEqualTo(String value) {
            addCriterion("ADES <=", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesLike(String value) {
            addCriterion("ADES like", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesNotLike(String value) {
            addCriterion("ADES not like", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesIn(List<String> values) {
            addCriterion("ADES in", values, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesNotIn(List<String> values) {
            addCriterion("ADES not in", values, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesBetween(String value1, String value2) {
            addCriterion("ADES between", value1, value2, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesNotBetween(String value1, String value2) {
            addCriterion("ADES not between", value1, value2, "ades");
            return (Criteria) this;
        }

        public Criteria andFareIsNull() {
            addCriterion("FARE is null");
            return (Criteria) this;
        }

        public Criteria andFareIsNotNull() {
            addCriterion("FARE is not null");
            return (Criteria) this;
        }

        public Criteria andFareEqualTo(Double value) {
            addCriterion("FARE =", value, "fare");
            return (Criteria) this;
        }

        public Criteria andFareNotEqualTo(Double value) {
            addCriterion("FARE <>", value, "fare");
            return (Criteria) this;
        }

        public Criteria andFareGreaterThan(Double value) {
            addCriterion("FARE >", value, "fare");
            return (Criteria) this;
        }

        public Criteria andFareGreaterThanOrEqualTo(Double value) {
            addCriterion("FARE >=", value, "fare");
            return (Criteria) this;
        }

        public Criteria andFareLessThan(Double value) {
            addCriterion("FARE <", value, "fare");
            return (Criteria) this;
        }

        public Criteria andFareLessThanOrEqualTo(Double value) {
            addCriterion("FARE <=", value, "fare");
            return (Criteria) this;
        }

        public Criteria andFareIn(List<Double> values) {
            addCriterion("FARE in", values, "fare");
            return (Criteria) this;
        }

        public Criteria andFareNotIn(List<Double> values) {
            addCriterion("FARE not in", values, "fare");
            return (Criteria) this;
        }

        public Criteria andFareBetween(Double value1, Double value2) {
            addCriterion("FARE between", value1, value2, "fare");
            return (Criteria) this;
        }

        public Criteria andFareNotBetween(Double value1, Double value2) {
            addCriterion("FARE not between", value1, value2, "fare");
            return (Criteria) this;
        }

        public Criteria andRmkIsNull() {
            addCriterion("RMK is null");
            return (Criteria) this;
        }

        public Criteria andRmkIsNotNull() {
            addCriterion("RMK is not null");
            return (Criteria) this;
        }

        public Criteria andRmkEqualTo(String value) {
            addCriterion("RMK =", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkNotEqualTo(String value) {
            addCriterion("RMK <>", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkGreaterThan(String value) {
            addCriterion("RMK >", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkGreaterThanOrEqualTo(String value) {
            addCriterion("RMK >=", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkLessThan(String value) {
            addCriterion("RMK <", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkLessThanOrEqualTo(String value) {
            addCriterion("RMK <=", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkLike(String value) {
            addCriterion("RMK like", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkNotLike(String value) {
            addCriterion("RMK not like", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkIn(List<String> values) {
            addCriterion("RMK in", values, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkNotIn(List<String> values) {
            addCriterion("RMK not in", values, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkBetween(String value1, String value2) {
            addCriterion("RMK between", value1, value2, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkNotBetween(String value1, String value2) {
            addCriterion("RMK not between", value1, value2, "rmk");
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

        public Criteria andCreateEmpIsNull() {
            addCriterion("CREATE_EMP is null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIsNotNull() {
            addCriterion("CREATE_EMP is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpEqualTo(String value) {
            addCriterion("CREATE_EMP =", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotEqualTo(String value) {
            addCriterion("CREATE_EMP <>", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpGreaterThan(String value) {
            addCriterion("CREATE_EMP >", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_EMP >=", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLessThan(String value) {
            addCriterion("CREATE_EMP <", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLessThanOrEqualTo(String value) {
            addCriterion("CREATE_EMP <=", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLike(String value) {
            addCriterion("CREATE_EMP like", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotLike(String value) {
            addCriterion("CREATE_EMP not like", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIn(List<String> values) {
            addCriterion("CREATE_EMP in", values, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotIn(List<String> values) {
            addCriterion("CREATE_EMP not in", values, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpBetween(String value1, String value2) {
            addCriterion("CREATE_EMP between", value1, value2, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotBetween(String value1, String value2) {
            addCriterion("CREATE_EMP not between", value1, value2, "createEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIsNull() {
            addCriterion("UPDATE_EMP is null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIsNotNull() {
            addCriterion("UPDATE_EMP is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpEqualTo(String value) {
            addCriterion("UPDATE_EMP =", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNotEqualTo(String value) {
            addCriterion("UPDATE_EMP <>", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpGreaterThan(String value) {
            addCriterion("UPDATE_EMP >", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_EMP >=", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpLessThan(String value) {
            addCriterion("UPDATE_EMP <", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_EMP <=", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpLike(String value) {
            addCriterion("UPDATE_EMP like", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNotLike(String value) {
            addCriterion("UPDATE_EMP not like", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIn(List<String> values) {
            addCriterion("UPDATE_EMP in", values, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNotIn(List<String> values) {
            addCriterion("UPDATE_EMP not in", values, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpBetween(String value1, String value2) {
            addCriterion("UPDATE_EMP between", value1, value2, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNotBetween(String value1, String value2) {
            addCriterion("UPDATE_EMP not between", value1, value2, "updateEmp");
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