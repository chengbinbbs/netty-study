package com.github.chengbin.protocol.response;

import com.github.chengbin.protocol.Packet;
import com.github.chengbin.protocol.command.Command;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class QuitGroupResponsePacket extends Packet {

    private boolean success;

    private String groupId;

    private String reason;

    @Override
    public Byte getCommand() {
        return Command.QUIT_GROUP_RESPONSE;
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
