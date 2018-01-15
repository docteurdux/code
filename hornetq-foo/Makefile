.PHONY: ALL VERIFY_QUEUE

ALL: VERIFY_QUEUE

hornetq-2.4.0.Final: ./hornetq-2.4.0.Final-bin.zip
	[ -e hornetq-2.4.0.Final ] || unzip hornetq-2.4.0.Final-bin.zip

hornetq-2.4.0.Final-bin.zip: /usr/bin/wget
	[ -e hornetq-2.4.0.Final-bin.zip ] || wget http://downloads.jboss.org/hornetq/hornetq-2.4.0.Final-bin.zip

/usr/bin/wget:
	sudo apt-get install wget

/usr/bin/mvn:
	sudo apt-get install maven

VERIFY_QUEUE: /usr/bin/mvn hornetq-2.4.0.Final
	cd hornetq-2.4.0.Final/examples/jms/queue ; mvn verify

