// SPDX-License-Identifier: MIT
pragma solidity ^0.8.18;

import {Script} from "forge-std/Script.sol";
import {LiangToken} from "../src/LiangToken.sol";
import {ICO} from "../src/ICO.sol";

contract DeployICO is Script {
    function run() external returns (LiangToken, ICO) {
        // Start broadcasting transactions
        vm.startBroadcast();

        // Deploy LiangToken contract
        LiangToken liangToken = new LiangToken();

        // Deploy ICO contract with LiangToken address as constructor argument
        ICO ico = new ICO(address(liangToken));

        // Get total supply from LiangToken
        uint256 totalSupply = liangToken.totalSupply();

        // Approve ICO contract to spend total supply of LiangToken
        liangToken.approve(address(ico), totalSupply);

        // Stop broadcasting transactions
        vm.stopBroadcast();

        return (liangToken, ico);
    }
}