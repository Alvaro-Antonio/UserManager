package com.usermanager.group.services;

import com.usermanager.group.jpa.Group;

import java.util.List;

@FunctionalInterface
public interface GetGroupService {
    List<Group> getGroup();
}
