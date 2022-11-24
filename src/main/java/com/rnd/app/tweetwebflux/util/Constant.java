package com.rnd.app.tweetwebflux.util;

import java.util.List;

public class Constant {

    public static Integer ACTIVE = 0;
    public static Integer NONACTIVE = 1;
    public static String ROLE_USER = "USER";
    public static String ROLE_ADMIN = "ADMIN";
    public static String ROLE_MAKER = "MAKER";
    public static String ROLE_APPROVER = "APPROVER";

    public static String[] ROLES = {
            ROLE_ADMIN,
            ROLE_MAKER,
            ROLE_USER,
            ROLE_APPROVER
    };

    public static String[] STATUS = {
           "CREATED_TWEET",
           "UPDATED_TWEET",
           "DELETED_TWEET",
           "CREATED_ACCOUNT",
           "LOGIN_ACCOUNT",
           "UPDATED_ACCOUNT"
    };

    public static final String APPROVE = "approve";
    public static final String REJECT = "reject";
    public static final String PENDING = "pending";
    public static final List<String> getApproval = List.of(APPROVE, REJECT, PENDING);

}
