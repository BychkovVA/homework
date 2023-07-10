package facade;

public class MessagingFacade {
    private EmailService emailService;
    private SMSService smsService;
    private PushNotificationService pushNotificationService;

    public MessagingFacade() {
        this.emailService = new EmailService();
        this.smsService = new SMSService();
        this.pushNotificationService = new PushNotificationService();
    }

    public void sendMessage(String email, String phoneNumber, String deviceToken, String message) {
        emailService.sendEmail(email, message);
        smsService.sendSMS(phoneNumber, message);
        pushNotificationService.sendPushNotification(deviceToken, message);
    }
}
