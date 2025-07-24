package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TIgoHotelStandardFeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TIgoHotelStandardFeeExample() {
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

        public Criteria andHotelNameIsNull() {
            addCriterion("HOTEL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNotNull() {
            addCriterion("HOTEL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEqualTo(String value) {
            addCriterion("HOTEL_NAME =", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotEqualTo(String value) {
            addCriterion("HOTEL_NAME <>", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThan(String value) {
            addCriterion("HOTEL_NAME >", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("HOTEL_NAME >=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThan(String value) {
            addCriterion("HOTEL_NAME <", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThanOrEqualTo(String value) {
            addCriterion("HOTEL_NAME <=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLike(String value) {
            addCriterion("HOTEL_NAME like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotLike(String value) {
            addCriterion("HOTEL_NAME not like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIn(List<String> values) {
            addCriterion("HOTEL_NAME in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotIn(List<String> values) {
            addCriterion("HOTEL_NAME not in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameBetween(String value1, String value2) {
            addCriterion("HOTEL_NAME between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotBetween(String value1, String value2) {
            addCriterion("HOTEL_NAME not between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelAddresIsNull() {
            addCriterion("HOTEL_ADDRES is null");
            return (Criteria) this;
        }

        public Criteria andHotelAddresIsNotNull() {
            addCriterion("HOTEL_ADDRES is not null");
            return (Criteria) this;
        }

        public Criteria andHotelAddresEqualTo(String value) {
            addCriterion("HOTEL_ADDRES =", value, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresNotEqualTo(String value) {
            addCriterion("HOTEL_ADDRES <>", value, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresGreaterThan(String value) {
            addCriterion("HOTEL_ADDRES >", value, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresGreaterThanOrEqualTo(String value) {
            addCriterion("HOTEL_ADDRES >=", value, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresLessThan(String value) {
            addCriterion("HOTEL_ADDRES <", value, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresLessThanOrEqualTo(String value) {
            addCriterion("HOTEL_ADDRES <=", value, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresLike(String value) {
            addCriterion("HOTEL_ADDRES like", value, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresNotLike(String value) {
            addCriterion("HOTEL_ADDRES not like", value, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresIn(List<String> values) {
            addCriterion("HOTEL_ADDRES in", values, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresNotIn(List<String> values) {
            addCriterion("HOTEL_ADDRES not in", values, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresBetween(String value1, String value2) {
            addCriterion("HOTEL_ADDRES between", value1, value2, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelAddresNotBetween(String value1, String value2) {
            addCriterion("HOTEL_ADDRES not between", value1, value2, "hotelAddres");
            return (Criteria) this;
        }

        public Criteria andHotelTelIsNull() {
            addCriterion("HOTEL_TEL is null");
            return (Criteria) this;
        }

        public Criteria andHotelTelIsNotNull() {
            addCriterion("HOTEL_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andHotelTelEqualTo(String value) {
            addCriterion("HOTEL_TEL =", value, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelNotEqualTo(String value) {
            addCriterion("HOTEL_TEL <>", value, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelGreaterThan(String value) {
            addCriterion("HOTEL_TEL >", value, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelGreaterThanOrEqualTo(String value) {
            addCriterion("HOTEL_TEL >=", value, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelLessThan(String value) {
            addCriterion("HOTEL_TEL <", value, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelLessThanOrEqualTo(String value) {
            addCriterion("HOTEL_TEL <=", value, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelLike(String value) {
            addCriterion("HOTEL_TEL like", value, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelNotLike(String value) {
            addCriterion("HOTEL_TEL not like", value, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelIn(List<String> values) {
            addCriterion("HOTEL_TEL in", values, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelNotIn(List<String> values) {
            addCriterion("HOTEL_TEL not in", values, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelBetween(String value1, String value2) {
            addCriterion("HOTEL_TEL between", value1, value2, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelTelNotBetween(String value1, String value2) {
            addCriterion("HOTEL_TEL not between", value1, value2, "hotelTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelIsNull() {
            addCriterion("HOTEL_MANAGER_TEL is null");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelIsNotNull() {
            addCriterion("HOTEL_MANAGER_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelEqualTo(String value) {
            addCriterion("HOTEL_MANAGER_TEL =", value, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelNotEqualTo(String value) {
            addCriterion("HOTEL_MANAGER_TEL <>", value, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelGreaterThan(String value) {
            addCriterion("HOTEL_MANAGER_TEL >", value, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelGreaterThanOrEqualTo(String value) {
            addCriterion("HOTEL_MANAGER_TEL >=", value, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelLessThan(String value) {
            addCriterion("HOTEL_MANAGER_TEL <", value, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelLessThanOrEqualTo(String value) {
            addCriterion("HOTEL_MANAGER_TEL <=", value, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelLike(String value) {
            addCriterion("HOTEL_MANAGER_TEL like", value, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelNotLike(String value) {
            addCriterion("HOTEL_MANAGER_TEL not like", value, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelIn(List<String> values) {
            addCriterion("HOTEL_MANAGER_TEL in", values, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelNotIn(List<String> values) {
            addCriterion("HOTEL_MANAGER_TEL not in", values, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelBetween(String value1, String value2) {
            addCriterion("HOTEL_MANAGER_TEL between", value1, value2, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andHotelManagerTelNotBetween(String value1, String value2) {
            addCriterion("HOTEL_MANAGER_TEL not between", value1, value2, "hotelManagerTel");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBIsNull() {
            addCriterion("NAME_OF_PARTY_B is null");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBIsNotNull() {
            addCriterion("NAME_OF_PARTY_B is not null");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBEqualTo(String value) {
            addCriterion("NAME_OF_PARTY_B =", value, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBNotEqualTo(String value) {
            addCriterion("NAME_OF_PARTY_B <>", value, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBGreaterThan(String value) {
            addCriterion("NAME_OF_PARTY_B >", value, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_OF_PARTY_B >=", value, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBLessThan(String value) {
            addCriterion("NAME_OF_PARTY_B <", value, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBLessThanOrEqualTo(String value) {
            addCriterion("NAME_OF_PARTY_B <=", value, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBLike(String value) {
            addCriterion("NAME_OF_PARTY_B like", value, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBNotLike(String value) {
            addCriterion("NAME_OF_PARTY_B not like", value, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBIn(List<String> values) {
            addCriterion("NAME_OF_PARTY_B in", values, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBNotIn(List<String> values) {
            addCriterion("NAME_OF_PARTY_B not in", values, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBBetween(String value1, String value2) {
            addCriterion("NAME_OF_PARTY_B between", value1, value2, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andNameOfPartyBNotBetween(String value1, String value2) {
            addCriterion("NAME_OF_PARTY_B not between", value1, value2, "nameOfPartyB");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateIsNull() {
            addCriterion("AGREEMENT_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateIsNotNull() {
            addCriterion("AGREEMENT_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("AGREEMENT_START_DATE =", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("AGREEMENT_START_DATE <>", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("AGREEMENT_START_DATE >", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AGREEMENT_START_DATE >=", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateLessThan(Date value) {
            addCriterionForJDBCDate("AGREEMENT_START_DATE <", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AGREEMENT_START_DATE <=", value, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("AGREEMENT_START_DATE in", values, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("AGREEMENT_START_DATE not in", values, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AGREEMENT_START_DATE between", value1, value2, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AGREEMENT_START_DATE not between", value1, value2, "agreementStartDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateIsNull() {
            addCriterion("AGREEMENT_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateIsNotNull() {
            addCriterion("AGREEMENT_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("AGREEMENT_END_DATE =", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("AGREEMENT_END_DATE <>", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("AGREEMENT_END_DATE >", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AGREEMENT_END_DATE >=", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateLessThan(Date value) {
            addCriterionForJDBCDate("AGREEMENT_END_DATE <", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AGREEMENT_END_DATE <=", value, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("AGREEMENT_END_DATE in", values, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("AGREEMENT_END_DATE not in", values, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AGREEMENT_END_DATE between", value1, value2, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andAgreementEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AGREEMENT_END_DATE not between", value1, value2, "agreementEndDate");
            return (Criteria) this;
        }

        public Criteria andBedIsNull() {
            addCriterion("BED is null");
            return (Criteria) this;
        }

        public Criteria andBedIsNotNull() {
            addCriterion("BED is not null");
            return (Criteria) this;
        }

        public Criteria andBedEqualTo(Double value) {
            addCriterion("BED =", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotEqualTo(Double value) {
            addCriterion("BED <>", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedGreaterThan(Double value) {
            addCriterion("BED >", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedGreaterThanOrEqualTo(Double value) {
            addCriterion("BED >=", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedLessThan(Double value) {
            addCriterion("BED <", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedLessThanOrEqualTo(Double value) {
            addCriterion("BED <=", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedIn(List<Double> values) {
            addCriterion("BED in", values, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotIn(List<Double> values) {
            addCriterion("BED not in", values, "bed");
            return (Criteria) this;
        }

        public Criteria andBedBetween(Double value1, Double value2) {
            addCriterion("BED between", value1, value2, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotBetween(Double value1, Double value2) {
            addCriterion("BED not between", value1, value2, "bed");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastIsNull() {
            addCriterion("HOME_BREAKFAST is null");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastIsNotNull() {
            addCriterion("HOME_BREAKFAST is not null");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastEqualTo(Double value) {
            addCriterion("HOME_BREAKFAST =", value, "homeBreakfast");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastNotEqualTo(Double value) {
            addCriterion("HOME_BREAKFAST <>", value, "homeBreakfast");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastGreaterThan(Double value) {
            addCriterion("HOME_BREAKFAST >", value, "homeBreakfast");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastGreaterThanOrEqualTo(Double value) {
            addCriterion("HOME_BREAKFAST >=", value, "homeBreakfast");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastLessThan(Double value) {
            addCriterion("HOME_BREAKFAST <", value, "homeBreakfast");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastLessThanOrEqualTo(Double value) {
            addCriterion("HOME_BREAKFAST <=", value, "homeBreakfast");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastIn(List<Double> values) {
            addCriterion("HOME_BREAKFAST in", values, "homeBreakfast");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastNotIn(List<Double> values) {
            addCriterion("HOME_BREAKFAST not in", values, "homeBreakfast");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastBetween(Double value1, Double value2) {
            addCriterion("HOME_BREAKFAST between", value1, value2, "homeBreakfast");
            return (Criteria) this;
        }

        public Criteria andHomeBreakfastNotBetween(Double value1, Double value2) {
            addCriterion("HOME_BREAKFAST not between", value1, value2, "homeBreakfast");
            return (Criteria) this;
        }

        public Criteria andHomeLunchIsNull() {
            addCriterion("HOME_LUNCH is null");
            return (Criteria) this;
        }

        public Criteria andHomeLunchIsNotNull() {
            addCriterion("HOME_LUNCH is not null");
            return (Criteria) this;
        }

        public Criteria andHomeLunchEqualTo(Double value) {
            addCriterion("HOME_LUNCH =", value, "homeLunch");
            return (Criteria) this;
        }

        public Criteria andHomeLunchNotEqualTo(Double value) {
            addCriterion("HOME_LUNCH <>", value, "homeLunch");
            return (Criteria) this;
        }

        public Criteria andHomeLunchGreaterThan(Double value) {
            addCriterion("HOME_LUNCH >", value, "homeLunch");
            return (Criteria) this;
        }

        public Criteria andHomeLunchGreaterThanOrEqualTo(Double value) {
            addCriterion("HOME_LUNCH >=", value, "homeLunch");
            return (Criteria) this;
        }

        public Criteria andHomeLunchLessThan(Double value) {
            addCriterion("HOME_LUNCH <", value, "homeLunch");
            return (Criteria) this;
        }

        public Criteria andHomeLunchLessThanOrEqualTo(Double value) {
            addCriterion("HOME_LUNCH <=", value, "homeLunch");
            return (Criteria) this;
        }

        public Criteria andHomeLunchIn(List<Double> values) {
            addCriterion("HOME_LUNCH in", values, "homeLunch");
            return (Criteria) this;
        }

        public Criteria andHomeLunchNotIn(List<Double> values) {
            addCriterion("HOME_LUNCH not in", values, "homeLunch");
            return (Criteria) this;
        }

        public Criteria andHomeLunchBetween(Double value1, Double value2) {
            addCriterion("HOME_LUNCH between", value1, value2, "homeLunch");
            return (Criteria) this;
        }

        public Criteria andHomeLunchNotBetween(Double value1, Double value2) {
            addCriterion("HOME_LUNCH not between", value1, value2, "homeLunch");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerIsNull() {
            addCriterion("HOME_DINNER is null");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerIsNotNull() {
            addCriterion("HOME_DINNER is not null");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerEqualTo(Double value) {
            addCriterion("HOME_DINNER =", value, "homeDinner");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerNotEqualTo(Double value) {
            addCriterion("HOME_DINNER <>", value, "homeDinner");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerGreaterThan(Double value) {
            addCriterion("HOME_DINNER >", value, "homeDinner");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerGreaterThanOrEqualTo(Double value) {
            addCriterion("HOME_DINNER >=", value, "homeDinner");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerLessThan(Double value) {
            addCriterion("HOME_DINNER <", value, "homeDinner");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerLessThanOrEqualTo(Double value) {
            addCriterion("HOME_DINNER <=", value, "homeDinner");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerIn(List<Double> values) {
            addCriterion("HOME_DINNER in", values, "homeDinner");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerNotIn(List<Double> values) {
            addCriterion("HOME_DINNER not in", values, "homeDinner");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerBetween(Double value1, Double value2) {
            addCriterion("HOME_DINNER between", value1, value2, "homeDinner");
            return (Criteria) this;
        }

        public Criteria andHomeDinnerNotBetween(Double value1, Double value2) {
            addCriterion("HOME_DINNER not between", value1, value2, "homeDinner");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastIsNull() {
            addCriterion("INTERNATIONAL_BREAKFAST is null");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastIsNotNull() {
            addCriterion("INTERNATIONAL_BREAKFAST is not null");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastEqualTo(Double value) {
            addCriterion("INTERNATIONAL_BREAKFAST =", value, "internationalBreakfast");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastNotEqualTo(Double value) {
            addCriterion("INTERNATIONAL_BREAKFAST <>", value, "internationalBreakfast");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastGreaterThan(Double value) {
            addCriterion("INTERNATIONAL_BREAKFAST >", value, "internationalBreakfast");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastGreaterThanOrEqualTo(Double value) {
            addCriterion("INTERNATIONAL_BREAKFAST >=", value, "internationalBreakfast");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastLessThan(Double value) {
            addCriterion("INTERNATIONAL_BREAKFAST <", value, "internationalBreakfast");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastLessThanOrEqualTo(Double value) {
            addCriterion("INTERNATIONAL_BREAKFAST <=", value, "internationalBreakfast");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastIn(List<Double> values) {
            addCriterion("INTERNATIONAL_BREAKFAST in", values, "internationalBreakfast");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastNotIn(List<Double> values) {
            addCriterion("INTERNATIONAL_BREAKFAST not in", values, "internationalBreakfast");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastBetween(Double value1, Double value2) {
            addCriterion("INTERNATIONAL_BREAKFAST between", value1, value2, "internationalBreakfast");
            return (Criteria) this;
        }

        public Criteria andInternationalBreakfastNotBetween(Double value1, Double value2) {
            addCriterion("INTERNATIONAL_BREAKFAST not between", value1, value2, "internationalBreakfast");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchIsNull() {
            addCriterion("INTERNATIONAL_LUNCH is null");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchIsNotNull() {
            addCriterion("INTERNATIONAL_LUNCH is not null");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchEqualTo(Double value) {
            addCriterion("INTERNATIONAL_LUNCH =", value, "internationalLunch");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchNotEqualTo(Double value) {
            addCriterion("INTERNATIONAL_LUNCH <>", value, "internationalLunch");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchGreaterThan(Double value) {
            addCriterion("INTERNATIONAL_LUNCH >", value, "internationalLunch");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchGreaterThanOrEqualTo(Double value) {
            addCriterion("INTERNATIONAL_LUNCH >=", value, "internationalLunch");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchLessThan(Double value) {
            addCriterion("INTERNATIONAL_LUNCH <", value, "internationalLunch");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchLessThanOrEqualTo(Double value) {
            addCriterion("INTERNATIONAL_LUNCH <=", value, "internationalLunch");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchIn(List<Double> values) {
            addCriterion("INTERNATIONAL_LUNCH in", values, "internationalLunch");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchNotIn(List<Double> values) {
            addCriterion("INTERNATIONAL_LUNCH not in", values, "internationalLunch");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchBetween(Double value1, Double value2) {
            addCriterion("INTERNATIONAL_LUNCH between", value1, value2, "internationalLunch");
            return (Criteria) this;
        }

        public Criteria andInternationalLunchNotBetween(Double value1, Double value2) {
            addCriterion("INTERNATIONAL_LUNCH not between", value1, value2, "internationalLunch");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerIsNull() {
            addCriterion("INTERNATIONAL_DINNER is null");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerIsNotNull() {
            addCriterion("INTERNATIONAL_DINNER is not null");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerEqualTo(Double value) {
            addCriterion("INTERNATIONAL_DINNER =", value, "internationalDinner");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerNotEqualTo(Double value) {
            addCriterion("INTERNATIONAL_DINNER <>", value, "internationalDinner");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerGreaterThan(Double value) {
            addCriterion("INTERNATIONAL_DINNER >", value, "internationalDinner");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerGreaterThanOrEqualTo(Double value) {
            addCriterion("INTERNATIONAL_DINNER >=", value, "internationalDinner");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerLessThan(Double value) {
            addCriterion("INTERNATIONAL_DINNER <", value, "internationalDinner");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerLessThanOrEqualTo(Double value) {
            addCriterion("INTERNATIONAL_DINNER <=", value, "internationalDinner");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerIn(List<Double> values) {
            addCriterion("INTERNATIONAL_DINNER in", values, "internationalDinner");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerNotIn(List<Double> values) {
            addCriterion("INTERNATIONAL_DINNER not in", values, "internationalDinner");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerBetween(Double value1, Double value2) {
            addCriterion("INTERNATIONAL_DINNER between", value1, value2, "internationalDinner");
            return (Criteria) this;
        }

        public Criteria andInternationalDinnerNotBetween(Double value1, Double value2) {
            addCriterion("INTERNATIONAL_DINNER not between", value1, value2, "internationalDinner");
            return (Criteria) this;
        }

        public Criteria andNightSnackIsNull() {
            addCriterion("NIGHT_SNACK is null");
            return (Criteria) this;
        }

        public Criteria andNightSnackIsNotNull() {
            addCriterion("NIGHT_SNACK is not null");
            return (Criteria) this;
        }

        public Criteria andNightSnackEqualTo(Double value) {
            addCriterion("NIGHT_SNACK =", value, "nightSnack");
            return (Criteria) this;
        }

        public Criteria andNightSnackNotEqualTo(Double value) {
            addCriterion("NIGHT_SNACK <>", value, "nightSnack");
            return (Criteria) this;
        }

        public Criteria andNightSnackGreaterThan(Double value) {
            addCriterion("NIGHT_SNACK >", value, "nightSnack");
            return (Criteria) this;
        }

        public Criteria andNightSnackGreaterThanOrEqualTo(Double value) {
            addCriterion("NIGHT_SNACK >=", value, "nightSnack");
            return (Criteria) this;
        }

        public Criteria andNightSnackLessThan(Double value) {
            addCriterion("NIGHT_SNACK <", value, "nightSnack");
            return (Criteria) this;
        }

        public Criteria andNightSnackLessThanOrEqualTo(Double value) {
            addCriterion("NIGHT_SNACK <=", value, "nightSnack");
            return (Criteria) this;
        }

        public Criteria andNightSnackIn(List<Double> values) {
            addCriterion("NIGHT_SNACK in", values, "nightSnack");
            return (Criteria) this;
        }

        public Criteria andNightSnackNotIn(List<Double> values) {
            addCriterion("NIGHT_SNACK not in", values, "nightSnack");
            return (Criteria) this;
        }

        public Criteria andNightSnackBetween(Double value1, Double value2) {
            addCriterion("NIGHT_SNACK between", value1, value2, "nightSnack");
            return (Criteria) this;
        }

        public Criteria andNightSnackNotBetween(Double value1, Double value2) {
            addCriterion("NIGHT_SNACK not between", value1, value2, "nightSnack");
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