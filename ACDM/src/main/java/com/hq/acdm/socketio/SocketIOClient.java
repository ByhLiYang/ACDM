package com.hq.acdm.socketio;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import lombok.extern.slf4j.Slf4j;

import java.net.URISyntaxException;

/**
 * @author LiFaQiang
 * @date 2019/10/30 10:14
 * @Description
 */
@Slf4j
public class SocketIOClient {
    public static String socketurl = "http://172.26.77.195:9999";
    public static Socket socket = null;
    public static Socket getSocket(){
        if (null!=socket){
            return socket;
        }
        IO.Options options = new IO.Options();
        options.transports = new String[]{"websocket"};
        options.reconnectionAttempts = 2;
        options.reconnectionDelay = 1000;//失败重连的时间间隔
        options.timeout = 500;//连接超时时间(ms)
        try {
            socket = IO.socket(socketurl, options);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            public void call(Object... args) {
                socket.send("我是web客户端，我上线了");
            }
        });
        socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                log.debug("我是web客户端，我已下线！");
            }
        });
        socket.connect();
        return socket;
    }
    public static void main(String[] args) {
        Socket socket = SocketIOClient.getSocket();
       // socket.emit("messageevent","web集成测试");
        //弹出事件op1，CTOT互换
        socket.emit("popupevent", "{\"airlines\":\"HU\",\"airlinestwo\":\"GS\",\"controlId\":\"135544\",\"ctot\":\"2021-03-22 22:51:00\",\"ctottwo\":\"2021-03-22 23:15:00\",\"department\":\"IGO\",\"execDate\":\"2021-03-22\",\"flid\":\"2055793\",\"flidtwo\":\"2055776\",\"flno\":\"HU7662\",\"flnotwo\":\"GS7859\",\"isnew\":\"1\",\"op\":\"1\"}");
        //弹出事件op2，航班不正常事件，晚到，晚退出，晚登机
        socket.emit("popupevent", "{\"department\":\"IGO\",\"execDate\":\"2021-03-28\",\"flag\":\"0\",\"flid\":\"2068024\",\"flno\":\"MF8486\",\"isnew\":\"1\",\"op\":\"2\",\"type\":\"closeDoor\",\"typename\":\"关门\"}");
        //弹出事件op3，撤轮挡后8分不移交
        socket.emit("popupevent", "{\"aobt\":\"2021-03-29 00:06:00\",\"department\":\"IGO\",\"execDate\":\"2021-03-28\",\"flid\":\"2068024\",\"flno\":\"MF8486\",\"isnew\":\"1\",\"nums\":\"8\",\"op\":\"3\"}");

        //弹出事件op4，优先排快速机位
        socket.emit("popupevent", "{\"aobt\":1616050260000,\"department\":\"CSN\",\"execDate\":1615996800000,\"flid\":2049356,\"flno\":\"CZ6433\",\"stand\":\"306\",\"nums\":16,\"op\":\"4\"}");
        //独立事件，优先排快速机位
        socket.emit("standRanking", "{\"jsonMsg\":[{\"aobt\":1616050260000,\"department\":\"CSN\",\"execDate\":1615996800000,\"flid\":2049356,\"flno\":\"CZ6433\",\"stand\":\"306\",\"nums\":16,\"op\":\"4\"}]}");

    }
}
