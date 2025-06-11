// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.20;

import "forge-std/Test.sol";
import "../src/ICO.sol";
import "../src/LiangToken.sol";

// contract ICOTest is Test {
//     ICO public ico;
//     LiangToken public token;
//     address public owner;
//     address public buyer;

//     function setUp() public {
//         owner = address(this);
//         buyer = vm.addr(1);

//         token = new LiangToken();
//         ico = new ICO(address(token));

//         // Approve ICO to transfer tokens on behalf of owner
//         token.approve(address(ico), token.totalSupply());

//         // Fund buyer with ETH
//         vm.deal(buyer, 10 ether);
//     }

//     function testBuyToken() public {
//         vm.prank(buyer);
//         ico.buyToken{value: 1 ether}();

//         uint256 expectedTokens = (1 ether / ico.price()) * 10 ** 18;
//         assertEq(token.balanceOf(buyer), expectedTokens);
//         assertEq(ico.totalTokensSold(), expectedTokens);
//     }

//     function testPauseAndUnpause() public {
//         ico.pause();
//         vm.expectRevert(Pausable.EnforcedPause.selector);

//         vm.prank(buyer);
//         ico.buyToken{value: 1 ether}();

//         ico.unpause();
//         vm.prank(buyer);
//         ico.buyToken{value: 1 ether}();

//         uint256 expectedTokens = (1 ether / ico.price()) * 10 ** 18;
//         assertEq(token.balanceOf(buyer), expectedTokens);
//     }

//     function testWithdrawal() public {
//         vm.prank(buyer);
//         ico.buyToken{value: 2 ether}();

//         uint256 balanceBefore = owner.balance;
//         ico.withdrawal();
//         uint256 balanceAfter = owner.balance;

//         assertEq(balanceAfter - balanceBefore, 2 ether);
//     }
// }



contract ICOTest is Test {
    ICO public ico;
    LiangToken public token;
    address public buyer;

    // 👇 Add this to accept ETH
    receive() external payable {}

    function setUp() public {
        buyer = vm.addr(1);

        token = new LiangToken();
        ico = new ICO(address(token));

        token.approve(address(ico), token.totalSupply());
        vm.deal(buyer, 10 ether);
    }

    function testBuyToken() public {
        vm.prank(buyer);
        ico.buyToken{value: 1 ether}();

        uint256 expectedTokens = (1 ether / ico.price()) * 10 ** 18;
        assertEq(token.balanceOf(buyer), expectedTokens);
        assertEq(ico.totalTokensSold(), expectedTokens);
    }

    function testPauseAndUnpause() public {
        ico.pause();
        vm.expectRevert(Pausable.EnforcedPause.selector);

        vm.prank(buyer);
        ico.buyToken{value: 1 ether}();

        ico.unpause();
        vm.prank(buyer);
        ico.buyToken{value: 1 ether}();

        uint256 expectedTokens = (1 ether / ico.price()) * 10 ** 18;
        assertEq(token.balanceOf(buyer), expectedTokens);
    }

    function testWithdrawal() public {
        vm.prank(buyer);
        ico.buyToken{value: 2 ether}();

        uint256 balanceBefore = address(this).balance;
        ico.withdrawal();
        uint256 balanceAfter = address(this).balance;

        assertEq(balanceAfter - balanceBefore, 2 ether);
    }
}