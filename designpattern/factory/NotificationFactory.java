package factory;

public class NotificationFactory {
	
	public Notification createNotification(String type) {
		if(type == null) {
			return null;
		}
		else if(type.equals("SMS")) {
			new SMSNotification();
		}
		else if(type.equals("Email")) {
			new EmailNotification();
		}
		else if(type.equals("Push")) {
			new PushNotification();
		}
		return null;
	}

}
