JAVAC=javac
JAVA=java

target:skipgraph.class
target:ClientTest.class

skipgraph.class:skipgraph.java sg_logic.class sg_node.class
	$(JAVAC) $<
sg_logic.class: sg_logic.java sg_node.class
	$(JAVAC) $<
sg_node.class: sg_node.java
	$(JAVAC) $<
ClientTest.class:ClientTest.java
	$(JAVAC) $<

.java.class:
	$(JAVAC) -c $< 

testclient:testclient.o
	g++ -o $@ $^ -lmsgpack -lmpio -lmsgpack-rpc -pthread -lboost_thread -lboost_program_options

testclient.o:testclient.cpp
	g++ -c -o $@ $^

.PHONY: clean
	rm *.class
