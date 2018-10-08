package com.github.chengbin.protocol.request;

import com.github.chengbin.protocol.Packet;
import com.github.chengbin.protocol.command.Command;

import java.util.List;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIds;

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_REQUEST;
    }
}
