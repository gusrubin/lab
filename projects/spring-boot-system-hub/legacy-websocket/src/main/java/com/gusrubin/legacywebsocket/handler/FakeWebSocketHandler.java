package com.gusrubin.legacywebsocket.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author Gustavo Rubin
 */
public class FakeWebSocketHandler extends TextWebSocketHandler {

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    // Assim que o cliente conectar, manda uma mensagem fake
    session.sendMessage(new TextMessage("Conexão estabelecida com servidor FAKE 🚀"));
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    // Qualquer mensagem recebida será ecoada + resposta fake
    String payload = message.getPayload();
    session.sendMessage(new TextMessage("Eco: " + payload));
    session.sendMessage(new TextMessage("Mensagem fake do servidor ✅"));
  }
}
