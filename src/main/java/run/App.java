package run;

import lsieun.spi.MessageServiceProvider;

import java.util.Optional;
import java.util.ServiceLoader;

public class App {
    public static void main(String[] args) {
        ServiceLoader<MessageServiceProvider> serviceLoader = ServiceLoader.load(MessageServiceProvider.class);

        for (MessageServiceProvider service : serviceLoader) {
            service.sendMessage("Hello");
        }

        // using Java 8 Optional to get the first service
        Optional<MessageServiceProvider> firstService = serviceLoader.findFirst();
        if (firstService.isPresent()) {
            firstService.get().sendMessage("Hello Friend");
        }

        // using Java 8 forEach() method
//        serviceLoader.forEach((service) -> service.sendMessage("Have a Nice Day!"));

        // Total Number of Loaded Services
//        System.out.println(serviceLoader.stream().count());

    }
}
