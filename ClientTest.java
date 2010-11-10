import org.msgpack.MessagePackObject;
import org.msgpack.rpc.Client;
import org.msgpack.rpc.Future;
import org.msgpack.rpc.Server;

public class ClientTest{
	//	static sg_logic logic = new sg_logic(new Server());
    public static void main(String[] args) throws Exception{
        Client client = new Client("127.0.0.1", 19850);
		
		//Object[] callArgs = new Object[1];
		//		callArgs[0] = logic.createMsgTellR(1,2);
		System.out.println("sending...");
        MessagePackObject result
			= client.callApply("msgTellR", new Object[]{});
		
		//        System.out.println(result.get());
    }
}