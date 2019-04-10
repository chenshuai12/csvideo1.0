package com.csvideo.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommentsExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentsExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(String value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(String value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(String value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(String value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(String value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(String value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLike(String value) {
            addCriterion("comment_id like", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotLike(String value) {
            addCriterion("comment_id not like", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<String> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<String> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(String value1, String value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(String value1, String value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdIsNull() {
            addCriterion("father_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdIsNotNull() {
            addCriterion("father_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdEqualTo(String value) {
            addCriterion("father_comment_id =", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdNotEqualTo(String value) {
            addCriterion("father_comment_id <>", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdGreaterThan(String value) {
            addCriterion("father_comment_id >", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdGreaterThanOrEqualTo(String value) {
            addCriterion("father_comment_id >=", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdLessThan(String value) {
            addCriterion("father_comment_id <", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdLessThanOrEqualTo(String value) {
            addCriterion("father_comment_id <=", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdLike(String value) {
            addCriterion("father_comment_id like", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdNotLike(String value) {
            addCriterion("father_comment_id not like", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdIn(List<String> values) {
            addCriterion("father_comment_id in", values, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdNotIn(List<String> values) {
            addCriterion("father_comment_id not in", values, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdBetween(String value1, String value2) {
            addCriterion("father_comment_id between", value1, value2, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdNotBetween(String value1, String value2) {
            addCriterion("father_comment_id not between", value1, value2, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andToUserIdIsNull() {
            addCriterion("to_user_id is null");
            return (Criteria) this;
        }

        public Criteria andToUserIdIsNotNull() {
            addCriterion("to_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andToUserIdEqualTo(String value) {
            addCriterion("to_user_id =", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotEqualTo(String value) {
            addCriterion("to_user_id <>", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdGreaterThan(String value) {
            addCriterion("to_user_id >", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("to_user_id >=", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLessThan(String value) {
            addCriterion("to_user_id <", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLessThanOrEqualTo(String value) {
            addCriterion("to_user_id <=", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLike(String value) {
            addCriterion("to_user_id like", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotLike(String value) {
            addCriterion("to_user_id not like", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdIn(List<String> values) {
            addCriterion("to_user_id in", values, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotIn(List<String> values) {
            addCriterion("to_user_id not in", values, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdBetween(String value1, String value2) {
            addCriterion("to_user_id between", value1, value2, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotBetween(String value1, String value2) {
            addCriterion("to_user_id not between", value1, value2, "toUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNull() {
            addCriterion("from_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNotNull() {
            addCriterion("from_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdEqualTo(String value) {
            addCriterion("from_user_id =", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotEqualTo(String value) {
            addCriterion("from_user_id <>", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThan(String value) {
            addCriterion("from_user_id >", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("from_user_id >=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThan(String value) {
            addCriterion("from_user_id <", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThanOrEqualTo(String value) {
            addCriterion("from_user_id <=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLike(String value) {
            addCriterion("from_user_id like", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotLike(String value) {
            addCriterion("from_user_id not like", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIn(List<String> values) {
            addCriterion("from_user_id in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotIn(List<String> values) {
            addCriterion("from_user_id not in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdBetween(String value1, String value2) {
            addCriterion("from_user_id between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotBetween(String value1, String value2) {
            addCriterion("from_user_id not between", value1, value2, "fromUserId");
            return (Criteria) this;
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

        public Criteria andMoviesIdIsNull() {
            addCriterion("movies_id is null");
            return (Criteria) this;
        }

        public Criteria andMoviesIdIsNotNull() {
            addCriterion("movies_id is not null");
            return (Criteria) this;
        }

        public Criteria andMoviesIdEqualTo(String value) {
            addCriterion("movies_id =", value, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdNotEqualTo(String value) {
            addCriterion("movies_id <>", value, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdGreaterThan(String value) {
            addCriterion("movies_id >", value, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdGreaterThanOrEqualTo(String value) {
            addCriterion("movies_id >=", value, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdLessThan(String value) {
            addCriterion("movies_id <", value, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdLessThanOrEqualTo(String value) {
            addCriterion("movies_id <=", value, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdLike(String value) {
            addCriterion("movies_id like", value, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdNotLike(String value) {
            addCriterion("movies_id not like", value, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdIn(List<String> values) {
            addCriterion("movies_id in", values, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdNotIn(List<String> values) {
            addCriterion("movies_id not in", values, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdBetween(String value1, String value2) {
            addCriterion("movies_id between", value1, value2, "moviesId");
            return (Criteria) this;
        }

        public Criteria andMoviesIdNotBetween(String value1, String value2) {
            addCriterion("movies_id not between", value1, value2, "moviesId");
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