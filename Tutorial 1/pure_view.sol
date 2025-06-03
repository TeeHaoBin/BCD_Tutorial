// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

contract FunctionType {

  uint256 public num = 10;

  function addOne(uint256 a) public pure returns (uint256) {
    return a + 1;
  }

  function doubleStoredValue() public view returns (uint256) {
    return num * 2;
  }
}