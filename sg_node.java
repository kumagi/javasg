import org.msgpack.rpc.Server;
import org.msgpack.rpc.Request;
import org.msgpack.rpc.EventLoop;
import org.msgpack.rpc.ReflectionDispatcher;

enum direction{
	left ,right;
};


public class sg_node{
	Integer key;
	byte[] value;
	Integer[][] neighborKey; // [left/right][level]
	Integer[][] sequenceNum; // [left/right][level]
	Integer rightRefCount;
	sg_node(Integer k, byte[] v){
		key = k;
		value = v;
		neighborKey = new Integer[2][8];
		sequenceNum = new Integer[2][8];
		rightRefCount = new Integer(0);
	}
	public Integer getKey(){return key;}
	public byte[] getValue(){return value;}
	public Integer getNeighborKey(direction dir, Integer level){
		return neighborKey[dir.ordinal()][level];
	}
	public Integer getSequeinceNum(direction dir, Integer level){
		return sequenceNum[dir.ordinal()][level];
	}

}