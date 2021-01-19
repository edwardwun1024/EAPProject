package com.edward.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author wangcheng
 * @date 2020/5/26 13:44
 */
public class KafkaTool {

    private final static Logger LOGGER = LoggerFactory.getLogger(KafkaTool.class);
    //ProducerConfig
    public static final String BOOTSTRAP_SERVERS_CONFIG = "bootstrap.servers";
    public static final String KEY_SERIALIZER_CLASS_CONFIG = "key.serializer";
    public static final String VALUE_SERIALIZER_CLASS_CONFIG = "value.serializer";
    public static final String ACKS_CONFIG = "acks";
    public static final String RETRIES_CONFIG = "retries";
    public static final String BATCH_SIZE_CONFIG = "batch.size";
    public static final String BUFFER_MEMORY_CONFIG = "buffer.memory";

    public String kafka_bootstrap_servers ="10.151.144.30:9092";
    public String enableSsl = "true";
    public String mechanism = "PLAIN";
    public String protocol = "SASL_PLAINTEXT";


    /**
     * 根据指定的topic发送kafka消息
     * @param topic 名称
     * @param msg 消息体
     */
    public void send(String topic, String msg) {
        Properties props = new Properties();
        props.put(BOOTSTRAP_SERVERS_CONFIG, kafka_bootstrap_servers);
        props.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ACKS_CONFIG, "0");
        if(StringUtils.equalsIgnoreCase("true", enableSsl)) {
            props.put("sasl.mechanism", mechanism);
            props.put("security.protocol", protocol);
        }

        props.put("sasl.jaas.config",
                "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin\";");

        // 如果请求失败，生产者会自动重试，我们指定是0次，如果启用重试，则会有重复消息的可能性
        props.put(RETRIES_CONFIG, 0);
        props.put(BATCH_SIZE_CONFIG, 4096);
        props.put(BUFFER_MEMORY_CONFIG, 40960);

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        ProducerRecord<String, String> producerRecord = new ProducerRecord(topic, msg);

        LOGGER.info("send kafka start");
        LOGGER.info("topic : " + producerRecord.topic());
        LOGGER.info("msg : " + producerRecord.value());
        producer.send(producerRecord,
                new org.apache.kafka.clients.producer.Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception e) {
                        if (e != null) {
                            System.out.println("onCompletion exception");
                            e.printStackTrace();
                        }
                        System.out.println("The offset of the record we just sent is: " + metadata);
                    }
                });

        LOGGER.info("close producer");
        producer.close();
        LOGGER.info("send kafka end");

    }

    /**
     * 监听发送已发送的kafka消息
     */
    public void recieve(String groupId, String topic){
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", kafka_bootstrap_servers);
        props.setProperty("group.id", groupId);
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        if(StringUtils.equalsIgnoreCase("true", enableSsl)) {
            props.put("sasl.mechanism", mechanism);
            props.put("security.protocol", protocol);
        }
        props.put("sasl.jaas.config",
                "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin\";");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        //可订阅多个topic
//        consumer.subscribe(Arrays.asList("topic1","topic2"));
        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }

    @Test
    public void testSendKafa(){
        String topic = "CityRawEvent";
        String msg = cityRawEventString();
            send(topic,msg);

//        System.out.println("下面时接收到的消息");
//        recieve("sensebi-kafka-group","KeeperRawEvent");
    }


    public String cityRawEventString(){
        String bodyString = "{\"eventName\":\"senseyeRegionEvent\",\"eventAction\":\"patternDetected\",\"data\":{\"type\":\"1\",\"trackId\":\"49392\",\"image\":\"http://10.151.144.30/intersense/images/structural/20210118/1348900369647800322|1348900759483191297/event/1348900369647800322|1348900759483191297_1610438017640181748_220_13374_1_1610939803765.jpg\",\"timestamp\":\"2021-01-18 11:28:00\",\"boundingBox\":{\"top\":33,\"right\":873,\"bottom\":568,\"left\":659},\"camera\":{\"id\":\"1348900369647800322\"},\"eventRoiId\":\"1610438017640181748\",\"attributes\":[{\"value\":\"1\",\"conf\":0.9523270130157471,\"key\":\"-1\"}]}}";
        return bodyString;
    }


}
