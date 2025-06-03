// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

contract StudentNameMap {

    mapping(address => string) public studentNames;

    function registerStudent(string memory name) public {
        studentNames[msg.sender] = name;
    }

    function getMyName() public view returns (string memory) {
        return studentNames[msg.sender];
    }
}