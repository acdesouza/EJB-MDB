package componentes;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName="jms/MDBQueue")
public class MDB implements MessageListener {

  public void onMessage(Message inMessage) {
    TextMessage msg = null;

    try {
      if (inMessage instanceof TextMessage) {
        msg = (TextMessage) inMessage;
        System.out.println("MESSAGE BEAN: Message received: " + msg.getText());
      } else {
        System.err.println("Message of wrong type: " + inMessage.getClass().getName());
      }
    } catch (JMSException e) {
      System.err.println(e.getMessage());
    }
  }

}
