package factory;

/*Real-time examples:

This design pattern has been widely used in JDK, such as 

1. getInstance() method of java.util.Calendar, NumberFormat, and ResourceBundle uses factory method design pattern. 
2. All the wrapper classes like Integer, Boolean etc, in Java uses this pattern to evaluate the values using valueOf() method. 
3. java.nio.charset.Charset.forName(), java.sql.DriverManager#getConnection(), java.net.URL.openConnection(), java.lang.Class.newInstance(), 
java.lang.Class.forName() are some of their example where factory method design pattern has been used.
*/

public class NotificationService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotificationFactory factory = new NotificationFactory();
		Notification notification = factory.createNotification("SMS");
		notification.notifyUser();
	}

}
