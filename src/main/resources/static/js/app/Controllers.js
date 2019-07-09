'use strict'

var module = angular.module('got.controllers', []);

module.controller("BooksListController", [ "$scope","BooksListService","CONSTANTS",
		function($scope, booksService, CONSTANTS) {
            function fetchIdFromBookURL(bookURL){
                var matcher=bookURL.match(CONSTANTS.BookURLRegex);
                if(matcher){
                    return matcher[1];
                }
                else return null;
            }

			booksService.getAllBooks().then(function (response) {
                $scope.books = response.data.map(function(book,index){
                    return {
                        bookNo: index+1,
                        book: book.name,
                        noOfPages: book.numberOfPages,
                        noOfCharacters: book.characters.length,
                        id:fetchIdFromBookURL(book.url)

                    }
                })

            }).catch(function (error) {
                $scope.error="Failed To Load Books";
                console.error(error);
            });
            $scope.sort = {
                sortBy: null,
                descending: null,
				deriveIcon: function (column) {
					if(column===this.sortBy) {
						if(this.descending)return CONSTANTS.descendingSortIcon;
						else return CONSTANTS.ascendingSortIcon;
                    }
                    else return CONSTANTS.nosortIcon;
                }
            };
            $scope.changeSort = function(column) {
               if($scope.sort.sortBy === column){
                   $scope.sort.descending = !$scope.sort.descending
			   }
			   else{
                   $scope.sort.sortBy = column;
                   $scope.sort.descending = false;
			   }

            };



        } ]);

module.controller("BookDetailsController", [ "$scope","$routeParams","BookDetailsService","CONSTANTS",
    function($scope,$routeParams, bookDetailsService) {

        bookDetailsService.getSelectedBook($routeParams.bookId).then(function (response) {
            $scope.book={
                book: response.data.name,
                noOfPages: response.data.numberOfPages,
                noOfCharacters: response.data.characters.length,
                publisher: response.data.publisher,
                country: response.data.country,
                mediaType: response.data.mediaType,
                released: response.data.released

            }

        }).catch(function (error) {
            $scope.error="Failed To Load Books";
            console.error(error);
        });

        function refreshReviews() {
           $scope.reviews=null;
           bookDetailsService.getReviewsForBook($routeParams.bookId).then(function (response) {
               $scope.reviews=response.data.map(function (review) {
                   return review.content;
               })

           }).catch(function (error) {
               $scope.reviewLoadError="Failed To Load reviews";
               console.error(error);
           });
       }
       refreshReviews();

       $scope.addReview = function(){
           $scope.addingReview=true;
           bookDetailsService.addReview($routeParams.bookId,$scope.reviewContent).then(function () {
               $scope.reviewContent="";
               refreshReviews();
           }).catch(function (reason) {
               alert("Failed to add review");
               console.error(reason);
           }).finally(function () {

               $scope.addingReview=false;
           })


       }



    } ]);