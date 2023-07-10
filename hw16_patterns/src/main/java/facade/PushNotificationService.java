package facade;

public class PushNotificationService {
    public void sendPushNotification(String deviceToken, String message) {
        System.out.println("Sending push notification to " + deviceToken + ": " + message);
    }
}