package com.xpanxion.java.springboot.da1.demo.model.student4;

import java.util.Date;

public class WorkoutPresentation4 {
        private Long memberId;
        private Date timeUtc;
        private WorkoutHistory4.CheckType checkType;

        public WorkoutPresentation4(Long memberId, Date timeUtc, WorkoutHistory4.CheckType checkType) {
            this.memberId = memberId;
            this.timeUtc = timeUtc;
            this.checkType = checkType;
        }

        public WorkoutPresentation4() {
        }

        public Long getMemberId() {
            return memberId;
        }

        public void setMemberId(Long memberId) {
            this.memberId = memberId;
        }

        public Date getTimeUtc() {
            return timeUtc;
        }

        public void setTimeUtc(Date timeUtc) {
            this.timeUtc = timeUtc;
        }

        public WorkoutHistory4.CheckType getCheckType() {
            return checkType;
        }

        public void setCheckType(WorkoutHistory4.CheckType checkType) {
            this.checkType = checkType;
        }

        @Override
        public String toString() {
            return "HistoryResult5{" +
                    "memberId=" + memberId +
                    ", timeUtc=" + timeUtc +
                    ", checkType=" + checkType +
                    '}';
        }
}

