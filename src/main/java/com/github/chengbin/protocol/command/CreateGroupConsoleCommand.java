package com.github.chengbin.protocol.command;

import io.netty.channel.Channel;
import com.github.chengbin.protocol.request.CreateGroupRequestPacket;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zhangcb
 * @Description:
 * @Date: Created on 2018/10/7.
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {

    private static final String USER_ID_SPLITER = ",";

    @Override
    public void exec(Scanner scanner, Channel channel) {

        CreateGroupRequestPacket requestPacket = new CreateGroupRequestPacket();

        System.out.print("【拉人群聊】输入 userId 列表，userId 之间英文逗号隔开：");

        String userIds = scanner.next();
        requestPacket.setUserIds(Arrays.asList(userIds.split(USER_ID_SPLITER)));
        channel.writeAndFlush(requestPacket);
    }
}
