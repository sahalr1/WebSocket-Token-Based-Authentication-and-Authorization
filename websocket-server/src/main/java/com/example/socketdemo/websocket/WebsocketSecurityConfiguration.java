package com.example.socketdemo.websocket;

//import io.github.jhipster.sample.security.AuthoritiesConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

@Configuration
public class WebsocketSecurityConfiguration extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
    	
    	
    	

    	messages.
        simpDestMatchers("/user/topic/reply").hasAuthority("ROLE_teacher").anyMessage().authenticated();

    }
    
    
    @Override
    protected boolean sameOriginDisabled() {
        return true;
    }
}
