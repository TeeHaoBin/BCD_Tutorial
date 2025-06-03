// SPDX-License-Identifier: MIT
pragma solidity ^0.8.24;
contract receiveEther{
	event ReceivedEther(address indexed sender, uint256 amount);
	receive() external payable {
		emit ReceivedEther(msg.sender, msg.value);
	}

	function getBalance() public view returns (uint256) {
		return address(this).balance;
	}
}