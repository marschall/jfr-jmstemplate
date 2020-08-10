JFR JmsTemplate [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/jfr-jmstemplate/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/jfr-jmstemplate) [![Javadocs](https://www.javadoc.io/badge/com.github.marschall/jfr-jmstemplate.svg)](https://www.javadoc.io/doc/com.github.marschall/jfr-jmstemplate) [![Build Status](https://travis-ci.org/marschall/jfr-jmstemplate.svg?branch=master)](https://travis-ci.org/marschall/jfr-jmstemplate)
===============

An implementation of Spring [JmsTemplate](https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#jms-jmstemplate) that generates [Flight Recorder](https://openjdk.java.net/jeps/328) events.

This project requires Java 11 based on OpenJDK or later.

```xml
<dependency>
  <groupId>com.github.marschall</groupId>
  <artifactId>jfr-jmstemplate</artifactId>
  <version>0.1.0</version>
</dependency>
```

![Flight Recording of a JUnit Test](https://github.com/marschall/jfr-jmstemplate/raw/master/src/main/javadoc/screenshot.png)

Compared to approaches based on `ConnectionFactory` an approach based on `JmsTemplate` has the advantage that it captures a complete queue interaction. A `JmsTemplate` based approach generates a single JFR event for an entire message queue interaction that involves several JMS method invocations.

Overhead
--------

We try to keep overhead to a minimum and have no additional allocations besides the JFR events. Besides the overhead of the event the only additional overhead is

* a wrapper around `JmsTemplate`
* a few `instanceof` operations and casts
* a `finally` block

We assume `javax.jms.Queue#getQueueName()` and `javax.jms.Topic#getTopicName()` are simple getters.

Usage
-----

```java
@Configuration
public class JmsConfiguration {

   @Autowired
   private ConnectionFactory connectionFactory;

   @Bean
   public JmsOperations jmsOperations() {
     return new JfrJmsOperations(new JmsTemplate(this.connectionFactory));
   }

}
```

Limitations
-----------

* We can not intercept `JmsTemplate#setDefaultDestination(Destination)` or `JmsTemplate#setDefaultDestinationName(String)` so for operations on the default destination we can not report the destination name.
