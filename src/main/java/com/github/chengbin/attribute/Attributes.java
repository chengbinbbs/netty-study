package com.github.chengbin.attribute;

import io.netty.util.AttributeKey;
import com.github.chengbin.session.Session;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
