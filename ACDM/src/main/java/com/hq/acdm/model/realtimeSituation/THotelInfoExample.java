package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class THotelInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public THotelInfoExample() {
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

        public Criteria andHotelRoomTypeIsNull() {
            addCriterion("HOTEL_ROOM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeIsNotNull() {
            addCriterion("HOTEL_ROOM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeEqualTo(String value) {
            addCriterion("HOTEL_ROOM_TYPE =", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeNotEqualTo(String value) {
            addCriterion("HOTEL_ROOM_TYPE <>", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeGreaterThan(String value) {
            addCriterion("HOTEL_ROOM_TYPE >", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("HOTEL_ROOM_TYPE >=", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeLessThan(String value) {
            addCriterion("HOTEL_ROOM_TYPE <", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeLessThanOrEqualTo(String value) {
            addCriterion("HOTEL_ROOM_TYPE <=", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeLike(String value) {
            addCriterion("HOTEL_ROOM_TYPE like", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeNotLike(String value) {
            addCriterion("HOTEL_ROOM_TYPE not like", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeIn(List<String> values) {
            addCriterion("HOTEL_ROOM_TYPE in", values, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeNotIn(List<String> values) {
            addCriterion("HOTEL_ROOM_TYPE not in", values, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeBetween(String value1, String value2) {
            addCriterion("HOTEL_ROOM_TYPE between", value1, value2, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeNotBetween(String value1, String value2) {
            addCriterion("HOTEL_ROOM_TYPE not between", value1, value2, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumIsNull() {
            addCriterion("HOTEL_ROOM_NUM is null");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumIsNotNull() {
            addCriterion("HOTEL_ROOM_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumEqualTo(Long value) {
            addCriterion("HOTEL_ROOM_NUM =", value, "hotelRoomNum");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumNotEqualTo(Long value) {
            addCriterion("HOTEL_ROOM_NUM <>", value, "hotelRoomNum");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumGreaterThan(Long value) {
            addCriterion("HOTEL_ROOM_NUM >", value, "hotelRoomNum");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumGreaterThanOrEqualTo(Long value) {
            addCriterion("HOTEL_ROOM_NUM >=", value, "hotelRoomNum");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumLessThan(Long value) {
            addCriterion("HOTEL_ROOM_NUM <", value, "hotelRoomNum");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumLessThanOrEqualTo(Long value) {
            addCriterion("HOTEL_ROOM_NUM <=", value, "hotelRoomNum");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumIn(List<Long> values) {
            addCriterion("HOTEL_ROOM_NUM in", values, "hotelRoomNum");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumNotIn(List<Long> values) {
            addCriterion("HOTEL_ROOM_NUM not in", values, "hotelRoomNum");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumBetween(Long value1, Long value2) {
            addCriterion("HOTEL_ROOM_NUM between", value1, value2, "hotelRoomNum");
            return (Criteria) this;
        }

        public Criteria andHotelRoomNumNotBetween(Long value1, Long value2) {
            addCriterion("HOTEL_ROOM_NUM not between", value1, value2, "hotelRoomNum");
            return (Criteria) this;
        }

        public Criteria andHotelPriceIsNull() {
            addCriterion("HOTEL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andHotelPriceIsNotNull() {
            addCriterion("HOTEL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPriceEqualTo(Long value) {
            addCriterion("HOTEL_PRICE =", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotEqualTo(Long value) {
            addCriterion("HOTEL_PRICE <>", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceGreaterThan(Long value) {
            addCriterion("HOTEL_PRICE >", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("HOTEL_PRICE >=", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceLessThan(Long value) {
            addCriterion("HOTEL_PRICE <", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceLessThanOrEqualTo(Long value) {
            addCriterion("HOTEL_PRICE <=", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceIn(List<Long> values) {
            addCriterion("HOTEL_PRICE in", values, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotIn(List<Long> values) {
            addCriterion("HOTEL_PRICE not in", values, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceBetween(Long value1, Long value2) {
            addCriterion("HOTEL_PRICE between", value1, value2, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotBetween(Long value1, Long value2) {
            addCriterion("HOTEL_PRICE not between", value1, value2, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumIsNull() {
            addCriterion("HOTEL_PEOPLE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumIsNotNull() {
            addCriterion("HOTEL_PEOPLE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumEqualTo(Long value) {
            addCriterion("HOTEL_PEOPLE_NUM =", value, "hotelPeopleNum");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumNotEqualTo(Long value) {
            addCriterion("HOTEL_PEOPLE_NUM <>", value, "hotelPeopleNum");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumGreaterThan(Long value) {
            addCriterion("HOTEL_PEOPLE_NUM >", value, "hotelPeopleNum");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumGreaterThanOrEqualTo(Long value) {
            addCriterion("HOTEL_PEOPLE_NUM >=", value, "hotelPeopleNum");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumLessThan(Long value) {
            addCriterion("HOTEL_PEOPLE_NUM <", value, "hotelPeopleNum");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumLessThanOrEqualTo(Long value) {
            addCriterion("HOTEL_PEOPLE_NUM <=", value, "hotelPeopleNum");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumIn(List<Long> values) {
            addCriterion("HOTEL_PEOPLE_NUM in", values, "hotelPeopleNum");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumNotIn(List<Long> values) {
            addCriterion("HOTEL_PEOPLE_NUM not in", values, "hotelPeopleNum");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumBetween(Long value1, Long value2) {
            addCriterion("HOTEL_PEOPLE_NUM between", value1, value2, "hotelPeopleNum");
            return (Criteria) this;
        }

        public Criteria andHotelPeopleNumNotBetween(Long value1, Long value2) {
            addCriterion("HOTEL_PEOPLE_NUM not between", value1, value2, "hotelPeopleNum");
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