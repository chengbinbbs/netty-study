
package com.github.chengbin.protocol.command;

import io.netty.channel.Channel;
import com.github.chengbin.protocol.request.ListGroupMembersRequestPacket;

import java.util.Scanner;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/8.
 */
public class ListGroupMembersConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket requestPacket = new ListGroupMembersRequestPacket();

        System.out.print("输入 groupId，获取群成员列表：");
        String groupId = scanner.next();

        requestPacket.setGroupId(groupId);

        channel.writeAndFlush(requestPacket);

    }
}
