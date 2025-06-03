// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

contract SimpleArray {

    string[3] public colors = ["red", "green", "blue"];

    function getColor(uint256 index) public view returns (string memory) {
        require(index < colors.length, "Index out of bounds");
        return colors[index];
    }
}