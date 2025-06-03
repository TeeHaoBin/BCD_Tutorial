// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

contract SimpleForLoop {

    uint256[] private numbers = [1, 2, 3, 4, 5];

    function totalValue() public view returns (uint256 sum) {

    uint256 total = 0;

    for (uint256 i = 0; i < numbers.length; i++) {
        total += numbers[i];
    }
    return total;
    }
}