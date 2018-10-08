package com.github.chengbin.protocol.response;

import com.github.chengbin.protocol.Packet;

import static com.github.chengbin.protocol.command.Command.JOIN_GROUP_RESPONSE;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class JoinGroupResponsePacket extends Packet {

    private boolean success;

    private String groupId;

    private String reason;

    public JoinGroupResponsePacket() {
    }

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_RESPONSE;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
