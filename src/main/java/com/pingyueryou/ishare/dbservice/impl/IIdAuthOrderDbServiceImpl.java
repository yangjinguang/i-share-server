package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IIdAuthOrderDbService;
import com.pingyueryou.ishare.entity.IIdAuthOrderExtra;
import com.pingyueryou.ishare.entity.IdAuthOrderStatus;
import com.pingyueryou.ishare.entity.Role;
import com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder;
import com.pingyueryou.ishare.jooq.tables.records.IIdAuthOrderRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IIdAuthOrder.I_ID_AUTH_ORDER;
import static com.pingyueryou.ishare.jooq.tables.IUser.I_USER;

@Service
public class IIdAuthOrderDbServiceImpl implements IIdAuthOrderDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IIdAuthOrder create(IIdAuthOrder order) {
        IIdAuthOrderRecord iIdAuthOrderRecord = context.newRecord(I_ID_AUTH_ORDER, order);
        iIdAuthOrderRecord.store();
        return iIdAuthOrderRecord.into(IIdAuthOrder.class);
    }

    @Override
    public Integer countTeacherOrders() {
        return context.selectCount().from(I_ID_AUTH_ORDER)
                .where(I_ID_AUTH_ORDER.ROLE.eq(Role.TEACHER.getIndex()))
                .and(I_ID_AUTH_ORDER.STATUS.eq(IdAuthOrderStatus.NEW.getIndex()))
                .fetchOne()
                .into(Integer.class);
    }

    @Override
    public List<IIdAuthOrderExtra> getTeacherOrders() {
        return context.select(I_ID_AUTH_ORDER.fields())
                .select(I_USER.NICK_NAME.as("nickName"))
                .from(I_ID_AUTH_ORDER)
                .leftJoin(I_USER)
                .on(I_USER.ID.eq(I_ID_AUTH_ORDER.USER_ID))
                .where(I_ID_AUTH_ORDER.ROLE.eq(Role.TEACHER.getIndex()))
                .and(I_ID_AUTH_ORDER.STATUS.eq(IdAuthOrderStatus.NEW.getIndex()))
                .fetch()
                .into(IIdAuthOrderExtra.class);
    }

    @Override
    public Integer countParentOrders(List<Long> classIds) {
        return context.selectCount().from(I_ID_AUTH_ORDER)
                .where(I_ID_AUTH_ORDER.ROLE.eq(Role.PARENT.getIndex()))
                .and(I_ID_AUTH_ORDER.CLASS_ID.in(classIds))
                .and(I_ID_AUTH_ORDER.STATUS.eq(IdAuthOrderStatus.NEW.getIndex()))
                .fetchOne()
                .into(Integer.class);
    }

    @Override
    public List<IIdAuthOrderExtra> getParentOrders(List<Long> classIds) {
        return context.select(I_ID_AUTH_ORDER.fields())
                .select(I_USER.NICK_NAME.as("nickName"))
                .from(I_ID_AUTH_ORDER)
                .leftJoin(I_USER)
                .on(I_USER.ID.eq(I_ID_AUTH_ORDER.USER_ID))
                .where(I_ID_AUTH_ORDER.ROLE.eq(Role.PARENT.getIndex()))
                .and(I_ID_AUTH_ORDER.CLASS_ID.in(classIds))
                .and(I_ID_AUTH_ORDER.STATUS.eq(IdAuthOrderStatus.NEW.getIndex()))
                .fetch()
                .into(IIdAuthOrderExtra.class);
    }

    @Override
    public IIdAuthOrderExtra get(Long id) {
        Record nickName = context.select(I_ID_AUTH_ORDER.fields())
                .select(I_USER.NICK_NAME.as("nickName"))
                .from(I_ID_AUTH_ORDER)
                .leftJoin(I_USER)
                .on(I_USER.ID.eq(I_ID_AUTH_ORDER.USER_ID))
                .where(I_ID_AUTH_ORDER.ID.eq(id))
                .fetchOptional()
                .orElse(null);
        if (nickName != null) {
            return nickName.into(IIdAuthOrderExtra.class);
        }
        return null;
    }

    @Override
    public void changeStatus(Long orderId, Integer status) {
        context.update(I_ID_AUTH_ORDER)
                .set(I_ID_AUTH_ORDER.STATUS, status)
                .where(I_ID_AUTH_ORDER.ID.eq(orderId))
                .execute();
    }
}
