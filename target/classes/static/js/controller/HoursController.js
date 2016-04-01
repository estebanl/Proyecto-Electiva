angular.module("app")
    .constant("HoursUrl", "/hours")
    .controller("HoursController", function ($scope, $http, HoursUrl) {

        $scope.createHours = function (newHours, semployee) {
            newHours.employee = semployee;
            $http.post(HoursUrl, newHours).success(function (data) {
                    $scope.getEmployee(semployee.id);
                    $scope.newHours = {};
                })
                .error(function (error) {

                });
        };
        
        $scope.updateHours = function (hours) {
            $http.put(HoursUrl,hours);
            // $scope.selectedEmployee($scope.selectEmployee);
        };

        $scope.totalHoursApproved = 0;
        $scope.totalHoursQuantity = 0;
        
        $scope.calculateTotalHours = function (employee) {
            $scope.totalHoursApproved = 0;
            $scope.totalHoursQuantity = 0;
            for (var i = 0; i < employee.hoursList.length; i++)
            {
                $scope.totalHoursQuantity += employee.hoursList[i].quantity;
                $scope.totalHoursApproved += employee.hoursList[i].approved;
            }
        }
        
    });