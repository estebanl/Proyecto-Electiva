angular.module("app")
    .constant("HoursUrl", "/hours")
    .controller("HoursController", function ($scope, $http, HoursUrl) {

        $scope.createHours = function (newHours, semployee) {
            newHours.employee = semployee;
            $http.post(HoursUrl, newHours).success(function (data) {
                    $scope.getEmployee(semployee.id);
                })
                .error(function (error) {

                });
        };
        
        $scope.updateHours = function (hours) {
            $http.put(HoursUrl,hours);
        }
    });