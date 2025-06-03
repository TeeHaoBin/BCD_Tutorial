
## Initial setup

```
npm init -y

npm install --save-dev hardhat

npx hardhat init

npx hardhat --version

```

![](attachment/e15cdfa19fc311fa24b46fd9d4179b2a.png)

![](attachment/ae0b87239a7f434af2ca481330630873.png)

---

### Read and test default lock contract

Copy and throw the code to remix ide. 
```
contracts/Lock.sol
```

https://www.epochconverter.com/

```
    //Add the following function to the lock contract
    function getCurrentTime() public view returns(uint256){
        uint256 currentTime = block.timestamp;
        return currentTime;
    }
```


---

### Read and run test file

```
/test/Lock.ts


//Command to run the test file
npx hardhat test

//Powershell command
$env:REPORT_GAS="true"; npx hardhat test

//Linux or mac
REPORT_GAS=true npx hardhat test

```

---

<div style="page-break-after: always;"></div>

### Run hardhat blockchain

```
//Command
npx hardhat node
```

![](attachment/62e674769913e9f24d6f3e867bc310b7.png)


Notes: port conflict
```
//U need to kill process that use the port

//In powershell
netstat -ano | findstr :8545
taskkill /PID <process Id> /F

//In linux
lsof -i :8545
kill [process id]

```




---

### Deploy smart contract

```

//Add the following code to hardhat configuration file -- hardhat.config.ts

  networks: {
    localhost: {
      chainId: 31337,
      url: 'http://127.0.0.1:8545',
    }
  }


//Command to deploy
npx hardhat ignition deploy ./ignition/modules/Lock.ts --reset --network localhost

```

#### Questions
1. How do I get the chainId? (Google search or hardhat documentation)
2. How do I get the url? (Over the console)


---


<div style="page-break-after: always;"></div>


### Automate command in short form


```
//Modify package.json scripts section

npm run deploy
npx hardhat ignition deploy ./ignition/modules/Lock.ts --reset --network localhost

npm run test
npx hardhat test

npm run compile
npx hardhat compile

```


![](attachment/57dc3371941baa2dce64398e86ef5a85.png)

<div style="page-break-after: always;"></div>


```
//Final result
{
  "name": "hardhatstart",
  "version": "1.0.0",
  "main": "index.js",
  "scripts": {
    "deploy": "npx hardhat ignition deploy ./ignition/modules/Lock.ts --reset --network localhost",
    "test": "npx hardhat test",
    "compile": "npx hardhat compile"
  },
  "keywords": [],
  "author": "",
  "license": "ISC",
  "description": "",
  "devDependencies": {
    "@nomicfoundation/hardhat-toolbox-viem": "^3.0.0",
    "hardhat": "^2.22.4"
  }
}
```


---

<div style="page-break-after: always;"></div>

### Connect metamask to hardhat

####  Add Network

![](attachment/589a0a05656e9cc38437348e26395559.png)

#### Delete network

![](attachment/5b0003f3907fb6c0f314df836d4b5127.png)

<div style="page-break-after: always;"></div>

#### Add Account

![](attachment/057d12a19994a5a86c8be8f807de4043.png)

![](attachment/bcdb0d5b5816ec31862f7d86f1c29eb8.png)

![](attachment/54046ede52f9962956ea2d408b49c434.png)


<div style="page-break-after: always;"></div>

#### Test Sending ETH from account 3 to account 2

![](attachment/0e3f83929c2d301abc9845d33cdd3784.png)


---


### Exercises
1. Try to setup hardhat from scratch again by yourself. 
2. Copy any previous contract from the Remix Ide and deploy it to blockchain using Hardhat framework. 