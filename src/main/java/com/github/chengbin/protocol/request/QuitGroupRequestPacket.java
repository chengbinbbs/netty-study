package com.github.chengbin.protocol.request;

import com.github.chengbin.protocol.Packet;
import com.github.chengbin.protocol.command.Command;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class QuitGroupRequestPacket extends Packet {

    private String groupId;


    @Override
    public Byte getCommand() {
        return Command.QUIT_GROUP_REQUEST;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
