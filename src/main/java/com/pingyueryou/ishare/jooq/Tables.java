/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq;


import com.pingyueryou.ishare.jooq.tables.IClass;
import com.pingyueryou.ishare.jooq.tables.IGrade;
import com.pingyueryou.ishare.jooq.tables.IIdAuthOrder;
import com.pingyueryou.ishare.jooq.tables.IItem;
import com.pingyueryou.ishare.jooq.tables.IItemLendOrder;
import com.pingyueryou.ishare.jooq.tables.IItemTag;
import com.pingyueryou.ishare.jooq.tables.IItemTagItem;
import com.pingyueryou.ishare.jooq.tables.IShare;
import com.pingyueryou.ishare.jooq.tables.IShareMedia;
import com.pingyueryou.ishare.jooq.tables.IStudent;
import com.pingyueryou.ishare.jooq.tables.IUser;
import com.pingyueryou.ishare.jooq.tables.IUserClass;
import com.pingyueryou.ishare.jooq.tables.IUserRole;
import com.pingyueryou.ishare.jooq.tables.IUserStudent;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in ishare
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>ishare.i_class</code>.
     */
    public static final IClass I_CLASS = com.pingyueryou.ishare.jooq.tables.IClass.I_CLASS;

    /**
     * The table <code>ishare.i_grade</code>.
     */
    public static final IGrade I_GRADE = com.pingyueryou.ishare.jooq.tables.IGrade.I_GRADE;

    /**
     * The table <code>ishare.i_id_auth_order</code>.
     */
    public static final IIdAuthOrder I_ID_AUTH_ORDER = com.pingyueryou.ishare.jooq.tables.IIdAuthOrder.I_ID_AUTH_ORDER;

    /**
     * The table <code>ishare.i_item</code>.
     */
    public static final IItem I_ITEM = com.pingyueryou.ishare.jooq.tables.IItem.I_ITEM;

    /**
     * The table <code>ishare.i_item_lend_order</code>.
     */
    public static final IItemLendOrder I_ITEM_LEND_ORDER = com.pingyueryou.ishare.jooq.tables.IItemLendOrder.I_ITEM_LEND_ORDER;

    /**
     * The table <code>ishare.i_item_tag</code>.
     */
    public static final IItemTag I_ITEM_TAG = com.pingyueryou.ishare.jooq.tables.IItemTag.I_ITEM_TAG;

    /**
     * The table <code>ishare.i_item_tag_item</code>.
     */
    public static final IItemTagItem I_ITEM_TAG_ITEM = com.pingyueryou.ishare.jooq.tables.IItemTagItem.I_ITEM_TAG_ITEM;

    /**
     * The table <code>ishare.i_share</code>.
     */
    public static final IShare I_SHARE = com.pingyueryou.ishare.jooq.tables.IShare.I_SHARE;

    /**
     * The table <code>ishare.i_share_media</code>.
     */
    public static final IShareMedia I_SHARE_MEDIA = com.pingyueryou.ishare.jooq.tables.IShareMedia.I_SHARE_MEDIA;

    /**
     * The table <code>ishare.i_student</code>.
     */
    public static final IStudent I_STUDENT = com.pingyueryou.ishare.jooq.tables.IStudent.I_STUDENT;

    /**
     * The table <code>ishare.i_user</code>.
     */
    public static final IUser I_USER = com.pingyueryou.ishare.jooq.tables.IUser.I_USER;

    /**
     * The table <code>ishare.i_user_class</code>.
     */
    public static final IUserClass I_USER_CLASS = com.pingyueryou.ishare.jooq.tables.IUserClass.I_USER_CLASS;

    /**
     * The table <code>ishare.i_user_role</code>.
     */
    public static final IUserRole I_USER_ROLE = com.pingyueryou.ishare.jooq.tables.IUserRole.I_USER_ROLE;

    /**
     * The table <code>ishare.i_user_student</code>.
     */
    public static final IUserStudent I_USER_STUDENT = com.pingyueryou.ishare.jooq.tables.IUserStudent.I_USER_STUDENT;
}
