package com.cwx.entity;

public class User {
        private int id;
        private String uuid;
        private String loginName;
        private String loginPassword;
        private String userRealName;
        private String userNickName;
        private String userContactPhone;
        private String userContactAddress;

        public int getId() {
            return id;
        }

        public String getUserRealName() {
            return userRealName;
        }

        public void setUserRealName(String userRealName) {
            this.userRealName = userRealName;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getLoginPassword() {
            return loginPassword;
        }

        public void setLoginPassword(String loginPassword) {
            this.loginPassword = loginPassword;
        }

        public String getUserNickName() {
            return userNickName;
        }

        public void setUserNickName(String userNickName) {
            this.userNickName = userNickName;
        }

        public String getUserContactPhone() {
            return userContactPhone;
        }

        public void setUserContactPhone(String userContactPhone) {
            this.userContactPhone = userContactPhone;
        }

        public String getUserContactAddress() {
            return userContactAddress;
        }

        public void setUserContactAddress(String userContactAddress) {
            this.userContactAddress = userContactAddress;
        }
    }


