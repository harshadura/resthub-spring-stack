package org.resthub.identity.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.core.domain.dao.ResourceDao;
import org.resthub.core.domain.model.User;
import org.resthub.core.service.impl.AbstractResourceServiceImpl;

@Named("userService")
public class UserServiceImpl extends AbstractResourceServiceImpl<User> {

    @Override
    @Inject
    @Named("userDao")
    public void setResourceDao(ResourceDao<User> resourceDao) {
        super.setResourceDao(resourceDao);
    }

}