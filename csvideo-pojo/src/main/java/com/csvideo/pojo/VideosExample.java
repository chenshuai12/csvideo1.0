package com.csvideo.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VideosExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideosExample() {
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

        public Criteria andVideosIdIsNull() {
            addCriterion("videos_id is null");
            return (Criteria) this;
        }

        public Criteria andVideosIdIsNotNull() {
            addCriterion("videos_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideosIdEqualTo(String value) {
            addCriterion("videos_id =", value, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdNotEqualTo(String value) {
            addCriterion("videos_id <>", value, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdGreaterThan(String value) {
            addCriterion("videos_id >", value, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdGreaterThanOrEqualTo(String value) {
            addCriterion("videos_id >=", value, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdLessThan(String value) {
            addCriterion("videos_id <", value, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdLessThanOrEqualTo(String value) {
            addCriterion("videos_id <=", value, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdLike(String value) {
            addCriterion("videos_id like", value, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdNotLike(String value) {
            addCriterion("videos_id not like", value, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdIn(List<String> values) {
            addCriterion("videos_id in", values, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdNotIn(List<String> values) {
            addCriterion("videos_id not in", values, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdBetween(String value1, String value2) {
            addCriterion("videos_id between", value1, value2, "videosId");
            return (Criteria) this;
        }

        public Criteria andVideosIdNotBetween(String value1, String value2) {
            addCriterion("videos_id not between", value1, value2, "videosId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andVideosPathIsNull() {
            addCriterion("videos_path is null");
            return (Criteria) this;
        }

        public Criteria andVideosPathIsNotNull() {
            addCriterion("videos_path is not null");
            return (Criteria) this;
        }

        public Criteria andVideosPathEqualTo(String value) {
            addCriterion("videos_path =", value, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathNotEqualTo(String value) {
            addCriterion("videos_path <>", value, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathGreaterThan(String value) {
            addCriterion("videos_path >", value, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathGreaterThanOrEqualTo(String value) {
            addCriterion("videos_path >=", value, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathLessThan(String value) {
            addCriterion("videos_path <", value, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathLessThanOrEqualTo(String value) {
            addCriterion("videos_path <=", value, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathLike(String value) {
            addCriterion("videos_path like", value, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathNotLike(String value) {
            addCriterion("videos_path not like", value, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathIn(List<String> values) {
            addCriterion("videos_path in", values, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathNotIn(List<String> values) {
            addCriterion("videos_path not in", values, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathBetween(String value1, String value2) {
            addCriterion("videos_path between", value1, value2, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPathNotBetween(String value1, String value2) {
            addCriterion("videos_path not between", value1, value2, "videosPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathIsNull() {
            addCriterion("videos_photo_path is null");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathIsNotNull() {
            addCriterion("videos_photo_path is not null");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathEqualTo(String value) {
            addCriterion("videos_photo_path =", value, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathNotEqualTo(String value) {
            addCriterion("videos_photo_path <>", value, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathGreaterThan(String value) {
            addCriterion("videos_photo_path >", value, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathGreaterThanOrEqualTo(String value) {
            addCriterion("videos_photo_path >=", value, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathLessThan(String value) {
            addCriterion("videos_photo_path <", value, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathLessThanOrEqualTo(String value) {
            addCriterion("videos_photo_path <=", value, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathLike(String value) {
            addCriterion("videos_photo_path like", value, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathNotLike(String value) {
            addCriterion("videos_photo_path not like", value, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathIn(List<String> values) {
            addCriterion("videos_photo_path in", values, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathNotIn(List<String> values) {
            addCriterion("videos_photo_path not in", values, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathBetween(String value1, String value2) {
            addCriterion("videos_photo_path between", value1, value2, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPhotoPathNotBetween(String value1, String value2) {
            addCriterion("videos_photo_path not between", value1, value2, "videosPhotoPath");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseIsNull() {
            addCriterion("videos_praise is null");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseIsNotNull() {
            addCriterion("videos_praise is not null");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseEqualTo(Integer value) {
            addCriterion("videos_praise =", value, "videosPraise");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseNotEqualTo(Integer value) {
            addCriterion("videos_praise <>", value, "videosPraise");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseGreaterThan(Integer value) {
            addCriterion("videos_praise >", value, "videosPraise");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseGreaterThanOrEqualTo(Integer value) {
            addCriterion("videos_praise >=", value, "videosPraise");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseLessThan(Integer value) {
            addCriterion("videos_praise <", value, "videosPraise");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseLessThanOrEqualTo(Integer value) {
            addCriterion("videos_praise <=", value, "videosPraise");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseIn(List<Integer> values) {
            addCriterion("videos_praise in", values, "videosPraise");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseNotIn(List<Integer> values) {
            addCriterion("videos_praise not in", values, "videosPraise");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseBetween(Integer value1, Integer value2) {
            addCriterion("videos_praise between", value1, value2, "videosPraise");
            return (Criteria) this;
        }

        public Criteria andVideosPraiseNotBetween(Integer value1, Integer value2) {
            addCriterion("videos_praise not between", value1, value2, "videosPraise");
            return (Criteria) this;
        }

        public Criteria andVideosStatuIsNull() {
            addCriterion("videos_statu is null");
            return (Criteria) this;
        }

        public Criteria andVideosStatuIsNotNull() {
            addCriterion("videos_statu is not null");
            return (Criteria) this;
        }

        public Criteria andVideosStatuEqualTo(String value) {
            addCriterion("videos_statu =", value, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuNotEqualTo(String value) {
            addCriterion("videos_statu <>", value, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuGreaterThan(String value) {
            addCriterion("videos_statu >", value, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuGreaterThanOrEqualTo(String value) {
            addCriterion("videos_statu >=", value, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuLessThan(String value) {
            addCriterion("videos_statu <", value, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuLessThanOrEqualTo(String value) {
            addCriterion("videos_statu <=", value, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuLike(String value) {
            addCriterion("videos_statu like", value, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuNotLike(String value) {
            addCriterion("videos_statu not like", value, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuIn(List<String> values) {
            addCriterion("videos_statu in", values, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuNotIn(List<String> values) {
            addCriterion("videos_statu not in", values, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuBetween(String value1, String value2) {
            addCriterion("videos_statu between", value1, value2, "videosStatu");
            return (Criteria) this;
        }

        public Criteria andVideosStatuNotBetween(String value1, String value2) {
            addCriterion("videos_statu not between", value1, value2, "videosStatu");
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