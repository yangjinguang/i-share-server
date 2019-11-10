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
import com.pingyueryou.ishare.jooq.tables.IShareComment;
import com.pingyueryou.ishare.jooq.tables.IShareLike;
import com.pingyueryou.ishare.jooq.tables.IShareMedia;
import com.pingyueryou.ishare.jooq.tables.IStudent;
import com.pingyueryou.ishare.jooq.tables.IUser;
import com.pingyueryou.ishare.jooq.tables.IUserClass;
import com.pingyueryou.ishare.jooq.tables.IUserRole;
import com.pingyueryou.ishare.jooq.tables.IUserStudent;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>ishare</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index I_CLASS_PRIMARY = Indexes0.I_CLASS_PRIMARY;
    public static final Index I_GRADE_PRIMARY = Indexes0.I_GRADE_PRIMARY;
    public static final Index I_ID_AUTH_ORDER_PRIMARY = Indexes0.I_ID_AUTH_ORDER_PRIMARY;
    public static final Index I_ITEM_PRIMARY = Indexes0.I_ITEM_PRIMARY;
    public static final Index I_ITEM_LEND_ORDER_PRIMARY = Indexes0.I_ITEM_LEND_ORDER_PRIMARY;
    public static final Index I_ITEM_TAG_PRIMARY = Indexes0.I_ITEM_TAG_PRIMARY;
    public static final Index I_ITEM_TAG_ITEM_PRIMARY = Indexes0.I_ITEM_TAG_ITEM_PRIMARY;
    public static final Index I_ITEM_TAG_ITEM_UK_ITEM_TAG_ID = Indexes0.I_ITEM_TAG_ITEM_UK_ITEM_TAG_ID;
    public static final Index I_SHARE_PRIMARY = Indexes0.I_SHARE_PRIMARY;
    public static final Index I_SHARE_COMMENT_PRIMARY = Indexes0.I_SHARE_COMMENT_PRIMARY;
    public static final Index I_SHARE_LIKE_PRIMARY = Indexes0.I_SHARE_LIKE_PRIMARY;
    public static final Index I_SHARE_LIKE_UK_SHARE_USER_ID = Indexes0.I_SHARE_LIKE_UK_SHARE_USER_ID;
    public static final Index I_SHARE_MEDIA_PRIMARY = Indexes0.I_SHARE_MEDIA_PRIMARY;
    public static final Index I_STUDENT_PRIMARY = Indexes0.I_STUDENT_PRIMARY;
    public static final Index I_USER_PRIMARY = Indexes0.I_USER_PRIMARY;
    public static final Index I_USER_UK_OPEN_ID = Indexes0.I_USER_UK_OPEN_ID;
    public static final Index I_USER_CLASS_PRIMARY = Indexes0.I_USER_CLASS_PRIMARY;
    public static final Index I_USER_CLASS_UK_USER_CLASS_ID = Indexes0.I_USER_CLASS_UK_USER_CLASS_ID;
    public static final Index I_USER_ROLE_PRIMARY = Indexes0.I_USER_ROLE_PRIMARY;
    public static final Index I_USER_ROLE_UK_USER_ID_ROLE = Indexes0.I_USER_ROLE_UK_USER_ID_ROLE;
    public static final Index I_USER_STUDENT_PRIMARY = Indexes0.I_USER_STUDENT_PRIMARY;
    public static final Index I_USER_STUDENT_UK_USER_STUDENT_ID = Indexes0.I_USER_STUDENT_UK_USER_STUDENT_ID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index I_CLASS_PRIMARY = Internal.createIndex("PRIMARY", IClass.I_CLASS, new OrderField[] { IClass.I_CLASS.ID }, true);
        public static Index I_GRADE_PRIMARY = Internal.createIndex("PRIMARY", IGrade.I_GRADE, new OrderField[] { IGrade.I_GRADE.ID }, true);
        public static Index I_ID_AUTH_ORDER_PRIMARY = Internal.createIndex("PRIMARY", IIdAuthOrder.I_ID_AUTH_ORDER, new OrderField[] { IIdAuthOrder.I_ID_AUTH_ORDER.ID }, true);
        public static Index I_ITEM_PRIMARY = Internal.createIndex("PRIMARY", IItem.I_ITEM, new OrderField[] { IItem.I_ITEM.ID }, true);
        public static Index I_ITEM_LEND_ORDER_PRIMARY = Internal.createIndex("PRIMARY", IItemLendOrder.I_ITEM_LEND_ORDER, new OrderField[] { IItemLendOrder.I_ITEM_LEND_ORDER.ID }, true);
        public static Index I_ITEM_TAG_PRIMARY = Internal.createIndex("PRIMARY", IItemTag.I_ITEM_TAG, new OrderField[] { IItemTag.I_ITEM_TAG.ID }, true);
        public static Index I_ITEM_TAG_ITEM_PRIMARY = Internal.createIndex("PRIMARY", IItemTagItem.I_ITEM_TAG_ITEM, new OrderField[] { IItemTagItem.I_ITEM_TAG_ITEM.ID }, true);
        public static Index I_ITEM_TAG_ITEM_UK_ITEM_TAG_ID = Internal.createIndex("uk_item_tag_id", IItemTagItem.I_ITEM_TAG_ITEM, new OrderField[] { IItemTagItem.I_ITEM_TAG_ITEM.ITEM_ID, IItemTagItem.I_ITEM_TAG_ITEM.TAG_ID }, true);
        public static Index I_SHARE_PRIMARY = Internal.createIndex("PRIMARY", IShare.I_SHARE, new OrderField[] { IShare.I_SHARE.ID }, true);
        public static Index I_SHARE_COMMENT_PRIMARY = Internal.createIndex("PRIMARY", IShareComment.I_SHARE_COMMENT, new OrderField[] { IShareComment.I_SHARE_COMMENT.ID }, true);
        public static Index I_SHARE_LIKE_PRIMARY = Internal.createIndex("PRIMARY", IShareLike.I_SHARE_LIKE, new OrderField[] { IShareLike.I_SHARE_LIKE.ID }, true);
        public static Index I_SHARE_LIKE_UK_SHARE_USER_ID = Internal.createIndex("uk_share_user_id", IShareLike.I_SHARE_LIKE, new OrderField[] { IShareLike.I_SHARE_LIKE.USER_ID, IShareLike.I_SHARE_LIKE.SHARE_ID }, true);
        public static Index I_SHARE_MEDIA_PRIMARY = Internal.createIndex("PRIMARY", IShareMedia.I_SHARE_MEDIA, new OrderField[] { IShareMedia.I_SHARE_MEDIA.ID }, true);
        public static Index I_STUDENT_PRIMARY = Internal.createIndex("PRIMARY", IStudent.I_STUDENT, new OrderField[] { IStudent.I_STUDENT.ID }, true);
        public static Index I_USER_PRIMARY = Internal.createIndex("PRIMARY", IUser.I_USER, new OrderField[] { IUser.I_USER.ID }, true);
        public static Index I_USER_UK_OPEN_ID = Internal.createIndex("uk_open_id", IUser.I_USER, new OrderField[] { IUser.I_USER.OPEN_ID }, true);
        public static Index I_USER_CLASS_PRIMARY = Internal.createIndex("PRIMARY", IUserClass.I_USER_CLASS, new OrderField[] { IUserClass.I_USER_CLASS.ID }, true);
        public static Index I_USER_CLASS_UK_USER_CLASS_ID = Internal.createIndex("uk_user_class_id", IUserClass.I_USER_CLASS, new OrderField[] { IUserClass.I_USER_CLASS.USER_ID, IUserClass.I_USER_CLASS.CLASS_ID }, true);
        public static Index I_USER_ROLE_PRIMARY = Internal.createIndex("PRIMARY", IUserRole.I_USER_ROLE, new OrderField[] { IUserRole.I_USER_ROLE.ID }, true);
        public static Index I_USER_ROLE_UK_USER_ID_ROLE = Internal.createIndex("uk_user_id_role", IUserRole.I_USER_ROLE, new OrderField[] { IUserRole.I_USER_ROLE.USER_ID, IUserRole.I_USER_ROLE.ROLE }, true);
        public static Index I_USER_STUDENT_PRIMARY = Internal.createIndex("PRIMARY", IUserStudent.I_USER_STUDENT, new OrderField[] { IUserStudent.I_USER_STUDENT.ID }, true);
        public static Index I_USER_STUDENT_UK_USER_STUDENT_ID = Internal.createIndex("uk_user_student_id", IUserStudent.I_USER_STUDENT, new OrderField[] { IUserStudent.I_USER_STUDENT.USER_ID, IUserStudent.I_USER_STUDENT.STUDENT_ID }, true);
    }
}
