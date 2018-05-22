package com.rulexu.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;
@Component
@ServerEndpoint("/webSocket")
public class WebSocketService {
    private final static Logger logger = LoggerFactory.getLogger(WebSocketService.class);
    private Session session;

    private static CopyOnWriteArraySet<WebSocketService> webSockets = new CopyOnWriteArraySet<WebSocketService>();


    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);

    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
    }


    @OnMessage
    public void onMessage(String message) {

    }

    public void sendMessage(String message) {
        for (WebSocketService webSocket : webSockets) {
            try {
                if(webSocket.session.isOpen()){
                    webSocket.session.getBasicRemote().sendText(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
