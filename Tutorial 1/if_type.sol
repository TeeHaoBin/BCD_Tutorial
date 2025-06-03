// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

contract Voting {

    uint public age;

    constructor(uint _age) {
        age = _age;
    }

    function canVote() public view returns (bool) {
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }
}