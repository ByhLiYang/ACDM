package com.hq.acdm.model.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAreaStandToAtcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAreaStandToAtcExample() {
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

        public Criteria andStandIsNull() {
            addCriterion("STAND is null");
            return (Criteria) this;
        }

        public Criteria andStandIsNotNull() {
            addCriterion("STAND is not null");
            return (Criteria) this;
        }

        public Criteria andStandEqualTo(String value) {
            addCriterion("STAND =", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotEqualTo(String value) {
            addCriterion("STAND <>", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandGreaterThan(String value) {
            addCriterion("STAND >", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandGreaterThanOrEqualTo(String value) {
            addCriterion("STAND >=", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandLessThan(String value) {
            addCriterion("STAND <", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandLessThanOrEqualTo(String value) {
            addCriterion("STAND <=", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandLike(String value) {
            addCriterion("STAND like", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotLike(String value) {
            addCriterion("STAND not like", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandIn(List<String> values) {
            addCriterion("STAND in", values, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotIn(List<String> values) {
            addCriterion("STAND not in", values, "stand");
            return (Criteria) this;
        }

        public Criteria andStandBetween(String value1, String value2) {
            addCriterion("STAND between", value1, value2, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotBetween(String value1, String value2) {
            addCriterion("STAND not between", value1, value2, "stand");
            return (Criteria) this;
        }

        public Criteria andLonIsNull() {
            addCriterion("LON is null");
            return (Criteria) this;
        }

        public Criteria andLonIsNotNull() {
            addCriterion("LON is not null");
            return (Criteria) this;
        }

        public Criteria andLonEqualTo(String value) {
            addCriterion("LON =", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotEqualTo(String value) {
            addCriterion("LON <>", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThan(String value) {
            addCriterion("LON >", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThanOrEqualTo(String value) {
            addCriterion("LON >=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThan(String value) {
            addCriterion("LON <", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThanOrEqualTo(String value) {
            addCriterion("LON <=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLike(String value) {
            addCriterion("LON like", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotLike(String value) {
            addCriterion("LON not like", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonIn(List<String> values) {
            addCriterion("LON in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotIn(List<String> values) {
            addCriterion("LON not in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonBetween(String value1, String value2) {
            addCriterion("LON between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotBetween(String value1, String value2) {
            addCriterion("LON not between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("LAT is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("LAT is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("LAT =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("LAT <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("LAT >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("LAT >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("LAT <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("LAT <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("LAT like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("LAT not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("LAT in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("LAT not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("LAT between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("LAT not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andIsremoteIsNull() {
            addCriterion("ISREMOTE is null");
            return (Criteria) this;
        }

        public Criteria andIsremoteIsNotNull() {
            addCriterion("ISREMOTE is not null");
            return (Criteria) this;
        }

        public Criteria andIsremoteEqualTo(String value) {
            addCriterion("ISREMOTE =", value, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteNotEqualTo(String value) {
            addCriterion("ISREMOTE <>", value, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteGreaterThan(String value) {
            addCriterion("ISREMOTE >", value, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteGreaterThanOrEqualTo(String value) {
            addCriterion("ISREMOTE >=", value, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteLessThan(String value) {
            addCriterion("ISREMOTE <", value, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteLessThanOrEqualTo(String value) {
            addCriterion("ISREMOTE <=", value, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteLike(String value) {
            addCriterion("ISREMOTE like", value, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteNotLike(String value) {
            addCriterion("ISREMOTE not like", value, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteIn(List<String> values) {
            addCriterion("ISREMOTE in", values, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteNotIn(List<String> values) {
            addCriterion("ISREMOTE not in", values, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteBetween(String value1, String value2) {
            addCriterion("ISREMOTE between", value1, value2, "isremote");
            return (Criteria) this;
        }

        public Criteria andIsremoteNotBetween(String value1, String value2) {
            addCriterion("ISREMOTE not between", value1, value2, "isremote");
            return (Criteria) this;
        }

        public Criteria andMaxtypeIsNull() {
            addCriterion("MAXTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMaxtypeIsNotNull() {
            addCriterion("MAXTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMaxtypeEqualTo(String value) {
            addCriterion("MAXTYPE =", value, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeNotEqualTo(String value) {
            addCriterion("MAXTYPE <>", value, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeGreaterThan(String value) {
            addCriterion("MAXTYPE >", value, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeGreaterThanOrEqualTo(String value) {
            addCriterion("MAXTYPE >=", value, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeLessThan(String value) {
            addCriterion("MAXTYPE <", value, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeLessThanOrEqualTo(String value) {
            addCriterion("MAXTYPE <=", value, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeLike(String value) {
            addCriterion("MAXTYPE like", value, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeNotLike(String value) {
            addCriterion("MAXTYPE not like", value, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeIn(List<String> values) {
            addCriterion("MAXTYPE in", values, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeNotIn(List<String> values) {
            addCriterion("MAXTYPE not in", values, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeBetween(String value1, String value2) {
            addCriterion("MAXTYPE between", value1, value2, "maxtype");
            return (Criteria) this;
        }

        public Criteria andMaxtypeNotBetween(String value1, String value2) {
            addCriterion("MAXTYPE not between", value1, value2, "maxtype");
            return (Criteria) this;
        }

        public Criteria andInternationalIsNull() {
            addCriterion("INTERNATIONAL is null");
            return (Criteria) this;
        }

        public Criteria andInternationalIsNotNull() {
            addCriterion("INTERNATIONAL is not null");
            return (Criteria) this;
        }

        public Criteria andInternationalEqualTo(String value) {
            addCriterion("INTERNATIONAL =", value, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalNotEqualTo(String value) {
            addCriterion("INTERNATIONAL <>", value, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalGreaterThan(String value) {
            addCriterion("INTERNATIONAL >", value, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalGreaterThanOrEqualTo(String value) {
            addCriterion("INTERNATIONAL >=", value, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalLessThan(String value) {
            addCriterion("INTERNATIONAL <", value, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalLessThanOrEqualTo(String value) {
            addCriterion("INTERNATIONAL <=", value, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalLike(String value) {
            addCriterion("INTERNATIONAL like", value, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalNotLike(String value) {
            addCriterion("INTERNATIONAL not like", value, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalIn(List<String> values) {
            addCriterion("INTERNATIONAL in", values, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalNotIn(List<String> values) {
            addCriterion("INTERNATIONAL not in", values, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalBetween(String value1, String value2) {
            addCriterion("INTERNATIONAL between", value1, value2, "international");
            return (Criteria) this;
        }

        public Criteria andInternationalNotBetween(String value1, String value2) {
            addCriterion("INTERNATIONAL not between", value1, value2, "international");
            return (Criteria) this;
        }

        public Criteria andBelongterminalIsNull() {
            addCriterion("BELONGTERMINAL is null");
            return (Criteria) this;
        }

        public Criteria andBelongterminalIsNotNull() {
            addCriterion("BELONGTERMINAL is not null");
            return (Criteria) this;
        }

        public Criteria andBelongterminalEqualTo(String value) {
            addCriterion("BELONGTERMINAL =", value, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalNotEqualTo(String value) {
            addCriterion("BELONGTERMINAL <>", value, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalGreaterThan(String value) {
            addCriterion("BELONGTERMINAL >", value, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalGreaterThanOrEqualTo(String value) {
            addCriterion("BELONGTERMINAL >=", value, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalLessThan(String value) {
            addCriterion("BELONGTERMINAL <", value, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalLessThanOrEqualTo(String value) {
            addCriterion("BELONGTERMINAL <=", value, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalLike(String value) {
            addCriterion("BELONGTERMINAL like", value, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalNotLike(String value) {
            addCriterion("BELONGTERMINAL not like", value, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalIn(List<String> values) {
            addCriterion("BELONGTERMINAL in", values, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalNotIn(List<String> values) {
            addCriterion("BELONGTERMINAL not in", values, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalBetween(String value1, String value2) {
            addCriterion("BELONGTERMINAL between", value1, value2, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andBelongterminalNotBetween(String value1, String value2) {
            addCriterion("BELONGTERMINAL not between", value1, value2, "belongterminal");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeIsNull() {
            addCriterion("NOSERVICETIME is null");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeIsNotNull() {
            addCriterion("NOSERVICETIME is not null");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeEqualTo(Date value) {
            addCriterion("NOSERVICETIME =", value, "noservicetime");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeNotEqualTo(Date value) {
            addCriterion("NOSERVICETIME <>", value, "noservicetime");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeGreaterThan(Date value) {
            addCriterion("NOSERVICETIME >", value, "noservicetime");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("NOSERVICETIME >=", value, "noservicetime");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeLessThan(Date value) {
            addCriterion("NOSERVICETIME <", value, "noservicetime");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeLessThanOrEqualTo(Date value) {
            addCriterion("NOSERVICETIME <=", value, "noservicetime");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeIn(List<Date> values) {
            addCriterion("NOSERVICETIME in", values, "noservicetime");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeNotIn(List<Date> values) {
            addCriterion("NOSERVICETIME not in", values, "noservicetime");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeBetween(Date value1, Date value2) {
            addCriterion("NOSERVICETIME between", value1, value2, "noservicetime");
            return (Criteria) this;
        }

        public Criteria andNoservicetimeNotBetween(Date value1, Date value2) {
            addCriterion("NOSERVICETIME not between", value1, value2, "noservicetime");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeIsNull() {
            addCriterion("RESUMESERVICETIME is null");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeIsNotNull() {
            addCriterion("RESUMESERVICETIME is not null");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeEqualTo(Date value) {
            addCriterion("RESUMESERVICETIME =", value, "resumeservicetime");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeNotEqualTo(Date value) {
            addCriterion("RESUMESERVICETIME <>", value, "resumeservicetime");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeGreaterThan(Date value) {
            addCriterion("RESUMESERVICETIME >", value, "resumeservicetime");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RESUMESERVICETIME >=", value, "resumeservicetime");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeLessThan(Date value) {
            addCriterion("RESUMESERVICETIME <", value, "resumeservicetime");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeLessThanOrEqualTo(Date value) {
            addCriterion("RESUMESERVICETIME <=", value, "resumeservicetime");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeIn(List<Date> values) {
            addCriterion("RESUMESERVICETIME in", values, "resumeservicetime");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeNotIn(List<Date> values) {
            addCriterion("RESUMESERVICETIME not in", values, "resumeservicetime");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeBetween(Date value1, Date value2) {
            addCriterion("RESUMESERVICETIME between", value1, value2, "resumeservicetime");
            return (Criteria) this;
        }

        public Criteria andResumeservicetimeNotBetween(Date value1, Date value2) {
            addCriterion("RESUMESERVICETIME not between", value1, value2, "resumeservicetime");
            return (Criteria) this;
        }

        public Criteria andPowersupplyIsNull() {
            addCriterion("POWERSUPPLY is null");
            return (Criteria) this;
        }

        public Criteria andPowersupplyIsNotNull() {
            addCriterion("POWERSUPPLY is not null");
            return (Criteria) this;
        }

        public Criteria andPowersupplyEqualTo(String value) {
            addCriterion("POWERSUPPLY =", value, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyNotEqualTo(String value) {
            addCriterion("POWERSUPPLY <>", value, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyGreaterThan(String value) {
            addCriterion("POWERSUPPLY >", value, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyGreaterThanOrEqualTo(String value) {
            addCriterion("POWERSUPPLY >=", value, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyLessThan(String value) {
            addCriterion("POWERSUPPLY <", value, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyLessThanOrEqualTo(String value) {
            addCriterion("POWERSUPPLY <=", value, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyLike(String value) {
            addCriterion("POWERSUPPLY like", value, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyNotLike(String value) {
            addCriterion("POWERSUPPLY not like", value, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyIn(List<String> values) {
            addCriterion("POWERSUPPLY in", values, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyNotIn(List<String> values) {
            addCriterion("POWERSUPPLY not in", values, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyBetween(String value1, String value2) {
            addCriterion("POWERSUPPLY between", value1, value2, "powersupply");
            return (Criteria) this;
        }

        public Criteria andPowersupplyNotBetween(String value1, String value2) {
            addCriterion("POWERSUPPLY not between", value1, value2, "powersupply");
            return (Criteria) this;
        }

        public Criteria andBornegassourceIsNull() {
            addCriterion("BORNEGASSOURCE is null");
            return (Criteria) this;
        }

        public Criteria andBornegassourceIsNotNull() {
            addCriterion("BORNEGASSOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andBornegassourceEqualTo(String value) {
            addCriterion("BORNEGASSOURCE =", value, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceNotEqualTo(String value) {
            addCriterion("BORNEGASSOURCE <>", value, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceGreaterThan(String value) {
            addCriterion("BORNEGASSOURCE >", value, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceGreaterThanOrEqualTo(String value) {
            addCriterion("BORNEGASSOURCE >=", value, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceLessThan(String value) {
            addCriterion("BORNEGASSOURCE <", value, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceLessThanOrEqualTo(String value) {
            addCriterion("BORNEGASSOURCE <=", value, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceLike(String value) {
            addCriterion("BORNEGASSOURCE like", value, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceNotLike(String value) {
            addCriterion("BORNEGASSOURCE not like", value, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceIn(List<String> values) {
            addCriterion("BORNEGASSOURCE in", values, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceNotIn(List<String> values) {
            addCriterion("BORNEGASSOURCE not in", values, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceBetween(String value1, String value2) {
            addCriterion("BORNEGASSOURCE between", value1, value2, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andBornegassourceNotBetween(String value1, String value2) {
            addCriterion("BORNEGASSOURCE not between", value1, value2, "bornegassource");
            return (Criteria) this;
        }

        public Criteria andConditionerIsNull() {
            addCriterion("CONDITIONER is null");
            return (Criteria) this;
        }

        public Criteria andConditionerIsNotNull() {
            addCriterion("CONDITIONER is not null");
            return (Criteria) this;
        }

        public Criteria andConditionerEqualTo(String value) {
            addCriterion("CONDITIONER =", value, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerNotEqualTo(String value) {
            addCriterion("CONDITIONER <>", value, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerGreaterThan(String value) {
            addCriterion("CONDITIONER >", value, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerGreaterThanOrEqualTo(String value) {
            addCriterion("CONDITIONER >=", value, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerLessThan(String value) {
            addCriterion("CONDITIONER <", value, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerLessThanOrEqualTo(String value) {
            addCriterion("CONDITIONER <=", value, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerLike(String value) {
            addCriterion("CONDITIONER like", value, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerNotLike(String value) {
            addCriterion("CONDITIONER not like", value, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerIn(List<String> values) {
            addCriterion("CONDITIONER in", values, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerNotIn(List<String> values) {
            addCriterion("CONDITIONER not in", values, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerBetween(String value1, String value2) {
            addCriterion("CONDITIONER between", value1, value2, "conditioner");
            return (Criteria) this;
        }

        public Criteria andConditionerNotBetween(String value1, String value2) {
            addCriterion("CONDITIONER not between", value1, value2, "conditioner");
            return (Criteria) this;
        }

        public Criteria andIsolationstandIsNull() {
            addCriterion("ISOLATIONSTAND is null");
            return (Criteria) this;
        }

        public Criteria andIsolationstandIsNotNull() {
            addCriterion("ISOLATIONSTAND is not null");
            return (Criteria) this;
        }

        public Criteria andIsolationstandEqualTo(String value) {
            addCriterion("ISOLATIONSTAND =", value, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandNotEqualTo(String value) {
            addCriterion("ISOLATIONSTAND <>", value, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandGreaterThan(String value) {
            addCriterion("ISOLATIONSTAND >", value, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandGreaterThanOrEqualTo(String value) {
            addCriterion("ISOLATIONSTAND >=", value, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandLessThan(String value) {
            addCriterion("ISOLATIONSTAND <", value, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandLessThanOrEqualTo(String value) {
            addCriterion("ISOLATIONSTAND <=", value, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandLike(String value) {
            addCriterion("ISOLATIONSTAND like", value, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandNotLike(String value) {
            addCriterion("ISOLATIONSTAND not like", value, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandIn(List<String> values) {
            addCriterion("ISOLATIONSTAND in", values, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandNotIn(List<String> values) {
            addCriterion("ISOLATIONSTAND not in", values, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandBetween(String value1, String value2) {
            addCriterion("ISOLATIONSTAND between", value1, value2, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsolationstandNotBetween(String value1, String value2) {
            addCriterion("ISOLATIONSTAND not between", value1, value2, "isolationstand");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("ISDELETE is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("ISDELETE is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(String value) {
            addCriterion("ISDELETE =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(String value) {
            addCriterion("ISDELETE <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(String value) {
            addCriterion("ISDELETE >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(String value) {
            addCriterion("ISDELETE >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(String value) {
            addCriterion("ISDELETE <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(String value) {
            addCriterion("ISDELETE <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLike(String value) {
            addCriterion("ISDELETE like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotLike(String value) {
            addCriterion("ISDELETE not like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<String> values) {
            addCriterion("ISDELETE in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<String> values) {
            addCriterion("ISDELETE not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(String value1, String value2) {
            addCriterion("ISDELETE between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(String value1, String value2) {
            addCriterion("ISDELETE not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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