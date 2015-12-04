'use strict';

angular.module('myApp.view1', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'view1/view1.html',
                    controller: 'View1Ctrl'
                });
            }])


        .controller('View1Ctrl', function ($http, $scope) {

            $scope.search = function () {

                var baseUrl = 'api/flightinfo/';


                var year = $scope.myDate.getFullYear();
                var month = $scope.myDate.getMonth();
                var day = $scope.myDate.getDate();
                $scope.date = new Date(year, month, day, 1);
                var formatDate = $scope.date.toISOString();


                if ($scope.destination !== "null")
                {
                    var attributes = $scope.origin + "/" + $scope.destination + "/" + formatDate + "/" + $scope.numberOfSeats;
                } else
                {
                    var attributes = $scope.origin + "/" + formatDate + "/" + $scope.numberOfSeats;
                }

                var url = baseUrl + attributes;

                $http.get(url).then(function successCallBack(res) {
                    $scope.data = res.data;
                }, function errorCallBack(res) {
                    alert("LORT");
                });
            };
        });
        