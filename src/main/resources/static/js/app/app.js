'use strict'

var module = angular.module('got', [ 'ngRoute','got.controllers', 'got.services']);
module.constant("CONSTANTS", {
	allBooksURL : "/api/books",
    getSelectedBookURL: function (bookId) {
        return "/api/books/"+bookId;
    },
    getReviewsForBookURL: function (bookId) {
        return "/api/books/"+bookId+"/reviews";
    },
	ascendingSortIcon: "icons/ascending.png",
    descendingSortIcon: "icons/descending.png",
    nosortIcon: "icons/nosort.png",
    BookURLRegex:/https:\/\/anapioficeandfire.com\/api\/books\/(.+)/

});

module.config(function($routeProvider) {
    $routeProvider
        .when("/books/:bookId", {
            templateUrl: "book-details",
            controller: "BookDetailsController"
        })
        .otherwise({
            templateUrl : "books",
            controller: "BooksListController"
        });
});