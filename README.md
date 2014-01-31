Bitcoin Java Core Components
============================
Open source Java core components and interface definitions of btc4j.

Development build status: [![Build Status](https://travis-ci.org/btc4j/btc4j-core.png?branch=master)](https://travis-ci.org/btc4j/btc4j-core)

btc4j-core does not use any third party or external libraries.

Development status: Mostly complete for current needs.

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
or, download artifacts directly from https://github.com/btc4j/btc4j-repo/tree/master/btc4j-core.

Core components include API's, model, utils, exceptions, etc:
* __BtcApi__: Interface definition of bitcoin internal API commands usually implemented in JSON-RPC
* __BtcException__: General exception class for all btc4j projects and wrapper for bitcoind json-rpc errors
* __BtcAccount__: Concrete implementation of a bitcoin account
* __BtcAddressBase__: Abstract bitcoin address
* __BtcInfoBase__: Abstract bitcoin information

BtcApi
------
* addmultisigaddress <nrequired> <'["key","key"]'> [account]
* addnode <node> <add|remove|onetry>
* backupwallet <destination>
* createmultisig <nrequired> <'["key","key"]'>
* createrawtransaction [{"txid":txid,"vout":n},...] {address:amount,...}
* decoderawtransaction <hex string>
* dumpprivkey <bitcoinaddress>
* getaccount <bitcoinaddress>
* getaccountaddress <account>
* getaddednodeinfo <dns> [node]
* getaddressesbyaccount <account>
* getbalance [account] [minconf=1]
* getblock <hash>
* getblockcount
* getblockhash <index>
* getblocktemplate [params]
* getconnectioncount
* getdifficulty
* getgenerate
* gethashespersec
* getinfo
* getmininginfo
* getnewaddress [account]
* getpeerinfo
* getrawmempool
* getrawtransaction <txid> [verbose=0]
* getreceivedbyaccount <account> [minconf=1]
* getreceivedbyaddress <bitcoinaddress> [minconf=1]
* gettransaction <txid>
* gettxout <txid> <n> [includemempool=true]
* gettxoutsetinfo
* getwork [data]
* help [command]
* importprivkey <bitcoinprivkey> [label] [rescan=true]
* keypoolrefill
* listaccounts [minconf=1]
* listaddressgroupings
* listlockunspent
* listreceivedbyaccount [minconf=1] [includeempty=false]
* listreceivedbyaddress [minconf=1] [includeempty=false]
* listsinceblock [blockhash] [target-confirmations]
* listtransactions [account] [count=10] [from=0]
* listunspent [minconf=1] [maxconf=9999999]  ["address",...]
* lockunspent unlock? [array-of-Objects]
* move <fromaccount> <toaccount> <amount> [minconf=1] [comment]
* sendfrom <fromaccount> <tobitcoinaddress> <amount> [minconf=1] [comment] [comment-to]
* sendmany <fromaccount> {address:amount,...} [minconf=1] [comment]
* sendrawtransaction <hex string>
* sendtoaddress <bitcoinaddress> <amount> [comment] [comment-to]
* setaccount <bitcoinaddress> <account>
* setgenerate <generate> [genproclimit]
* settxfee <amount>
* signmessage <bitcoinaddress> <message>
* signrawtransaction <hex string> [{"txid":txid,"vout":n,"scriptPubKey":hex,"redeemScript":hex},...] [<privatekey1>,...] [sighashtype="ALL"]
* stop
* submitblock <hex data> [optional-params-obj]
* validateaddress <bitcoinaddress>
* verifymessage <bitcoinaddress> <signature> <message>
* walletlock
* walletpassphrase <passphrase> <timeout>
* walletpassphrasechange <oldpassphrase> <newpassphrase>

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