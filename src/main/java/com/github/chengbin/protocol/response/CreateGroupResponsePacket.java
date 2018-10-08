package com.github.chengbin.protocol.response;

import com.github.chengbin.protocol.Packet;
import com.github.chengbin.protocol.command.Command;

import java.util.List;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class CreateGroupResponsePacket extends Packet {

    private String groupId;     //群聊id

    private List<String> usernames;

    private boolean success;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
