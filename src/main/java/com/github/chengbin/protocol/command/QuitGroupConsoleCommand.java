package com.github.chengbin.protocol.command;

import io.netty.channel.Channel;
import com.github.chengbin.protocol.request.QuitGroupRequestPacket;

import java.util.Scanner;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class QuitGroupConsoleCommand implements ConsoleCommand {


    @Override
    public void exec(Scanner scanner, Channel channel) {

        QuitGroupRequestPacket requestPacket = new QuitGroupRequestPacket();
        System.out.println("输入groupId,退出群聊:");

        String groupId = scanner.next();
        requestPacket.setGroupId(groupId);
        channel.writeAndFlush(requestPacket);
    }
}
