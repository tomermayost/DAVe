/**
 * Created by jakub on 20/10/2016.
 */

(function() {
    'use strict';

    angular.module('dave').controller('MarginComponentHistoryController', MarginComponentHistoryController);

    function MarginComponentHistoryController($scope, $routeParams, $http, $interval, $filter, sortRecordsService, updateViewWindowService) {
        var vm = this;
        vm.initialLoad= true;
        vm.pageSize = 20;
        vm.recordCount = 0;
        vm.viewWindow = [];
        vm.updateViewWindow = updateViewWindow;
        vm.chartData = [];
        vm.errorMessage = "";
        vm.sortRecords = sortRecords;
        vm.route = {
            "clearer": $routeParams.clearer,
            "member": $routeParams.member,
            "account": $routeParams.account,
            "class": $routeParams.class,
            "ccy": $routeParams.ccy
        };

        var currentPage = 1;
        var refresh = $interval(loadData, 60000);
        var restQueryUrl = '/api/v1.0/mc/history/' + vm.route.clearer + '/' + vm.route.member + '/' + vm.route.account + '/' + vm.route.class + '/' + vm.route.ccy;
        var defaultOrdering = ["-received"];
        var ordering = defaultOrdering;
        var sourceData = [];

        loadData();

        ///////////////////

        function loadData()
        {
            $http.get(restQueryUrl).success(function(data) {
                vm.errorMessage = "";
                processData(data);
                processGraphData(data);
                vm.initialLoad = false;
            }).error(function(data, status, headers, config) {
                vm.errorMessage = "Server returned status " + status;
                vm.initialLoad = false;
            });
        }

        function processData(data) {
            sourceData = data;
            vm.recordCount = data.length;
            updateViewWindow(currentPage);
        }

        function processGraphData(data) {
            var chartData = [];
            var index;

            for (index = 0; index < data.length; ++index) {
                var tick = {
                    period: $filter('date')(data[index].received, "yyyy-MM-dd HH:mm:ss"),
                    variationMargin: data[index].variationMargin,
                    premiumMargin: data[index].premiumMargin,
                    liquiMargin: data[index].liquiMargin,
                    spreadMargin: data[index].spreadMargin,
                    additionalMargin: data[index].additionalMargin
                };

                chartData.push(tick);
            }

            vm.chartData = chartData;
        }

        function sortRecords(column) {
            ordering = sortRecordsService(column, ordering, defaultOrdering);
            updateViewWindow(currentPage);
        }

        function updateViewWindow(page) {
            currentPage = page;
            vm.viewWindow = vm.viewWindow = updateViewWindowService(sourceData, null, ordering, currentPage, vm.pageSize);
        }

        $scope.$on("$destroy", function() {
            if (refresh != null) {
                $interval.cancel(refresh);
            }
        });
    };
})();