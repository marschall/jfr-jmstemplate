package com.github.marschall.jfr.jmstemplate;

import static org.junit.Assert.assertEquals;

import javax.jms.ConnectionFactory;

import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;

public class JfrJmsOperationsTest {

  @Rule
  public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();

  private JmsOperations jmsOperations;

  @Before
  public void setUp() {
    ConnectionFactory connectionFactory = this.broker.createConnectionFactory();
    this.jmsOperations = new JfrJmsOperations(new JmsTemplate(connectionFactory));
  }

  @Test
  public void simpleOperations() {
    String destinationName = "sample.destination";
    String message = "hello";
    this.jmsOperations.convertAndSend(destinationName, message);
    Object received = this.jmsOperations.receiveAndConvert(destinationName);
    assertEquals(message, received);
  }

}
