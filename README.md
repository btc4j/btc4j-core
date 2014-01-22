Bitcoin Java Core Components (btc4j-core)
=========================================
Type-safe, open source Java core components and interface definitions of btc4j.

Development build status: [![Build Status](https://travis-ci.org/btc4j/btc4j-core.png?branch=master)](https://travis-ci.org/btc4j/btc4j-core)

btc4j-core does not use any third party or external library

Development status: Mostly complete for current needs

Using btc4j-core
----------------
btc4j-core is free software under [The MIT License (MIT)](http://opensource.org/licenses/MIT/ "The MIT License (MIT)"). It is maintained by Guillermo Gonzalez (ggonzalez@btc4j.org).

Maven pom.xml dependency:
```xml
<dependency>
	<groupId>org.btc4j</groupId>
	<artifactId>btc4j-core</artifactId>
	<version>0.0.3-SNAPSHOT</version>
</dependency>
```

Core components include API's, model, utils, exceptions, etc:
* __BtcApi__: Interface definition of bitcoin internal API commands usually implemented in JSON-RPC
* __BtcException__: General exception class for all btc4j projects and wrapper for bitcoind json-rpc errors
* __BtcAccount__: Concrete implementation of a bitcoin account
* __BtcAddressBase__: Abstract bitcoin address
* __BtcInfoBase__: Abstract bitcoin information

Issues
------
Report bugs, issues, or suggestions: https://github.com/btc4j/btc4j-core/issues.

Contributions
-------------
Project location: https://github.com/btc4j/btc4j-core.
* git: `git@github.com:btc4j/btc4j-core.git`
* svn: `https://github.com/btc4j/btc4j-core`

Donations
---------
If you find the software useful and would like to make a donation, please send bitcoins to `1ACz6GKw3B6vjoYwGA2hnXDnbR5koFhC4j`.

Copyright &copy; 2013, 2014 by Guillermo Gonzalez, [btc4j.org](http://www.btc4j.org "btc4j.org").