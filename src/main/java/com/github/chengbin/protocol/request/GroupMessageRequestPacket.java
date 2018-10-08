package com.github.chengbin.protocol.request;

import com.github.chengbin.protocol.Packet;

import static com.github.chengbin.protocol.command.Command.GROUP_MESSAGE_REQUEST;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
public class GroupMessageRequestPacket extends Packet {

    private String groupId;

    private String message;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
