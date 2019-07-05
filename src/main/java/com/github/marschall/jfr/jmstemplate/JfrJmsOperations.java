package com.github.marschall.jfr.jmstemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.jms.JmsException;
import org.springframework.jms.core.BrowserCallback;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.jms.core.ProducerCallback;
import org.springframework.jms.core.SessionCallback;

import jdk.jfr.Category;
import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;
/**
 * An implementation of {@link JmsOperations} that generates JFR events.
 * The events are generated in the "Spring JMS" category.
 */
public final class JfrJmsOperations implements JmsOperations {

  private final JmsOperations delegate;

  public JfrJmsOperations(JmsOperations delegate) {
    this.delegate = delegate;
  }

  @Override
  public <T> T execute(SessionCallback<T> action) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("execute");
    event.begin();
    try {
      return this.delegate.execute(action);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public <T> T execute(ProducerCallback<T> action) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("execute");
    event.begin();
    try {
      return this.delegate.execute(action);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public <T> T execute(Destination destination, ProducerCallback<T> action) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("execute");
    event.setDestinationName(getDestinationName(destination));
    event.begin();
    try {
      return this.delegate.execute(destination, action);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public <T> T execute(String destinationName, ProducerCallback<T> action) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("execute");
    event.setDestinationName(destinationName);
    event.begin();
    try {
      return this.delegate.execute(destinationName, action);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public void send(MessageCreator messageCreator) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("send");
    event.begin();
    try {
      this.delegate.send(messageCreator);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public void send(Destination destination, MessageCreator messageCreator) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("send");
    event.setDestinationName(getDestinationName(destination));
    event.begin();
    try {
      this.delegate.send(destination, messageCreator);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public void send(String destinationName, MessageCreator messageCreator) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("send");
    event.setDestinationName(destinationName);
    event.begin();
    try {
      this.delegate.send(destinationName, messageCreator);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public void convertAndSend(Object message) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("convertAndSend");
    event.begin();
    try {
      this.delegate.convertAndSend(message);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public void convertAndSend(Destination destination, Object message) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("convertAndSend");
    event.setDestinationName(getDestinationName(destination));
    event.begin();
    try {
      this.delegate.convertAndSend(destination, message);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public void convertAndSend(String destinationName, Object message) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("convertAndSend");
    event.setDestinationName(destinationName);
    event.begin();
    try {
      this.delegate.convertAndSend(destinationName, message);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public void convertAndSend(Object message, MessagePostProcessor postProcessor) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("convertAndSend");
    event.begin();
    try {
      this.delegate.convertAndSend(message, postProcessor);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public void convertAndSend(Destination destination, Object message, MessagePostProcessor postProcessor)
      throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("convertAndSend");
    event.setDestinationName(getDestinationName(destination));
    event.begin();
    try {
      this.delegate.convertAndSend(destination, message, postProcessor);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public void convertAndSend(String destinationName, Object message, MessagePostProcessor postProcessor)
      throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("convertAndSend");
    event.setDestinationName(destinationName);
    event.begin();
    try {
      this.delegate.convertAndSend(destinationName, message, postProcessor);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Message receive() throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receive");
    event.begin();
    try {
      return this.delegate.receive();
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Message receive(Destination destination) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receive");
    event.setDestinationName(getDestinationName(destination));
    event.begin();
    try {
      return this.delegate.receive(destination);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Message receive(String destinationName) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receive");
    event.setDestinationName(destinationName);
    event.begin();
    try {
      return this.delegate.receive(destinationName);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Message receiveSelected(String messageSelector) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receiveSelected");
    event.setMessageSelector(messageSelector);
    event.begin();
    try {
      return this.delegate.receiveSelected(messageSelector);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Message receiveSelected(Destination destination, String messageSelector) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receiveSelected");
    event.setDestinationName(getDestinationName(destination));
    event.setMessageSelector(messageSelector);
    event.begin();
    try {
      return this.delegate.receiveSelected(destination, messageSelector);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Message receiveSelected(String destinationName, String messageSelector) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receiveSelected");
    event.setDestinationName(destinationName);
    event.setMessageSelector(messageSelector);
    event.begin();
    try {
      return this.delegate.receiveSelected(destinationName, messageSelector);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Object receiveAndConvert() throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receiveSelectedAndConvert");
    event.begin();
    try {
      return this.delegate.receiveAndConvert();
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Object receiveAndConvert(Destination destination) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receiveSelectedAndConvert");
    event.setDestinationName(getDestinationName(destination));
    event.begin();
    try {
      return this.delegate.receiveAndConvert(destination);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Object receiveAndConvert(String destinationName) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receiveSelectedAndConvert");
    event.setDestinationName(destinationName);
    event.begin();
    try {
      return this.delegate.receiveAndConvert(destinationName);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Object receiveSelectedAndConvert(String messageSelector) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receiveSelectedAndConvert");
    event.setMessageSelector(messageSelector);
    event.begin();
    try {
      return this.delegate.receiveSelectedAndConvert(messageSelector);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Object receiveSelectedAndConvert(Destination destination, String messageSelector) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receiveSelectedAndConvert");
    event.setDestinationName(getDestinationName(destination));
    event.setMessageSelector(messageSelector);
    event.begin();
    try {
      return this.delegate.receiveSelectedAndConvert(destination, messageSelector);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Object receiveSelectedAndConvert(String destinationName, String messageSelector) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("receiveSelectedAndConvert");
    event.setDestinationName(destinationName);
    event.setMessageSelector(messageSelector);
    event.begin();
    try {
      return this.delegate.receiveSelectedAndConvert(destinationName, messageSelector);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Message sendAndReceive(MessageCreator messageCreator) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("sendAndReceive");
    event.begin();
    try {
      return this.delegate.sendAndReceive(messageCreator);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Message sendAndReceive(Destination destination, MessageCreator messageCreator) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("sendAndReceive");
    event.setDestinationName(getDestinationName(destination));
    event.begin();
    try {
      return this.delegate.sendAndReceive(destination, messageCreator);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public Message sendAndReceive(String destinationName, MessageCreator messageCreator) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("sendAndReceive");
    event.setDestinationName(destinationName);
    event.begin();
    try {
      return this.delegate.sendAndReceive(destinationName, messageCreator);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public <T> T browse(BrowserCallback<T> action) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("browse");
    event.begin();
    try {
      return this.delegate.browse(action);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public <T> T browse(Queue queue, BrowserCallback<T> action) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("browse");
    event.setDestinationName(getDestinationName(queue));
    event.begin();
    try {
      return this.delegate.browse(queue, action);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public <T> T browse(String queueName, BrowserCallback<T> action) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("browse");
    event.setDestinationName(queueName);
    event.begin();
    try {
      return this.delegate.browse(queueName, action);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public <T> T browseSelected(String messageSelector, BrowserCallback<T> action) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("browseSelected");
    event.setMessageSelector(messageSelector);
    event.begin();
    try {
      return this.delegate.browseSelected(messageSelector, action);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public <T> T browseSelected(Queue queue, String messageSelector, BrowserCallback<T> action) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("browseSelected");
    event.setDestinationName(getDestinationName(queue));
    event.setMessageSelector(messageSelector);
    event.begin();
    try {
      return this.delegate.browseSelected(queue, messageSelector, action);
    } finally {
      event.end();
      event.commit();
    }
  }

  @Override
  public <T> T browseSelected(String queueName, String messageSelector, BrowserCallback<T> action) throws JmsException {
    JmsEvent event = new JmsEvent();
    event.setOperationName("browseSelected");
    event.setDestinationName(queueName);
    event.setMessageSelector(messageSelector);
    event.begin();
    try {
      return this.delegate.browseSelected(queueName, messageSelector, action);
    } finally {
      event.end();
      event.commit();
    }
  }

  private static String getDestinationName(Destination destination) {
    try {
      if (destination instanceof Queue) {
        return ((Queue) destination).getQueueName();
      } else if (destination instanceof Topic) {
        return ((Topic) destination).getTopicName();
      }
    } catch (JMSException e) {
      return "<JMSException>";
    }
    return null;
  }

  @Label("Operation")
  @Description("A JMS Operation")
  @Category("Spring JMS")
  static class JmsEvent extends Event {

    @Label("Operation Name")
    @Description("The name of the JDBC operation")
    private String operationName;

    @Label("Destination Name")
    @Description("The name of the Queue or Topic")
    private String destinationName;
    
    @Label("Message Selector")
    @Description("The message selector")
    private String messageSelector;

    String getOperationName() {
      return this.operationName;
    }

    void setOperationName(String operationName) {
      this.operationName = operationName;
    }

    String getDestinationName() {
      return this.destinationName;
    }

    void setDestinationName(String destinationName) {
      this.destinationName = destinationName;
    }

    String getMessageSelector() {
      return this.messageSelector;
    }

    void setMessageSelector(String messageSelector) {
      this.messageSelector = messageSelector;
    }

  }

}
