package com.rejola.BProject.shared;

import com.rejola.BProject.master.user.User;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Constant {

    static ConcurrentHashMap<UUID, User> userHashMap  = null;
}
