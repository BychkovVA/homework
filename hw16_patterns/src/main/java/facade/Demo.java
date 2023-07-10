package facade;

public class Demo {
    public static void main(String[] args) {
        MessagingFacade messagingFacade = new MessagingFacade();
        messagingFacade.sendMessage("example@example.com", "+1234567890", "device_token", "Hello, World!");
    }
}
