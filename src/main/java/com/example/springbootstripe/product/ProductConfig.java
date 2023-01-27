package com.example.springbootstripe.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
            Product keyboard = new Product(
                    "Keyboard",
                    "Mechanical Keyboard",
                    7999L,
                    135,
                    88
            );
            Product mouse = new Product(
                    "Mouse",
                    "Wired mouse",
                    4999L,
                    137,
                    35
            );
            Product monitor = new Product(
                    "Monitor",
                    "LED Monitor",
                    15999L,
                    144,
                    23
            );
            Product speakers = new Product(
                    "Speakers",
                    "Surround Sound speakers",
                    3999L,
                    131,
                    64
            );
            Product headset = new Product(
                    "Headset",
                    "Wireless Headset",
                    8999L,
                    115,
                    24
            );
            Product webcam = new Product(
                    "Webcam",
                    "Full HD Webcam",
                    5999L,
                    187,
                    71
            );
            Product microphone = new Product(
                    "Microphone",
                    "Wired USB Microphone",
                    6999L,
                    244,
                    36
            );
            Product externalSsd = new Product(
                    "External SSD",
                    "4TB Portable External SSD",
                    59999L,
                    234,
                    11
            );
            repository.saveAll(List.of(keyboard, mouse, monitor, speakers, headset, webcam, microphone, externalSsd));
        };
    }
}
