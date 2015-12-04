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
                // var searchDate= $scope.date.toISOString();
                var searchDate = JSON.stringify($scope.date);


                if ($scope.destination !== "null")
                {
                    var attributes = $scope.from + "/" + $scope.to + "/" + searchDate + "/" + $scope.persons;
                } else
                {
                    var attributes = $scope.from + "/" + searchDate + "/" + $scope.persons;
                }

                var url = baseUrl + attributes;

                $http.get(url).then(function successCallBack(res) {
                    $scope.data = res.data;
                }, function errorCallBack(res) {
                    alert("LORT");
                });
            };
        });
        