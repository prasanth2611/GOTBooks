'use strict'

var module = angular.module('got.services', []);

module.factory('BooksListService',
    [ "$http", "CONSTANTS", function($http, CONSTANTS) {
        var service = {};
        service.getAllBooks = function() {
            return $http.get(CONSTANTS.allBooksURL);
        }
        return service;
    } ]);

module.factory('BookDetailsService',
    [ "$http", "CONSTANTS", function($http, CONSTANTS) {
        var service = {};

        service.getSelectedBook = function(bookId) {
            return $http.get(CONSTANTS.getSelectedBookURL(bookId));
        }
        service.getReviewsForBook = function(bookId) {
            return $http.get(CONSTANTS.getReviewsForBookURL(bookId));
        }
        service.addReview = function(bookId,content) {
            return $http.post(CONSTANTS.getReviewsForBookURL(bookId),content);
        }
        return service;
    } ]);