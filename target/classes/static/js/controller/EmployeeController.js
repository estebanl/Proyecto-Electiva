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
                })
                .error(function (error) {
                    $scope.error = error;
                })
        };


        $scope.selectedEmployee = function (employee) {
           $scope.getEmployee(employee.id);
        };

    });