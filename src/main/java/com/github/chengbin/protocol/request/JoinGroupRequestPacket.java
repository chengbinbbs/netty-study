package com.github.chengbin.protocol.request;

import com.github.chengbin.protocol.Packet;

import static com.github.chengbin.protocol.command.Command.JOIN_GROUP_REQUEST;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class JoinGroupRequestPacket extends Packet {

    private String groupId;



    @Override
    public Byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
