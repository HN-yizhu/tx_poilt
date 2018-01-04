package com.poilt.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserAliasIsNull() {
            addCriterion("user_alias is null");
            return (Criteria) this;
        }

        public Criteria andUserAliasIsNotNull() {
            addCriterion("user_alias is not null");
            return (Criteria) this;
        }

        public Criteria andUserAliasEqualTo(String value) {
            addCriterion("user_alias =", value, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasNotEqualTo(String value) {
            addCriterion("user_alias <>", value, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasGreaterThan(String value) {
            addCriterion("user_alias >", value, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasGreaterThanOrEqualTo(String value) {
            addCriterion("user_alias >=", value, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasLessThan(String value) {
            addCriterion("user_alias <", value, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasLessThanOrEqualTo(String value) {
            addCriterion("user_alias <=", value, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasLike(String value) {
            addCriterion("user_alias like", value, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasNotLike(String value) {
            addCriterion("user_alias not like", value, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasIn(List<String> values) {
            addCriterion("user_alias in", values, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasNotIn(List<String> values) {
            addCriterion("user_alias not in", values, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasBetween(String value1, String value2) {
            addCriterion("user_alias between", value1, value2, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserAliasNotBetween(String value1, String value2) {
            addCriterion("user_alias not between", value1, value2, "userAlias");
            return (Criteria) this;
        }

        public Criteria andUserCertNoIsNull() {
            addCriterion("user_cert_no is null");
            return (Criteria) this;
        }

        public Criteria andUserCertNoIsNotNull() {
            addCriterion("user_cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserCertNoEqualTo(String value) {
            addCriterion("user_cert_no =", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoNotEqualTo(String value) {
            addCriterion("user_cert_no <>", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoGreaterThan(String value) {
            addCriterion("user_cert_no >", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_cert_no >=", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoLessThan(String value) {
            addCriterion("user_cert_no <", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoLessThanOrEqualTo(String value) {
            addCriterion("user_cert_no <=", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoLike(String value) {
            addCriterion("user_cert_no like", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoNotLike(String value) {
            addCriterion("user_cert_no not like", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoIn(List<String> values) {
            addCriterion("user_cert_no in", values, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoNotIn(List<String> values) {
            addCriterion("user_cert_no not in", values, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoBetween(String value1, String value2) {
            addCriterion("user_cert_no between", value1, value2, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoNotBetween(String value1, String value2) {
            addCriterion("user_cert_no not between", value1, value2, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andCreditRateIsNull() {
            addCriterion("credit_rate is null");
            return (Criteria) this;
        }

        public Criteria andCreditRateIsNotNull() {
            addCriterion("credit_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCreditRateEqualTo(String value) {
            addCriterion("credit_rate =", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotEqualTo(String value) {
            addCriterion("credit_rate <>", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateGreaterThan(String value) {
            addCriterion("credit_rate >", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateGreaterThanOrEqualTo(String value) {
            addCriterion("credit_rate >=", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLessThan(String value) {
            addCriterion("credit_rate <", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLessThanOrEqualTo(String value) {
            addCriterion("credit_rate <=", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLike(String value) {
            addCriterion("credit_rate like", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotLike(String value) {
            addCriterion("credit_rate not like", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateIn(List<String> values) {
            addCriterion("credit_rate in", values, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotIn(List<String> values) {
            addCriterion("credit_rate not in", values, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateBetween(String value1, String value2) {
            addCriterion("credit_rate between", value1, value2, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotBetween(String value1, String value2) {
            addCriterion("credit_rate not between", value1, value2, "creditRate");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalIsNull() {
            addCriterion("history_total is null");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalIsNotNull() {
            addCriterion("history_total is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalEqualTo(Integer value) {
            addCriterion("history_total =", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalNotEqualTo(Integer value) {
            addCriterion("history_total <>", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalGreaterThan(Integer value) {
            addCriterion("history_total >", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("history_total >=", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalLessThan(Integer value) {
            addCriterion("history_total <", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalLessThanOrEqualTo(Integer value) {
            addCriterion("history_total <=", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalIn(List<Integer> values) {
            addCriterion("history_total in", values, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalNotIn(List<Integer> values) {
            addCriterion("history_total not in", values, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalBetween(Integer value1, Integer value2) {
            addCriterion("history_total between", value1, value2, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("history_total not between", value1, value2, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNull() {
            addCriterion("user_no is null");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNotNull() {
            addCriterion("user_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserNoEqualTo(String value) {
            addCriterion("user_no =", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotEqualTo(String value) {
            addCriterion("user_no <>", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThan(String value) {
            addCriterion("user_no >", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_no >=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThan(String value) {
            addCriterion("user_no <", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThanOrEqualTo(String value) {
            addCriterion("user_no <=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLike(String value) {
            addCriterion("user_no like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotLike(String value) {
            addCriterion("user_no not like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIn(List<String> values) {
            addCriterion("user_no in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotIn(List<String> values) {
            addCriterion("user_no not in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoBetween(String value1, String value2) {
            addCriterion("user_no between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotBetween(String value1, String value2) {
            addCriterion("user_no not between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserUuidIsNull() {
            addCriterion("user_uuid is null");
            return (Criteria) this;
        }

        public Criteria andUserUuidIsNotNull() {
            addCriterion("user_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUserUuidEqualTo(String value) {
            addCriterion("user_uuid =", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidNotEqualTo(String value) {
            addCriterion("user_uuid <>", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidGreaterThan(String value) {
            addCriterion("user_uuid >", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidGreaterThanOrEqualTo(String value) {
            addCriterion("user_uuid >=", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidLessThan(String value) {
            addCriterion("user_uuid <", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidLessThanOrEqualTo(String value) {
            addCriterion("user_uuid <=", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidLike(String value) {
            addCriterion("user_uuid like", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidNotLike(String value) {
            addCriterion("user_uuid not like", value, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidIn(List<String> values) {
            addCriterion("user_uuid in", values, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidNotIn(List<String> values) {
            addCriterion("user_uuid not in", values, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidBetween(String value1, String value2) {
            addCriterion("user_uuid between", value1, value2, "userUuid");
            return (Criteria) this;
        }

        public Criteria andUserUuidNotBetween(String value1, String value2) {
            addCriterion("user_uuid not between", value1, value2, "userUuid");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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