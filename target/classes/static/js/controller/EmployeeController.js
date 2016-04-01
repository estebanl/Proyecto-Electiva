angular.module("app")
    .constant("EmployeeUrl", "/employee")
    .controller("EmployeeController", function ($scope, $http, EmployeeUrl) {


        
        $scope.createEmployee = function (employee, supervisor) {
            employee.supervisor = supervisor;
            $http.post(EmployeeUrl, employee).success(function (data) {
                $scope.getSupervisor(supervisor.id);
            }).error(function (error) {

            });
        };

        $scope.getEmployee = function (id) {
            $http.get(EmployeeUrl+"/"+id)
                .success(function (data) {
                    $scope.selectEmployee = data;
                    $scope.calculateTotal();
                })
                .error(function (error) {
                    $scope.error = error;
                })
        };


        $scope.selectedEmployee = function (employee) {
           $scope.getEmployee(employee.id);
        };

        $scope.calculateTotal = function () {
            $scope.totalHours = 0;
            $scope.totalApproved = 0;
            $scope.totalTotalPrice = 0;
            for (var i = 0; i < $scope.selectEmployee.hoursList.length; i++)
            {
                $scope.totalHours += $scope.selectEmployee.hoursList[i].quantity;
                $scope.totalApproved += $scope.selectEmployee.hoursList[i].approved;
                $scope.totalTotalPrice += $scope.selectEmployee.hoursList[i].totalPrice;
            }
        };

    });