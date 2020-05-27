package com.edward.common;

//import org.apache.commons.lang3.StringUtils;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.clients.producer.*;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;

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

//    private final static Logger LOGGER = LoggerFactory.getLogger(KafkaTool.class);

    /**
     * 根据指定的topic发送kafka消息
     * @param topic 名称
     * @param msg 消息体
     * @param key 用于标记发送的消息
     */
//    public void send(String topic, String msg, String key) {
//        Properties props = new Properties();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, CommonSettings.config."kafka_bootstrap_servers");
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.ACKS_CONFIG, "0");
//        if(StringUtils.equalsIgnoreCase("true", CommonSettings.config."kafka_enableSsl")) {
//            props.put("sasl.mechanism", CommonSettings.config."kafka_mechanism");
//            props.put("security.protocol", CommonSettings.config."kafka_security_protocol");
//        }
//
//        props.put("sasl.jaas.config",
//                "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin\";");
//
//        // 如果请求失败，生产者会自动重试，我们指定是0次，如果启用重试，则会有重复消息的可能性
//        props.put(ProducerConfig.RETRIES_CONFIG, 0);
//        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 4096);
//        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 40960);
//
//        Producer<String, String> producer = new KafkaProducer<String, String>(props);
//        ProducerRecord<String, String> producerRecord = new ProducerRecord(topic, msg);
//
//        System.out.println("send kafka start");
//        System.out.println("topic : " + producerRecord.topic());
//        System.out.println("msg : " + producerRecord.value())
//        producer.send(producerRecord,
//                new org.apache.kafka.clients.producer.Callback() {
//                    @Override
//                    public void onCompletion(RecordMetadata metadata, Exception e) {
//                        if (e != null) {
//                            System.out.println("onCompletion exception");
//                            e.printStackTrace();
//                        }
//                        System.out.println("The offset of the record we just sent is: " + metadata);
//                    }
//                });
//
//        System.out.println("close producer");
//        producer.close();
//        System.out.println("send kafka end")
//
//    }
//
//    /**
//     * 监听发送已发送的kafka消息
//     */
//    public void recieve(String groupId, String topic){
//        Properties props = new Properties();
//        props.setProperty("bootstrap.servers", CommonSettings.config."kafka_bootstrap_servers");
//        props.setProperty("group.id", groupId);
//        props.setProperty("enable.auto.commit", "true");
//        props.setProperty("auto.commit.interval.ms", "1000");
//        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        if(StringUtils.equalsIgnoreCase("true", CommonSettings.config."kafka_enableSsl")) {
//            props.put("sasl.mechanism", CommonSettings.config."kafka_mechanism");
//            props.put("security.protocol", CommonSettings.config."kafka_security_protocol");
//        }
//        props.put("sasl.jaas.config",
//                "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"admin\";");
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//        //可订阅多个topic
////        consumer.subscribe(Arrays.asList("topic1","topic2"));
//        consumer.subscribe(Arrays.asList(topic));
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100))
//            for (ConsumerRecord<String, String> record : records)
//                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//        }
//    }
//
//    @Test
//    public void testSendKafa(){
//        String topic = "FaceRawImage";
//        String msg = "{\n" +
//                "  \"data\": {\n" +
//                "    \"attributes\": [\n" +
//                "      {\n" +
//                "        \"conf\": 0.7843137254901961,\n" +
//                "        \"key\": \"-1\",\n" +
//                "        \"value\": \"1\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"conf\": 0.7843137254901961,\n" +
//                "        \"key\": \"57\",\n" +
//                "        \"value\": \"32\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"conf\": 0.7843137254901961,\n" +
//                "        \"key\": \"4\",\n" +
//                "        \"value\": \"0\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"conf\": 0.7843137254901961,\n" +
//                "        \"key\": \"5\",\n" +
//                "        \"value\": \"0\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"conf\": 0.7843137254901961,\n" +
//                "        \"key\": \"27\",\n" +
//                "        \"value\": \"3\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"conf\": 0.7843137254901961,\n" +
//                "        \"key\": \"55\",\n" +
//                "        \"value\": \"0\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"conf\": 0.7843137254901961,\n" +
//                "        \"key\": \"76\",\n" +
//                "        \"value\": \"2\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"conf\": 0.7843137254901961,\n" +
//                "        \"key\": \"56\",\n" +
//                "        \"value\": \"8\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"conf\": 0.7843137254901961,\n" +
//                "        \"key\": \"56\",\n" +
//                "        \"value\": \"10\"\n" +
//                "      }\n" +
//                "    ],\n" +
//                "    \"camera\": {\n" +
//                "      \"privilege\": \"0,1,2,3,4\",\n" +
//                "      \"referId\": \"1263745839575076865\",\n" +
//                "      \"type\": \"-1\"\n" +
//                "    },\n" +
//                "    \"capturedTime\": \"2020-05-26 15:29:04\",\n" +
//                "    \"detectTaskInfos\": [\n" +
//                "      {\n" +
//                "        \"recognisedInfos\": [\n" +
//                "          {\n" +
//                "            \"similars\": [\n" +
//                "              {\n" +
//                "                \"score\": \"\",\n" +
//                "                \"target\": {\n" +
//                "                  \"aliasname\": \"\",\n" +
//                "                  \"name\": \"\",\n" +
//                "                  \"personType\": \"\",\n" +
//                "                  \"serial\": \"\",\n" +
//                "                  \"tarLibName\": \"\",\n" +
//                "                  \"tarLibSerial\": \"\",\n" +
//                "                  \"url\": \"\"\n" +
//                "                }\n" +
//                "              }\n" +
//                "            ]\n" +
//                "          }\n" +
//                "        ]\n" +
//                "      }\n" +
//                "    ],\n" +
//                "    \"faceImageTag\": \"passer\",\n" +
//                "    \"faceInfo\": {\n" +
//                "      \"image\": {\n" +
//                "        \"url\": \"/images/camera/20200525/HumanFace_220200525155909754_3282350_7115.jpg\"\n" +
//                "      },\n" +
//                "      \"trackId\": \"3282350\"\n" +
//                "    },\n" +
//                "    \"image\": {\n" +
//                "      \"height\": \"0\",\n" +
//                "      \"url\": \"/images/camera/20200525/HumanFace_220200525155909754_3282350_6257.jpg\",\n" +
//                "      \"width\": \"0\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  \"eventName\": \"senseDLCRawImage\",\n" +
//                "  \"eventAction\": \"imageCapture\"\n" +
//                "}";
////        send(topic,msg);
//        System.out.println("下面时接收到的消息")
//        recieve("sensebi-kafka-group","KeeperRawEvent");
//    }


}
