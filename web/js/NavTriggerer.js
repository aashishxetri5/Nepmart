/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $(".nav-trigger").click(function () {
        $(".side-nav").toggleClass("visible");
    });

    $(".hamburger-menu-btn").click(function () {
        $(this).toggleClass("click");
        $(".sidebar").toggleClass("show");
    });

    $(".navbar-toggler").click(function () {
        $(".hamburger-menu-btn").toggleClass("hide");
        $(".sidebar").toggleClass("hide");
//${"."
    });

});