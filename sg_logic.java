
import org.msgpack.object.RawType;
import org.msgpack.MessagePackObject;
import org.msgpack.MessagePack;

import org.msgpack.MessageConverter;
import org.msgpack.annotation.MessagePackMessage;
import org.msgpack.template.ClassTemplate;

import org.msgpack.rpc.Server;
import org.msgpack.rpc.Request;
import org.msgpack.rpc.EventLoop;
import org.msgpack.rpc.ReflectionDispatcher;

import java.util.concurrent.ConcurrentSkipListMap;

import java.io.IOException;


public class sg_logic{
	Server server;
	ConcurrentSkipListMap<Integer, sg_node> storage;
	
	sg_logic(Server sv){
		server = sv;
	}
	
	@MessagePackMessage
	public static class msgTellR {
		public Integer targetKey;
		public Integer targetLevel;
		public msgTellR(Integer key, Integer level){
			targetKey = key;
			targetLevel = level;
		}
	}
	
	public static msgTellR createMsgTellR(Integer key, Integer level){
		return new msgTellR(key,level);
	}
	
	
	public void tellR(Request req){
		msgTellR msg = req.getArguments().convert(msgTellR.class);
		System.out.println("tellR called!");
	}
	
	public void setR(Request req){
		System.out.println("hello");
		
	}
	
}