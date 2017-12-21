package com.poilt.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CardExample() {
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

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNull() {
            addCriterion("cert_no is null");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNotNull() {
            addCriterion("cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andCertNoEqualTo(String value) {
            addCriterion("cert_no =", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotEqualTo(String value) {
            addCriterion("cert_no <>", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThan(String value) {
            addCriterion("cert_no >", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("cert_no >=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThan(String value) {
            addCriterion("cert_no <", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThanOrEqualTo(String value) {
            addCriterion("cert_no <=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLike(String value) {
            addCriterion("cert_no like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotLike(String value) {
            addCriterion("cert_no not like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoIn(List<String> values) {
            addCriterion("cert_no in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotIn(List<String> values) {
            addCriterion("cert_no not in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoBetween(String value1, String value2) {
            addCriterion("cert_no between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotBetween(String value1, String value2) {
            addCriterion("cert_no not between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("card_type like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("card_type not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardUserNameIsNull() {
            addCriterion("card_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCardUserNameIsNotNull() {
            addCriterion("card_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCardUserNameEqualTo(String value) {
            addCriterion("card_user_name =", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameNotEqualTo(String value) {
            addCriterion("card_user_name <>", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameGreaterThan(String value) {
            addCriterion("card_user_name >", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("card_user_name >=", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameLessThan(String value) {
            addCriterion("card_user_name <", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameLessThanOrEqualTo(String value) {
            addCriterion("card_user_name <=", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameLike(String value) {
            addCriterion("card_user_name like", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameNotLike(String value) {
            addCriterion("card_user_name not like", value, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameIn(List<String> values) {
            addCriterion("card_user_name in", values, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameNotIn(List<String> values) {
            addCriterion("card_user_name not in", values, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameBetween(String value1, String value2) {
            addCriterion("card_user_name between", value1, value2, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardUserNameNotBetween(String value1, String value2) {
            addCriterion("card_user_name not between", value1, value2, "cardUserName");
            return (Criteria) this;
        }

        public Criteria andCardStatusIsNull() {
            addCriterion("card_status is null");
            return (Criteria) this;
        }

        public Criteria andCardStatusIsNotNull() {
            addCriterion("card_status is not null");
            return (Criteria) this;
        }

        public Criteria andCardStatusEqualTo(String value) {
            addCriterion("card_status =", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusNotEqualTo(String value) {
            addCriterion("card_status <>", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusGreaterThan(String value) {
            addCriterion("card_status >", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusGreaterThanOrEqualTo(String value) {
            addCriterion("card_status >=", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusLessThan(String value) {
            addCriterion("card_status <", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusLessThanOrEqualTo(String value) {
            addCriterion("card_status <=", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusLike(String value) {
            addCriterion("card_status like", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusNotLike(String value) {
            addCriterion("card_status not like", value, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusIn(List<String> values) {
            addCriterion("card_status in", values, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusNotIn(List<String> values) {
            addCriterion("card_status not in", values, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusBetween(String value1, String value2) {
            addCriterion("card_status between", value1, value2, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardStatusNotBetween(String value1, String value2) {
            addCriterion("card_status not between", value1, value2, "cardStatus");
            return (Criteria) this;
        }

        public Criteria andCardProvinceIsNull() {
            addCriterion("card_province is null");
            return (Criteria) this;
        }

        public Criteria andCardProvinceIsNotNull() {
            addCriterion("card_province is not null");
            return (Criteria) this;
        }

        public Criteria andCardProvinceEqualTo(String value) {
            addCriterion("card_province =", value, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceNotEqualTo(String value) {
            addCriterion("card_province <>", value, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceGreaterThan(String value) {
            addCriterion("card_province >", value, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("card_province >=", value, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceLessThan(String value) {
            addCriterion("card_province <", value, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceLessThanOrEqualTo(String value) {
            addCriterion("card_province <=", value, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceLike(String value) {
            addCriterion("card_province like", value, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceNotLike(String value) {
            addCriterion("card_province not like", value, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceIn(List<String> values) {
            addCriterion("card_province in", values, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceNotIn(List<String> values) {
            addCriterion("card_province not in", values, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceBetween(String value1, String value2) {
            addCriterion("card_province between", value1, value2, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardProvinceNotBetween(String value1, String value2) {
            addCriterion("card_province not between", value1, value2, "cardProvince");
            return (Criteria) this;
        }

        public Criteria andCardCityIsNull() {
            addCriterion("card_city is null");
            return (Criteria) this;
        }

        public Criteria andCardCityIsNotNull() {
            addCriterion("card_city is not null");
            return (Criteria) this;
        }

        public Criteria andCardCityEqualTo(String value) {
            addCriterion("card_city =", value, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityNotEqualTo(String value) {
            addCriterion("card_city <>", value, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityGreaterThan(String value) {
            addCriterion("card_city >", value, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityGreaterThanOrEqualTo(String value) {
            addCriterion("card_city >=", value, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityLessThan(String value) {
            addCriterion("card_city <", value, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityLessThanOrEqualTo(String value) {
            addCriterion("card_city <=", value, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityLike(String value) {
            addCriterion("card_city like", value, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityNotLike(String value) {
            addCriterion("card_city not like", value, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityIn(List<String> values) {
            addCriterion("card_city in", values, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityNotIn(List<String> values) {
            addCriterion("card_city not in", values, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityBetween(String value1, String value2) {
            addCriterion("card_city between", value1, value2, "cardCity");
            return (Criteria) this;
        }

        public Criteria andCardCityNotBetween(String value1, String value2) {
            addCriterion("card_city not between", value1, value2, "cardCity");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameIsNull() {
            addCriterion("bank_sub_name is null");
            return (Criteria) this;
        }

        public Criteria andBankSubNameIsNotNull() {
            addCriterion("bank_sub_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankSubNameEqualTo(String value) {
            addCriterion("bank_sub_name =", value, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameNotEqualTo(String value) {
            addCriterion("bank_sub_name <>", value, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameGreaterThan(String value) {
            addCriterion("bank_sub_name >", value, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_sub_name >=", value, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameLessThan(String value) {
            addCriterion("bank_sub_name <", value, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameLessThanOrEqualTo(String value) {
            addCriterion("bank_sub_name <=", value, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameLike(String value) {
            addCriterion("bank_sub_name like", value, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameNotLike(String value) {
            addCriterion("bank_sub_name not like", value, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameIn(List<String> values) {
            addCriterion("bank_sub_name in", values, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameNotIn(List<String> values) {
            addCriterion("bank_sub_name not in", values, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameBetween(String value1, String value2) {
            addCriterion("bank_sub_name between", value1, value2, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankSubNameNotBetween(String value1, String value2) {
            addCriterion("bank_sub_name not between", value1, value2, "bankSubName");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoIsNull() {
            addCriterion("bank_channel_no is null");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoIsNotNull() {
            addCriterion("bank_channel_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoEqualTo(String value) {
            addCriterion("bank_channel_no =", value, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoNotEqualTo(String value) {
            addCriterion("bank_channel_no <>", value, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoGreaterThan(String value) {
            addCriterion("bank_channel_no >", value, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_channel_no >=", value, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoLessThan(String value) {
            addCriterion("bank_channel_no <", value, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoLessThanOrEqualTo(String value) {
            addCriterion("bank_channel_no <=", value, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoLike(String value) {
            addCriterion("bank_channel_no like", value, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoNotLike(String value) {
            addCriterion("bank_channel_no not like", value, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoIn(List<String> values) {
            addCriterion("bank_channel_no in", values, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoNotIn(List<String> values) {
            addCriterion("bank_channel_no not in", values, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoBetween(String value1, String value2) {
            addCriterion("bank_channel_no between", value1, value2, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankChannelNoNotBetween(String value1, String value2) {
            addCriterion("bank_channel_no not between", value1, value2, "bankChannelNo");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNull() {
            addCriterion("bank_code is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("bank_code is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("bank_code =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("bank_code <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("bank_code >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bank_code >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("bank_code <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("bank_code <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("bank_code like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("bank_code not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("bank_code in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("bank_code not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("bank_code between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("bank_code not between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNull() {
            addCriterion("bank_no is null");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNotNull() {
            addCriterion("bank_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankNoEqualTo(String value) {
            addCriterion("bank_no =", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotEqualTo(String value) {
            addCriterion("bank_no <>", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThan(String value) {
            addCriterion("bank_no >", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_no >=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThan(String value) {
            addCriterion("bank_no <", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThanOrEqualTo(String value) {
            addCriterion("bank_no <=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLike(String value) {
            addCriterion("bank_no like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotLike(String value) {
            addCriterion("bank_no not like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoIn(List<String> values) {
            addCriterion("bank_no in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotIn(List<String> values) {
            addCriterion("bank_no not in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoBetween(String value1, String value2) {
            addCriterion("bank_no between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotBetween(String value1, String value2) {
            addCriterion("bank_no not between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNull() {
            addCriterion("use_type is null");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNotNull() {
            addCriterion("use_type is not null");
            return (Criteria) this;
        }

        public Criteria andUseTypeEqualTo(String value) {
            addCriterion("use_type =", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotEqualTo(String value) {
            addCriterion("use_type <>", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThan(String value) {
            addCriterion("use_type >", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("use_type >=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThan(String value) {
            addCriterion("use_type <", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThanOrEqualTo(String value) {
            addCriterion("use_type <=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLike(String value) {
            addCriterion("use_type like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotLike(String value) {
            addCriterion("use_type not like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIn(List<String> values) {
            addCriterion("use_type in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotIn(List<String> values) {
            addCriterion("use_type not in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeBetween(String value1, String value2) {
            addCriterion("use_type between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotBetween(String value1, String value2) {
            addCriterion("use_type not between", value1, value2, "useType");
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