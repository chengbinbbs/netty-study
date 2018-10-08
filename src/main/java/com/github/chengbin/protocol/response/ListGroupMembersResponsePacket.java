package com.github.chengbin.protocol.response;

import com.github.chengbin.protocol.command.Command;
import com.github.chengbin.protocol.Packet;
import com.github.chengbin.session.Session;

import java.util.List;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
public class ListGroupMembersResponsePacket extends Packet {


    private List<Session> sessionList;

    private String groupId;

    @Override
    public Byte getCommand() {
        return Command.LIST_GROUP_MEMBERS_RESPONSE;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }
}
