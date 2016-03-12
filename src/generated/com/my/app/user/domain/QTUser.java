package com.my.app.user.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTUser is a Querydsl query type for TUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTUser extends EntityPathBase<TUser> {

    private static final long serialVersionUID = -97284010L;

    public static final QTUser tUser = new QTUser("tUser");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final BooleanPath isAdminYn = createBoolean("isAdminYn");

    public final DateTimePath<java.sql.Timestamp> updatedAt = createDateTime("updatedAt", java.sql.Timestamp.class);

    public final StringPath USER_NAME = createString("USER_NAME");

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> userType = createNumber("userType", Integer.class);

    public QTUser(String variable) {
        super(TUser.class, forVariable(variable));
    }

    public QTUser(Path<? extends TUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTUser(PathMetadata<?> metadata) {
        super(TUser.class, metadata);
    }

}

