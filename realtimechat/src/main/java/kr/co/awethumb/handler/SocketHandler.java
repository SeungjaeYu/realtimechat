package kr.co.awethumb.handler;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.InitializingBean;

import org.springframework.web.socket.CloseStatus;

import org.springframework.web.socket.TextMessage;

import org.springframework.web.socket.WebSocketMessage;

import org.springframework.web.socket.WebSocketSession;

import org.springframework.web.socket.handler.TextWebSocketHandler;

 

public class SocketHandler extends TextWebSocketHandler implements InitializingBean {

 


       private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();

 

      

       public SocketHandler (){

             super();


       }

 

       @Override

       public void afterConnectionClosed(WebSocketSession session,

                    CloseStatus status) throws Exception {

             super.afterConnectionClosed(session, status);

 

             sessionSet.remove(session);


       }

 

       @Override

       public void afterConnectionEstablished(WebSocketSession session)

                    throws Exception {

             super.afterConnectionEstablished(session);

 

             sessionSet.add(session);


       }

 

       @Override

       public void handleMessage(WebSocketSession session,

                    WebSocketMessage<?> message) throws Exception {

             super.handleMessage(session, message);

            


       }

 

       @Override

       public void handleTransportError(WebSocketSession session,

                    Throwable exception) throws Exception {


       }

 

       @Override

       public boolean supportsPartialMessages() {


            

             return super.supportsPartialMessages();

       }

      

       public void sendMessage (String message){

             for (WebSocketSession session: this.sessionSet){

                    if (session.isOpen()){

                           try{

                                 session.sendMessage(new TextMessage(message));

                           }catch (Exception ignored){


                           }

                    }

             }

       }

 

       @Override
       public void afterPropertiesSet() throws Exception {

    	   sendMessage("전송 완료");
 


       }

 

}
