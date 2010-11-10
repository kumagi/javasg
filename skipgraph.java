import org.msgpack.object.RawType;

import org.msgpack.rpc.Server;
import org.msgpack.rpc.Request;
import org.msgpack.rpc.EventLoop;
import org.msgpack.rpc.ReflectionDispatcher;


import java.io.IOException;


public class skipgraph{
    public static void main(String[] args){
        EventLoop loop = new EventLoop();
        Server server = new Server(loop);

        try{
            server.serve(new ReflectionDispatcher(new sg_logic(server)));
            server.listen(19850);

            while(true){
				try{
					Thread.sleep(20000000);
				}catch(InterruptedException e){
					System.out.println(e);
				}
				System.out.println("waiting...");
            }
        }catch(IOException e){
            server.close();
            loop.shutdown();
        }
    }
}